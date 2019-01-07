package com.youweihui.tourismstore.ui.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;

import com.youweihui.tourismstore.R;
import com.youweihui.tourismstore.adapter.ShopCenterAdapter;
import com.youweihui.tourismstore.adapter.ShopTabAdapter;
import com.youweihui.tourismstore.adapter.ShopTopAdapter;
import com.youweihui.tourismstore.base.BaseFragment;
import com.youweihui.tourismstore.bean.FindRecommendGoodsBean;

import com.youweihui.tourismstore.net.client.RetrofitClient;
import com.youweihui.tourismstore.net.request.EmptyRequest;
import com.youweihui.tourismstore.ui.activity.GoodsDetailActivity;
import com.youweihui.tourismstore.utils.GlideUtils;
import com.youweihui.tourismstore.view.BannerView;
import com.youweihui.tourismstore.view.CustomScrollView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by ${范泽宁} on 2018/12/10.
 */

public class ShopFragment extends BaseFragment implements ShopTopAdapter.OnItemClickListener,ShopCenterAdapter.OnItemClickListener, SwipeRefreshLayout.OnRefreshListener, BannerView.OnPageViewClicked, ViewTreeObserver.OnGlobalLayoutListener, CustomScrollView.Callbacks {

    @BindView(R.id.shop_scroll)
    CustomScrollView customScrollView;

    @BindView(R.id.shop_banner)
    BannerView bannerView;

    @BindView(R.id.shop_tb_seat)
    TabLayout seatLayout;

    @BindView(R.id.shop_tb_real)
    TabLayout realLayout;

    @BindView(R.id.shop_view_pager)
    ViewPager viewPager;

    @BindView(R.id.fragment_shop_refresh)
    SwipeRefreshLayout refreshLayout;

    @BindView(R.id.shop_top_recycle)
    RecyclerView recyclerView1;

    @BindView(R.id.shop_center_recycle)
    RecyclerView recyclerView2;

    @BindView(R.id.shop_center_title)
    TextView centerTitle;

    @BindView(R.id.shop_top_title)
    TextView topTitle;

    private ArrayList<String> titleList;

    private ArrayList<ShopTabFragment> fragments;

    private ShopTabAdapter tabAdapter;

    private ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;

    private RetrofitClient retrofitClient = new RetrofitClient();

    private Disposable disposable;

    private ShopTabFragment fragment1;

    private ShopTabFragment fragment2;

    private ShopTabFragment fragment3;

    private ShopTopAdapter shopTopAdapter;

    private ShopCenterAdapter shopCenterAdapter;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_shop;
    }

    @Override
    protected void initView() {
        titleList = new ArrayList<>();
        fragments = new ArrayList<>();
        tabAdapter = new ShopTabAdapter(getActivity().getSupportFragmentManager(), fragments, titleList);
        shopTopAdapter = new ShopTopAdapter(new ArrayList<>());
        shopCenterAdapter = new ShopCenterAdapter(new ArrayList<>());
    }

    @Override
    public void onPageViewClicked(int position) {

    }

    @SuppressLint("NewApi")
    @Override
    public void onGlobalLayout() {
        realLayout.setTranslationY(seatLayout.getTop());
        realLayout.setVisibility(View.VISIBLE);
        viewPager.getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    @Override
    public void getData() {
        super.getData();
        EmptyRequest emptyRequest = new EmptyRequest();
        disposable = retrofitClient.getFindRecommendGoods(emptyRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(bean -> {
                    setData(bean);
                }, throwable -> {

                });
    }

    @Override
    public void onScrollChanged(int x, int y, int oldx, int oldy) {
        int translation = Math.max(y, seatLayout.getTop());
        realLayout.setTranslationY(translation);
        if (y - 50 * 3 > realLayout.getHeight() - 10) {

        } else {

        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (!disposable.isDisposed()) {
            disposable.dispose();
        }
    }

    private void setData(FindRecommendGoodsBean bean) {

        List<View> list = new ArrayList<>();

        for (int i = 0; i < bean.getBannerList().size(); i++) {
            ImageView imageView = new ImageView(getActivity());
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            GlideUtils.showToImageView(context, imageView, bean.getBannerList().get(i).getAdvertisingUrl().toString());
            list.add(imageView);
        }

        bannerView.setPageViewPics(list);

        shopTopAdapter.setData(bean.getHotlist());
        shopCenterAdapter.setData(bean.getTravellist());

        topTitle.setText(bean.getHotlist().get(0).getClassifyName());
        centerTitle.setText(bean.getTravellist().get(0).getClassifyName());
    }

    @Override
    protected void setAttribute() {

        recyclerView1.setLayoutManager(new GridLayoutManager(context, 2));
        recyclerView1.setAdapter(shopTopAdapter);

        recyclerView2.setLayoutManager(new GridLayoutManager(context, 2));
        recyclerView2.setAdapter(shopCenterAdapter);


        titleList.add("默认排序");
        titleList.add("销量最高");
        titleList.add("价格最优");

        fragment1 = new ShopTabFragment(0);
        fragment2 = new ShopTabFragment(1);
        fragment3 = new ShopTabFragment(2);

        fragment1.setSwipeRefreshLayout(refreshLayout);
        fragment2.setSwipeRefreshLayout(refreshLayout);
        fragment3.setSwipeRefreshLayout(refreshLayout);

        fragments.add(fragment1);
        fragments.add(fragment2);
        fragments.add(fragment3);

        for (int i = 0; i < titleList.size(); i++) {
            seatLayout.addTab(seatLayout.newTab());
            realLayout.addTab(realLayout.newTab());
        }

        realLayout.setTabMode(titleList.size() <= 4 ? TabLayout.MODE_FIXED : TabLayout.MODE_SCROLLABLE);
        seatLayout.setTabMode(titleList.size() <= 4 ? TabLayout.MODE_FIXED : TabLayout.MODE_SCROLLABLE);
        realLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.orange));
        seatLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.orange));

        seatLayout.setupWithViewPager(viewPager);
        realLayout.setupWithViewPager(viewPager);
        tabAdapter.setData(fragments, titleList);

        viewPager.setOffscreenPageLimit(2);
        viewPager.setCurrentItem(0);
        viewPager.setAdapter(tabAdapter);

        bannerView.setOnPageViewClicked(this);
        onGlobalLayoutListener = this;
        customScrollView.setCallbacks(this);
        refreshLayout.setOnRefreshListener(this);
        shopTopAdapter.setOnItemClickListener(this);
        shopCenterAdapter.setOnItemClickListener(this);
        viewPager.getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);

        refreshLayout.setProgressBackgroundColorSchemeResource(R.color.translucentWhite);
        refreshLayout.setColorSchemeResources(R.color.dark_grey, R.color.theme, R.color.translucent);
    }

    @Override
    public void onRefresh() {
        fragment1.refresh();
    }

    @Override
    public void onItemClick(View v, int position, int type) {
        Intent intent = new Intent(context, GoodsDetailActivity.class);
        if (type == shopTopAdapter.getItemViewType(position)){
            intent.putExtra("goodsId", shopTopAdapter.getData().get(position).getGoodsId() + "");
        }else{
            intent.putExtra("goodsId", shopCenterAdapter.getData().get(position).getGoodsId() + "");
        }
        startActivity(intent);
    }
}
