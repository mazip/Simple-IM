package org.mazip.protocol.xmpp.codec;

import org.mazip.protocol.xmpp.Iq;
import org.mazip.protocol.xmpp.Message;
import org.mazip.protocol.xmpp.Query;
import org.mazip.protocol.xmpp.XMPPStream;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

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
            Iq iq =null;
            Query query=null;
            Message message=null;
            while (eventType != XmlPullParser.END_DOCUMENT) {
                String nodeName = xmlPullParser.getName();
                switch (eventType) {
                    //文档开始
                    case XmlPullParser.START_DOCUMENT:
                        break;
                    //开始节点
                    case XmlPullParser.START_TAG:
                        if("stream:stream".equals(nodeName)){
                            //解析stream
                            return (T)getStream(xmlPullParser);
                        }else if("iq".equals(nodeName)){
                            iq=new Iq();
                            iq.setType(xmlPullParser.getAttributeValue(null,Iq.TYPE_ATTR));
                            iq.setId(xmlPullParser.getAttributeValue(null,Iq.ID_ATTR));
                        }else if("query".equals(nodeName)){
                            if(iq!=null&&!"set".equals(iq.getType())){
                                query = new Query();
                                query.setXmlns(xmlPullParser.getAttributeValue(null,Query.XMLNS_ATTR));
                                iq.setQuery(query);
                                return (T)iq;
                            }else{
                                query = new Query();
                                query.setXmlns(xmlPullParser.getAttributeValue(null,Query.XMLNS_ATTR));
                            }
                        }else if("username".equals(nodeName)){
                            if(query!=null){
                                Map<String,String> map = new HashMap<String,String>();
                                map.put("username",xmlPullParser.nextText());
                                query.setAttrs(map);
                                iq.setQuery(query);
                                return (T)iq;
                            }
                        }else if("message".equals(nodeName)){
                            message=new Message();
                            message.setType(xmlPullParser.getAttributeValue(null,Message.TYPE_ATTR));
                            message.setTo(xmlPullParser.getAttributeValue(null,Message.TO_ATTR));
                        }else if("body".equals(nodeName)){
                            if(message!=null){
                                message.setBody(xmlPullParser.nextText());
                                return (T)message;
                            }
                        }

                        break;
                    case XmlPullParser.END_TAG:
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
