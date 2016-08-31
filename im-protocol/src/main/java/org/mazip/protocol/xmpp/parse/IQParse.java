package org.mazip.protocol.xmpp.parse;

import org.mazip.protocol.xmpp.Iq;
import org.mazip.protocol.xmpp.Query;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mazip on 2016/8/29.
 */
public class IQParse extends DefaultParse {


    @Override
    public Iq parse(XmlPullParser xmlPullParser) {

        Iq iq = new Iq();
        int eventType = 0;
        try {
            iq.setType(xmlPullParser.getAttributeValue(null,"type"));
            iq.setId(xmlPullParser.getAttributeValue(null,"id"));
            Query query=null;
            Map<String,String> map=null;
            eventType =xmlPullParser.next();
            while(eventType!=XmlPullParser.END_DOCUMENT){
                String nodeName = xmlPullParser.getName();
                if(eventType==XmlPullParser.START_TAG){
                    if("query".equals(nodeName)){
                        query = new Query();
                        query.setXmlns(xmlPullParser.getAttributeValue(null,"xmlns"));
                    }else if("list".equals(nodeName)){

                    }else if("iq".equals(nodeName)){

                    }else{
                        if(map==null){
                            map = new HashMap<String,String>();
                        }
                        map.put(nodeName,xmlPullParser.nextText());
                    }
                }
                eventType = xmlPullParser.next();
            }
            query.setAttrs(map);
            iq.setQuery(query);
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return iq;
    }
}
