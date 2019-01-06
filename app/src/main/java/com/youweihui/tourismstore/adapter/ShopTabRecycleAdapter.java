package com.youweihui.tourismstore.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.youweihui.tourismstore.R;
import com.youweihui.tourismstore.bean.FindRecommendGoodsListBean;
import com.youweihui.tourismstore.bean.ShopTabEntity;
import com.youweihui.tourismstore.utils.GlideUtils;

import java.util.List;

public class ShopTabRecycleAdapter extends RecyclerView.Adapter<ShopTabRecycleAdapter.viewHolder> {

    private List<FindRecommendGoodsListBean.PageBean.ListBean> list;

    private Context context;

    public ShopTabRecycleAdapter(List<FindRecommendGoodsListBean.PageBean.ListBean> list) {
        this.list = list;
    }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new viewHolder(LayoutInflater.from(context).inflate(R.layout.item_shop_tab, parent, false));
    }

    @Override
    public void onBindViewHolder(final viewHolder holder, int position) {
        GlideUtils.showToImageView(context, holder.imageView, list.get(position).getPictureUrl());
        holder.textView1.setText(list.get(position).getGoodsName());
        holder.textView2.setText(list.get(position).getIntegral() + "积分");
        if (onItemClickListener != null) {
            holder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClick(holder.itemView, holder.getLayoutPosition());
                }
            });
        }
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
            imageView = (ImageView) itemView.findViewById(R.id.item_shop_img);
            textView1 = (TextView) itemView.findViewById(R.id.shop_text);
            textView2 = (TextView) itemView.findViewById(R.id.shop_text1);
//            textView2 = (TextView) itemView.findViewById(R.id.);
//            textView3 = (TextView) itemView.findViewById(R.id.);
        }
    }

    public void setData(List<FindRecommendGoodsListBean.PageBean.ListBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(View v, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        onItemClickListener = listener;
    }

    public List<FindRecommendGoodsListBean.PageBean.ListBean> getData() {
        return list;
    }
}

