package org.mazip.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Created by mazip on 2016/8/7.
 */
public class TimeServer {

    // pipline就是一根管道 handler来处理  HeadHandler-->handler1-->handler2-->TailHandler
    public void bind(int port){

        //EventLoop 是处理所有注册到本线路上的多路复用器Selector上的channel
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        //1.创建serverBootstrap实例
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap
                .group(bossGroup,workerGroup)//2.设置并绑定Reactor线程池
                .channel(NioServerSocketChannel.class)//3.设置并绑定服务端channel
                .option(ChannelOption.SO_BACKLOG,1024)//backlog 指定了内核为此套接口排队的最大连接数
                .childHandler(new ChildHander());
        try {
           ChannelFuture future = bootstrap.bind(port).sync();
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
           workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }

    }

    private class ChildHander extends ChannelInitializer<SocketChannel>{

        @Override
        protected void initChannel(SocketChannel ch) throws Exception {
            ch.pipeline().addLast(new TimeServerHandler());
        }
    }

    public static void main(String[] args) {

        new TimeServer().bind(8080);
    }
}
