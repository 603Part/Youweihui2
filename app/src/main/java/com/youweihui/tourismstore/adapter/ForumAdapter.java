package com.youweihui.tourismstore.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.youweihui.tourismstore.R;
import com.youweihui.tourismstore.bean.ForumBean;
import com.youweihui.tourismstore.utils.GlideUtils;
import com.youweihui.tourismstore.view.CustomImageView;

import java.util.List;

public class ForumAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<ForumBean.PageBean.ListBean> list;

    // 普通布局
    private final int TYPE_ITEM = 1;
    // 脚布局
    private final int TYPE_FOOTER = 2;


    // 正在加载
    public final int LOADING = 1;
    // 加载完成
    public final int LOADING_COMPLETE = 2;
    // 加载到底
    public final int LOADING_END = 3;


    private Context context;

    private int normalType = 0;
    private int loadState;

    public ForumAdapter(List<ForumBean.PageBean.ListBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();

        if (viewType == TYPE_ITEM) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_forum, parent, false);
            return new viewHolder(view);

        } else if (viewType == TYPE_FOOTER) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.layout_refresh_footer, parent, false);
            return new FootViewHolder(view);
        }


//        if (viewType == normalType) {
//            return new viewHolder(LayoutInflater.from(context).inflate(R.layout.item_forum, parent, false));
//        }
        return null;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holders, int position) {

        if (holders instanceof ForumAdapter.viewHolder) {
            ForumAdapter.viewHolder holder = (ForumAdapter.viewHolder) holders;
            if (list.get(position).getHeadUrl() != null) {
                GlideUtils.showToCircleImageView(context, list.get(position).getHeadUrl().toString(), holder.imageView);
            }

            if (list.get(position).getPictureUrl() != null) {
                GlideUtils.showToCircleImageView(context, list.get(position).getPictureUrl(), holder.imageView2);
            }

            if (list.get(position).getPubdate() != null)
                holder.textView2.setText(list.get(position).getPubdate().toString());

            holder.textView1.setText(list.get(position).getIssuer());
            holder.textView3.setText(list.get(position).getBrowseNum() + "");
            holder.textView4.setText(list.get(position).getLikeNum() + "");
            holder.textView5.setText(list.get(position).getCommentNum() + "");

            if (onItemClickListener != null) {
                holder.relativeLayout.setOnClickListener(view -> onItemClickListener.onItemClick(holder.itemView, holder.getLayoutPosition(), 1));
            }

        } else if(holders instanceof FootViewHolder){
            FootViewHolder footViewHolder = (FootViewHolder) holders;
            switch (loadState) {
                case LOADING: // 正在加载
                    footViewHolder.tvLoading.setVisibility(View.VISIBLE);
                    break;

                case LOADING_COMPLETE: // 加载完成
                    footViewHolder.tvLoading.setVisibility(View.INVISIBLE);
                    break;

                case LOADING_END: // 加载到底
                    footViewHolder.tvLoading.setVisibility(View.GONE);
                    break;

                default:
                    break;
            }

        }

    }

    @Override
    public int getItemCount() {
        return list.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position + 1 == getItemCount()) {
            return TYPE_FOOTER;
        } else {
            return TYPE_ITEM;
        }
    }


    class viewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private CustomImageView imageView2;
        private RelativeLayout relativeLayout;
        private TextView textView1, textView2, textView3, textView4, textView5;

        public viewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.item_forum_img);
            imageView2 = itemView.findViewById(R.id.item_forum_center_img);
            textView1 = itemView.findViewById(R.id.item_forum_name);
            textView2 = itemView.findViewById(R.id.item_forum_time);
            textView3 = itemView.findViewById(R.id.item_forum_eye);
            textView4 = itemView.findViewById(R.id.item_forum_praise);
            textView5 = itemView.findViewById(R.id.item_forum_reply);
            relativeLayout = itemView.findViewById(R.id.item_forum_relative);
        }
    }

    public void setData(List<ForumBean.PageBean.ListBean> beans) {
        list.addAll(beans);
        notifyDataSetChanged();
    }

    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(View v, int position, int type);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        onItemClickListener = listener;
    }



    private class FootViewHolder extends RecyclerView.ViewHolder {

        TextView tvLoading;


        FootViewHolder(View itemView) {
            super(itemView);
            tvLoading = itemView.findViewById(R.id.loading);
        }
    }

    /**
     * 设置上拉加载状态
     *
     * @param loadState 0.正在加载 1.加载完成 2.加载到底
     */
    public void setLoadState(int loadState) {
        this.loadState = loadState;
        notifyDataSetChanged();
    }


}
