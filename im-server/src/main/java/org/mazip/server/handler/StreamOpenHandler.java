package org.mazip.server.handler;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import org.jivesoftware.smack.packet.StartTls;
import org.jivesoftware.smack.packet.StreamError;
import org.jivesoftware.smack.packet.StreamOpen;
import org.jivesoftware.smack.util.MultiMap;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.mazip.util.reflect.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/**
 * Created by mazip on 2016/9/5.
 */
public class StreamOpenHandler extends ChannelHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        String reply;
        //客户端发来StreamOpen的请求
        MultiMap multiMap =(MultiMap) msg;
        List list= multiMap.values();
        Iterator iterator= list.iterator();
        while(iterator.hasNext()){
            Object itr = iterator.next();
            if(itr instanceof StreamOpen){
                Field to= ReflectionUtils.findField(itr.getClass(),"to");
                to.setAccessible(true);
                if(!"icloudedu.net".equals(to.get(itr).toString())){
                    StreamError streamError = new StreamError(StreamError.Condition.host_unknown,null,null,null);
                    reply=streamError.toXML().toString();
                    ctx.writeAndFlush(reply);
                }else{
                    Field from= ReflectionUtils.findField(itr.getClass(),"from");
                    from.setAccessible(true);
                    String sto = "";
                    if(from.get(itr)!=null){
                        sto = from.get(itr).toString();
                    }else{
                        sto=null;
                    }
                    Field lang= ReflectionUtils.findField(itr.getClass(),"lang");
                    StreamOpen streamOpen = new StreamOpen(sto,to.get(itr).toString(), UUID.randomUUID().toString(),lang.get(itr).toString(),StreamOpen.StreamContentNamespace.server);
                    StartTls startTls = new StartTls(false);
                    reply = streamOpen.toXML().append("<stream:features>").append(startTls.toXML()).append("</stream:features>").toString();
                    ctx.writeAndFlush(reply);
                }

            }
        }


    }
}
