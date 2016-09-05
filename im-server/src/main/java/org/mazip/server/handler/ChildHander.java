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
        // StreamOpenHandler       初始化的处理器
        // loginHandler      登录的处理器
        // chatHandler       聊天的处理器
        // mucHandler        群聊的处理器
        // stateHandler      状态更改的处理器
        // 调用read 从head-->tail 调用write 从tail-->head
        // head-->MessageDecoder-->tail
        ch.pipeline().addLast(new MessageDecoder(10240,4,4));
        // head-->MessageDecoder-->StreamOpenHandler-->tail
        ch.pipeline().addLast(new StreamOpenHandler());
        // head-->MessageDecoder-->StreamOpenHandler-->XMPPHandler-->tail
        //ch.pipeline().addLast(new XMPPHandler());
        //TODO:心跳处理
    }
}
