package org.mazip.util.config;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mazip on 2016/8/11.
 */
public class TestConfig {

    @Test
    public void testConfig(){

        ConfigItem configItem = new ConfigItem();
        configItem.setVer("0.0.1");
        Mod mod = new Mod();
        mod.setDepend("mod1");
        mod.setConfPath("222");
        List<String> s = new ArrayList<String>();
        s.add("333");
        mod.setLibs(s);
        mod.setName("mod");
        configItem.setMod(mod);
        System.out.println(JSON.toJSON(configItem).toString());

    }
}
