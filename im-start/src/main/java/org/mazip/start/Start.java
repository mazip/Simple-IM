package org.mazip.start;

import org.mazip.start.exception.UsageException;

/**
 * Created by mazip on 2016/8/19.
 */
public class Start {


    /**
     * 项目启动
     * @param args
     */
    public static void main(String[] args) {
//        try
//        {
//            // 解析参数
//            // 启动
//            proccessArgs(args);
//            main.start(startArgs);
//        }
//        catch (UsageException e)
//        {
//            System.err.println(e.getMessage());
//            usageExit(e.getCause(),e.getExitCode());
//        }
//        catch (Throwable e)
//        {
//            usageExit(e,UsageException.ERR_UNKNOWN);
//        }


        //检查配置项
        checkConf();
        //加载模块
        loadMod();
        //启动
        doStart();
    }


    private static void proccessArgs(String[] args) throws UsageException {

    }

    /**
     * 检查配置项
     */
    private static void checkConf(){

    }

    /**
     * 加载模块
     */
    private static void loadMod(){

    }

    /**
     * 启动
     */
    private static void doStart(){

    }


}
