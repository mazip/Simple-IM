package org.mazip.jarone;

import org.mazip.util.component.LifeCycle;


/**
 * Created by mazip on 2016/8/4.
 */
public class OneBean implements LifeCycle{

    private OneService oneService;


    public void start() throws Exception {
        System.out.println("one start");
        oneService=new OneService();
        oneService.test();
    }

    public void stop() throws Exception {

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

    public boolean isFailed() {
        return false;
    }

    public void addLifeCycleListener(Listener listener) {

    }

    public void removeLifeCycleListener(Listener listener) {

    }
}
