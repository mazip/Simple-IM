package org.mazip.protocol.xmpp.codec;

import org.junit.Test;
import org.mazip.protocol.xmpp.Iq;
import org.mazip.protocol.xmpp.Query;
import org.mazip.protocol.xmpp.XMPPStream;

import java.util.HashMap;
import java.util.Map;

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


        Iq iq = new Iq();
        iq.setId("auth-1");
        iq.setType("result");
        Query query = new Query();
        query.setXmlns("jabber:iq:auth");
        Map<String,String> map = new HashMap<String,String>();
        map.put("username",null);
        map.put("password",null);
        map.put("digest",null);
        map.put("resource",null);
        query.setAttrs(map);
        iq.setQuery(query);
        String s1 = XMPPSerialize.serialize(iq);
        System.out.println(s1);
    }
}
