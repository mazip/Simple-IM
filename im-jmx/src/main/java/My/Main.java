package My;

import MXBean.com.example.mxbeans.QueueSampler;

import javax.management.*;
import java.lang.management.ManagementFactory;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by mazip on 2016/8/25.
 */
public class Main {
    public static void main(String[] args) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException, InterruptedException {

        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName name =
                new ObjectName("My:type=First");


        Basic mxbean = new First();

        // Register the Queue Sampler MXBean
        mbs.registerMBean(mxbean, name);


        // Wait forever
        System.out.println("Waiting...");
        Thread.sleep(Long.MAX_VALUE);

    }
}
