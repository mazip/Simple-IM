package org.mazip.protocol.xmpp.codec;

import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.UUID;

/**
 * Created by mazip on 2016/8/23.
 */
public class XMPPSerialize {

    public static String serialize(Object t){


        XmlPullParserFactory factory = null;
        try {
            factory = XmlPullParserFactory.newInstance();
            // 通过工厂对象得到Serializer对象
            XmlSerializer serializer = factory.newSerializer();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            serializer.setOutput(outputStream,"UTF-8");
            serializer.startDocument("utf-8", true);
            Class cls = t.getClass();
            Field[] fields =cls.getDeclaredFields();
            for (int i=0;i<fields.length;i++){
                if(Modifier.isPublic(fields[i].getModifiers())){
                     if("START_TAG".equals(fields[i].getName())){
                         serializer.startTag(null, fields[i].get(t).toString());
                         continue;
                     }
                }
                if("private".equals(Modifier.toString(fields[i].getModifiers()))){
                    fields[i].setAccessible(true);
                    if("id".equals(fields[i].getName())){
                        if(fields[i].get(t)==null){

                            serializer.attribute(null,cls.getField(fields[i].getName().toUpperCase()+"_ATTR").get(t).toString(), UUID.randomUUID().toString());
                        }else{
                            serializer.attribute(null,cls.getField(fields[i].getName().toUpperCase()+"_ATTR").get(t).toString(), fields[i].get(t).toString());
                        }
                    }else{
                        serializer.attribute(null,cls.getField(fields[i].getName().toUpperCase()+"_ATTR").get(t).toString(),fields[i].get(t).toString());
                    }
                }
            }
            serializer.endDocument();
            return outputStream.toString();



        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        return "";
    }
}
