package com.youweihui.tourismstore.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.youweihui.tourismstore.R;
import com.youweihui.tourismstore.bean.HomeEntity;
import com.youweihui.tourismstore.bean.HomeTopEntity;
import com.youweihui.tourismstore.bean.ShopEntity;

import java.util.List;

public class HomeTopAdapter extends RecyclerView.Adapter<HomeTopAdapter.viewHolder> {

    private Context context;

    private List<HomeEntity.HomeTopEntity> list;

    private OnItemClickListener onItemClickListener;

    public HomeTopAdapter(List<HomeEntity.HomeTopEntity> list) {
        this.list = list;
    }

    public void setData(List<HomeEntity.HomeTopEntity> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public interface OnItemClickListener {
        void onItemClick(View v, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        onItemClickListener = listener;
    }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new viewHolder(LayoutInflater.from(context).inflate(R.layout.item_home_top, parent, false));
    }

    @Override
    public void onBindViewHolder(final viewHolder holder, int position) {
        switch (position) {
            case 0:
                holder.textView1.setBackgroundResource(R.mipmap.ic_home_1);
                holder.textView1.setText(list.get(position).getTitle());
                break;
            case 1:
                holder.textView1.setBackgroundResource(R.mipmap.ic_home_2);
                holder.textView1.setText(list.get(position).getTitle());
                break;
            case 2:
                holder.textView1.setBackgroundResource(R.mipmap.ic_home_2);
                holder.textView1.setText(list.get(position).getTitle());
                break;
            case 3:
                holder.textView1.setBackgroundResource(R.mipmap.ic_home_4);
                holder.textView1.setText(list.get(position).getTitle());
                break;
            case 4:
                holder.textView1.setBackgroundResource(R.mipmap.ic_home_5);
                holder.textView1.setText(list.get(position).getTitle());
                break;
            case 5:
                holder.textView1.setBackgroundResource(R.mipmap.ic_home_6);
                holder.textView1.setText(list.get(position).getTitle());
                break;
            case 6:
                holder.textView1.setBackgroundResource(R.mipmap.ic_home_7);
                holder.textView1.setText(list.get(position).getTitle());
                break;
            case 7:
                holder.textView1.setBackgroundResource(R.mipmap.ic_home_8);
                holder.textView1.setText(list.get(position).getTitle());
                break;
        }

        if (onItemClickListener != null) {
            holder.textView1.setOnClickListener(new View.OnClickListener() {
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
//            imageView = (ImageView) itemView.findViewById(R.id.);
            textView1 = (TextView) itemView.findViewById(R.id.item_home_top_text);
//            textView2 = (TextView) itemView.findViewById(R.id.);
//            textView3 = (TextView) itemView.findViewById(R.id.);
        }
    }
}
