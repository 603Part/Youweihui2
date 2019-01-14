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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.youweihui.tourismstore.R;
import com.youweihui.tourismstore.bean.FindRecommendGoodsBean;
import com.youweihui.tourismstore.bean.FindRecommendGoodsListBean;
import com.youweihui.tourismstore.utils.GlideUtils;
import com.youweihui.tourismstore.view.BannerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

public class ShopAdapter extends RecyclerView.Adapter {

    private List<FindRecommendGoodsListBean.PageBean.ListBean> list;

    private List<FindRecommendGoodsBean.BannerListBean> bannerList;

    private List<FindRecommendGoodsBean.HotlistBean> hotList;

    private List<FindRecommendGoodsBean.TravellistBean> travelList;

    private Context context;

    private int BannerType = 1;

    private int ShopHotListType = 2;

    private int ShopTravelType = 3;

    private int ShopMoreType = 4;

    private int ShopListType = 5;

    private int count = 0;

    private int lastItemPosition;

    public ShopAdapter(Context context) {
        this.context = context;
        list = new ArrayList<>();
        bannerList = new ArrayList<>();
        hotList = new ArrayList<>();
        travelList = new ArrayList<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == BannerType) {
            return new TypeBannerHolder(LayoutInflater.from(context).inflate(R.layout.adapter_shop_banner, parent, false));
        } else if (viewType == ShopHotListType) {
            return new ViewHolder2(LayoutInflater.from(context).inflate(R.layout.adapter_shop_list2, parent, false));
        } else if (viewType == ShopTravelType) {
            return new ViewHolder3(LayoutInflater.from(context).inflate(R.layout.adapter_shop_list3, parent, false));
        } else if (viewType == ShopListType) {
            return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.adapter_shop_list, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof TypeBannerHolder && bannerList.size() != 0 && ((TypeBannerHolder) holder).bannerLayout.getChildCount() == 0) {
            List<View> list = new ArrayList<>();
            for (int i = 0; i < bannerList.size(); i++) {
                ImageView imageView = new ImageView(context);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                GlideUtils.showToImageView(context, imageView, bannerList.get(position).getAdvertisingUrl().toString());
                list.add(imageView);
            }
            ((TypeBannerHolder) holder).bannerLayout.setPageViewPics(list);
        } else if (holder instanceof ViewHolder2 && hotList.size() != 0) {
            ((ViewHolder2) holder).hotTitle.setText(hotList.get(0).getClassifyName());
            ((ViewHolder2) holder).recyclerView.setLayoutManager(new GridLayoutManager(context, 2));
            ShopHotListAdapter hotListAdapter = new ShopHotListAdapter(context, hotList);
            ((ViewHolder2) holder).recyclerView.setAdapter(hotListAdapter);
        } else if (holder instanceof ViewHolder3 && travelList.size() != 0) {
            ((ViewHolder3) holder).travelTitle.setText(travelList.get(0).getClassifyName());
            ((ViewHolder3) holder).recyclerView.setLayoutManager(new GridLayoutManager(context, 2));
            ShopTravelListAdapter travelListAdapter = new ShopTravelListAdapter(context, travelList);
            ((ViewHolder3) holder).recyclerView.setAdapter(travelListAdapter);
        } else if (holder instanceof ViewHolder && list.size() != 0) {
            ((ViewHolder) holder).moreTtitle.setText("更多产品");

            ShopListAdapter shopListAdapter = new ShopListAdapter(context, list);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 2);
            ((ViewHolder) holder).recyclerView.setLayoutManager(gridLayoutManager);

            ((ViewHolder) holder).recyclerView.setAdapter(shopListAdapter);

            ((ViewHolder) holder).recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                    super.onScrollStateChanged(recyclerView, newState);
                    if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                        if (shopListAdapter.isFadeTips() == false && lastItemPosition + 1 == shopListAdapter.getItemCount()) {
                            Toast.makeText(context, "最下面", Toast.LENGTH_SHORT).show();
//                        getFindRecommendGoodsList(tabPosition);
                        }
                    }
                }

                @Override
                public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);
                    lastItemPosition = gridLayoutManager.findLastVisibleItemPosition();
                }
            });

            if (((ViewHolder) holder).tabLayout.getTabCount() == 0){
                ((ViewHolder) holder).tabLayout.addTab(((ViewHolder) holder).tabLayout.newTab().setText("默认排序"));
                ((ViewHolder) holder).tabLayout.addTab(((ViewHolder) holder).tabLayout.newTab().setText("销量最高"));
                ((ViewHolder) holder).tabLayout.addTab(((ViewHolder) holder).tabLayout.newTab().setText("价格最优"));
                ((ViewHolder) holder).tabLayout.setSelectedTabIndicatorColor(context.getResources().getColor(R.color.orange));

                ((ViewHolder) holder).tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
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
        }
    }

    @Override
    public int getItemCount() {
        return count;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0)
            return BannerType;
        else if (position == 1)
            return ShopHotListType;
        else if (position == 2)
            return ShopTravelType;
        else
            return ShopListType;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private RecyclerView recyclerView;
        private TabLayout tabLayout;
        private TextView moreTtitle;

        public ViewHolder(View itemView) {
            super(itemView);
            tabLayout = itemView.findViewById(R.id.shop_more_tab);
            moreTtitle = itemView.findViewById(R.id.shop_more_title);
            recyclerView = itemView.findViewById(R.id.adapter_shop_list_recycle);
        }
    }

    class ViewHolder2 extends RecyclerView.ViewHolder {

        private RecyclerView recyclerView;
        private TextView hotTitle;

        public ViewHolder2(View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.adapter_shop_list_recycle2);
            hotTitle = itemView.findViewById(R.id.shop_hot_title);
        }
    }

    class ViewHolder3 extends RecyclerView.ViewHolder {

        private RecyclerView recyclerView;

        private TextView travelTitle;

        public ViewHolder3(View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.adapter_shop_list_recycle3);
            travelTitle = itemView.findViewById(R.id.shop_travel_title);
        }
    }

    public class TypeBannerHolder extends RecyclerView.ViewHolder {

        private BannerView bannerLayout;

        public TypeBannerHolder(View view) {
            super(view);
            bannerLayout = view.findViewById(R.id.shop_banner);
        }
    }

    public void setData(List<FindRecommendGoodsListBean.PageBean.ListBean> list) {
        this.list = list;
        count++;
        notifyItemRangeChanged(ShopListType, list.size());
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

    public boolean isFadeTips() {
        return fadeTips;
    }

    public void loadDataList(List<FindRecommendGoodsListBean.PageBean.ListBean> newData, boolean hasMore) {
        if (newData != null) {
            list.addAll(newData);
        }
        this.hasMore = hasMore;
        notifyDataSetChanged();
    }

    private boolean fadeTips = false;

    private boolean hasMore = true;
}

