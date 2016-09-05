package org.mazip.util.component;

/**
 * Created by mazip on 2016/8/9.
 */
public class ServerComponent extends AbstractLifeCycle {


    @Override
    protected void doStart() throws Exception {
        System.out.println("啦啦啦啦啦啦 我启动了");
    }

    @Override
    protected void doStop() throws Exception {
        System.out.println("啦啦啦啦啦啦 我停止了");
    }

    @Override
    protected void doSuspend() throws Exception {
        System.out.println("啦啦啦啦啦啦 谁阻断了我");
    }

    @Override
    protected void doResume() throws Exception {
        System.out.println("啦啦啦啦啦啦 谁又把我恢复了");
    }
}
