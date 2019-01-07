package com.youweihui.tourismstore.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.youweihui.tourismstore.R;
import com.youweihui.tourismstore.bean.ForumEntity;
import com.youweihui.tourismstore.bean.SpecialBean;
import com.youweihui.tourismstore.utils.GlideUtils;
import com.youweihui.tourismstore.utils.GridSpacingItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class SpecialAdapter extends RecyclerView.Adapter<SpecialAdapter.viewHolder> {

    private List<SpecialBean.DataBean.FeatureTitleListBean> list;

    private Context context;

    public SpecialAdapter(List<SpecialBean.DataBean.FeatureTitleListBean> list) {
        this.list = list;
    }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new viewHolder(LayoutInflater.from(context).inflate(R.layout.item_special, parent, false));
    }

    @Override
    public void onBindViewHolder(final viewHolder holder, int position) {
        RecyclerView recyclerview = holder.recyclerView;
        recyclerview.setLayoutManager(new GridLayoutManager(context, 2));
        recyclerview.addItemDecoration(new GridSpacingItemDecoration(2, 10, true));
        recyclerview.setHasFixedSize(true);

        SpecialChildAdapter adapter = new SpecialChildAdapter(new ArrayList<>());
        recyclerview.setAdapter(adapter);
        adapter.setData(list.get(position).getProcuctList());

        holder.textView1.setText(list.get(position).getTitleName());

        if (onItemClickListener != null) {
            holder.textView3.setOnClickListener(new View.OnClickListener() {
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
        private RecyclerView recyclerView;

        public viewHolder(View itemView) {
            super(itemView);
//            imageView = (ImageView) itemView.findViewById(R.id.);
            textView1 = (TextView) itemView.findViewById(R.id.item_special_title);
//            textView2 = (TextView) itemView.findViewById(R.id.);
            textView3 = (TextView) itemView.findViewById(R.id.item_special_more);
            recyclerView = itemView.findViewById(R.id.item_special_recycle);

        }
    }

    public void setData(List<SpecialBean.DataBean.FeatureTitleListBean> list) {
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
