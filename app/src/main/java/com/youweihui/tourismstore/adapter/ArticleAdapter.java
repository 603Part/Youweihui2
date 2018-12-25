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
import com.youweihui.tourismstore.bean.ForumEntity;
import com.youweihui.tourismstore.utils.GlideUtils;

import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.viewHolder> {

    private List<ForumEntity> list;

    private Context context;

    public ArticleAdapter(List<ForumEntity> list) {
        this.list = list;
    }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new viewHolder(LayoutInflater.from(context).inflate(R.layout.item_article, parent, false));
    }

    @Override
    public void onBindViewHolder(final viewHolder holder, int position) {
        switch (position) {
            case 0:
                GlideUtils.showToCircleImageView(context, list.get(position).getImg(), holder.imageView);
                operation(holder,0);
                break;
            case 1:
                GlideUtils.showToCircleImageView(context, list.get(position).getImg(), holder.imageView);
                operation(holder,0);
                break;
            case 2:
                GlideUtils.showToCircleImageView(context, list.get(position).getImg(), holder.imageView);
                operation(holder,0);
                break;
            case 3:
                GlideUtils.showToImageView(context, holder.imageView2,list.get(position).getImg());
                operation(holder,1);
                break;
            case 4:
                GlideUtils.showToImageView(context, holder.imageView2,list.get(position).getImg());
                operation(holder,1);
                break;
            case 5:
                GlideUtils.showToImageView(context, holder.imageView2,list.get(position).getImg());
                operation(holder,1);
                break;
            case 6:
                GlideUtils.showToImageView(context, holder.imageView2,list.get(position).getImg());
                operation(holder,1);
                break;
            case 7:
                GlideUtils.showToImageView(context, holder.imageView2,list.get(position).getImg());
                operation(holder,1);
                break;
        }

        if (onItemClickListener != null) {
            holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClick(holder.itemView, holder.getLayoutPosition(), 1);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class viewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView,imageView2;
        private RelativeLayout relativeLayout;
        private TextView textView1, textView2, textView3,textView4,textView5,textView6,textView7,textView8,textView9;

        public viewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.item_forum1_img);
            imageView2 = (ImageView) itemView.findViewById(R.id.item_forum2_img);
            textView1 = (TextView) itemView.findViewById(R.id.item_forum1_name);
            textView2 = (TextView) itemView.findViewById(R.id.item_forum1_time);
            textView3 = (TextView) itemView.findViewById(R.id.item_forum2_name);
            textView4 = (TextView) itemView.findViewById(R.id.item_forum2_time);
            textView5 = (TextView) itemView.findViewById(R.id.item_forum1_content);
            textView6 = (TextView) itemView.findViewById(R.id.item_forum2_content);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.item_forum1_relative);


//
//            textView7 = (TextView) itemView.findViewById(R.id.item_forum1_eye);
//            textView8 = (TextView) itemView.findViewById(R.id.item_forum1_praise);
//            textView9 = (TextView) itemView.findViewById(R.id.item_forum1_reply);


        }
    }

    public void setData(List<ForumEntity> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    private void operation(viewHolder holder,int position){
        if (position == 0){
            holder.imageView2.setVisibility(View.GONE);
            holder.imageView.setVisibility(View.VISIBLE);
            holder.textView1.setVisibility(View.VISIBLE);
            holder.textView2.setVisibility(View.VISIBLE);
            holder.textView3.setVisibility(View.GONE);
            holder.textView4.setVisibility(View.GONE);
            holder.textView5.setVisibility(View.VISIBLE);
            holder.textView6.setVisibility(View.GONE);

//            holder.textView7.setVisibility(View.VISIBLE);
//            holder.textView8.setVisibility(View.VISIBLE);
//            holder.textView9.setVisibility(View.VISIBLE);
        }else{
            holder.imageView.setVisibility(View.GONE);
            holder.imageView2.setVisibility(View.VISIBLE);
            holder.textView1.setVisibility(View.GONE);
            holder.textView2.setVisibility(View.GONE);
            holder.textView3.setVisibility(View.VISIBLE);
            holder.textView4.setVisibility(View.VISIBLE);
            holder.textView5.setVisibility(View.GONE);
            holder.textView6.setVisibility(View.VISIBLE);
//            holder.textView7.setVisibility(View.VISIBLE);
//            holder.textView8.setVisibility(View.VISIBLE);
//            holder.textView9.setVisibility(View.VISIBLE);

        }
    }

    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(View v, int position, int type);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        onItemClickListener = listener;
    }
}
