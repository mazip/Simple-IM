package org.mazip.protocol.xmpp;

import org.mazip.protocol.xmpp.annotation.XMPPATTR;

/**
 * Created by mazip on 2016/8/23.
 */
public class Packet {


    @XMPPATTR("from")
    private String from;
    @XMPPATTR("to")
    private String to;
    @XMPPATTR("type")
    private String type;
    @XMPPATTR("id")
    private String id;
    @XMPPATTR("xmlns:lang")
    private String lang;
    @XMPPATTR("jabber:client")
    private String clientXMLNS;
    @XMPPATTR("jabber:server")
    private String serverXMLNS;
    @XMPPATTR("xmlns")
    private String XMLNS;
    @XMPPATTR("perm")
    private String perm;
    @XMPPATTR("pr")
    private String priority;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getClientXMLNS() {
        return clientXMLNS;
    }

    public void setClientXMLNS(String clientXMLNS) {
        this.clientXMLNS = clientXMLNS;
    }

    public String getServerXMLNS() {
        return serverXMLNS;
    }

    public void setServerXMLNS(String serverXMLNS) {
        this.serverXMLNS = serverXMLNS;
    }

    public String getXMLNS() {
        return XMLNS;
    }

    public void setXMLNS(String XMLNS) {
        this.XMLNS = XMLNS;
    }

    public String getPerm() {
        return perm;
    }

    public void setPerm(String perm) {
        this.perm = perm;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
