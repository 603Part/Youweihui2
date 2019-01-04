package com.youweihui.tourismstore.ui.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

import com.youweihui.tourismstore.R;
import com.youweihui.tourismstore.adapter.EndFragmentTabAdapter;
import com.youweihui.tourismstore.base.BaseActivity;
import com.youweihui.tourismstore.base.BaseFragment;
import com.youweihui.tourismstore.ui.fragment.EndDetailTab1Fragment;
import com.youweihui.tourismstore.ui.fragment.EndDetailTab2Fragment;
import com.youweihui.tourismstore.ui.fragment.EndDetailTab3Fragment;
import com.youweihui.tourismstore.utils.GlideUtils;
import com.youweihui.tourismstore.view.CustomScrollView;
import com.youweihui.tourismstore.view.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class EndDetailsActivity extends BaseActivity {

    @BindView(R.id.end_detail_top_img)
    ImageView imageView;

    @BindView(R.id.end_detail_back)
    ImageView back;

    @BindView(R.id.end_detail_img)
    ImageView imageView2;

    @BindView(R.id.end_detail_tb_layout)
    TabLayout tabLayout;

    @BindView(R.id.end_detail_tb_layout2)
    TabLayout tabLayout2;

    @BindView(R.id.end_detail_scroll)
    CustomScrollView customScrollView;

    @BindView(R.id.end_detail_pager)
    NoScrollViewPager viewPager;

    private ArrayList<String> imgList;

    private List<String> tabList;

    private ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;

    private ArrayList<Fragment> fragments;

    private EndFragmentTabAdapter detailTabAdapter;

    private ArrayList<String> titleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_details);
        setStatusBarColor(false);
        tabList = new ArrayList<>();
        imgList = new ArrayList<>();
        fragments = new ArrayList<>();
        titleList = new ArrayList<>();

        tabList.add("攻略");
        tabList.add("游记");
        tabList.add("大家怎么说");

        titleList.add("攻略");
        titleList.add("游记");
        titleList.add("大家怎么说");

        detailTabAdapter = new EndFragmentTabAdapter(this.getSupportFragmentManager(), fragments, titleList);

        EndDetailTab1Fragment fragment1 = new EndDetailTab1Fragment();
        EndDetailTab2Fragment fragment2 = new EndDetailTab2Fragment();
        EndDetailTab3Fragment fragment3 = new EndDetailTab3Fragment();

        fragments.add(fragment1);
        fragments.add(fragment2);
        fragments.add(fragment3);

        viewPager.setAdapter(detailTabAdapter);

        viewPager.setOffscreenPageLimit(2);
        viewPager.setCurrentItem(0);

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
                tabLayout2.setTranslationY(tabLayout.getTop());
                tabLayout2.setVisibility(View.VISIBLE);

                viewPager.getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
            }
        };

        viewPager.getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);

        customScrollView.setCallbacks(new CustomScrollView.Callbacks() {
            @Override
            public void onScrollChanged(int x, int y, int oldx, int oldy) {
                int translation = Math.max(y, tabLayout.getTop());
                tabLayout2.setTranslationY(translation);

                if (y > imageView.getHeight()) {
                } else {
                }
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

        tabLayout.setupWithViewPager(viewPager);
        tabLayout2.setupWithViewPager(viewPager);

        detailTabAdapter.setData(fragments, titleList);

        GlideUtils.showToImageView(this, imageView, "http://img17.3lian.com/d/file/201702/16/17cd567662bafc8d63d73d41444585d2.jpg");
        GlideUtils.showToImageView(this, imageView2, "http://imgs.h2o-china.com/news/2017/10/1508203823432909.png");


    }

    @OnClick({R.id.end_detail_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.end_detail_back:
                finish();
                break;
        }
    }
}
