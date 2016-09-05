import org.mazip.util.component.AbstractLifeCycle;
import org.mazip.util.component.LifeCycle;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ServiceLoader;

/**
 * Created by mazip on 2016/8/4.
 */
public class Main {
    public static void main(String[] args) {


        File f = new File("G:\\testlibs");
        File[] files = f.listFiles();
        URL[] urls = new URL[files.length];
        for(int i=0;i<files.length;i++){
            try {
                urls[i]=files[i].toURI().toURL();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

        URLClassLoader urlClassLoader =new URLClassLoader(urls);

        URL[]  u = urlClassLoader.getURLs();
        for (int i=0;i<u.length;i++){
            System.out.println(u[i].toString());
        }


        ServiceLoader<LifeCycle> serviceLoader =ServiceLoader.load(LifeCycle.class,urlClassLoader);
        for (LifeCycle service : serviceLoader) {
            System.out.println("--");
            try {
                service.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
