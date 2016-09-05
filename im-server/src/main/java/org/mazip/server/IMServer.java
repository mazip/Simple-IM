package org.mazip.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.mazip.server.handler.ChildHander;
import org.mazip.util.annotation.SimpleServer;
import org.mazip.util.component.AbstractLifeCycle;
import org.mazip.util.server.IServer;

/**
 * Created by mazip on 2016/8/10.
 */
@SimpleServer
public class IMServer extends AbstractLifeCycle implements IServer {
    /**
     * 初始化
     * @throws Exception
     */
    @Override
    protected void doInit() throws Exception {

    }

    @Override
    protected void doStart() throws Exception {

    }

    public static void main(String[] args) {
        new IMServer().bind(15225);
    }

    private void bind(int port){
        EventLoopGroup workGroup = new NioEventLoopGroup();
        EventLoopGroup bossGroup = new NioEventLoopGroup();

        ServerBootstrap serverBootstrap = new ServerBootstrap();

        serverBootstrap.group(bossGroup,workGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG,1024)
                .childHandler(new ChildHander());

        try {
            ChannelFuture future = serverBootstrap.bind(port).sync();
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            workGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }


    }
}
