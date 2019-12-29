package com.chiye.yswx05.ui.product;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.chiye.yswx05.common.ProductEntity;
import com.chiye.yswx05.common.ProductTypeEntity;
import com.chiye.yswx05.common.ServerUrl;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

public class ProductViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    ServerUrl serverUrl;

    public ProductViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is product fragment");

    }



    /**
     * 获取主营产品菜单列表
     *
     * @param context
     */
    public void getTypeList(final Context context, final ProductFragment fragment) {
        OkHttpUtils
                .get()
                .url(serverUrl.getProductMenu(context))
                .build()
                .execute(new StringCallback() {

                    @Override
                    public void onError(okhttp3.Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Gson gson = new Gson();
                        ProductTypeEntity productTypeEntity = gson.fromJson(response, ProductTypeEntity.class);
                        getProductList(context, productTypeEntity.getProducts().get(0).getId(), 1, fragment);
                        fragment.setProductTypeContent(productTypeEntity);
                    }
                });
    }


    /**
     * 获取产品
     *
     * @param context
     * @param fragment
     */
    public void getProductList(Context context, int id, int page, final ProductFragment fragment) {

        OkHttpUtils
                .get()
                .url(ServerUrl.getProductList(context, id, page))
                .build()
                .execute(new StringCallback() {

                    @Override
                    public void onError(okhttp3.Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Gson gson = new Gson();
                        ProductEntity productEntity = gson.fromJson(response, ProductEntity.class);
                        if (fragment != null)
                            fragment.setProductContent(productEntity);
                    }
                });


    }
}
