package com.youweihui.tourismstore.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.youweihui.tourismstore.R;
import com.youweihui.tourismstore.bean.VisaEntity;
import com.youweihui.tourismstore.utils.GlideUtils;

import java.util.List;

public class VisaTopAdapter extends RecyclerView.Adapter<VisaTopAdapter.viewHolder> {

    private List<VisaEntity> list;

    private Context context;

    public VisaTopAdapter(List<VisaEntity> list) {
        this.list = list;
    }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new viewHolder(LayoutInflater.from(context).inflate(R.layout.item_visa_top, parent, false));
    }

    @Override
    public void onBindViewHolder(final viewHolder holder, int position) {
        GlideUtils.showToImageView(context,holder.imageView,list.get(position).getImg().toString());
        if (onItemClickListener!=null){
            holder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClick(holder.itemView,holder.getLayoutPosition(),0);
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
            imageView = (ImageView) itemView.findViewById(R.id.item_visa_img);
//            textView1 = (TextView) itemView.findViewById(R.id.);
//            textView2 = (TextView) itemView.findViewById(R.id.);
//            textView3 = (TextView) itemView.findViewById(R.id.);
        }
    }

    public void setData(List<VisaEntity> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(View v, int position,int type);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        onItemClickListener= listener;
    }
}
