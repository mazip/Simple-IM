package org.mazip.util.component;

import org.junit.Test;

/**
 * Created by mazip on 2016/8/9.
 */

public class TestComponent {

    @Test
    public void testServerComponet(){

        ServerComponent serverComponent = new ServerComponent();
        serverComponent.addLifeCycleListener(new ServerComponetListener());
        try {
            serverComponent.start();
            serverComponent.suspend();
            serverComponent.resume();
            serverComponent.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
