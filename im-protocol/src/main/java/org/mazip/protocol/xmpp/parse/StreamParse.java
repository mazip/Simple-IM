package org.mazip.protocol.xmpp.parse;

import org.jivesoftware.smack.packet.StreamOpen;
import org.mazip.protocol.xmpp.util.XParseUtils;
import org.xmlpull.v1.XmlPullParser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mazip on 2016/8/29.
 */
public class StreamParse extends DefaultParse {

    @Override
    public List parse(XmlPullParser xmlPullParser) {
        List list= new ArrayList();
        String to = XParseUtils.getStringAttribute(xmlPullParser, "to");
        String from = XParseUtils.getStringAttribute(xmlPullParser, "from");
        String id = XParseUtils.getStringAttribute(xmlPullParser, "id");
        String lang = XParseUtils.getStringAttribute(xmlPullParser, "xmlns:lang");
        StreamOpen xmppStream = new StreamOpen(to, from, id, lang, StreamOpen.StreamContentNamespace.client);
        list.add(xmppStream);
        return list;
    }
}
