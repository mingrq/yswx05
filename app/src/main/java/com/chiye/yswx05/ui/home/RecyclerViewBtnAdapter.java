package com.chiye.yswx05.ui.home;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.chiye.yswx05.MainActivity;
import com.chiye.yswx05.R;

public class RecyclerViewBtnAdapter extends RecyclerView.Adapter<RecyclerViewBtnAdapter.ViewHolder> {
    RcyBtnEntity rcyBtnEntity;
    Context context;
    Fragment fragment;

    public RecyclerViewBtnAdapter(Context context) {
        this.context = context;
    }

    public void setRcyBtnEntity(RcyBtnEntity rcyBtnEntity) {
        this.rcyBtnEntity = rcyBtnEntity;
        notifyDataSetChanged();
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_home_btn, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        if (rcyBtnEntity != null) {
            if (position < rcyBtnEntity.getProducts().size()) {
                holder.textView.setText(rcyBtnEntity.getProducts().get(position).getTypeName());

            } else {
                holder.textView.setText("更多");
            }
            holder.homemenuControl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (position < rcyBtnEntity.getProducts().size()) {
                        ((MainActivity)fragment.getActivity()).jump(position,rcyBtnEntity.getProducts().get(position).getId());
                    } else {
                        ((MainActivity)fragment.getActivity()).jump(position,-1);
                    }

                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return rcyBtnEntity == null || rcyBtnEntity.getProducts() == null || rcyBtnEntity.getProducts().size() == 0 ? 0 : rcyBtnEntity.getProducts().size() + 1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
LinearLayout homemenuControl;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.homemenu_control_text);
            homemenuControl = itemView.findViewById(R.id.homemenu_control);
        }
    }
}
