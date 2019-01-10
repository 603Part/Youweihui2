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
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.youweihui.tourismstore.R;
import com.youweihui.tourismstore.adapter.TailOrderDetailAdapter;
import com.youweihui.tourismstore.adapter.TailOrderDetailImgListAdapter;
import com.youweihui.tourismstore.adapter.TailOrderDetailListAdapter;
import com.youweihui.tourismstore.base.BaseActivity;
import com.youweihui.tourismstore.bean.HomeTabEntity;
import com.youweihui.tourismstore.bean.HomeTailOrderEntity;
import com.youweihui.tourismstore.utils.GlideUtils;
import com.youweihui.tourismstore.utils.GridSpacingItemDecoration;
import com.youweihui.tourismstore.view.CustomScrollView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class TailOrderDetailActivity extends BaseActivity {

    @BindView(R.id.tail_order_detail_recycle2)
    RecyclerView recyclerView;

    @BindView(R.id.tail_order_detail_recycle)
    RecyclerView dateRecyclerView;

    @BindView(R.id.tail_order_detail_recycle3)
    RecyclerView imgRecycleView;

    @BindView(R.id.tail_order_detail_top_img)
    ImageView imageView;

    @BindView(R.id.tail_order_tb_layout)
    TabLayout tabLayout;

    @BindView(R.id.tail_order_tb_layout2)
    TabLayout tabLayout2;

    @BindView(R.id.tail_order_detail_scroll)
    CustomScrollView customScrollView;

    @BindView(R.id.tail_order_relative)
    RelativeLayout relativeLayout;

    private ArrayList<String> imgList;

    private List<String> tabList;

    private TailOrderDetailListAdapter listAdapter;

    private TailOrderDetailImgListAdapter imgListAdapter;

    private TailOrderDetailAdapter adapter;

    private ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tail_order_detail);

//        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        setStatusBarColor(false);

        GlideUtils.showToImageView(this, imageView, "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1545417741414&di=4527223a7d4259721b48e6781a2ab24b&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2F38dbb6fd5266d016c2a2ac069c2bd40735fa3560.jpg");

        imgList = new ArrayList<>();
        tabList = new ArrayList<>();

        adapter = new TailOrderDetailAdapter(new ArrayList<HomeTailOrderEntity>());
        listAdapter = new TailOrderDetailListAdapter(new ArrayList<HomeTabEntity>());
        imgListAdapter = new TailOrderDetailImgListAdapter(new ArrayList<HomeTabEntity>());

        dateRecyclerView.setLayoutManager(new GridLayoutManager(this, 5));
        dateRecyclerView.addItemDecoration(new GridSpacingItemDecoration(5, 10, true));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        imgRecycleView.setLayoutManager(new LinearLayoutManager(this));

        dateRecyclerView.setAdapter(adapter);
        recyclerView.setAdapter(listAdapter);

        imgRecycleView.setAdapter(imgListAdapter);

        tabList.add("产品特色");
        tabList.add("详细行程");
        tabList.add("费用说明");
        tabList.add("预定指南");
        tabList.add("产品评论");

        for (int i = 0; i < tabList.size(); i++) {
            tabLayout2.addTab(tabLayout2.newTab().setText(tabList.get(i).toString()));
        }

        tabLayout.setTabMode(tabList.size() <= 4 ? TabLayout.MODE_FIXED : TabLayout.MODE_SCROLLABLE);
        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.orange));
        tabLayout2.setTabMode(tabList.size() <= 4 ? TabLayout.MODE_FIXED : TabLayout.MODE_SCROLLABLE);
        tabLayout2.setSelectedTabIndicatorColor(getResources().getColor(R.color.orange));

        onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() {
            @SuppressLint("NewApi")
            @Override
            public void onGlobalLayout() {
                tabLayout2.setTranslationY(tabLayout.getTop());
                tabLayout2.setVisibility(View.VISIBLE);
                customScrollView.getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
            }
        };

        customScrollView.getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);

        customScrollView.setCallbacks(new CustomScrollView.Callbacks() {
            @Override
            public void onScrollChanged(int x, int y, int oldx, int oldy) {
                int translation = Math.max(y, tabLayout.getTop());
                tabLayout2.setTranslationY(translation);
                if (y > relativeLayout.getHeight()) {
//                    getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                    setStatusBarColor(true);
                } else {
//                    getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_LAYOUT_FLAGS);
                    setStatusBarColor(false);
                }
            }
        });

        add();
    }

    private void add() {
        List<HomeTabEntity> list = new ArrayList<>();
        List<HomeTailOrderEntity> list2 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            HomeTabEntity homeTabEntity = new HomeTabEntity();
            HomeTailOrderEntity homeTailOrderEntity = new HomeTailOrderEntity();
            switch (i) {
                case 0:
                    homeTabEntity.setImg("http://you.lumeilvyou3.cn/wenda/01/images/b2367f36779e3fa7fe3a2c131b3d7a84.jpg");
                    break;
                case 1:
                    homeTabEntity.setImg("http://you.lumeilvyou3.cn/wenda/01/images/b2367f36779e3fa7fe3a2c131b3d7a84.jpg");
                    break;
                case 2:
                    homeTabEntity.setImg("http://you.lumeilvyou3.cn/wenda/01/images/a6ad9024c244ffbd20427c37a1e691a8.jpg");
                    break;
                case 3:
                    homeTabEntity.setImg("http://you.lumeilvyou3.cn/wenda/01/images/55b79ae2e0296aef854d03289e4f0664.jpg");
                    break;
                case 4:
                    homeTabEntity.setImg("http://you.lumeilvyou3.cn/wenda/01/images/55b79ae2e0296aef854d03289e4f0664.jpg");
                    break;
                case 5:
                    homeTabEntity.setImg("http://you.lumeilvyou3.cn/wenda/01/images/eecdc2b9be66398a43d57430138cef4a.jpg");
                    break;
                case 6:
                    homeTabEntity.setImg("http://you.lumeilvyou3.cn/wenda/01/images/a6ad9024c244ffbd20427c37a1e691a8.jpg");
                    break;
                case 7:
                    homeTabEntity.setImg("http://you.lumeilvyou3.cn/wenda/01/images/eecdc2b9be66398a43d57430138cef4a.jpg");
                    break;
            }
            list.add(homeTabEntity);
            list2.add(homeTailOrderEntity);
        }
        adapter.setData(list2);
        listAdapter.setData(list);
        imgListAdapter.setData(list);
    }

    @OnClick({R.id.tail_order_detail_back, R.id.goods_detail_start})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tail_order_detail_back:
                finish();
                break;
            case R.id.goods_detail_start:
                Intent intent = new Intent(this, OrderWriteActivity.class);
                intent.putExtra("1","2");
                startActivity(intent);
                break;
        }
    }
}
