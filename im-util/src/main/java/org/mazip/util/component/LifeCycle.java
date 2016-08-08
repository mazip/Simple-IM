
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

    public boolean isSuspend();

    public boolean isResume();

    /**
     * 是否启动失败
     */
    public boolean isFailed();

    /**
     * 添加监听
     *
     * @param listener
     */
    public void addLifeCycleListener(LifeCycleListener listener);

    /**
     * 移除监听
     *
     * @param listener
     */
    public void removeLifeCycleListener(LifeCycleListener listener);
    


}
