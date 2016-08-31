package org.mazip.protocol.xmpp;

/**
 * Created by mazip on 2016/8/31.
 */
public interface Element {

    /**
     * 序列化成xml
     * @return
     */
    public CharSequence toXML();
}
