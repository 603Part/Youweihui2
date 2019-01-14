package com.youweihui.tourismstore.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.youweihui.tourismstore.R;
import com.youweihui.tourismstore.bean.FindRecommendGoodsListBean;
import com.youweihui.tourismstore.utils.GlideUtils;

import java.util.List;

public class ShopListAdapter extends RecyclerView.Adapter<ShopListAdapter.ViewHolder> {

    private Context context;

    private List<FindRecommendGoodsListBean.PageBean.ListBean> list;

    private LayoutInflater inflater;

    public ShopListAdapter(Context mContext, List<FindRecommendGoodsListBean.PageBean.ListBean> listBeans) {
        this.context = mContext;
        this.list = listBeans;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_shop, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ShopListAdapter.ViewHolder holder, int position) {
        GlideUtils.showToImageView(context, holder.imageView, list.get(position).getPictureUrl());
        holder.textView1.setText(list.get(position).getGoodsName());
        holder.textView2.setText(list.get(position).getIntegral() + "积分");
        if (onItemClickListener != null) {
            holder.imageView.setOnClickListener(view ->
                    onItemClickListener.onItemClick(holder.itemView, holder.getLayoutPosition())
            );
        }
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView textView1, textView2;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.item_shop_img);
            textView1 = itemView.findViewById(R.id.shop_text);
            textView2 = itemView.findViewById(R.id.shop_text1);
        }
    }

    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(View v, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        onItemClickListener = listener;
    }




    public boolean isFadeTips() {
        return fadeTips;
    }

    public void loadDataList(List<FindRecommendGoodsListBean.PageBean.ListBean> newData, boolean hasMore) {
        if (newData != null) {
            list.addAll(newData);
        }
        this.hasMore = hasMore;
        notifyDataSetChanged();
    }

    private boolean fadeTips = false;

    private boolean hasMore = true;

}
