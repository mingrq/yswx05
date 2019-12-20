package com.chiye.yswx05.common;

import com.chiye.yswx05.BuildConfig;

public class ServerUrl {

    private static String ServerIp = BuildConfig.ServerIp;//服务器地址

    /**
     * 获取桌面菜单按钮信息
     * @return
     */
    public static String getHomeMenuBtn(){
        return ServerIp+"/GetProducts?size=7";
    }


    /**
     * 获取桌面产品信息
     * @return
     */
    public static String getRecProduct(){
        return ServerIp+"/GetRecProduct";
    }
}
