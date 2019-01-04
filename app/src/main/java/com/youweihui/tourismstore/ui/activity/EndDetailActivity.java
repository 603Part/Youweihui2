package com.youweihui.tourismstore.ui.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

import com.youweihui.tourismstore.R;
import com.youweihui.tourismstore.adapter.EndFragment1Adapter;
import com.youweihui.tourismstore.adapter.EndFragmentTabAdapter;
import com.youweihui.tourismstore.base.BaseActivity;
import com.youweihui.tourismstore.bean.EndFragment1Entity;
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

public class EndDetailActivity extends BaseActivity {

    @BindView(R.id.end_detail_top_img)
    ImageView imageView;

    @BindView(R.id.end_detail_back)
    ImageView back;

    @BindView(R.id.end_detail_img)
    ImageView imageView2;

    @BindView(R.id.end_detail_img2)
    ImageView imageView3;

    @BindView(R.id.end_detail_scroll)
    CustomScrollView customScrollView;

    @BindView(R.id.end_detail_recycle)
    RecyclerView recyclerView;

    private EndFragment1Adapter fragment1Adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_detail);
        setStatusBarColor(false);

        fragment1Adapter = new EndFragment1Adapter(new ArrayList<EndFragment1Entity>());

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(fragment1Adapter);

        GlideUtils.showToImageView(this, imageView, "http://img17.3lian.com/d/file/201702/16/17cd567662bafc8d63d73d41444585d2.jpg");
        GlideUtils.showToImageView(this, imageView2, "http://imgs.h2o-china.com/news/2017/10/1508203823432909.png");
        GlideUtils.showToImageView(this, imageView3, "http://img17.3lian.com/d/file/201702/16/17cd567662bafc8d63d73d41444585d2.jpg ");

        List<EndFragment1Entity> list = new ArrayList<>();

        EndFragment1Entity entity1 = new EndFragment1Entity();
        EndFragment1Entity entity2 = new EndFragment1Entity();
        EndFragment1Entity entity3 = new EndFragment1Entity();
        EndFragment1Entity entity4 = new EndFragment1Entity();
        EndFragment1Entity entity5 = new EndFragment1Entity();
        EndFragment1Entity entity6 = new EndFragment1Entity();
        EndFragment1Entity entity7 = new EndFragment1Entity();
        EndFragment1Entity entity8 = new EndFragment1Entity();

        list.add(entity1);
        list.add(entity2);
        list.add(entity3);
        list.add(entity4);
        list.add(entity5);
        list.add(entity6);
        list.add(entity7);
        list.add(entity8);
        fragment1Adapter.setData(list);
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
