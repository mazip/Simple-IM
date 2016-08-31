package org.mazip.protocol.xmpp.codec;

import com.sun.tools.internal.ws.wsdl.document.jaxws.Exception;
import com.sun.tools.javadoc.Start;
import org.mazip.protocol.xmpp.Query;
import org.mazip.protocol.xmpp.annotation.StartTag;
import org.mazip.protocol.xmpp.annotation.XMPPATTR;
import org.mazip.protocol.xmpp.annotation.XMPPChild;
import org.mazip.util.reflect.ReflectionUtils;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;

/**
 * Created by mazip on 2016/8/23.
 */
public class XMPPSerialize {

    /**
     * 尝试了xmlpull 的写法
     *
     * @param t
     * @return
     */
    public static String serialize(Object t) {

        XmlPullParserFactory factory = null;
        try {
            factory = XmlPullParserFactory.newInstance();
            // 通过工厂对象得到Serializer对象
            XmlSerializer serializer = factory.newSerializer();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            serializer.setOutput(outputStream, "UTF-8");
            serializer.startDocument("utf-8", true);
            serialize(t, serializer);
            serializer.endDocument();
            return outputStream.toString().replace("<?xml version='1.0' encoding='utf-8' standalone='yes' ?>", "");
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return "";
    }

    //TODO:优化
    private static void serialize(Object t, XmlSerializer serializer) throws NoSuchFieldException, IOException, IllegalAccessException {


        Class cls = t.getClass();

        Field[] fields = ReflectionUtils.getAllDeclaredField(t);
        Annotation annotation = cls.getAnnotation(StartTag.class);
        String startTag = "";
        if (annotation != null) {
            StartTag tag = (StartTag) annotation;
            startTag = tag.value();
        } else {
            throw new NoSuchFieldException();
        }
        serializer.startTag(null, startTag);

        for (int i = 0; i < fields.length; i++) {
            if ("private".equals(Modifier.toString(fields[i].getModifiers()))) {
                fields[i].setAccessible(true);
                if (fields[i].get(t) != null) {
                    Annotation[] annotations = fields[i].getAnnotations();
                    for (int j = 0; j < annotations.length; j++) {
                        if (annotations[j] instanceof XMPPATTR) {
                            String attrName = ((XMPPATTR) annotations[j]).value();
                            if ("id".equals(attrName)) {
                                if (fields[i].get(t) == null) {
                                    serializer.attribute(null, attrName, UUID.randomUUID().toString());
                                } else {
                                    serializer.attribute(null, attrName, fields[i].get(t).toString());
                                }
                            } else {
                                if (fields[i].get(t) != null) {
                                    serializer.attribute(null, attrName, fields[i].get(t).toString());
                                }
                            }
                        }
                    }
                }

            }
        }
        for (int i = 0; i < fields.length; i++) {
            if ("private".equals(Modifier.toString(fields[i].getModifiers()))) {
                fields[i].setAccessible(true);
                if (fields[i].get(t) != null) {
                    Annotation[] annotations = fields[i].getAnnotations();
                    for (int j = 0; j < annotations.length; j++) {
                        if (annotations[j] instanceof XMPPChild) {
                            String childName = ((XMPPChild) annotations[j]).value();

                            //判断是否是基本类型
                            if ("String".equalsIgnoreCase(fields[i].getType().getSimpleName())) {
                                serializer.startTag(null, childName);
                                serializer.text(fields[i].get(t).toString());
                                serializer.endTag(null, childName);
                            } else {
                                if ("HashMap".equalsIgnoreCase(fields[i].get(t).getClass().getSimpleName())) {
                                    Map p = (Map) fields[i].get(t);
                                    Set<Map.Entry<String, String>> set = p.entrySet();
                                    Iterator<Map.Entry<String, String>> mapIterator = set.iterator();
                                    while (mapIterator.hasNext()) {
                                        Map.Entry<String, String> entry = mapIterator.next();
                                        serializer.startTag(null, entry.getKey());
                                        if (entry.getValue() != null) {
                                            serializer.text(entry.getValue());
                                        }
                                        serializer.endTag(null, entry.getKey());
                                    }
                                } else {
                                    serialize(fields[i].get(t), serializer);
                                }
                            }
                        }
                    }
                }
            }
        }


        if (!"stream:stream".equals(startTag)) {
            serializer.endTag(null, startTag);
        }

    }

}
