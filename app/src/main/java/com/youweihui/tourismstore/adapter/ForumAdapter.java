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
import com.youweihui.tourismstore.bean.ForumBean;
import com.youweihui.tourismstore.bean.ForumEntity;
import com.youweihui.tourismstore.utils.GlideUtils;
import com.youweihui.tourismstore.view.CustomImageView;

import java.util.List;

public class ForumAdapter extends RecyclerView.Adapter<ForumAdapter.viewHolder> {

    private List<ForumBean.PageBean.ListBean> list;

    private Context context;

    public ForumAdapter(List<ForumBean.PageBean.ListBean> list) {
        this.list = list;
    }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new viewHolder(LayoutInflater.from(context).inflate(R.layout.item_forum, parent, false));
    }

    @Override
    public void onBindViewHolder(final viewHolder holder, int position) {

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
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class viewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private CustomImageView imageView2;
        private RelativeLayout relativeLayout;
        private TextView textView1, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9;

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


//
//            textView7 = (TextView) itemView.findViewById(R.id.item_forum1_eye);
//            textView8 = (TextView) itemView.findViewById(R.id.item_forum1_praise);
//            textView9 = (TextView) itemView.findViewById(R.id.item_forum1_reply);


        }
    }

    public void setData(List<ForumBean.PageBean.ListBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(View v, int position, int type);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        onItemClickListener = listener;
    }
}
