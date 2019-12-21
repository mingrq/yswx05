package com.chiye.yswx05.ui;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.chiye.yswx05.ProductContentEntity;
import com.chiye.yswx05.R;
import com.chiye.yswx05.common.ProductEntity;
import com.chiye.yswx05.common.ServerUrl;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

public class ProductContentActivity extends AppCompatActivity {


    private TextView tvProductContentTit;
    private ImageView ivProductContentTit;
    private WebView tvProductContent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productcontent);
        tvProductContentTit = findViewById(R.id.tv_product_content_tit);
        ivProductContentTit = findViewById(R.id.iv_product_content_tit);
        tvProductContent = findViewById(R.id.tv_product_content);
        setTitle(getResources().getString(R.string.comanyname));//设置标题
        Intent intent = getIntent();
        int cid = intent.getIntExtra("cid",0);
        getContent(cid);
    }

    public void getContent(int cid) {
        OkHttpUtils
                .get()
                .url(ServerUrl.getProductContent(this, cid))
                .build()
                .execute(new StringCallback() {

                    @Override
                    public void onError(okhttp3.Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Gson gson = new Gson();
                        ProductContentEntity entity = gson.fromJson(response, ProductContentEntity.class);
                        setContent(entity);
                    }
                });
    }

    private void setContent(ProductContentEntity entity) {
        tvProductContentTit.setText(entity.getProductDetail().getName());
        Glide.with(this).load(entity.getProductDetail().getLitpic()).into(ivProductContentTit);
        tvProductContent.loadData(entity.getProductDetail().getDetail(), "text/html", "UTF-8");
    }
}
