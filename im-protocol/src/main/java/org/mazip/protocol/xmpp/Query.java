package org.mazip.protocol.xmpp;

import java.util.Map;

/**
 * Created by mazip on 2016/8/23.
 */
public class Query {

    /** Field description */
    public static final String XMLNS_ATTR = "xmlns";

    private String xmlns;

    private Map<String,String> attrs;

    public Map<String, String> getAttrs() {
        return attrs;
    }

    public void setAttrs(Map<String, String> attrs) {
        this.attrs = attrs;
    }

    public String getXmlns() {
        return xmlns;
    }

    public void setXmlns(String xmlns) {
        this.xmlns = xmlns;
    }
}
