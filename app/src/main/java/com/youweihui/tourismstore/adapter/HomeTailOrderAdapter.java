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
import com.youweihui.tourismstore.utils.GlideUtils;

import java.util.List;

public class HomeTailOrderAdapter extends RecyclerView.Adapter<HomeTailOrderAdapter.viewHolder> {

    private List<HomeEntity.HomeTailOrderEntity> list;

    private Context context;

    public HomeTailOrderAdapter(List<HomeEntity.HomeTailOrderEntity> list) {
        this.list = list;
    }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new viewHolder(LayoutInflater.from(context).inflate(R.layout.item_home_tail_order, parent, false));
    }

    @Override
    public void onBindViewHolder(viewHolder holder, int position) {
        GlideUtils.showToImageView(context,holder.imageView,list.get(position).getImg());
        holder.textView1.setText(list.get(position).getTitle().toString());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class viewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView  textView1,textView2,textView3;

        public viewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.item_home_tail_order_img);
            textView1 = (TextView) itemView.findViewById(R.id.item_home_tail_order_title);
//            textView2 = (TextView) itemView.findViewById(R.id.);
//            textView3 = (TextView) itemView.findViewById(R.id.);
        }
    }

    public void setData(List<HomeEntity.HomeTailOrderEntity> list){
        this.list = list;
        notifyDataSetChanged();
    }
}
