package com.youweihui.tourismstore.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.youweihui.tourismstore.R;
import com.youweihui.tourismstore.bean.ForumEntity;
import com.youweihui.tourismstore.bean.SpecialBean;
import com.youweihui.tourismstore.ui.activity.TailOrderDetailActivity;
import com.youweihui.tourismstore.utils.GlideUtils;

import java.util.List;

public class SpecialChildAdapter extends RecyclerView.Adapter<SpecialChildAdapter.viewHolder> {

    private List<SpecialBean.DataBean.FeatureTitleListBean.ProcuctListBean> list;

    private Context context;

    public SpecialChildAdapter(List<SpecialBean.DataBean.FeatureTitleListBean.ProcuctListBean> list) {
        this.list = list;
    }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new viewHolder(LayoutInflater.from(context).inflate(R.layout.item_special_child, parent, false));
    }

    @Override
    public void onBindViewHolder(viewHolder holder, int position) {

        holder.textView1.setText(list.get(position).getProductName());

        if (list.get(position).getPictureUrl() != null) {
            GlideUtils.showToImageView(context, holder.imageView, list.get(position).getPictureUrl().toString());
        }

        if (list.get(position).getProductSubtitle() != null){
            holder.textView2.setText(list.get(position).getProductSubtitle().toString());
        }

        if (list.get(position).getProductPrice() != null){
            holder.textView3.setText("¥ " + list.get(position).getProductPrice().toString());
        }

        holder.imageView.setOnClickListener(view -> {
            Intent intent = new Intent(context, TailOrderDetailActivity.class);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class viewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView textView1, textView2, textView3;

        public viewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.item_special_child_img);
            textView1 = (TextView) itemView.findViewById(R.id.item_special_child_title);
            textView2 = (TextView) itemView.findViewById(R.id.item_special_child_content);
            textView3 = (TextView) itemView.findViewById(R.id.item_special_child_money);

        }
    }

    public void setData(List<SpecialBean.DataBean.FeatureTitleListBean.ProcuctListBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }
}
