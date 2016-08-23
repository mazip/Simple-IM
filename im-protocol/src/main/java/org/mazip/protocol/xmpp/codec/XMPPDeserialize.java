package org.mazip.protocol.xmpp.codec;

import org.mazip.protocol.xmpp.XMPPStream;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.*;

/**
 * Created by mazip on 2016/8/23.
 */
public class XMPPDeserialize {


    /**
     * 反序列化
     *
     * @param str
     * @param <T>
     * @return
     */
    public static <T> T desrialize(String str) {

        XmlPullParserFactory pullParserFactory = null;
        try {
            pullParserFactory = XmlPullParserFactory.newInstance();
            //获取XmlPullParser的实例
            XmlPullParser xmlPullParser = pullParserFactory.newPullParser();
            //设置输入流  xml文件
            InputStream is = new ByteArrayInputStream(str.getBytes("UTF-8"));
            xmlPullParser.setInput(is, "UTF-8");
            int eventType = xmlPullParser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                String nodeName = xmlPullParser.getName();
                switch (eventType) {
                    //文档开始
                    case XmlPullParser.START_DOCUMENT:
                        System.out.println("start_document");
                        break;
                    //开始节点
                    case XmlPullParser.START_TAG:
                        if("stream:stream".equals(nodeName)){
                            //解析stream
                            return (T)getStream(xmlPullParser);
                        }

                        break;
                    case XmlPullParser.END_TAG:
                        if ("student".equals(nodeName)) {

                        }
                        break;
                    default:
                        break;
                }
                eventType = xmlPullParser.next();
            }

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    private static XMPPStream getStream(XmlPullParser xmlPullParser) {
        XMPPStream xmppStream = new XMPPStream();
        xmppStream.setFrom(xmlPullParser.getAttributeValue(null,XMPPStream.FROM_ATTR));
        xmppStream.setTo(xmlPullParser.getAttributeValue(null,XMPPStream.TO_ATTR));
        xmppStream.setId(xmlPullParser.getAttributeValue(null,XMPPStream.ID_ATTR));
        xmppStream.setLang(xmlPullParser.getAttributeValue(null,XMPPStream.LANG_ATTR));
        xmppStream.setVersion(xmlPullParser.getAttributeValue(null,XMPPStream.VERSION_ATTR));
        xmppStream.setXmlns(xmlPullParser.getAttributeValue(null,XMPPStream.XMLNS_ATTR));
        xmppStream.setXmlnsStream(xmlPullParser.getAttributeValue(null,XMPPStream.XMLNSSTREAM_ATTR));
        return xmppStream;
    }
}
