package com.youweihui.tourismstore.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.youweihui.tourismstore.R;
import com.youweihui.tourismstore.bean.ClassifyLeftEntity;

import java.util.List;

public class ClassifyLeftAdapter extends RecyclerView.Adapter<ClassifyLeftAdapter.viewHolder> {

    private List<ClassifyLeftEntity> list;

    private Context context;

    private int selectPos = 0;

    public ClassifyLeftAdapter(List<ClassifyLeftEntity> list) {
        this.list = list;
    }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new viewHolder(LayoutInflater.from(context).inflate(R.layout.item_classify_left, parent, false));
    }

    @Override
    public void onBindViewHolder(final viewHolder holder, int position) {

        if (selectPos == holder.getAdapterPosition()) {
            holder.textView1.setBackgroundColor(context.getResources().getColor(R.color.white));
            holder.textView1.setTextColor(context.getResources().getColor(R.color.orange));
            holder.view.setVisibility(View.GONE);
        } else {
            holder.textView1.setBackgroundColor(context.getResources().getColor(R.color.default_bg));
            holder.textView1.setTextColor(context.getResources().getColor(R.color.text_color));
            holder.view.setVisibility(View.VISIBLE);
        }

        holder.textView1.setText(list.get(position).getTitle());

        if (onItemClickListener != null) {
            holder.textView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClick(holder.itemView, holder.getLayoutPosition(), 0);
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
        private View view;

        public viewHolder(View itemView) {
            super(itemView);
//            imageView = (ImageView) itemView.findViewById(R.id.item_visa_img);
            textView1 = (TextView) itemView.findViewById(R.id.item_classify_left_text);
            view = (View) itemView.findViewById(R.id.item_classify_left_line);
//            textView2 = (TextView) itemView.findViewById(R.id.);
//            textView3 = (TextView) itemView.findViewById(R.id.);
        }
    }

    public void setData(List<ClassifyLeftEntity> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public int getSelectPos() {
        return selectPos;
    }

    public void setSelectPos(int selectPos) {
        this.selectPos = selectPos;
    }

    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(View v, int position, int type);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        onItemClickListener = listener;
    }


}
