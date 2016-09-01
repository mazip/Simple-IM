package org.mazip.protocol.xmpp.parse;

import org.xmlpull.v1.XmlPullParser;

/**
 * Created by mazip on 2016/8/29.
 */
public class StreamParse extends DefaultParse {

    @Override
    public XMPPStream parse(XmlPullParser xmlPullParser) {
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
