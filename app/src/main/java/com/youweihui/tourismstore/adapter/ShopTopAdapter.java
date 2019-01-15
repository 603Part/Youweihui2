package com.youweihui.tourismstore.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.youweihui.tourismstore.R;
import com.youweihui.tourismstore.bean.FindRecommendGoodsBean;
import com.youweihui.tourismstore.bean.FindRecommendGoodsListBean;
import com.youweihui.tourismstore.bean.HomeEntity;
import com.youweihui.tourismstore.utils.GlideUtils;

import java.util.List;

public class ShopTopAdapter extends RecyclerView.Adapter<ShopTopAdapter.viewHolder> {

    private List<FindRecommendGoodsBean.HotlistBean> list;

    private Context context;

    public ShopTopAdapter(List<FindRecommendGoodsBean.HotlistBean> list) {
        this.list = list;
    }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new viewHolder(LayoutInflater.from(context).inflate(R.layout.item_shop_top, parent, false));
    }

    @Override
    public void onBindViewHolder(viewHolder holder, int position) {
        GlideUtils.showToImageView(context, holder.imageView, list.get(position).getPictureUrl());
        holder.textView1.setText(list.get(position).getGoodsName());
        holder.textView2.setText(list.get(position).getIntegral() + "积分");

        if (onItemClickListener != null) {
            holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClick(holder.itemView, holder.getLayoutPosition(),getItemViewType(position));
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
        private RelativeLayout relativeLayout;

        public viewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.item_shop_top_img);
            textView1 = (TextView) itemView.findViewById(R.id.item_shop_top_title);
            textView2 = (TextView) itemView.findViewById(R.id.item_shop_top_integral);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.item_shop_top_relative);
//            textView2 = (TextView) itemView.findViewById(R.id.);
//            textView3 = (TextView) itemView.findViewById(R.id.);
        }
    }

    public void setData(List<FindRecommendGoodsBean.HotlistBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(View v, int position,int type);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        onItemClickListener = listener;
    }

    public List<FindRecommendGoodsBean.HotlistBean> getData() {
        return list;
    }
}