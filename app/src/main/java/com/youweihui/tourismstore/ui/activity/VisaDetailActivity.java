package com.youweihui.tourismstore.ui.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.youweihui.tourismstore.R;
import com.youweihui.tourismstore.adapter.VisaDetailAdapter;
import com.youweihui.tourismstore.adapter.VisaDetailDetailAdapter;
import com.youweihui.tourismstore.base.BaseActivity;
import com.youweihui.tourismstore.bean.HomeEntity;
import com.youweihui.tourismstore.bean.HomeTailOrderEntity;
import com.youweihui.tourismstore.utils.GlideUtils;
import com.youweihui.tourismstore.utils.GridSpacingItemDecoration;
import com.youweihui.tourismstore.view.CustomScrollView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


public class VisaDetailActivity extends BaseActivity {

    @BindView(R.id.visa_detail_recycler)
    RecyclerView recyclerView;

    @BindView(R.id.visa_detail_original)
    TextView original;

    @BindView(R.id.visa_detail_start)
    TextView start;

    @BindView(R.id.visa_detail_tb_layout2)
    TabLayout tabLayout2;

    @BindView(R.id.visa_detail_tb_layout)
    TabLayout tabLayout;

    @BindView(R.id.visa_detail_recycler2)
    RecyclerView recyclerView2;

    @BindView(R.id.visa_detail_relative)
    RelativeLayout relativeLayout;

    @BindView(R.id.visa_detail_img)
    ImageView imageView;

    @BindView(R.id.visa_detail_scroll)
    CustomScrollView customScrollView;

    private VisaDetailDetailAdapter detailAdapter;

    private List<HomeEntity> tabList;

    private ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;

    private VisaDetailAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visa_detail);

        original.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);

        tabList = new ArrayList<>();

        detailAdapter = new VisaDetailDetailAdapter(new ArrayList<HomeTailOrderEntity>());
        adapter = new VisaDetailAdapter(new ArrayList<HomeTailOrderEntity>());
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(1, 1, true));
        recyclerView.setAdapter(detailAdapter);
        recyclerView2.setAdapter(adapter);

        setData();


    }

    private void setData() {
        List<HomeTailOrderEntity> list2 = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            HomeTailOrderEntity homeTailOrderEntity = new HomeTailOrderEntity();
            switch (i) {
                case 0:
                    homeTailOrderEntity.setTitle("办理时间");
                    homeTailOrderEntity.setTitle2("6-7个工作日");
                    homeTailOrderEntity.setImg("http://you.lumeilvyou3.cn/wenda/01/images/b2367f36779e3fa7fe3a2c131b3d7a84.jpg");
                    break;
                case 1:
                    homeTailOrderEntity.setTitle("最多停留");
                    homeTailOrderEntity.setTitle2("不超过三个月");
                    homeTailOrderEntity.setImg("http://you.lumeilvyou3.cn/wenda/01/images/b2367f36779e3fa7fe3a2c131b3d7a84.jpg");
                    break;
                case 2:
                    homeTailOrderEntity.setTitle("面试");
                    homeTailOrderEntity.setTitle2("不需要");
                    homeTailOrderEntity.setImg("http://you.lumeilvyou3.cn/wenda/01/images/a6ad9024c244ffbd20427c37a1e691a8.jpg");
                    break;
                case 3:
                    homeTailOrderEntity.setTitle("有效期");
                    homeTailOrderEntity.setTitle2("三年多次");
                    homeTailOrderEntity.setImg("http://you.lumeilvyou3.cn/wenda/01/images/55b79ae2e0296aef854d03289e4f0664.jpg");
                    break;
                case 4:
                    homeTailOrderEntity.setTitle("受理范围");
                    homeTailOrderEntity.setTitle2("全国");
                    homeTailOrderEntity.setImg("http://you.lumeilvyou3.cn/wenda/01/images/55b79ae2e0296aef854d03289e4f0664.jpg");
                    break;
                case 5:
                    homeTailOrderEntity.setTitle("邀请函");
                    homeTailOrderEntity.setTitle2("英文邀请函");
                    homeTailOrderEntity.setImg("http://you.lumeilvyou3.cn/wenda/01/images/eecdc2b9be66398a43d57430138cef4a.jpg");
                    break;
            }
            list2.add(homeTailOrderEntity);
        }
        detailAdapter.setData(list2);
        adapter.setData(list2);

        HomeEntity homeEntity1 = new HomeEntity();
        HomeEntity homeEntity2 = new HomeEntity();
        HomeEntity homeEntity3 = new HomeEntity();

        homeEntity1.setTabTitle("签证预定");
        homeEntity2.setTabTitle("所需材料");
        homeEntity3.setTabTitle("服务详情");

        tabList.add(homeEntity1);
        tabList.add(homeEntity2);
        tabList.add(homeEntity3);

        for (int i = 0; i < tabList.size(); i++) {
            tabLayout2.addTab(tabLayout2.newTab().setText(tabList.get(i).getTabTitle().toString()));
        }

        tabLayout2.setTabMode(tabList.size() <= 4 ? TabLayout.MODE_FIXED : TabLayout.MODE_SCROLLABLE);
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

        GlideUtils.showToImageView(this, imageView, "https://youimg1.c-ctrip.com/target/100k0w000000kfkneF5E5_R_640_10000_Q90.jpg");
    }

    @OnClick({R.id.visa_detail_back, R.id.visa_detail_start})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.visa_detail_back:
                finish();
                break;
            case R.id.visa_detail_start:
                Intent intent = new Intent(VisaDetailActivity.this, OrderWriteActivity.class);
                intent.putExtra("1","1");
                startActivity(intent);
                break;
        }
    }
}
