package org.mazip.server.handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.buffer.UnpooledHeapByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import org.mazip.protocol.xmpp.codec.XMPPSerialize;
import org.mazip.server.manager.C2SConnectManager;

import java.util.List;

/**
 * Created by mazip on 2016/8/29.
 */
public class MessageEncoder extends MessageToMessageEncoder {


    @Override
    protected void encode(ChannelHandlerContext ctx, Object msg, List out) throws Exception {
        if(msg instanceof UnpooledHeapByteBuf){
            ctx.write(msg);
        }else{
            String encodeStr=XMPPSerialize.serialize(msg);
            System.out.println("服务端返回:" + encodeStr);
            ByteBuf buf = Unpooled.copiedBuffer(encodeStr.getBytes());
            if(msg instanceof  Message){
                Message message =(Message)msg;
                C2SConnectManager.getConnection(message.getTo().split("\\@")[0]).writeAndFlush(buf);
            }else{
                ctx.write(buf);
            }
        }

    }
}
