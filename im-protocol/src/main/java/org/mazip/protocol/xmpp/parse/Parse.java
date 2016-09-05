package org.mazip.protocol.xmpp.parse;


import org.xmlpull.v1.XmlPullParser;

import java.util.List;

/**
 * Created by mazip on 2016/8/29.
 */
public interface Parse {

    public List parse(XmlPullParser xmlPullParser);

}
