package org.mazip.server.manager;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by mazip on 2016/8/29.
 * client-->to-->server
 */
public class C2SConnectManager {

    private static final Map<String, ChannelHandlerContext> connection = new ConcurrentHashMap<String, ChannelHandlerContext>();



    /**
     * 添加链接
     *
     * @param uid
     * @param channelHandlerContext
     */
    public static void addConnection(String uid, ChannelHandlerContext channelHandlerContext) {
        connection.put(uid, channelHandlerContext);
    }

    /**
     * 移除链接
     *
     * @param uid
     */
    public static void removeConnection(String uid) {
        connection.remove(uid);
    }

    /**
     * 获取连接
     *
     * @param uid
     * @return
     */
    public static ChannelHandlerContext getConnection(String uid) {
        return connection.get(uid);
    }

    /**
     * 获取连接个数
     *
     * @return
     */
    public static int getConnCount() {
        return connection.size();
    }

}
