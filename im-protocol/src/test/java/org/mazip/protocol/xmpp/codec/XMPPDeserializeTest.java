package org.mazip.protocol.xmpp.codec;

import org.junit.Assert;
import org.junit.Test;
import org.mazip.protocol.xmpp.XMPPStream;

/**
 * Created by mazip on 2016/8/23.
 */
public class XMPPDeserializeTest {

    @Test
    public void testDeserialize() {
//        String str = "<stream:stream\n" +
//                "       from='juliet@im.example.com'\n" +
//                "       to='im.example.com'\n" +
//                "       version='1.0'\n" +
//                "       xml:lang='en'\n" +
//                "       xmlns='jabber:client'\n" +
//                "       xmlns:stream='http://etherx.jabber.org/streams'>";
//        XMPPStream stream = XMPPDeserialize.desrialize(str);
//        Assert.assertEquals(stream.getFrom(),"juliet@im.example.com");
//        Assert.assertEquals(stream.getTo(),"im.example.com");
//        Assert.assertEquals(stream.getVersion(),"1.0");
//        Assert.assertEquals(stream.getLang(),"en");

        XMPPDeserialize.desrialize("</stream:stream>");


    }
}
