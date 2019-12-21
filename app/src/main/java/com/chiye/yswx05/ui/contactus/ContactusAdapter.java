package com.chiye.yswx05.ui.contactus;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.chiye.yswx05.R;

import java.util.List;
import java.util.Map;


public class ContactusAdapter extends BaseAdapter {

    private List<Map<String,String>> list;
    private Context context;

    public ContactusAdapter(Context context) {
        this.context = context;
    }

    public void setList(List<Map<String,String>> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return list == null || list.size() == 0 ? 0 : list.size();
    }

    @Override
    public Object getItem(int i) {
        if (list == null) {
            return null;
        }
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        // 当view为空时才加载布局，否则，直接修改内容
        if (view == null) {
            // 通过inflate的方法加载布局，context需要在使用这个Adapter的Activity中传入。
            view = View.inflate(context,R.layout.item_contactus, null);
            viewHolder = new ViewHolder();
            viewHolder.tvContactusTit = (TextView) view.findViewById(R.id.tv_contactus_tit);
            viewHolder.tvContactusContent = (TextView) view.findViewById(R.id.tv_contactus_content);
            view.setTag(viewHolder); // 用setTag方法将处理好的viewHolder放入view中
        } else { // 否则，让convertView等于view，然后从中取出ViewHolder即可
            viewHolder = (ViewHolder) view.getTag();
        }
        // 从viewHolder中取出对应的对象，然后赋值给他们
        viewHolder.tvContactusTit.setText(list.get(i).get("tit"));
        viewHolder.tvContactusContent.setText(list.get(i).get("content"));
        // 将这个处理好的view返回
        return view;
    }

    private class ViewHolder {
        public TextView tvContactusContent;
        public TextView tvContactusTit;
    }
}
