package com.youweihui.tourismstore.ui.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.youweihui.tourismstore.R;
import com.youweihui.tourismstore.adapter.GoodsDetailAdapter;
import com.youweihui.tourismstore.adapter.ShopTabRecycleAdapter;
import com.youweihui.tourismstore.base.BaseActivity;
import com.youweihui.tourismstore.bean.ShopTabEntity;
import com.youweihui.tourismstore.utils.GlideUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class GoodsDetailActivity extends BaseActivity implements GoodsDetailAdapter.OnItemClickListener, NestedScrollView.OnScrollChangeListener {

    @BindView(R.id.goods_detail_img)
    ImageView imageView;

    @BindView(R.id.goods_detail_start)
    TextView start;

    @BindView(R.id.goods_detail_recycle)
    RecyclerView recyclerView;

    @BindView(R.id.goods_detail_scroll)
    NestedScrollView scrollView;

    @BindView(R.id.goods_detail_bottom_linear)
    LinearLayout linearLayout;

    private GoodsDetailAdapter recycleAdapter;

    private boolean isShow = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_detail);
        GlideUtils.showToImageView(this, imageView, "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1544938270649&di=7a48f0c72ca306e2e551e1113d5672a8&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2Ff9dcd100baa1cd116794e219b212c8fcc3ce2dec.jpg");

        recycleAdapter = new GoodsDetailAdapter(new ArrayList<ShopTabEntity>());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recycleAdapter);

        recycleAdapter.setOnItemClickListener(this);

        scrollView.setOnScrollChangeListener(this);

        addData();
    }

    @OnClick({R.id.goods_detail_start, R.id.goods_detail_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.goods_detail_start:
                Intent intent = new Intent(this, ConfirmOrderActivity.class);
                startActivity(intent);
                break;
            case R.id.goods_detail_back:
                finish();
                break;
        }
    }

    @Override
    public void onItemClick(View v, int position) {

    }

    private void addData() {
        List<ShopTabEntity> list = new ArrayList<>();

        ShopTabEntity entity1 = new ShopTabEntity();
        ShopTabEntity entity2 = new ShopTabEntity();
        ShopTabEntity entity3 = new ShopTabEntity();
        ShopTabEntity entity4 = new ShopTabEntity();
        ShopTabEntity entity5 = new ShopTabEntity();
        ShopTabEntity entity6 = new ShopTabEntity();
        ShopTabEntity entity7 = new ShopTabEntity();
        ShopTabEntity entity8 = new ShopTabEntity();


        entity1.setImg("http://you.lumeilvyou3.cn/wenda/01/images/b2367f36779e3fa7fe3a2c131b3d7a84.jpg");
        entity8.setImg("http://you.lumeilvyou3.cn/wenda/01/images/b2367f36779e3fa7fe3a2c131b3d7a84.jpg");
        entity2.setImg("http://you.lumeilvyou3.cn/wenda/01/images/a6ad9024c244ffbd20427c37a1e691a8.jpg");
        entity7.setImg("http://you.lumeilvyou3.cn/wenda/01/images/55b79ae2e0296aef854d03289e4f0664.jpg");
        entity3.setImg("http://you.lumeilvyou3.cn/wenda/01/images/55b79ae2e0296aef854d03289e4f0664.jpg");
        entity4.setImg("http://you.lumeilvyou3.cn/wenda/01/images/eecdc2b9be66398a43d57430138cef4a.jpg");
        entity6.setImg("http://you.lumeilvyou3.cn/wenda/01/images/eecdc2b9be66398a43d57430138cef4a.jpg");
        entity5.setImg("http://you.lumeilvyou3.cn/wenda/01/images/a6ad9024c244ffbd20427c37a1e691a8.jpg");

        list.add(entity1);
        list.add(entity2);
        list.add(entity3);
        list.add(entity4);
        list.add(entity5);
        list.add(entity6);
        list.add(entity7);
        list.add(entity8);

        recycleAdapter.setData(list);
    }

    @Override
    public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
        if (scrollY - oldScrollY > 0 && isShow) {
            isShow = false;
            linearLayout.animate().translationY(linearLayout.getHeight());
        } else if (scrollY - oldScrollY < 0 && !isShow) {
            isShow = true;
            linearLayout.animate().translationY(0);
        }
    }
}
