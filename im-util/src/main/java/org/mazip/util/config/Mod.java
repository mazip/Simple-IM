package org.mazip.util.config;

import java.util.List;

/**
 * Created by mazip on 2016/8/11.
 */
public class Mod {

    private String Name;
    // 依赖
    private String depend;
    // lib
    private List<String> libs;
    // 配置文件地址
    private String confPath;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDepend() {
        return depend;
    }

    public void setDepend(String depend) {
        this.depend = depend;
    }

    public List<String> getLibs() {
        return libs;
    }

    public void setLibs(List<String> libs) {
        this.libs = libs;
    }

    public String getConfPath() {
        return confPath;
    }

    public void setConfPath(String confPath) {
        this.confPath = confPath;
    }
}
