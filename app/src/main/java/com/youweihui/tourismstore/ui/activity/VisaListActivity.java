package com.youweihui.tourismstore.ui.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

import com.youweihui.tourismstore.R;
import com.youweihui.tourismstore.adapter.TailListAdapter;
import com.youweihui.tourismstore.adapter.VisaListAdapter;
import com.youweihui.tourismstore.base.BaseActivity;
import com.youweihui.tourismstore.bean.HomeTailOrderEntity;
import com.youweihui.tourismstore.bean.VisaBottomEntity;
import com.youweihui.tourismstore.bean.VisaEntity;
import com.youweihui.tourismstore.bean.VisaListEntity;
import com.youweihui.tourismstore.utils.GlideUtils;
import com.youweihui.tourismstore.view.CustomScrollView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class VisaListActivity extends BaseActivity {

    @BindView(R.id.visa_list_img)
    ImageView imageView;

    @BindView(R.id.visa_list_recycle)
    RecyclerView recyclerView;

    @BindView(R.id.visa_list_tb_layout)
    TabLayout tabLayout;

    @BindView(R.id.visa_list_tb_layout2)
    TabLayout tabLayout2;

    @BindView(R.id.visa_list_scroll)
    CustomScrollView customScrollView;

    private List<VisaListEntity> entityList;

    private List<String> tabList;

    private VisaListAdapter adapter;

    private ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visa_list);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

        tabList = new ArrayList<>();
        entityList = new ArrayList<>();

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setHasFixedSize(true);
        recyclerView.setFocusable(false);

        adapter = new VisaListAdapter(new ArrayList<VisaListEntity>());
        recyclerView.setAdapter(adapter);

        setData();
    }

    @OnClick({R.id.visa_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.visa_back:
                finish();
                break;
        }
    }


    private void setData() {
        tabList.add("默认排序");
        tabList.add("销量最高");
        tabList.add("价格最优");

        for (int i = 0; i < tabList.size(); i++) {
            tabLayout.addTab(tabLayout.newTab().setText(tabList.get(i)));
            tabLayout2.addTab(tabLayout2.newTab().setText(tabList.get(i)));
        }


        GlideUtils.showToImageView(this, imageView, "http://img17.3lian.com/d/file/201702/16/17cd567662bafc8d63d73d41444585d2.jpg");
        for (int i = 0; i < 6; i++) {
            VisaListEntity visaListEntity = new VisaListEntity();
            switch (i) {
                case 0:
                    visaListEntity.setImg("http://imgsrc.baidu.com/forum/pic/item/124e510fd9f9d72ac213bca3d92a2834349bbb1f.jpg");
                    visaListEntity.setTitle("澳大利亚旅游签证");
                    break;
                case 1:
                    visaListEntity.setImg("http://you.lumeilvyou3.cn/wenda/01/images/b2367f36779e3fa7fe3a2c131b3d7a84.jpg");
                    visaListEntity.setTitle("澳大利亚旅游签证");
                    break;
                case 2:
                    visaListEntity.setImg("http://you.lumeilvyou3.cn/wenda/01/images/a6ad9024c244ffbd20427c37a1e691a8.jpg");
                    visaListEntity.setTitle("澳大利亚旅游签证");
                    break;
                case 3:
                    visaListEntity.setImg("http://you.lumeilvyou3.cn/wenda/01/images/55b79ae2e0296aef854d03289e4f0664.jpg");
                    visaListEntity.setTitle("澳大利亚旅游签证");
                    break;
                case 4:
                    visaListEntity.setImg("http://you.lumeilvyou3.cn/wenda/01/images/55b79ae2e0296aef854d03289e4f0664.jpg");
                    visaListEntity.setTitle("澳大利亚旅游签证");
                    break;
                case 5:
                    visaListEntity.setImg("http://you.lumeilvyou3.cn/wenda/01/images/b2367f36779e3fa7fe3a2c131b3d7a84.jpg");
                    visaListEntity.setTitle("澳大利亚旅游签证");
                    break;
            }
            entityList.add(visaListEntity);
        }
        adapter.setData(entityList);

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

                recyclerView.getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
            }
        };

        recyclerView.getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);

        customScrollView.setCallbacks(new CustomScrollView.Callbacks() {
            @Override
            public void onScrollChanged(int x, int y, int oldx, int oldy) {
                int translation = Math.max(y, tabLayout.getTop());
                tabLayout2.setTranslationY(translation);

                if (y > imageView.getHeight() + 100) {
                    getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                } else {
                    getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
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
    }
}
