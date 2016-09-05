package org.mazip.protocol.xmpp.parse;

/**
 * Created by mazip on 2016/8/29.
 */
public enum ParseEnum {

    STREAM("stream:stream"),
    STREAMFEATURES("stream:features"),
    IQ("iq"),
    MESSAGE("message"),
    PRESENCE("presence")
    ;

    private String text;
    private ParseEnum(String text){

        this.text=text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


}
