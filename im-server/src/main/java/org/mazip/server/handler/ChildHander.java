package org.mazip.server.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

import java.util.HashMap;

/**
 * Created by mazip on 2016/8/19.
 */
public class ChildHander extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        XMPPHandler xmppHandler = new XMPPHandler();
        xmppHandler.chMap=new HashMap<String, ChannelHandlerContext>();
        ch.pipeline().addFirst(xmppHandler);
    }
}
