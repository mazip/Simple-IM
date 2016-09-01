package org.mazip.protocol.xmpp.parse;

import org.xmlpull.v1.XmlPullParser;

/**
 * Created by mazip on 2016/8/29.
 */
public class PresenceParse extends DefaultParse{
    @Override
    public Presence parse(XmlPullParser xmlPullParser) {
        Presence presence = new Presence();
        return presence;
    }
}
