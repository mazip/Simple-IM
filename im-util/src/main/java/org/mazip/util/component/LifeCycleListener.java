package org.mazip.util.component;

import java.util.EventListener;

/**
 * Created by mazip on 2016/8/8.
 */
public interface LifeCycleListener extends EventListener {

    //初始化
    public void lifeCycleInitialize(LifeCycle event);


    //启动
    public void lifeCycleStarting(LifeCycle event);

    public void lifeCycleStarted(LifeCycle event);

    //阻塞
    public void lifyCycleSuspend(LifeCycle event);

    //恢复
    public void lifyCycleResume(LifeCycle event);

    //启动失败
    public void lifeCycleFailure(LifeCycle event, Throwable cause);

    //组件停止
    public void lifeCycleStopping(LifeCycle event);
    public void lifeCycleStopped(LifeCycle event);
}
