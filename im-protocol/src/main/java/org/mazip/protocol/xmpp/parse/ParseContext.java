package org.mazip.protocol.xmpp.parse;

import org.xmlpull.v1.XmlPullParser;

/**
 * Created by mazip on 2016/8/29.
 */
public class ParseContext {


    public static Object doParse(XmlPullParser pullParser,String key){
        Parse parse= ParseFactory.getInstance().doParse(key);
        return parse.parse(pullParser);
    }

}
