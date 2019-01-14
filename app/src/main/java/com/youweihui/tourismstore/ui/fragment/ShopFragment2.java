package com.youweihui.tourismstore.ui.fragment;

import android.support.design.widget.TabLayout;
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
public class ShopFragment2 extends BaseFragment implements ShopAdapter.OnTabSelectedListener {

    @BindView(R.id.shop_recycle)
    RecyclerView recyclerView;

    @BindView(R.id.shop_top_tab)
    TabLayout tabLayout;

    @BindView(R.id.shop_top_linear)
    LinearLayout linearLayout;

    private int page = 1;

    private Disposable disposable;

    private int tabPosition;

    private RetrofitClient retrofitClient = new RetrofitClient();

    private ShopAdapter shopAdapter;

    private LinearLayoutManager linearLayoutManager;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_shop2;
    }

    @Override
    protected void initView() {
        shopAdapter = new ShopAdapter(context);
        shopAdapter.setOnTabSelectedListener(this);
    }

    @Override
    public void getData() {
        super.getData();
        getFindRecommendGoods();
        getFindRecommendGoodsList(0);
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
                if (firstPosition >= shopAdapter.getItemViewType(2)) {
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
        linearLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(shopAdapter);

        tabLayout.addTab(tabLayout.newTab().setText("默认排序"));
        tabLayout.addTab(tabLayout.newTab().setText("销量最高"));
        tabLayout.addTab(tabLayout.newTab().setText("价格最优"));
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
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
                        if (shopAdapter.getListData().size() > 0) {
                            shopAdapter.loadDataList(bean.getPage().getList(), true);
                        } else {
                            shopAdapter.setData(bean.getPage().getList());
                        }
                    } else {
                        Toast.makeText(context, "没有更多", Toast.LENGTH_SHORT).show();
                    }
                }, throwable -> {

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

                });
    }

    @Override
    public void onTabClick(int position) {
        tabPosition = position;
        switch (position) {
            case 0:
                getFindRecommendGoodsList(0);
                break;
            case 1:
                getFindRecommendGoodsList(1);
                break;
            case 2:
                getFindRecommendGoodsList(2);
                break;
        }
    }
}
