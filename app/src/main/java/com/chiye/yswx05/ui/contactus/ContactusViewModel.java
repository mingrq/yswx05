package com.chiye.yswx05.ui.contactus;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.chiye.yswx05.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContactusViewModel extends ViewModel {

    private MutableLiveData<List<Map<String, String>>> entity;


    /**
     * 获取联系我们数据
     *
     * @return
     */
    public LiveData<List<Map<String, String>>> getContactusEntity(Context context) {
        entity = new MutableLiveData<>();
        List<Map<String, String>> list = new ArrayList<>();

        //400电话
        String four = context.getResources().getString(R.string.fourphone);
        String[] fourarr = four.split(",");
        for (int i = 0; i < fourarr.length; i++) {
            Map<String, String> map1 = new HashMap<>();
            map1.put("tit", "免费电话:");
            map1.put("content", fourarr[i].trim());
            list.add(map1);
        }

        //电话
        String telephone = context.getResources().getString(R.string.telephone);
        String[] telephonearr = telephone.split(",");
        for (int
             k = 0; k < telephonearr.length; k++) {
            Map<String, String> map2 = new HashMap<>();
            map2.put("tit", "电话:");
            map2.put("content", telephonearr[k].trim());
            list.add(map2);
        }


        //传真
        String fax = context.getResources().getString(R.string.fax);
        String[] faxarr = fax.split(",");
        for (int
             j = 0; j < faxarr.length; j++) {
            Map<String, String> map3 = new HashMap<>();
            map3.put("tit", "传真:");
            map3.put("content", faxarr[j].trim());
            list.add(map3);
        }

        //网站
        String website = context.getResources().getString(R.string.website);
        String[] websitearr = website.split(",");
        for (int
             h = 0; h < websitearr.length; h++) {
            Map<String, String> map4 = new HashMap<>();
            map4.put("tit", "网站:");
            map4.put("content", websitearr[h].trim());
            list.add(map4);
        }

        //地址
        Map<String, String> map5 = new HashMap<>();
        map5.put("tit", "地址:");
        map5.put("content", context.getResources().getString(R.string.location).trim());
        list.add(map5);

        //email
        String email = context.getResources().getString(R.string.email);
        String[] emailarr = email.split(",");
        for (int
             s = 0; s < emailarr.length; s++) {
            Map<String, String> map6 = new HashMap<>();
            map6.put("tit", "E-mail:");
            map6.put("content", emailarr[s].trim());
            list.add(map6);
        }

        //qq
        String qq = context.getResources().getString(R.string.qq);
        String[] qqarr = qq.split(",");
        for (int
             e = 0; e < qqarr.length; e++) {
            Map<String, String> map7 = new HashMap<>();
            map7.put("tit", "QQ:");
            map7.put("content", qqarr[e].trim());
            list.add(map7);
        }

        entity.setValue(list);
        return entity;
    }
}
