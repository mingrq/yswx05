package com.chiye.yswx05.ui.home;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.chiye.yswx05.R;
import com.chiye.yswx05.common.ProductEntity;
import com.chiye.yswx05.common.RecyclerViewProductAdapter;
import com.chiye.yswx05.common.SlideShow;
import com.ming.pullloadmorerecyclerview_lib.PullLoadMoreView;

import java.util.List;


public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private RecyclerViewBtnAdapter btnAdapter;
    private PullLoadMoreView recyclerViewbtn;
    private PullLoadMoreView recyclerViewproduct;
    private RecyclerViewProductAdapter productAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        //轮播图
        final SlideShow slideShow = root.findViewById(R.id.home_slide);
        homeViewModel.getSlidowList().observe(this, new Observer<List<String>>() {
            @Override
            public void onChanged(@Nullable List<String> list) {
                slideShow.setData(list);
                slideShow.commit();
                slideShow.startSlide();
            }
        });

        //菜单按钮
        recyclerViewbtn = root.findViewById(R.id.rcv_menu);
        btnAdapter = new RecyclerViewBtnAdapter(getContext());
        btnAdapter.setFragment(this);
        recyclerViewbtn
                .setInitLayoutType(PullLoadMoreView.GRIDLAYOUT, PullLoadMoreView.VERTICAL)
                .setInitSpacing(4, 0,dp2px(14), true, true)
                .setInitAdapter(btnAdapter)
                .setInitRefreshAndMoreEnable(false, false)
                .commit();
        homeViewModel.getBtnList(getContext(), HomeFragment.this);


        //产品信息
        recyclerViewproduct = root.findViewById(R.id.rcv_product);
        productAdapter = new RecyclerViewProductAdapter(getContext());
        recyclerViewproduct
                .setInitLayoutType(PullLoadMoreView.GRIDLAYOUT, PullLoadMoreView.VERTICAL)
                .setInitSpacing(2, dp2px(10),dp2px(10), true, true)
                .setInitAdapter(productAdapter)
                .setInitRefreshAndMoreEnable(false, false)
                .commit();
        homeViewModel.getProductList(getContext(), HomeFragment.this);
        return root;
    }

    /**
     * dp转px
     */
    public int dp2px(float dpValues) {
        dpValues = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpValues, getResources().getDisplayMetrics());
        return (int) (dpValues + 0.5f);
    }

    /**
     * 设置分类按钮数据
     * @param rcyBtnEntity
     */
    public void setContent(RcyBtnEntity rcyBtnEntity) {
        btnAdapter.setRcyBtnEntity(rcyBtnEntity);
    }

    /**
     * 设置产品数据
     * @param productEntity
     */
    public void setProductContent(ProductEntity productEntity) {
        productAdapter.setRcyBtnEntity(productEntity);
    }
}