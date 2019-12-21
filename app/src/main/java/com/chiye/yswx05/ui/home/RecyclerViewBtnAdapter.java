package com.chiye.yswx05.ui.home;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chiye.yswx05.R;

public class RecyclerViewBtnAdapter extends RecyclerView.Adapter<RecyclerViewBtnAdapter.ViewHolder> {
    RcyBtnEntity rcyBtnEntity;
Context context;

    public RecyclerViewBtnAdapter(Context context) {
        this.context = context;
    }

    public void setRcyBtnEntity(RcyBtnEntity rcyBtnEntity) {
        this.rcyBtnEntity = rcyBtnEntity;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_contactus, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(rcyBtnEntity.getProducts().get(position).getTypeName());
    }

    @Override
    public int getItemCount() {
        return rcyBtnEntity == null || rcyBtnEntity.getProducts() == null || rcyBtnEntity.getProducts().size() == 0 ? 0 : rcyBtnEntity.getProducts().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.homemenu_control_text);
        }
    }
}
