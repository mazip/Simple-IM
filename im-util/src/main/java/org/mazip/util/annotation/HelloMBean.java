package org.mazip.util.annotation;

/**
 * Created by mazip on 2016/8/24.
 */
public interface HelloMBean {
    public String getName();
    public void setName(String name);
    public void printHello();
    public void printHello(String whoName);
}
