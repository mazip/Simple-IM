
package org.mazip.util.component;

import java.util.EventListener;

/* ------------------------------------------------------------ */

/**
 * 管理类的生命周期
 */

public interface LifeCycle {
    /**
     * 组件启动
     */
    public void start()
            throws Exception;

    /**
     * 组件关闭
     */
    public void stop()
            throws Exception;

    /**
     * 组件暂停
     *
     * @throws Exception
     */
    public void suspend() throws Exception;

    /**
     * 组件恢复
     * @throws Exception
     */
    public void resume() throws Exception;

    /**
     */
    public boolean isRunning();

    /**
     */
    public boolean isStarted();

    /**
     */
    public boolean isStarting();

    /**
     */
    public boolean isStopping();

    /**
     */
    public boolean isStopped();


    /**
     * 是否启动失败
     */
    public boolean isFailed();

    /**
     * 添加监听
     *
     * @param listener
     */
    public void addLifeCycleListener(LifeCycle.Listener listener);

    /**
     * 移除监听
     *
     * @param listener
     */
    public void removeLifeCycleListener(LifeCycle.Listener listener);
    

    /* ------------------------------------------------------------ */

    /**
     * Listener.
     * A listener for Lifecycle events.
     */
    public interface Listener extends EventListener {


        //初始化
        public void lifeCycleInitialize(LifeCycle event);

        //启动
        public void lifeCycleStarted(LifeCycle event);

        //阻塞
        public void lifyCycleSuspend(LifeCycle event);

        //恢复
        public void lifyCycleResume(LifeCycle event);

        //启动失败
        public void lifeCycleFailure(LifeCycle event, Throwable cause);

        //组件停止
        public void lifeCycleStopped(LifeCycle event);
    }
}
