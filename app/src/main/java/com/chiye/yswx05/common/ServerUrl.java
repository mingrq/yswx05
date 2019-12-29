package com.chiye.yswx05.common;

import android.content.Context;
import com.chiye.yswx05.R;

public class ServerUrl {

    Context context;
    private String IP;
    public ServerUrl(Context context) {
        this.context = context;
       IP = context.getResources().getString(R.string.serverip);
    }




    /**
     * 获取桌面菜单按钮信息
     * @return
     */
    public String getHomeMenuBtn(){
        return IP+"/GetProducts?size=7";
    }
    /**
     * 获取主营产品
     * @return
     */
    public String getProductMenu(){
        return IP+"/GetProducts";
    }

    /**
     * 获取产品列表
     * @return
     */
    public String getProductList(int id,int page){
        return IP+"/GetRecommend?typeid="+id+"&ye="+page;
    }
    /**
     * 获取桌面产品信息
     * @return
     */
    public String getRecProduct(){
        return IP+"/GetRecProduct";
    }

    /**
     * 获取产品内容
     * @return
     */
    public String getProductContent(int id){
        return IP+"/GetDetail?aid="+id;
    }

}
