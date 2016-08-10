package org.mazip.jartwo;

import org.junit.Test;
import org.mazip.util.annotation.SimpleServer;
import org.mazip.util.context.ClassUtil;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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

        List<Class> classes1 = classUtil.getClasssFromJarFile("E:\\Simple-IM\\Simple-IM\\im-jar-two\\target\\im-jar-two-1.0-SNAPSHOT.jar");

        classes1.forEach(x->{
            if(x.getAnnotation(SimpleServer.class)!=null){
                System.out.println(x.getName());
            }
        });
    }



    @Test
    public void testAnnotationStart(){
        ClassUtil classUtil = new ClassUtil();
        List<Class> classes1 = classUtil.getClasssFromJarFile("E:\\Simple-IM\\Simple-IM\\im-jar-two\\target\\im-jar-two-1.0-SNAPSHOT.jar");

        classes1.forEach(x->{
            if(x.getAnnotation(SimpleServer.class)!=null){
                try {
                    Method method =    x.getDeclaredMethod("doStart",(Class[])null);
                    method.setAccessible(true);
                    method.invoke(x.newInstance(),null);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
