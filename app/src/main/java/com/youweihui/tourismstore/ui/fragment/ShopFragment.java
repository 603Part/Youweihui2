package com.youweihui.tourismstore.ui.fragment;

import android.annotation.SuppressLint;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

import com.youweihui.tourismstore.R;
import com.youweihui.tourismstore.adapter.ShopTabAdapter;
import com.youweihui.tourismstore.base.BaseFragment;
import com.youweihui.tourismstore.bean.HomeTailOrderEntity;
import com.youweihui.tourismstore.net.Const;
import com.youweihui.tourismstore.net.client.IntegralClient;
import com.youweihui.tourismstore.net.request.GoodsRequest;
import com.youweihui.tourismstore.net.request.SubmitRequest;
import com.youweihui.tourismstore.net.response.BaseResponse;
import com.youweihui.tourismstore.utils.GlideUtils;
import com.youweihui.tourismstore.view.BannerView;
import com.youweihui.tourismstore.view.CustomScrollView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.support.constraint.Constraints.TAG;

/**
 * Created by ${范泽宁} on 2018/12/10.
 */

public class ShopFragment extends BaseFragment {

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

    private ArrayList<String> imgList;

    private ArrayList<String> titleList;

    private ArrayList<ShopTabFragment> fragments;

    private ShopTabAdapter tabAdapter;

    private ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
    private IntegralClient integralClient = new IntegralClient();
    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_shop;
    }

    @Override
    protected void initView() {
        imgList = new ArrayList<>();
        titleList = new ArrayList<>();
        fragments = new ArrayList<>();
        addData();
        initData();
        setBannerData();

        tabAdapter = new ShopTabAdapter(getActivity().getSupportFragmentManager(), fragments, titleList);

        for (int i = 0; i < titleList.size(); i++) {
            ShopTabFragment fragment = new ShopTabFragment();
            seatLayout.addTab(seatLayout.newTab());
            realLayout.addTab(realLayout.newTab());
            fragments.add(fragment);
        }

        viewPager.setAdapter(tabAdapter);

        viewPager.setOffscreenPageLimit(2);
        viewPager.setCurrentItem(0);

        realLayout.setTabMode(titleList.size() <= 4 ? TabLayout.MODE_FIXED : TabLayout.MODE_SCROLLABLE);
        seatLayout.setTabMode(titleList.size() <= 4 ? TabLayout.MODE_FIXED : TabLayout.MODE_SCROLLABLE);
        realLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.orange));
        seatLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.orange));

        onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() {
            @SuppressLint("NewApi")
            @Override
            public void onGlobalLayout() {
                realLayout.setTranslationY(seatLayout.getTop());
                realLayout.setVisibility(View.VISIBLE);
                viewPager.getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
            }
        };

        viewPager.getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);

        customScrollView.setCallbacks(new CustomScrollView.Callbacks() {
            @Override
            public void onScrollChanged(int x, int y, int oldx, int oldy) {
                int translation = Math.max(y, seatLayout.getTop());
                realLayout.setTranslationY(translation);
                if (y - 50 * 3 > realLayout.getHeight() - 10) {
                } else {
                }
            }
        });

        realLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        seatLayout.setupWithViewPager(viewPager);
        realLayout.setupWithViewPager(viewPager);
        tabAdapter.setData(fragments, titleList);
    }

    private static final String TAG = "ShopFragment";
    private void initData() {

//        SubmitRequest submitRequest = new SubmitRequest();
//        submitRequest.setAddressId(1);
//        submitRequest.setIntegralGoodsId(1);
//        submitRequest.setNumber(1);

        GoodsRequest goodsRequest = new GoodsRequest();
        goodsRequest.setGoodsId(1);

        integralClient.submitorderCall(goodsRequest).enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                String msg = response.body().getMsg();
                String code = response.body().getCode();
                Log.d(TAG, "onResponse: " + msg + code);
            }

            @Override
            public void onFailure(Call<BaseResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private void setBannerData() {
        List<View> list = new ArrayList<>();

        for (int i = 0; i < imgList.size(); i++) {
            ImageView imageView = new ImageView(getActivity());
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            GlideUtils.showToImageView(context, imageView, imgList.get(i).toString());
            list.add(imageView);
        }

        bannerView.setPageViewPics(list);

        bannerView.setOnPageViewClicked(new BannerView.OnPageViewClicked() {
            @Override
            public void onPageViewClicked(int position) {

            }
        });
    }


    private void addData() {
        GlideUtils.showToImageView(context, imageView, "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1544604788490&di=fc5b75d6e602177ce0a03a3d41caf973&imgtype=0&src=http%3A%2F%2Fimg11.360buyimg.com%2FpopWaterMark%2Fjfs%2Ft1282%2F115%2F192193495%2F98436%2Fe93dc4c6%2F555864dfNe01ec732.jpg");
        GlideUtils.showToImageView(context, imageView2, "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2716005277,1504952450&fm=26&gp=0.jpg");
        GlideUtils.showToImageView(context, imageView3, "http://img0.imgtn.bdimg.com/it/u=3984418058,1929810248&fm=200&gp=0.jpg");
        GlideUtils.showToImageView(context, imageView4, "http://img4.imgtn.bdimg.com/it/u=194403913,1806200511&fm=200&gp=0.jpg");
        HomeTailOrderEntity entity1 = new HomeTailOrderEntity();
        HomeTailOrderEntity entity2 = new HomeTailOrderEntity();
        HomeTailOrderEntity entity3 = new HomeTailOrderEntity();
        HomeTailOrderEntity entity4 = new HomeTailOrderEntity();
        HomeTailOrderEntity entity5 = new HomeTailOrderEntity();
        HomeTailOrderEntity entity6 = new HomeTailOrderEntity();
        HomeTailOrderEntity entity7 = new HomeTailOrderEntity();
        HomeTailOrderEntity entity8 = new HomeTailOrderEntity();

        entity1.setImg("http://you.lumeilvyou3.cn/wenda/01/images/b2367f36779e3fa7fe3a2c131b3d7a84.jpg");
        entity8.setImg("http://you.lumeilvyou3.cn/wenda/01/images/b2367f36779e3fa7fe3a2c131b3d7a84.jpg");
        entity2.setImg("http://you.lumeilvyou3.cn/wenda/01/images/a6ad9024c244ffbd20427c37a1e691a8.jpg");
        entity7.setImg("http://you.lumeilvyou3.cn/wenda/01/images/55b79ae2e0296aef854d03289e4f0664.jpg");
        entity3.setImg("http://you.lumeilvyou3.cn/wenda/01/images/55b79ae2e0296aef854d03289e4f0664.jpg");
        entity4.setImg("http://you.lumeilvyou3.cn/wenda/01/images/eecdc2b9be66398a43d57430138cef4a.jpg");
        entity6.setImg("http://you.lumeilvyou3.cn/wenda/01/images/eecdc2b9be66398a43d57430138cef4a.jpg");
        entity5.setImg("http://you.lumeilvyou3.cn/wenda/01/images/a6ad9024c244ffbd20427c37a1e691a8.jpg");

        titleList.add("默认排序");
        titleList.add("销量最高");
        titleList.add("价格最优");

        imgList.add("http://img17.3lian.com/d/file/201702/16/17cd567662bafc8d63d73d41444585d2.jpg");
        imgList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1544426740841&di=1aa67a38806d3cb35d77a1e9bce4d707&imgtype=0&src=http%3A%2F%2Fimg.pptjia.com%2Fimage%2F20180117%2Ff4b76385a3ccdbac48893cc6418806d5.jpg");
        imgList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1544426787463&di=423811f8e34002b14a8039e9ec53bf75&imgtype=0&src=http%3A%2F%2Fimg17.3lian.com%2Fd%2Ffile%2F201701%2F09%2F7d3cdc209be727aef32d28795dd58b3b.jpg");

    }
}
