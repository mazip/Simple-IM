package org.mazip.protocol.xmpp.codec;

import org.junit.Test;
import org.mazip.protocol.xmpp.XMPPStream;

/**
 * Created by mazip on 2016/8/23.
 */
public class XMPPSerializeTest {

    @Test
    public void testSerialize(){

        XMPPStream stream = new XMPPStream();
        stream.setFrom("juliet@im.example.com");
        stream.setTo("im.example.com");
        stream.setLang("en");
        stream.setVersion("1.0");
        stream.setXmlns("jabber:client");
        stream.setXmlnsStream("http://etherx.jabber.org/streams");
        String s = XMPPSerialize.serialize(stream);
        System.out.println(s);
    }
}
