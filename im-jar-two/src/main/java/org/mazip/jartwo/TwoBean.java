package org.mazip.jartwo;

import org.mazip.util.component.LifeCycle;
import org.mazip.util.component.LifeCycleListener;


/**
 * Created by mazip on 2016/8/4.
 */
public class TwoBean implements LifeCycle {

    private TwoService twoService;


    public void start() throws Exception {
        System.out.println("two start");
        twoService=new TwoService();
        twoService.test();
    }

    public void stop() throws Exception {

    }

    @Override
    public void suspend() throws Exception {

    }

    @Override
    public void resume() throws Exception {

    }

    public boolean isRunning() {
        return false;
    }

    public boolean isStarted() {
        return false;
    }

    public boolean isStarting() {
        return false;
    }

    public boolean isStopping() {
        return false;
    }

    public boolean isStopped() {
        return false;
    }

    @Override
    public boolean isSuspend() {
        return false;
    }

    @Override
    public boolean isResume() {
        return false;
    }

    public boolean isFailed() {
        return false;
    }

    @Override
    public void addLifeCycleListener(LifeCycleListener listener) {

    }

    @Override
    public void removeLifeCycleListener(LifeCycleListener listener) {

    }


}
