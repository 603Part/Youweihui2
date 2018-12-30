package com.youweihui.tourismstore.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.youweihui.tourismstore.R;
import com.youweihui.tourismstore.bean.EndFragment1Entity;
import com.youweihui.tourismstore.bean.ForumEntity;
import com.youweihui.tourismstore.bean.HomeTailOrderEntity;
import com.youweihui.tourismstore.utils.GridSpacingItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class EndFragment1BottomAdapter extends RecyclerView.Adapter<EndFragment1BottomAdapter.viewHolder> {

    private List<EndFragment1Entity> list;

    private Context context;

    public EndFragment1BottomAdapter(List<EndFragment1Entity> list) {
        this.list = list;
    }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new viewHolder(LayoutInflater.from(context).inflate(R.layout.item_end_frag1_bottom, parent, false));
    }

    @Override
    public void onBindViewHolder(final viewHolder holder, int position) {
        RecyclerView recyclerview = holder.recyclerView;
        recyclerview.setLayoutManager(new LinearLayoutManager(context));

        EndFragment1BottomChildAdapter childAdapter = new EndFragment1BottomChildAdapter(new ArrayList<EndFragment1Entity>());
        recyclerview.setAdapter(childAdapter);
        childAdapter.setData(list);

        if (onItemClickListener != null) {
            holder.textView3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClick(holder.itemView, holder.getLayoutPosition(),0);
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
//            textView1 = (TextView) itemView.findViewById(R.id.);
//            textView2 = (TextView) itemView.findViewById(R.id.);
            recyclerView = itemView.findViewById(R.id.item_end_frag1_bottom_recycle);

        }
    }

    public void setData(List<EndFragment1Entity> list) {
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
