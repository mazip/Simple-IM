package org.mazip.protocol.xmpp;

import org.mazip.protocol.xmpp.annotation.StartTag;
import org.mazip.protocol.xmpp.annotation.XMPPATTR;
import org.mazip.protocol.xmpp.annotation.XMPPChild;

import java.util.Map;

/**
 * Created by mazip on 2016/8/23.
 */
@StartTag("query")
public class Query {


    @XMPPATTR("xmlns")
    private String xmlns;
    @XMPPChild()
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
