package com.youweihui.tourismstore.ui.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.Toast;

import com.youweihui.tourismstore.R;
import com.youweihui.tourismstore.adapter.TailOrderTabRecycleAdapter;
import com.youweihui.tourismstore.adapter.TailOrderTabRecycleAdapter2;
import com.youweihui.tourismstore.base.BaseFragment;
import com.youweihui.tourismstore.bean.HomeTailOrderEntity;
import com.youweihui.tourismstore.bean.ShopEntity;
import com.youweihui.tourismstore.ui.activity.ProductActivity;
import com.youweihui.tourismstore.ui.activity.TailOrderDetailActivity;
import com.youweihui.tourismstore.utils.GlideUtils;
import com.youweihui.tourismstore.utils.SpaceItemDecoration;
import com.youweihui.tourismstore.view.BannerView;
import com.youweihui.tourismstore.view.CustomScrollView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by ${范泽宁} on 2018/12/10.
 */

public class TailOrderFragment extends BaseFragment implements TailOrderTabRecycleAdapter2.OnItemClickListener,TailOrderTabRecycleAdapter.OnItemClickListener{

    //轮播图
    @BindView(R.id.tail_order_banner)
    BannerView bannerView;

    @BindView(R.id.tail_order_tb_layout)
    TabLayout tabLayout;

    @BindView(R.id.tail_order_tb_layout2)
    TabLayout tabLayout2;

    @BindView(R.id.tail_order_scroll)
    CustomScrollView customScrollView;

    @BindView(R.id.tail_order_recycle2)
    RecyclerView recyclerView2;

    @BindView(R.id.tail_order_recycle)
    RecyclerView recyclerView;

    private ArrayList<String> imgList;

    private List<String> tabList;

    private List<BaseFragment> fragList;

    private TailOrderTabRecycleAdapter2 tabRecycleAdapter2;

    private TailOrderTabRecycleAdapter tabRecycleAdapter;

    private ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;

    private int scrollX;

    private int scrollY;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_tail_order;
    }

    @Override
    protected void initView() {
        imgList = new ArrayList<>();
        fragList = new ArrayList<>();
        tabList = new ArrayList<>();

        tabRecycleAdapter2 = new TailOrderTabRecycleAdapter2(new ArrayList<ShopEntity>());
        tabRecycleAdapter = new TailOrderTabRecycleAdapter(new ArrayList<HomeTailOrderEntity>());
        recyclerView2.setLayoutManager(new GridLayoutManager(context, 4));
        recyclerView2.addItemDecoration(new SpaceItemDecoration(1, 1));
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView2.setAdapter(tabRecycleAdapter2);
        recyclerView.setAdapter(tabRecycleAdapter);

        tabRecycleAdapter2.setOnItemClickListener(this);
        tabRecycleAdapter.setOnItemClickListener(this);

        addData();
        setBannerData();
        setTailOrder();
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

    private void setTailOrder() {
        for (int i = 0; i < tabList.size(); i++) {
            tabLayout.addTab(tabLayout.newTab().setText(tabList.get(i).toString()));
            tabLayout2.addTab(tabLayout2.newTab().setText(tabList.get(i).toString()));
        }
        tabLayout.setTabMode(tabList.size() <= 4 ? TabLayout.MODE_FIXED : TabLayout.MODE_SCROLLABLE);
        tabLayout2.setTabMode(tabList.size() <= 4 ? TabLayout.MODE_FIXED : TabLayout.MODE_SCROLLABLE);
        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.orange));
        tabLayout2.setSelectedTabIndicatorColor(getResources().getColor(R.color.orange));

//        tabLayout.setSelectedTabIndicatorHeight((int) getResources().getDimension(R.dimen.indicatorHeight));

        onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() {
            @SuppressLint("NewApi")
            @Override
            public void onGlobalLayout() {
                tabLayout2.setTranslationY(tabLayout.getTop());//tabLayout.getTop() 1128
                tabLayout2.setVisibility(View.VISIBLE);
                Toast.makeText(context,"3",Toast.LENGTH_SHORT).show();
                recyclerView.getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
            }
        };

        customScrollView.setCallbacks(new CustomScrollView.Callbacks() {
            @Override
            public void onScrollChanged(int x, int y, int oldx, int oldy) {
                int translation = Math.max(y, tabLayout.getTop());
                tabLayout2.setTranslationY(translation);
                if (y - 50 * 3 > tabLayout2.getHeight() - 10) {

                } else {

                }
            }
        });

        recyclerView.getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);

        tabLayout2.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
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
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden) {
            scrollX = customScrollView.getScrollX();
            scrollY = customScrollView.getScrollY();
            bannerView.stop();
        } else {
            customScrollView.scrollTo(scrollX, scrollY);
            bannerView.start();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        bannerView.stop();
    }

    @Override
    public void onStop() {
        super.onStop();
        bannerView.stop();
    }

    private void addData() {
        List<HomeTailOrderEntity> tailOrderList = new ArrayList<>();

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

        tailOrderList.add(entity1);
        tailOrderList.add(entity2);
        tailOrderList.add(entity3);
        tailOrderList.add(entity4);
        tailOrderList.add(entity5);
        tailOrderList.add(entity7);
        tailOrderList.add(entity8);
        tailOrderList.add(entity6);

        tabList.add("推荐");
        tabList.add("当季热门");
        tabList.add("海岛");
        tabList.add("名胜古迹");
        tabList.add("旅游景点");
        tabList.add("上海");
        tabList.add("广州");
        tabList.add("北京");
        tabList.add("更多地方");

        imgList.add("http://img17.3lian.com/d/file/201702/16/17cd567662bafc8d63d73d41444585d2.jpg");
        imgList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1544426740841&di=1aa67a38806d3cb35d77a1e9bce4d707&imgtype=0&src=http%3A%2F%2Fimg.pptjia.com%2Fimage%2F20180117%2Ff4b76385a3ccdbac48893cc6418806d5.jpg");
        imgList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1544426787463&di=423811f8e34002b14a8039e9ec53bf75&imgtype=0&src=http%3A%2F%2Fimg17.3lian.com%2Fd%2Ffile%2F201701%2F09%2F7d3cdc209be727aef32d28795dd58b3b.jpg");

        List<ShopEntity> list = new ArrayList<>();
        ShopEntity shopEntity1 = new ShopEntity();
        ShopEntity shopEntity2 = new ShopEntity();
        ShopEntity shopEntity3 = new ShopEntity();
        ShopEntity shopEntity4 = new ShopEntity();
        ShopEntity shopEntity5 = new ShopEntity();
        ShopEntity shopEntity6 = new ShopEntity();
        ShopEntity shopEntity7 = new ShopEntity();
        ShopEntity shopEntity8 = new ShopEntity();
        ShopEntity shopEntity9 = new ShopEntity();
        ShopEntity shopEntity10 = new ShopEntity();
        ShopEntity shopEntity11 = new ShopEntity();
        ShopEntity shopEntity12 = new ShopEntity();
        list.add(shopEntity1);
        list.add(shopEntity2);
        list.add(shopEntity3);
        list.add(shopEntity4);
        list.add(shopEntity5);
        list.add(shopEntity6);
        list.add(shopEntity7);
        list.add(shopEntity8);
        list.add(shopEntity9);
        list.add(shopEntity10);
        list.add(shopEntity11);
        list.add(shopEntity12);
        tabRecycleAdapter2.setData(list);


        tailOrderList.add(entity1);
        tailOrderList.add(entity2);
        tailOrderList.add(entity3);
        tailOrderList.add(entity4);
        tailOrderList.add(entity5);
        tailOrderList.add(entity6);
        tailOrderList.add(entity7);
        tailOrderList.add(entity8);

        tabRecycleAdapter.setData(tailOrderList);
    }

    @Override
    public void onItemClick(View v, int position, int type) {
        if (type == 0){
            Intent intent = new Intent(context, ProductActivity.class);
            startActivity(intent);
        }else{
            Intent intent = new Intent(context, TailOrderDetailActivity.class);
            startActivity(intent);
        }
    }
}
