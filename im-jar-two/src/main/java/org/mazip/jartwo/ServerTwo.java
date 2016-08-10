package org.mazip.jartwo;

import org.mazip.util.annotation.SimpleServer;
import org.mazip.util.component.AbstractLifeCycle;

/**
 * Created by mazip on 2016/8/10.
 */
@SimpleServer
public class ServerTwo extends AbstractLifeCycle{

    @Override
    protected void doStart() throws Exception {
        System.out.println("我是serverTwo 我启动了");
    }
}
