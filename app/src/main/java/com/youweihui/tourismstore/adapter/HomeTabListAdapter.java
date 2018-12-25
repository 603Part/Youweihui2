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

public class HomeTabListAdapter extends RecyclerView.Adapter<HomeTabListAdapter.viewHolder> {

    private List<HomeEntity.HomeListEntity> list;

    private Context context;

    public HomeTabListAdapter(List<HomeEntity.HomeListEntity> list) {
        this.list = list;
    }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new viewHolder(LayoutInflater.from(context).inflate(R.layout.item_home_tab_list, parent, false));
    }

    @Override
    public void onBindViewHolder(viewHolder holder, int position) {
        GlideUtils.showToImageView(context,holder.imageView,list.get(position).getImg());
        holder.textView1.setText(list.get(position).getTitle());
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
            imageView = (ImageView) itemView.findViewById(R.id.item_home_tab_list_img);
            textView1 = (TextView) itemView.findViewById(R.id.item_home_tab_list_title);
//            textView2 = (TextView) itemView.findViewById(R.id.);
//            textView3 = (TextView) itemView.findViewById(R.id.);
        }
    }

    public void setData(List<HomeEntity.HomeListEntity> list){
        this.list = list;
        notifyDataSetChanged();
    }
}
