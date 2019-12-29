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
import com.chiye.yswx05.ProductContentModel;
import com.chiye.yswx05.R;

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
        ProductContentModel model = new ProductContentModel(this);
        model.getContent(cid);
    }



    public void setContent(ProductContentEntity entity) {
        tvProductContentTit.setText(entity.getProductDetail().getName());
        Glide.with(this).load(entity.getProductDetail().getLitpic()).into(ivProductContentTit);
        tvProductContent.loadData(entity.getProductDetail().getDetail(), "text/html", "UTF-8");
    }
}
