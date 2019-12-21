package com.chiye.yswx05.common;

import android.content.Context;
import com.chiye.yswx05.R;

public class ServerUrl {


    /**
     * 获取桌面菜单按钮信息
     * @return
     */
    public static String getHomeMenuBtn(Context context){
        return context.getResources().getString(R.string.serverip)+"/GetProducts?size=7";
    }
    /**
     * 获取主营产品
     * @return
     */
    public static String getProductMenu(Context context){
        return context.getResources().getString(R.string.serverip)+"/GetProducts";
    }

    /**
     * 获取桌面产品信息
     * @return
     */
    public static String getRecProduct(Context context){
        return context.getResources().getString(R.string.serverip)+"/GetRecProduct";
    }
}
