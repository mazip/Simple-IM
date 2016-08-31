package org.mazip.protocol.xmpp.parse;

import org.mazip.protocol.xmpp.Iq;
import org.mazip.protocol.xmpp.Message;
import org.mazip.protocol.xmpp.Query;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mazip on 2016/8/29.
 */
public class MessageParse extends DefaultParse {
    @Override
    public Message parse(XmlPullParser xmlPullParser) {
        Message message = new Message();

        int eventType = 0;
        try {
            message.setType(xmlPullParser.getAttributeValue(null,"type"));
            message.setTo(xmlPullParser.getAttributeValue(null,"to"));

            eventType =xmlPullParser.next();
            while(eventType!=XmlPullParser.END_DOCUMENT){
                String nodeName = xmlPullParser.getName();
                if(eventType==XmlPullParser.START_TAG){
                    if("body".equals(nodeName)){
                        message.setBody(xmlPullParser.nextText());
                    }
                }
                eventType = xmlPullParser.next();
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return message;
    }
}
