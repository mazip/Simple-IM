package org.mazip.server.handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import org.mazip.protocol.xmpp.Iq;
import org.mazip.protocol.xmpp.Message;
import org.mazip.protocol.xmpp.Query;
import org.mazip.protocol.xmpp.XMPPStream;
import org.mazip.protocol.xmpp.codec.XMPPDeserialize;
import org.mazip.protocol.xmpp.codec.XMPPSerialize;

import java.lang.reflect.Member;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mazip on 2016/8/19.
 */
public class XMPPHandler extends ChannelHandlerAdapter {


    public static Map<String, ChannelHandlerContext> chMap;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        System.out.println("id:" + ctx.channel().id());

        ByteBuf byteBuf = (ByteBuf) msg;
        byte[] req = new byte[byteBuf.readableBytes()];
        byteBuf.readBytes(req);
        String body = new String(req, "UTF-8");
        System.out.println("客户端:" + body);
        if ("</stream:stream>".equals(body)) {

            System.out.println("流结束");
        } else {


            Object t = XMPPDeserialize.desrialize(body);
            if (t instanceof XMPPStream) {
                XMPPStream stream = (XMPPStream) t;
                String from = stream.getFrom();
                String to = stream.getTo();
                if (from != null) {
                    stream.setFrom(to);
                }
                stream.setTo(from);
                String streamstr = XMPPSerialize.serialize(stream);
                System.out.println("返回:" + streamstr);
                ByteBuf buf = Unpooled.copiedBuffer(streamstr.getBytes());
                ctx.write(buf);
            } else if (t instanceof Iq) {
                Iq iq = (Iq) t;
                if ("get".equals(iq.getType())) {
                    if ("jabber:iq:auth".equals(iq.getQuery().getXmlns())) {
                        Iq result = new Iq();
                        result.setId(iq.getId());
                        result.setType("result");
                        Query query = new Query();
                        query.setXmlns("jabber:iq:auth");
                        Map<String, String> map = new HashMap<String, String>();
                        map.put("username", "username");
                        map.put("password", "password");
                        map.put("digest", "digest");
                        map.put("resource", "resource");
                        query.setAttrs(map);
                        result.setQuery(query);
                        String s1 = XMPPSerialize.serialize(result);
                        s1 = s1.replace("<?xml version='1.0' encoding='utf-8' standalone='yes' ?>", "");
                        System.out.println("返回:" + s1);
                        ByteBuf buf = Unpooled.copiedBuffer(s1.getBytes());
                        ctx.write(buf);
                    } else if ("jabber:iq:roster".equals(iq.getQuery().getXmlns())) {
                        Iq result = new Iq();
                        result.setId(iq.getId());
                        result.setType("result");
                        Query query = new Query();
                        query.setXmlns("jabber:iq:roster");
                        result.setQuery(query);
                        String s1 = XMPPSerialize.serialize(result);
                        s1 = s1.replace("<?xml version='1.0' encoding='utf-8' standalone='yes' ?>", "");
                        System.out.println("返回:" + s1);
                        ByteBuf buf = Unpooled.copiedBuffer(s1.getBytes());
                        ctx.write(buf);
                    }
                } else if ("set".equals(iq.getType())) {
                    if ("jabber:iq:auth".equals(iq.getQuery().getXmlns())) {
                        Iq result = new Iq();
                        result.setId(iq.getId());
                        result.setType("result");
                        String s1 = XMPPSerialize.serialize(result);
                        s1 = s1.replace("<?xml version='1.0' encoding='utf-8' standalone='yes' ?>", "");
                        System.out.println("返回:" + s1);
                        ByteBuf buf = Unpooled.copiedBuffer(s1.getBytes());
                        ctx.write(buf);
                        String username = iq.getQuery().getAttrs().get("username").toString();
                        chMap.put(username, ctx);
                    }

                }
            }else if(t instanceof Message){
                Message message=(Message) t;
                if("chat".equals(message.getType())){
                    String[] s =message.getTo().split("\\@");
                    ChannelHandlerContext ctx1= chMap.get(s[0]);
                    String ss = "<message type=\"chat\" from=\"1001@icloudedu.net\" to=\"1002@icloudedu.net\" >\n" +
                            "<body>1111</body>\n" +
                            "<active xmlns=\"http://jabber.org/protocol/chatstates\"/>\n" +
                            "</message>";
                    ByteBuf buf = Unpooled.copiedBuffer(ss.getBytes());
                    ctx1.write(buf);
                    ctx1.flush();
                }

            }

        }

//        String currentTime ="query time order".equalsIgnoreCase(body)?new Date(System.currentTimeMillis()).toString():"bad order";
//
//        ByteBuf buf = Unpooled.copiedBuffer(currentTime.getBytes());
//        ctx.write(buf);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }


}
