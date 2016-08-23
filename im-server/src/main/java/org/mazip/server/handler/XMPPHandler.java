package org.mazip.server.handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import org.mazip.protocol.xmpp.XMPPStream;
import org.mazip.protocol.xmpp.codec.XMPPDeserialize;

import java.util.Date;

/**
 * Created by mazip on 2016/8/19.
 */
public class XMPPHandler extends ChannelHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        byte[] req = new byte[byteBuf.readableBytes()];
        byteBuf.readBytes(req);
        String body=new String(req,"UTF-8");
        System.out.println(body);
        Object t = XMPPDeserialize.desrialize(body);
        if(t instanceof XMPPStream){

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
