package org.mazip.util.component;

/**
 * Created by mazip on 2016/8/8.
 * 生命周期的几种状态
 * NEW 初始化 启动 运行中 中断 恢复 停止
 */
public enum LifeCycleState {

    NEW,

    INITIALIZE,

    STARTTING,

    STARTED,

    SUSPEND,

    RESUME,

    STOPPING,

    STOPPED,

    FAILED


}
