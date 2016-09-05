package org.mazip.util.context;

import org.junit.Test;
import org.mazip.util.annotation.SimpleServer;

import java.util.List;

/**
 * Created by mazip on 2016/8/10.
 */
public class TestClassUtil {


    @Test
    public void testClassAnnotation(){

        ClassUtil classUtil = new ClassUtil();
        List<Class> classes = classUtil.getClasssFromPackage("org");

        classes.forEach(x->{
           if(x.getAnnotation(SimpleServer.class)!=null){
               System.out.println(x.getName());
           }
        });
    }

}
