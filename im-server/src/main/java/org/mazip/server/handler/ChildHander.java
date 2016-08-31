package org.mazip.server.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;

import java.util.HashMap;

/**
 * Created by mazip on 2016/8/19.
 */
public class ChildHander extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        //TODO:最大包长度
        //TODO：研究这里的顺序 涉及到了输入输出流的方向
        // 调用read 从head-->tail 调用write 从tail-->head
        // head-->MessageDecoder-->tail
        ch.pipeline().addLast(new MessageDecoder(10240,4,4));
        // head-->MessageDecoder-->MessageEncoder-->tail
        ch.pipeline().addLast(new MessageEncoder());
        // head-->MessageDecoder-->MessageEncoder-->XMPPHandler-->tail
        ch.pipeline().addLast(new XMPPHandler());
        //TODO:心跳处理
    }
}
