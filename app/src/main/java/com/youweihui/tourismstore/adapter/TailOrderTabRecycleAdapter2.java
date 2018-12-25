package com.youweihui.tourismstore.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.youweihui.tourismstore.R;
import com.youweihui.tourismstore.bean.ShopEntity;

import java.util.List;

public class TailOrderTabRecycleAdapter2 extends RecyclerView.Adapter<TailOrderTabRecycleAdapter2.viewHolder> {

    private List<ShopEntity> list;

    private Context context;

    public TailOrderTabRecycleAdapter2(List<ShopEntity> list) {
        this.list = list;
    }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new viewHolder(LayoutInflater.from(context).inflate(R.layout.item_tail_order_tab2, parent, false));
    }

    @Override
    public void onBindViewHolder(viewHolder holder, int position) {
//        ImageLoader.showToImageView(context,holder.imageView,list.get(position).getImg());
        switch (position) {
            case 0:
                holder.textView1.setBackgroundResource(R.mipmap.ic_home_1);
                break;
            case 1:
                holder.textView1.setBackgroundResource(R.mipmap.ic_home_2);
                break;
            case 2:
                holder.textView1.setBackgroundResource(R.mipmap.ic_home_2);
                break;
            case 3:
                holder.textView1.setBackgroundResource(R.mipmap.ic_home_4);
                break;
            case 4:
                holder.textView1.setBackgroundResource(R.mipmap.ic_home_5);
                break;
            case 5:
                holder.textView1.setBackgroundResource(R.mipmap.ic_home_6);
                break;
            case 6:
                holder.textView1.setBackgroundResource(R.mipmap.ic_home_7);
                break;
            case 7:
                holder.textView1.setBackgroundResource(R.mipmap.ic_home_8);
                break;
            case 8:
                holder.textView1.setBackgroundResource(R.mipmap.ic_home_9);
                break;
            case 9:
                holder.textView1.setBackgroundResource(R.mipmap.ic_home_10);
                break;
            case 10:
                holder.textView1.setBackgroundResource(R.mipmap.ic_home_11);
                break;
            case 11:
                holder.textView1.setBackgroundResource(R.mipmap.ic_home_12);
                break;
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
            textView1 = (TextView) itemView.findViewById(R.id.item_tail_order_text);
//            textView2 = (TextView) itemView.findViewById(R.id.);
//            textView3 = (TextView) itemView.findViewById(R.id.);
        }
    }

    public void setData(List<ShopEntity> list) {
        this.list = list;
        notifyDataSetChanged();
    }
}
