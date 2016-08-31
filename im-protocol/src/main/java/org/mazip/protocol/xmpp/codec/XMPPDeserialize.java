package org.mazip.protocol.xmpp.codec;

import org.mazip.protocol.xmpp.*;
import org.mazip.protocol.xmpp.parse.ParseContext;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mazip on 2016/8/23.
 * <p>
 * 需要解析的
 * stream 流
 * stanza 节
 * message
 * presence
 * iq
 * <p>
 * 1. 流命名空间
 * <stream/> 根元素 ("流头") 必须由 'http://etherx.jabber.org/streams' (即 "流命名空间") 命名空间来限定. 如果违反了这个规则, 接受到该流头的实体必须以一个流错误来关闭流, 这个流错误应该是 <invalid-namespace/> (4.9.3.10), 尽管一些现存的实现发送的是 <bad-format/> (4.9.3.1) .
 * 2.
 */
public class XMPPDeserialize {

    /**
     * 反序列化
     *
     * @param str
     * @param <T>
     * @return
     */
    public static <T> T deserialize(String str) {

        try {
            XmlPullParserFactory pullParserFactory = XmlPullParserFactory.newInstance();
            //获取XmlPullParser的实例
            XmlPullParser xmlPullParser = pullParserFactory.newPullParser();
            //设置输入流  xml文件
            InputStream is = new ByteArrayInputStream(str.getBytes("UTF-8"));
            xmlPullParser.setInput(is, "UTF-8");
            int eventType = xmlPullParser.getEventType();
            while(eventType!=XmlPullParser.END_DOCUMENT){
                if(eventType==XmlPullParser.START_TAG){
                    String nodeName = xmlPullParser.getName();
                    return (T) ParseContext.doParse(xmlPullParser, nodeName);
                }else{
                   eventType = xmlPullParser.next();
                }
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


}
