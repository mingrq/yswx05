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
     * 获取产品列表
     * @return
     */
    public static String getProductList(Context context,int id,int page){
        return context.getResources().getString(R.string.serverip)+"/GetRecommend?typeid="+id+"&ye="+page;
    }
    /**
     * 获取桌面产品信息
     * @return
     */
    public static String getRecProduct(Context context){
        return context.getResources().getString(R.string.serverip)+"/GetRecProduct";
    }

    /**
     * 获取产品内容
     * @return
     */
    public static String getProductContent(Context context,int id){
        return context.getResources().getString(R.string.serverip)+"/GetDetail?aid="+id;
    }

}
