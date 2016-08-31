package org.mazip.protocol.xmpp;

import org.mazip.protocol.xmpp.annotation.StartTag;
import org.mazip.protocol.xmpp.annotation.XMPPChild;

/**
 * Created by mazip on 2016/8/24.
 */
@StartTag("message")
public class Message extends Packet {


    @XMPPChild("body")
    private String body;


    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
