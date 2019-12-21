package com.chiye.yswx05.common;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.chiye.yswx05.R;
import com.chiye.yswx05.ui.ProductContentActivity;

public class RecyclerViewProductAdapter extends RecyclerView.Adapter<RecyclerViewProductAdapter.ViewHolder> {
    ProductEntity productEntity;
    Context context;

    public RecyclerViewProductAdapter(Context context) {
        this.context = context;
    }

    public void setRcyBtnEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_home_reproduct, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        if (productEntity != null) {
            holder.textView.setText(productEntity.getProduct().getProductLists().get(position).getName());
            Glide.with(context).load(productEntity.getProduct().getProductLists().get(position).getLitpic()).into(holder.imageView);
            holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, ProductContentActivity.class);
                    intent.putExtra("cid",productEntity.getProduct().getProductLists().get(position).getAid());
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return productEntity == null || productEntity.getProduct().getProductLists() == null || productEntity.getProduct().getProductLists().size() == 0 ? 0 : productEntity.getProduct().getProductLists().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;
        RelativeLayout relativeLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_product_tit);
            imageView = itemView.findViewById(R.id.iv_product);
            relativeLayout = itemView.findViewById(R.id.rly_productitem);
        }
    }
}
