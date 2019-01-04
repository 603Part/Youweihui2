package com.youweihui.tourismstore.ui.fragment;

import android.annotation.SuppressLint;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

import com.youweihui.tourismstore.R;
import com.youweihui.tourismstore.adapter.ShopTabAdapter;
import com.youweihui.tourismstore.base.BaseFragment;
import com.youweihui.tourismstore.bean.FindRecommendGoodsBean;
import com.youweihui.tourismstore.bean.HomeTailOrderEntity;
import com.youweihui.tourismstore.net.Const;
import com.youweihui.tourismstore.net.client.IntegralClient;
import com.youweihui.tourismstore.net.request.EmptyRequest;
import com.youweihui.tourismstore.net.request.GoodsRequest;
import com.youweihui.tourismstore.net.request.SubmitRequest;
import com.youweihui.tourismstore.net.response.BaseResponse;
import com.youweihui.tourismstore.utils.GlideUtils;
import com.youweihui.tourismstore.view.BannerView;
import com.youweihui.tourismstore.view.CustomScrollView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.support.constraint.Constraints.TAG;

/**
 * Created by ${范泽宁} on 2018/12/10.
 */

public class ShopFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener,BannerView.OnPageViewClicked ,ViewTreeObserver.OnGlobalLayoutListener,CustomScrollView.Callbacks {

    @BindView(R.id.shop_scroll)
    CustomScrollView customScrollView;

    @BindView(R.id.shop_banner)
    BannerView bannerView;

    @BindView(R.id.shop_img)
    ImageView imageView;

    @BindView(R.id.shop_img2)
    ImageView imageView2;

    @BindView(R.id.shop_img3)
    ImageView imageView3;

    @BindView(R.id.shop_img4)
    ImageView imageView4;

    @BindView(R.id.shop_tb_seat)
    TabLayout seatLayout;

    @BindView(R.id.shop_tb_real)
    TabLayout realLayout;

    @BindView(R.id.shop_view_pager)
    ViewPager viewPager;

    @BindView(R.id.fragment_shop_refresh)
    SwipeRefreshLayout refreshLayout;

    private ArrayList<String> titleList;

    private ArrayList<ShopTabFragment> fragments;

    private ShopTabAdapter tabAdapter;

    private ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;

    private IntegralClient integralClient = new IntegralClient();
    private Disposable disposable;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_shop;
    }

    @Override
    protected void initView() {
        titleList = new ArrayList<>();
        fragments = new ArrayList<>();
        tabAdapter = new ShopTabAdapter(getActivity().getSupportFragmentManager(), fragments, titleList);
    }

    @Override
    protected void setAttribute() {

        titleList.add("默认排序");
        titleList.add("销量最高");
        titleList.add("价格最优");

        for (int i = 0; i < titleList.size(); i++) {
            ShopTabFragment fragment = new ShopTabFragment();
            seatLayout.addTab(seatLayout.newTab());
            realLayout.addTab(realLayout.newTab());
            fragments.add(fragment);
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
    }

    @Override
    protected void setOnClick() {
        super.setOnClick();
        bannerView.setOnPageViewClicked(this);
        onGlobalLayoutListener = this;
        customScrollView.setCallbacks(this);
        refreshLayout.setOnRefreshListener(this);
        viewPager.getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    @Override
    protected void initSwipeRefresh() {
        super.initSwipeRefresh();
        refreshLayout.setProgressBackgroundColorSchemeResource(R.color.translucentWhite);
        refreshLayout.setColorSchemeResources(R.color.dark_grey, R.color.theme, R.color.translucent);
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
        disposable = integralClient.getFindRecommendGoods(emptyRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(bean -> {
                    List<View> list = new ArrayList<>();
                    for (int i = 0; i < bean.getBannerList().size(); i++) {
                        ImageView imageView = new ImageView(getActivity());
                        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                        GlideUtils.showToImageView(context, imageView, bean.getBannerList().get(i).getAdvertisingUrl().toString());
                        list.add(imageView);
                    }
                    bannerView.setPageViewPics(list);
                }, fzn -> {
                    Log.d(TAG, "getData: ");
                });
//        integralClient.getFindRecommendGoods(emptyRequest)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<FindRecommendGoodsBean>() {
//
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(FindRecommendGoodsBean bean) {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
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

    @Override
    public void onRefresh() {

    }
}
