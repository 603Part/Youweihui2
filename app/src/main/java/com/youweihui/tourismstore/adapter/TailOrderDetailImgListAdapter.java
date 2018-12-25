package com.youweihui.tourismstore.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.youweihui.tourismstore.R;
import com.youweihui.tourismstore.bean.HomeTabEntity;
import com.youweihui.tourismstore.utils.GlideUtils;

import java.util.List;

public class TailOrderDetailImgListAdapter extends RecyclerView.Adapter<TailOrderDetailImgListAdapter.viewHolder> {

    private List<HomeTabEntity> list;

    private Context context;

    public TailOrderDetailImgListAdapter(List<HomeTabEntity> list) {
        this.list = list;
    }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new viewHolder(LayoutInflater.from(context).inflate(R.layout.item_tail_order_detail_img_list, parent, false));
    }

    @Override
    public void onBindViewHolder(viewHolder holder, int position) {
        GlideUtils.showToImageView(context,holder.imageView,"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1545420169697&di=911f2f18e59bca1ae129356e064d4403&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimage%2Fc0%253Dshijue1%252C0%252C0%252C294%252C40%2Fsign%3D21fe2dd371899e516c8332572aceb346%2F0eb30f2442a7d933dc911a5da74bd11373f001e6.jpg");
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class viewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView  textView1,textView2,textView3;

        public viewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.item_tail_order_detail_img_list_img);
//            textView1 = (TextView) itemView.findViewById(R.id.);
//            textView2 = (TextView) itemView.findViewById(R.id.);
//            textView3 = (TextView) itemView.findViewById(R.id.);
        }
    }

    public void setData(List<HomeTabEntity> list){
        this.list = list;
        notifyDataSetChanged();
    }
}
