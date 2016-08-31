package org.mazip.protocol.xmpp.parse;


import org.xmlpull.v1.XmlPullParser;

/**
 * Created by mazip on 2016/8/29.
 */
public interface Parse {

    public Object parse(XmlPullParser xmlPullParser);

}
