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

public class EndFragment3Adapter extends RecyclerView.Adapter<EndFragment3Adapter.viewHolder> {

    private List<ForumEntity> list;

    private Context context;

    public EndFragment3Adapter(List<ForumEntity> list) {
        this.list = list;
    }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new viewHolder(LayoutInflater.from(context).inflate(R.layout.item_end_frag3, parent, false));
    }

    @Override
    public void onBindViewHolder(final viewHolder holder, int position) {
        GlideUtils.showToCircleImageView(context, list.get(position).getImg(), holder.imageView);

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
            imageView = (ImageView) itemView.findViewById(R.id.item_end_frag3_img);
            textView1 = (TextView) itemView.findViewById(R.id.item_end_frag3_name);
            textView2 = (TextView) itemView.findViewById(R.id.item_end_frag3_time);
            textView3 = (TextView) itemView.findViewById(R.id.item_end_frag3_content);
            textView4 = (TextView) itemView.findViewById(R.id.item_end_frag3_eye);
            textView5 = (TextView) itemView.findViewById(R.id.item_end_frag3_praise);
            textView6 = (TextView) itemView.findViewById(R.id.item_end_frag3_reply);
        }
    }

    public void setData(List<ForumEntity> list) {
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
