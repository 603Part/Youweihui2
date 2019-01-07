package com.youweihui.tourismstore.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.youweihui.tourismstore.R;
import com.youweihui.tourismstore.adapter.GoodsDetailAdapter;
import com.youweihui.tourismstore.base.BaseActivity;
import com.youweihui.tourismstore.bean.GoodInfoBean;
import com.youweihui.tourismstore.net.client.RetrofitClient;
import com.youweihui.tourismstore.net.request.GoodsInfoRequest;
import com.youweihui.tourismstore.utils.GlideUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class GoodsDetailActivity extends BaseActivity implements GoodsDetailAdapter.OnItemClickListener, NestedScrollView.OnScrollChangeListener {

    @BindView(R.id.goods_detail_img)
    ImageView imageView;

    @BindView(R.id.goods_detail_start)
    TextView start;

    @BindView(R.id.goods_detail_content)
    TextView content;

    @BindView(R.id.goods_detail_sales)
    TextView sales;

    @BindView(R.id.goods_detail_integral)
    TextView integral;

    @BindView(R.id.goods_detail_recycle)
    RecyclerView recyclerView;

    @BindView(R.id.goods_detail_scroll)
    NestedScrollView scrollView;

    @BindView(R.id.goods_detail_bottom_linear)
    LinearLayout linearLayout;

    private GoodsDetailAdapter recycleAdapter;

    private Disposable disposable;

    private boolean isShow = true;

    private RetrofitClient retrofitClient = new RetrofitClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_detail);

        recycleAdapter = new GoodsDetailAdapter(new ArrayList<>());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recycleAdapter);
        recycleAdapter.setOnItemClickListener(this);
        scrollView.setOnScrollChangeListener(this);

        getData();
    }

    @OnClick({R.id.goods_detail_start, R.id.goods_detail_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.goods_detail_start:
                Intent intent = new Intent(this, ConfirmOrderActivity.class);
                startActivity(intent);
                break;
            case R.id.goods_detail_back:
                finish();
                break;
        }
    }

    @Override
    public void onItemClick(View v, int position) {

    }

    @Override
    public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
        if (scrollY - oldScrollY > 0 && isShow) {
            isShow = false;
            linearLayout.animate().translationY(linearLayout.getHeight());
        } else if (scrollY - oldScrollY < 0 && !isShow) {
            isShow = true;
            linearLayout.animate().translationY(0);
        }
    }

    private void getData() {
        GoodsInfoRequest goodsInfoRequest = new GoodsInfoRequest();
        goodsInfoRequest.setGoodsId(getIntent().getStringExtra("goodsId"));
        goodsInfoRequest.setMemberId(3 + "");
        disposable = retrofitClient.getGoodsInfo(goodsInfoRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(bean -> {
                    setData(bean.getGoodsInfo());
                }, throwable -> {

                });
    }

    private void setData(GoodInfoBean.GoodsInfoBean bean) {
        GlideUtils.showToImageView(this, imageView, bean.getPictureUrl());
        content.setText(bean.getGoodsDescription());
        integral.setText(bean.getIntegral() + "积分");
        sales.setText("销量 : " + bean.getSalesVolume());
        recycleAdapter.setData(bean.getPictureList());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (!disposable.isDisposed()) {
            disposable.dispose();
        }
    }
}
