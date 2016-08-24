package org.mazip.protocol.xmpp;

/**
 * Created by mazip on 2016/8/24.
 */
public class Message extends Packet {

    public static final  String  START_TAG="message";

    private String body;

    private String type;

    private String to;

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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
