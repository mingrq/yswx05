package com.chiye.yswx05.ui.home;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.chiye.yswx05.common.ProductEntity;
import com.chiye.yswx05.common.ServerUrl;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

public class HomeViewModel extends ViewModel {


    /**
     * 获取分类按钮
     * @param context
     * @param homeFragment
     */
    public void getBtnList(Context context, final HomeFragment homeFragment) {

        OkHttpUtils
                .get()
                .url(ServerUrl.getHomeMenuBtn(context))
                .build()
                .execute(new StringCallback() {

                    @Override
                    public void onError(okhttp3.Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Gson gson = new Gson();
                        RcyBtnEntity rcyBtnEntity= gson.fromJson(response,RcyBtnEntity.class);
                        homeFragment.setContent(rcyBtnEntity);
                    }
                });


    }

    /**
     * 获取热门产品
     * @param context
     * @param homeFragment
     */
    public void getProductList(Context context, final HomeFragment homeFragment) {

        OkHttpUtils
                .get()
                .url(ServerUrl.getRecProduct(context))
                .build()
                .execute(new StringCallback() {

                    @Override
                    public void onError(okhttp3.Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Gson gson = new Gson();
                        ProductEntity productEntity= gson.fromJson(response,ProductEntity.class);
                        homeFragment.setProductContent(productEntity);
                    }
                });


    }
    /**
     * 设置轮播图数据
     * @return
     */
    public LiveData<List<String>> getSlidowList() {
         MutableLiveData<List<String>> listMutableLiveData = new MutableLiveData<>();
        List<String> list = new ArrayList<>();
        list.add("http://www.chiyekeji.com/uploads/20180427/1524818741514024.jpg");
        list.add("http://p1.pccoo.cn/post/20140323/201403231052181880.jpg");
        listMutableLiveData.setValue(list);
        return listMutableLiveData;
    }
}