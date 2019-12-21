package com.chiye.yswx05.ui.product;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.chiye.yswx05.R;
import com.chiye.yswx05.common.ProductTypeEntity;
import com.google.android.material.tabs.TabLayout;

public class ProductFragment extends Fragment {
    private ProductViewModel productViewModel;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        productViewModel =
                ViewModelProviders.of(this).get(ProductViewModel.class);
        View root = inflater.inflate(R.layout.fragment_product, container, false);
        tabLayout = root.findViewById(R.id.tl_tabs);
        //viewPager = root.findViewById(R.id.vp_content);
        productViewModel.getTypeList(getContext(),this);
        return root;
    }

    /**
     * 设置产品类型列表
     * @param entity
     */
    public void setProductTypeContent(ProductTypeEntity entity) {
        for (int i=0;i<entity.getProducts().size();i++){
            tabLayout.addTab(tabLayout.newTab().setText(entity.getProducts().get(i).getTypeName()));
        }
    }
}
