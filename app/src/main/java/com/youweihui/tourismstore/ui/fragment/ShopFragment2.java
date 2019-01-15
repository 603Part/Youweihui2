package com.youweihui.tourismstore.ui.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.youweihui.tourismstore.R;
import com.youweihui.tourismstore.adapter.ShopAdapter;
import com.youweihui.tourismstore.adapter.ShopAdapter2;
import com.youweihui.tourismstore.base.BaseFragment;
import com.youweihui.tourismstore.bean.FindRecommendGoodsListBean;
import com.youweihui.tourismstore.net.client.RetrofitClient;
import com.youweihui.tourismstore.net.request.EmptyRequest;
import com.youweihui.tourismstore.net.request.GoodsListRequest;

import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ${范泽宁} on 2018/12/10.
 */
public class ShopFragment2 extends BaseFragment implements ShopAdapter2.OnTabSelectedListener, SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.shop_recycle)
    RecyclerView recyclerView;

    @BindView(R.id.shop_top_tab)
    TabLayout tabLayout;

    @BindView(R.id.shop_refresh)
    SwipeRefreshLayout refreshLayout;

    @BindView(R.id.shop_top_linear)
    LinearLayout linearLayout;

    private int page = 1;

    private Disposable disposable;

    private int tabPosition = 0;

    private RetrofitClient retrofitClient = new RetrofitClient();

    private ShopAdapter2 shopAdapter;

    private LinearLayoutManager linearLayoutManager;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_shop2;
    }

    @Override
    protected void initView() {
        shopAdapter = new ShopAdapter2(context);
    }

    @Override
    public void getData() {
        super.getData();
        getFindRecommendGoods();
        getFindRecommendGoodsList(tabPosition);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (!disposable.isDisposed()) {
            disposable.dispose();
        }
    }

    @Override
    protected void setOnClick() {
        super.setOnClick();
        shopAdapter.setOnTabSelectedListener(this);
        refreshLayout.setOnRefreshListener(this);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
//                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
//                    if (shopAdapter.isFadeTips() == false && lastItemPosition + 1 == shopAdapter.getItemCount()) {
//                        Toast.makeText(context, "最下面", Toast.LENGTH_SHORT).show();
////                        getFindRecommendGoodsList(tabPosition);
//                    }
//                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int firstPosition = linearLayoutManager.findFirstVisibleItemPosition();
                if (firstPosition >= shopAdapter.getItemViewType(1)) {
                    linearLayout.setVisibility(View.VISIBLE);
                    tabLayout.setVisibility(View.VISIBLE);
                } else {
                    linearLayout.setVisibility(View.GONE);
                    tabLayout.setVisibility(View.GONE);
                }

                lastItemPosition = linearLayoutManager.findLastVisibleItemPosition();
            }
        });
    }

    private int lastItemPosition;

    @Override
    protected void setAttribute() {
        linearLayoutManager = new GridLayoutManager(context, 2);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(shopAdapter);
        tabLayout.addTab(tabLayout.newTab().setText("默认排序"));
        tabLayout.addTab(tabLayout.newTab().setText("销量最高"));
        tabLayout.addTab(tabLayout.newTab().setText("价格最优"));
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        refreshLayout.setColorSchemeResources(R.color.theme);
    }

    @Override
    public void onTabClick(int position) {
        tabPosition = position;
        switch (position) {
            case 0:
                page = 1;
                tabPosition = 0;
                getFindRecommendGoodsList(tabPosition);
                break;
            case 1:
                page = 1;
                tabPosition = 1;
                getFindRecommendGoodsList(tabPosition);
                break;
            case 2:
                page = 1;
                tabPosition = 2;
                getFindRecommendGoodsList(tabPosition);
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        recyclerView.setFocusable(false);
    }

    @Override
    public void onRefresh() {
        page = 1;
        shopAdapter.getListData().clear();
        getFindRecommendGoods();
        getFindRecommendGoodsList(tabPosition);
    }

    private void getFindRecommendGoodsList(int orderby) {
        GoodsListRequest listRequest = new GoodsListRequest();
        listRequest.setPage(page);
        listRequest.setLimit(10);
        listRequest.setOrderby(orderby);
        disposable = retrofitClient.getFindRecommendGoodsList(listRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(bean -> {
                    if (page < bean.getPage().getTotalPage()) {
                        page++;
                        shopAdapter.setData(bean.getPage().getList());
                    } else {
                        Toast.makeText(context, "没有更多", Toast.LENGTH_SHORT).show();
                    }

                    if (refreshLayout.isRefreshing())
                        refreshLayout.setRefreshing(false);
                }, throwable -> {
                    if (refreshLayout.isRefreshing())
                        refreshLayout.setRefreshing(false);
                });
    }

    private void getFindRecommendGoods() {
        EmptyRequest emptyRequest = new EmptyRequest();
        disposable = retrofitClient.getFindRecommendGoods(emptyRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(bean -> {
                    shopAdapter.setBanner(bean.getBannerList());
                    shopAdapter.setHot(bean.getHotlist());
                    shopAdapter.setTravel(bean.getTravellist());
                }, throwable -> {
                    if (refreshLayout.isRefreshing())
                        refreshLayout.setRefreshing(false);
                });
    }
}
