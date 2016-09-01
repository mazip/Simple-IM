package org.mazip.protocol.xmpp.parse;

import org.xmlpull.v1.XmlPullParser;

/**
 * Created by mazip on 2016/8/29.
 */
public class StreamFeatureParse extends DefaultParse {
    @Override
    public XMPPStreamFeatures parse(XmlPullParser xmlPullParser) {
        XMPPStreamFeatures xmppStreamFeatures = new XMPPStreamFeatures();
        return xmppStreamFeatures;
    }
}
