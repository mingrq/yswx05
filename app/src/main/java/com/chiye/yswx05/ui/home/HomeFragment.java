package com.chiye.yswx05.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.chiye.yswx05.R;
import com.ming.pullloadmorerecyclerview_lib.PullLoadMoreView;

import java.util.ArrayList;
import java.util.List;

import ming.com.slideshow_lib.SlideShow;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private RecyclerViewBtnAdapter btnAdapter;

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
        PullLoadMoreView recyclerViewbtn = root.findViewById(R.id.rcv_menu);
        btnAdapter = new RecyclerViewBtnAdapter(getContext());
        recyclerViewbtn
                .setInitLayoutType(PullLoadMoreView.GRIDLAYOUT,PullLoadMoreView.VERTICAL)
                .setInitSpacing(4, 10, 10, true, true)
                .setInitAdapter(btnAdapter);
        List<Integer> contents = new ArrayList<>();
        for (int i = 0; i < 60; i++) {
            contents.add(i);
        }
        recyclerViewbtn.setInitOnLoadMoreListener(new PullLoadMoreView.LoadMoreListener() {

            @Override
            public void onLoadMore() {

                //pullLoadMoreView.setFooterType(PullLoadMoreView.NOMORE);
            }
        });
        recyclerViewbtn.setInitOnPullLoadListener(new PullLoadMoreView.PullLoadListener() {
            @Override
            public void onRefresh() {

            }
        });

        recyclerViewbtn.commit();


        homeViewModel.getBtnList(getContext(),this);





        //产品信息
        PullLoadMoreView recyclerViewproduct = root.findViewById(R.id.rcv_product);

        return root;
    }

    public void setContent(RcyBtnEntity rcyBtnEntity){
        btnAdapter.setRcyBtnEntity(rcyBtnEntity);
    }
}