package com.youweihui.tourismstore.ui.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.youweihui.tourismstore.R;
import com.youweihui.tourismstore.adapter.EndFragment1Adapter;
import com.youweihui.tourismstore.adapter.EndFragment1BottomAdapter;
import com.youweihui.tourismstore.base.BaseFragment;
import com.youweihui.tourismstore.bean.EndFragment1Entity;
import com.youweihui.tourismstore.ui.activity.EndDetailActivity;
import com.youweihui.tourismstore.utils.GlideUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by ${范泽宁} on 2018/12/11.
 */

@SuppressLint("ValidFragment")
public class EndDetailTab1Fragment extends BaseFragment {

    @BindView(R.id.end_detail_tab1_recycle)
    RecyclerView recyclerView;

    @BindView(R.id.end_detail_tab1_recycle2)
    RecyclerView recyclerView2;

    @BindView(R.id.end_detail_tab1_img)
    ImageView topImage;

    private EndFragment1Adapter fragment1Adapter;

    private EndFragment1BottomAdapter fragment1BottomAdapter;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_end_detail_tab1;
    }

    @Override
    protected void initView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView2.setLayoutManager(new LinearLayoutManager(context));
        fragment1BottomAdapter = new EndFragment1BottomAdapter(new ArrayList<EndFragment1Entity>());
        fragment1Adapter = new EndFragment1Adapter(new ArrayList<EndFragment1Entity>());
        recyclerView.setAdapter(fragment1Adapter);
        recyclerView2.setAdapter(fragment1BottomAdapter);

        GlideUtils.showToImageView(context, topImage, "http://you.lumeilvyou3.cn/wenda/01/images/b2367f36779e3fa7fe3a2c131b3d7a84.jpg");

        List<EndFragment1Entity> list = new ArrayList<>();
        List<EndFragment1Entity> list2 = new ArrayList<>();

        EndFragment1Entity entity1 = new EndFragment1Entity();
        EndFragment1Entity entity2 = new EndFragment1Entity();
        EndFragment1Entity entity3 = new EndFragment1Entity();
        EndFragment1Entity entity4 = new EndFragment1Entity();
        EndFragment1Entity entity5 = new EndFragment1Entity();
        EndFragment1Entity entity6 = new EndFragment1Entity();
        EndFragment1Entity entity7 = new EndFragment1Entity();
        EndFragment1Entity entity8 = new EndFragment1Entity();

        list2.add(entity1);
        list2.add(entity2);
        list2.add(entity3);

        list.add(entity1);
        list.add(entity2);
        list.add(entity3);
        list.add(entity4);
        list.add(entity5);
        list.add(entity6);
        list.add(entity7);
        list.add(entity8);
        fragment1Adapter.setData(list);
        fragment1BottomAdapter.setData(list2);
    }

    @OnClick({R.id.end_detail_more})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.end_detail_more:
                Intent intent = new Intent(getContext(), EndDetailActivity.class);
                startActivity(intent);
                break;
        }
    }
}
