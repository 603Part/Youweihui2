package com.youweihui.tourismstore.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.youweihui.tourismstore.R;
import com.youweihui.tourismstore.bean.FindRecommendGoodsBean;
import com.youweihui.tourismstore.bean.FindRecommendGoodsListBean;
import com.youweihui.tourismstore.utils.GlideUtils;
import com.youweihui.tourismstore.view.BannerView;

import java.util.ArrayList;
import java.util.List;

public class ShopAdapter2 extends RecyclerView.Adapter {

    private List<FindRecommendGoodsListBean.PageBean.ListBean> list;

    private List<FindRecommendGoodsBean.BannerListBean> bannerList;

    private List<FindRecommendGoodsBean.HotlistBean> hotList;

    private List<FindRecommendGoodsBean.TravellistBean> travelList;

    private Context context;

    private int ShopListType = 1;

    private int ShopHeadType = 0;

    private int count = 0;

    public ShopAdapter2(Context context) {
        this.context = context;
        list = new ArrayList<>();
        bannerList = new ArrayList<>();
        hotList = new ArrayList<>();
        travelList = new ArrayList<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ShopHeadType) {
            return new HeadHolder(LayoutInflater.from(context).inflate(R.layout.adapter_shop_head, parent, false));
        } else if (viewType == ShopListType) {
            return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.adapter_shop_list, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof HeadHolder) {
            List<View> list = new ArrayList<>();
            for (int i = 0; i < bannerList.size(); i++) {
                ImageView imageView = new ImageView(context);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                GlideUtils.showToImageView(context, imageView, bannerList.get(position).getAdvertisingUrl().toString());
                list.add(imageView);
            }
            ((HeadHolder) holder).bannerLayout.setPageViewPics(list);

            if (hotList.size() > 0)
                ((HeadHolder) holder).hotTitle.setText(hotList.get(0).getClassifyName());
            else
                ((HeadHolder) holder).hotTitle.setText("热门爆款");

            ((HeadHolder) holder).hotRecycle.setLayoutManager(new GridLayoutManager(context, 2));
            ((HeadHolder) holder).travelRecycle.setLayoutManager(new GridLayoutManager(context, 2));

            ShopHotListAdapter hotListAdapter = new ShopHotListAdapter(context, hotList);
            ShopTravelListAdapter travelListAdapter = new ShopTravelListAdapter(context, travelList);

            ((HeadHolder) holder).hotRecycle.setAdapter(hotListAdapter);
            ((HeadHolder) holder).travelRecycle.setAdapter(travelListAdapter);
            ((HeadHolder) holder).moreTitle.setText("更多产品");

            if (((HeadHolder) holder).tabLayout.getTabCount() == 0) {
                ((HeadHolder) holder).tabLayout.addTab(((HeadHolder) holder).tabLayout.newTab().setText("默认排序"));
                ((HeadHolder) holder).tabLayout.addTab(((HeadHolder) holder).tabLayout.newTab().setText("销量最高"));
                ((HeadHolder) holder).tabLayout.addTab(((HeadHolder) holder).tabLayout.newTab().setText("价格最优"));
                ((HeadHolder) holder).tabLayout.setSelectedTabIndicatorColor(context.getResources().getColor(R.color.orange));

                ((HeadHolder) holder).tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        if (tabSelectedListener != null) {
                            tabSelectedListener.onTabClick(tab.getPosition());
                        }
                    }

                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {

                    }

                    @Override
                    public void onTabReselected(TabLayout.Tab tab) {

                    }
                });
            }
        } else if (holder instanceof ViewHolder) {
            ((ViewHolder) holder).itemShopText.setText(list.get(position).getGoodsName());
            ((ViewHolder) holder).itemShopIntegral.setText(list.get(position).getIntegral() + "积分");
            GlideUtils.showToImageView(context, ((ViewHolder) holder).itemShopImg, list.get(position).getPictureUrl());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0)
            return ShopHeadType;
        else
            return ShopListType;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
        if (manager instanceof GridLayoutManager) {
            final GridLayoutManager gridLayoutManager = ((GridLayoutManager) manager);
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    return getItemViewType(position) == ShopHeadType ? gridLayoutManager.getSpanCount() : 1;
                }
            });
        }
    }

    @Override
    public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        ViewGroup.LayoutParams lp = holder.itemView.getLayoutParams();
        if (lp != null && lp instanceof StaggeredGridLayoutManager.LayoutParams) {
            StaggeredGridLayoutManager.LayoutParams p = (StaggeredGridLayoutManager.LayoutParams) lp;
            p.setFullSpan(holder.getLayoutPosition() == 0);
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView itemShopIntegral, itemShopText;
        private ImageView itemShopImg;

        public ViewHolder(View itemView) {
            super(itemView);
            itemShopImg = itemView.findViewById(R.id.item_shop_img);
            itemShopText = itemView.findViewById(R.id.item_shop_text);
            itemShopIntegral = itemView.findViewById(R.id.item_shop_integral);
        }
    }

    public class HeadHolder extends RecyclerView.ViewHolder {

        private BannerView bannerLayout;
        private TextView hotTitle, travelTitle, moreTitle;
        private RecyclerView hotRecycle, travelRecycle;
        private TabLayout tabLayout;

        public HeadHolder(View view) {
            super(view);
            bannerLayout = view.findViewById(R.id.adapter_shop_head_banner);
            hotTitle = view.findViewById(R.id.adapter_shop_head_hot_title);
            hotRecycle = view.findViewById(R.id.adapter_shop_head_hot_list);
            travelTitle = view.findViewById(R.id.adapter_shop_head_travel_title);
            travelRecycle = view.findViewById(R.id.adapter_shop_head_travel_list);
            moreTitle = view.findViewById(R.id.adapter_shop_head_more_title);
            tabLayout = view.findViewById(R.id.adapter_shop_head_tab);
        }
    }

    public void setData(List<FindRecommendGoodsListBean.PageBean.ListBean> newData) {
        if (newData != null) {
            list.addAll(newData);
        }
        count++;
        notifyDataSetChanged();
    }

    public void setBanner(List<FindRecommendGoodsBean.BannerListBean> bannerListBean) {
        bannerList = bannerListBean;
        count++;
        notifyDataSetChanged();
    }

    public void setHot(List<FindRecommendGoodsBean.HotlistBean> hotlistBeans) {
        hotList = hotlistBeans;
        count++;
        notifyDataSetChanged();
    }

    public void setTravel(List<FindRecommendGoodsBean.TravellistBean> travellistBeans) {
        travelList = travellistBeans;
        count++;
        notifyDataSetChanged();
    }

    private OnTabSelectedListener tabSelectedListener;

    public interface OnTabSelectedListener {
        void onTabClick(int position);
    }

    public void setOnTabSelectedListener(OnTabSelectedListener tabSelectedListener) {
        this.tabSelectedListener = tabSelectedListener;
    }

    public List<FindRecommendGoodsListBean.PageBean.ListBean> getListData() {
        return list;
    }
}

