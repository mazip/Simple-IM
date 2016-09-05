package org.mazip.util.config;

/**
 * Created by mazip on 2016/8/11.
 */
public class ConfigItem {
    //field

    //mod 模块
    private Mod mod;
    //ver 版本
    private String ver;
    //

    public Mod getMod() {
        return mod;
    }

    public void setMod(Mod mod) {
        this.mod = mod;
    }

    public String getVer() {
        return ver;
    }

    public void setVer(String ver) {
        this.ver = ver;
    }
}
