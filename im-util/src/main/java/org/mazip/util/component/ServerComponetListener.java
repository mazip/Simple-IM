package org.mazip.util.component;

/**
 * Created by mazip on 2016/8/9.
 */
public class ServerComponetListener implements LifeCycleListener {
    public void lifeCycleInitialize(LifeCycle event) {
        System.out.println("初始化。。。。。。。。。。。。");
    }

    public void lifeCycleStarting(LifeCycle event) {
        System.out.println("启动中。。。。。。。。。。。");
    }

    public void lifeCycleStarted(LifeCycle event) {
        System.out.println("已启动。。。。。。。。。。。");
    }

    public void lifyCycleSuspend(LifeCycle event) {
        System.out.println("阻断。。。。。。。。。。。");
    }

    public void lifyCycleResume(LifeCycle event) {
        System.out.println("恢复。。。。。。。。。。。");
    }

    public void lifeCycleFailure(LifeCycle event, Throwable cause) {
        System.out.println("失败。。。。。。。。");
    }

    public void lifeCycleStopping(LifeCycle event) {
        System.out.println("停止中。。。。。。。。。。");
    }

    public void lifeCycleStopped(LifeCycle event) {
        System.out.println("已停止。。。。。。。。。。");
    }
}
