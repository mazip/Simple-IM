package org.mazip.protocol.xmpp.util;

import org.jivesoftware.smack.util.ParserUtils;
import org.xmlpull.v1.XmlPullParser;

/**
 * Created by mazip on 2016/9/5.
 */
public class XParseUtils extends ParserUtils {

    public static String getStringAttribute(XmlPullParser parser, String name) {
       return parser.getAttributeValue(null,name);
    }
}
