package com.youweihui.tourismstore.ui.fragment;

import android.support.design.widget.TabLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;

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
public class ShopFragment2 extends BaseFragment {

    @BindView(R.id.shop_recycle)
    RecyclerView recyclerView;

    @BindView(R.id.shop_top_tab)
    TabLayout tabLayout;

    @BindView(R.id.shop_top_linear)
    LinearLayout linearLayout;

    private int type = 1;

    private Disposable disposable;

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
    }

    @Override
    public void getData() {
        super.getData();
        getFindRecommendGoods();
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
            }
        });
    }

    @Override
    protected void setAttribute() {
        linearLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(shopAdapter);

        tabLayout.addTab(tabLayout.newTab().setText("默认排序"));
        tabLayout.addTab(tabLayout.newTab().setText("销量最高"));
        tabLayout.addTab(tabLayout.newTab().setText("价格最优"));
        tabLayout.setTabMode(TabLayout.MODE_FIXED );
    }

    private void getFindRecommendGoodsList() {
        GoodsListRequest listRequest = new GoodsListRequest();
        listRequest.setPage(1);
        listRequest.setLimit(100);
        listRequest.setOrderby(type);
        disposable = retrofitClient.getFindRecommendGoodsList(listRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(bean -> {
                    bean.getPage().getList().add(new FindRecommendGoodsListBean.PageBean.ListBean());
                    bean.getPage().getList().add(new FindRecommendGoodsListBean.PageBean.ListBean());
                    bean.getPage().getList().add(new FindRecommendGoodsListBean.PageBean.ListBean());
                    bean.getPage().getList().add(new FindRecommendGoodsListBean.PageBean.ListBean());
                    bean.getPage().getList().add(new FindRecommendGoodsListBean.PageBean.ListBean());
                    bean.getPage().getList().add(new FindRecommendGoodsListBean.PageBean.ListBean());
                    bean.getPage().getList().add(new FindRecommendGoodsListBean.PageBean.ListBean());
                    bean.getPage().getList().add(new FindRecommendGoodsListBean.PageBean.ListBean());
                    bean.getPage().getList().add(new FindRecommendGoodsListBean.PageBean.ListBean());
                    bean.getPage().getList().add(new FindRecommendGoodsListBean.PageBean.ListBean());
                    bean.getPage().getList().add(new FindRecommendGoodsListBean.PageBean.ListBean());
                    bean.getPage().getList().add(new FindRecommendGoodsListBean.PageBean.ListBean());
                    bean.getPage().getList().add(new FindRecommendGoodsListBean.PageBean.ListBean());
                    bean.getPage().getList().add(new FindRecommendGoodsListBean.PageBean.ListBean());
                    bean.getPage().getList().add(new FindRecommendGoodsListBean.PageBean.ListBean());
                    bean.getPage().getList().add(new FindRecommendGoodsListBean.PageBean.ListBean());
                    bean.getPage().getList().add(new FindRecommendGoodsListBean.PageBean.ListBean());
                    bean.getPage().getList().add(new FindRecommendGoodsListBean.PageBean.ListBean());
                    shopAdapter.setData(bean.getPage().getList());
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
                    getFindRecommendGoodsList();
                }, throwable -> {

                });
    }
}
