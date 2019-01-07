package com.youweihui.tourismstore.ui.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.youweihui.tourismstore.R;
import com.youweihui.tourismstore.adapter.ShopTabRecycleAdapter;
import com.youweihui.tourismstore.base.BaseFragment;
import com.youweihui.tourismstore.bean.FindRecommendGoodsListBean;
import com.youweihui.tourismstore.net.client.RetrofitClient;
import com.youweihui.tourismstore.net.request.GoodsListRequest;
import com.youweihui.tourismstore.ui.activity.GoodsDetailActivity;

import java.util.ArrayList;

import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ${范泽宁} on 2018/12/11.
 */

@SuppressLint("ValidFragment")
public class ShopTabFragment extends BaseFragment implements ShopTabRecycleAdapter.OnItemClickListener {

    @BindView(R.id.shop_tab_recycle)
    RecyclerView recyclerView;

    private ShopTabRecycleAdapter recycleAdapter;

    private SwipeRefreshLayout swipeRefreshLayout;

    private Disposable disposable;

    protected boolean isRefreshing;

    private int type;

    private RetrofitClient retrofitClient = new RetrofitClient();

    public ShopTabFragment(int type) {
        this.type = type;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_shop_tab;
    }

    @Override
    protected void initView() {
        recycleAdapter = new ShopTabRecycleAdapter(new ArrayList<>());
        recyclerView.setLayoutManager(new GridLayoutManager(context, 2));
        recyclerView.setAdapter(recycleAdapter);
        recycleAdapter.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(View v, int position) {
        Intent intent = new Intent(context, GoodsDetailActivity.class);
        intent.putExtra("goodsId", recycleAdapter.getData().get(position).getGoodsId()+"");
        startActivity(intent);
    }

    public void setSwipeRefreshLayout(SwipeRefreshLayout swipeRefreshLayout) {
        this.swipeRefreshLayout = swipeRefreshLayout;
    }

    public boolean isRefreshing() {
        return isRefreshing;
    }

    public void setRefreshing(boolean refreshing) {
        isRefreshing = refreshing;
    }

    public void refresh() {
        if (isRefreshing())
            return;
        setRefreshing(true);
        new Handler().postDelayed(() -> {
            setRefreshing(false);
            if (swipeRefreshLayout != null)
                swipeRefreshLayout.setRefreshing(false);
        }, 0);
    }

    @Override
    public void getData() {
        super.getData();
        GoodsListRequest listRequest = new GoodsListRequest();
        listRequest.setPage(1);
        listRequest.setLimit(100);
        listRequest.setOrderby(type);
        disposable = retrofitClient.getFindRecommendGoodsList(listRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(bean -> {
                    setData(bean);
                }, throwable -> {

                });
    }

    private void setData(FindRecommendGoodsListBean bean) {
        recycleAdapter.setData(bean.getPage().getList());
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (!disposable.isDisposed()) {
            disposable.dispose();
        }
    }
}
