package com.chiye.yswx05;

import android.content.Context;

import com.chiye.yswx05.common.ServerUrl;
import com.chiye.yswx05.ui.ProductContentActivity;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

public class ProductContentModel {
    private ProductContentActivity activity;
    ServerUrl serverUrl;
    public ProductContentModel(ProductContentActivity activity) {
        this.activity = activity;
        this.serverUrl =new ServerUrl(activity);
    }

    public void getContent(int cid) {
        OkHttpUtils
                .get()
                .url(serverUrl.getProductContent( cid))
                .build()
                .execute(new StringCallback() {

                    @Override
                    public void onError(okhttp3.Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Gson gson = new Gson();
                        ProductContentEntity entity = gson.fromJson(response, ProductContentEntity.class);
                        if (activity!=null)
                            activity.setContent(entity);
                    }
                });
    }
}
