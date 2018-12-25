package com.youweihui.tourismstore.ui.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageButton;

import com.youweihui.tourismstore.R;
import com.youweihui.tourismstore.adapter.ProductTabAdapter;
import com.youweihui.tourismstore.adapter.ProductTopAdapter;
import com.youweihui.tourismstore.base.BaseActivity;
import com.youweihui.tourismstore.bean.HomeTailOrderEntity;
import com.youweihui.tourismstore.bean.ShopEntity;
import com.youweihui.tourismstore.view.CustomScrollView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by ${范泽宁} on 2018/12/14.
 */

public class ProductActivity extends BaseActivity implements ProductTabAdapter.OnItemClickListener {

    @BindView(R.id.product_recycle)
    RecyclerView recyclerView;

    @BindView(R.id.product_recycle2)
    RecyclerView recyclerView2;

    @BindView(R.id.product_tb_layout)
    TabLayout tabLayout;

    @BindView(R.id.product_tb_layout2)
    TabLayout tabLayout2;

    @BindView(R.id.product_back)
    ImageButton back;

    @BindView(R.id.product_scroll)
    CustomScrollView customScrollView;

    private ProductTopAdapter productTopAdapter;

    private ProductTabAdapter tabAdapter;

    private List<String> tabList;

    private ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        tabList = new ArrayList<>();

        productTopAdapter = new ProductTopAdapter(new ArrayList<ShopEntity>());
        tabAdapter = new ProductTabAdapter(new ArrayList<HomeTailOrderEntity>());
        recyclerView.setLayoutManager(new GridLayoutManager(this, 5));
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(productTopAdapter);
        recyclerView2.setAdapter(tabAdapter);
        tabAdapter.setOnItemClickListener(this);

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
//        ShopEntity shopEntity11 = new ShopEntity();
//        ShopEntity shopEntity12 = new ShopEntity();
//        ShopEntity shopEntity13 = new ShopEntity();
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
//        list.add(shopEntity11);
//        list.add(shopEntity12);
//        list.add(shopEntity13);
        productTopAdapter.setData(list);

        tabList.add("推荐");
        tabList.add("当季热门");
        tabList.add("海岛");
        tabList.add("名胜古迹");
        tabList.add("旅游景点");
        tabList.add("上海");
        tabList.add("广州");
        tabList.add("北京");
        tabList.add("更多地方");

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
        tailOrderList.add(entity6);
        tailOrderList.add(entity7);
        tailOrderList.add(entity8);

        tabAdapter.setData(tailOrderList);

        for (int i = 0; i < tabList.size(); i++) {
            tabLayout.addTab(tabLayout.newTab().setText(tabList.get(i).toString()));
            tabLayout2.addTab(tabLayout2.newTab().setText(tabList.get(i).toString()));
        }

        tabLayout.setTabMode(tabList.size() <= 4 ? TabLayout.MODE_FIXED : TabLayout.MODE_SCROLLABLE);
        tabLayout2.setTabMode(tabList.size() <= 4 ? TabLayout.MODE_FIXED : TabLayout.MODE_SCROLLABLE);
        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.orange));
        tabLayout2.setSelectedTabIndicatorColor(getResources().getColor(R.color.orange));

        onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() {
            @SuppressLint("NewApi")
            @Override
            public void onGlobalLayout() {
                tabLayout2.setTranslationY(tabLayout.getTop());
                tabLayout2.setVisibility(View.VISIBLE);
                recyclerView2.getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
            }
        };

        recyclerView2.getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);

        customScrollView.setCallbacks(new CustomScrollView.Callbacks() {
            @Override
            public void onScrollChanged(int x, int y, int oldx, int oldy) {
                int translation = Math.max(y, tabLayout.getTop());
                tabLayout2.setTranslationY(translation);
            }
        });

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
    public void onItemClick(View v, int position) {
        Intent intent = new Intent(ProductActivity.this, TailOrderDetailActivity.class);
        startActivity(intent);
    }

    @OnClick({R.id.product_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.product_back:
                finish();
                break;
        }
    }
}
