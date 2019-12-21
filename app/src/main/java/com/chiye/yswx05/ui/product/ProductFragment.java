package com.chiye.yswx05.ui.product;

import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
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
import com.chiye.yswx05.common.EventB;
import com.chiye.yswx05.common.ProductEntity;
import com.chiye.yswx05.common.ProductTypeEntity;
import com.chiye.yswx05.common.RecyclerViewProductAdapter;
import com.chiye.yswx05.ui.home.HomeFragment;
import com.google.android.material.tabs.TabLayout;
import com.ming.pullloadmorerecyclerview_lib.PullLoadMoreView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class ProductFragment extends Fragment {
    private ProductViewModel productViewModel;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    ProductTypeEntity entity;
    private PullLoadMoreView pullLoadMoreView;
    private RecyclerViewProductAdapter productAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        productViewModel =
                ViewModelProviders.of(this).get(ProductViewModel.class);
        View root = inflater.inflate(R.layout.fragment_product, container, false);
        //产品类型
        tabLayout = root.findViewById(R.id.tl_tabs);
       tabLayout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
           @Override
           public void onTabSelected(TabLayout.Tab tab) {

               productViewModel.getProductList(getContext(),entity.getProducts().get(tab.getPosition()).getId(),1,ProductFragment.this);
           }

           @Override
           public void onTabUnselected(TabLayout.Tab tab) {

           }

           @Override
           public void onTabReselected(TabLayout.Tab tab) {

           }
       });
        productViewModel.getTypeList(getContext(),this);

        //产品内容
        pullLoadMoreView = root.findViewById(R.id.fly_product);
        productAdapter = new RecyclerViewProductAdapter(getContext());
        pullLoadMoreView
                .setInitLayoutType(PullLoadMoreView.GRIDLAYOUT, PullLoadMoreView.VERTICAL)
                .setInitSpacing(2, dp2px(10),dp2px(10), true, true)
                .setInitAdapter(productAdapter)
                .setInitRefreshAndMoreEnable(false, false)
                .commit();
        return root;
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onGetMessage(EventB eventB) {
        tabLayout.getTabAt(eventB.getPosation()).select();
    }
    /**
     * dp转px
     */
    public int dp2px(float dpValues) {
        dpValues = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpValues, getResources().getDisplayMetrics());
        return (int) (dpValues + 0.5f);
    }
    /**
     * 设置产品类型列表
     * @param entity
     */
    public void setProductTypeContent(ProductTypeEntity entity) {
        this.entity=entity;
        for (int i=0;i<entity.getProducts().size();i++){
            tabLayout.addTab(tabLayout.newTab().setText(entity.getProducts().get(i).getTypeName()));
        }
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
    /**
     * 设置产品类型列表
     * @param entity
     */
    public void setProductContent(ProductEntity entity) {
            productAdapter.setRcyBtnEntity(entity);
    }
}
