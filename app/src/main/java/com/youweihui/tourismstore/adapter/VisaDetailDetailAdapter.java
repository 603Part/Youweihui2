package com.youweihui.tourismstore.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.youweihui.tourismstore.R;
import com.youweihui.tourismstore.bean.HomeTailOrderEntity;

import java.util.List;

public class VisaDetailDetailAdapter extends RecyclerView.Adapter<VisaDetailDetailAdapter.viewHolder> {

    private List<HomeTailOrderEntity> list;

    private Context context;

    public VisaDetailDetailAdapter(List<HomeTailOrderEntity> list) {
        this.list = list;
    }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new viewHolder(LayoutInflater.from(context).inflate(R.layout.item_visa_detail, parent, false));
    }

    @Override
    public void onBindViewHolder(final viewHolder holder, int position) {
//        ImageLoader.showToImageView(context, holder.imageView, list.get(position).getImg());

        holder.textView1.setText(list.get(position).getTitle());
        holder.textView2.setText(list.get(position).getTitle2());
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
//            imageView = (ImageView) itemView.findViewById(R.id.item_tail_order_tab_img);
            textView1 = (TextView) itemView.findViewById(R.id.item_visa_test1);
            textView2 = (TextView) itemView.findViewById(R.id.item_visa_test2);
//            textView3 = (TextView) itemView.findViewById(R.id.);
        }
    }

    public void setData(List<HomeTailOrderEntity> list) {
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
}
