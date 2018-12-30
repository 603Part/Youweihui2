package com.youweihui.tourismstore.ui.activity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;

import com.youweihui.tourismstore.R;
import com.youweihui.tourismstore.adapter.TailListAdapter;
import com.youweihui.tourismstore.adapter.TailListDialogAdapter;
import com.youweihui.tourismstore.base.BaseActivity;
import com.youweihui.tourismstore.bean.HomeTailOrderEntity;
import com.youweihui.tourismstore.utils.DensityUtil;
import com.youweihui.tourismstore.utils.GlideUtils;
import com.youweihui.tourismstore.utils.TabLayoutUtils;
import com.youweihui.tourismstore.view.CustomScrollView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class TailListActivity extends BaseActivity {

    @BindView(R.id.tail_list_top_img)
    ImageView imageView;

    @BindView(R.id.tail_list_back)
    ImageView back;

    @BindView(R.id.tail_list_city)
    TextView city;

    @BindView(R.id.tail_list_destination)
    TextView destination;

    @BindView(R.id.tail_list_nature)
    TextView nature;

    @BindView(R.id.tail_list_time)
    TextView time;

    @BindView(R.id.tail_list_recycle)
    RecyclerView recyclerView;

    @BindView(R.id.tail_list_tb_layout)
    TabLayout tabLayout;

    @BindView(R.id.tail_list_tb_layout2)
    TabLayout tabLayout2;

    @BindView(R.id.tail_list_scroll)
    CustomScrollView customScrollView;

    private ArrayList<String> imgList;

    private List<String> tabList;

    private ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tail_list);
        setStatusBarColor(false);

        tabList = new ArrayList<>();
        imgList = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setHasFixedSize(true);
        recyclerView.setFocusable(false);

        TailListAdapter adapter = new TailListAdapter(new ArrayList<HomeTailOrderEntity>());
        recyclerView.setAdapter(adapter);

        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                TabLayoutUtils.setIndicator(tabLayout, 50, 50);
            }
        });

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

        adapter.setData(tailOrderList);

        tabList.add("默认排序");
        tabList.add("销量最高");
        tabList.add("价格最优");

        GlideUtils.showToImageView(this, imageView, "http://img17.3lian.com/d/file/201702/16/17cd567662bafc8d63d73d41444585d2.jpg");

        setTailOrder();
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
    }

    @OnClick({R.id.tail_list_back, R.id.tail_list_city, R.id.tail_list_destination, R.id.tail_list_nature, R.id.tail_list_time})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tail_list_back:
                finish();
                break;

            case R.id.tail_list_city:
                showDialog();
                break;

            case R.id.tail_list_destination:
                showDialog();
                break;

            case R.id.tail_list_nature:
                showDialog();
                break;

            case R.id.tail_list_time:
                showDialog();
                break;
        }
    }

    private void showDialog() {
        final Dialog bottomDialog = new Dialog(this, R.style.BottomDialog);
        View contentView = LayoutInflater.from(this).inflate(R.layout.dialog_list, null);
        bottomDialog.setContentView(contentView);
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) contentView.getLayoutParams();
        params.width = getResources().getDisplayMetrics().widthPixels - DensityUtil.dp2px(this, 16f);
        params.bottomMargin = DensityUtil.dp2px(this, 8f);
        params.topMargin = DensityUtil.dp2px(this, 8f);
        contentView.setLayoutParams(params);
        bottomDialog.getWindow().setGravity(Gravity.BOTTOM);
        bottomDialog.setCanceledOnTouchOutside(true);
        bottomDialog.getWindow().setWindowAnimations(R.style.BottomDialog_Animation);

        bottomDialog.show();

        RecyclerView recyclerView = contentView.findViewById(R.id.dialog_recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final TailListDialogAdapter dialogAdapter = new TailListDialogAdapter(new ArrayList<String>());
        recyclerView.setAdapter(dialogAdapter);

        List<String> list = new ArrayList<>();
        list.add("石家庄");
        list.add("北京");
        list.add("天津");
        list.add("沈阳");
        list.add("内蒙古");
        list.add("江西");
        list.add("香港");
        list.add("南京");

        list.add("石家庄");
        list.add("北京");
        list.add("天津");
        list.add("沈阳");
        list.add("内蒙古");
        list.add("江西");
        list.add("香港");
        list.add("南京");

        list.add("石家庄");
        list.add("北京");
        list.add("天津");
        list.add("沈阳");
        list.add("内蒙古");
        list.add("江西");
        list.add("香港");
        list.add("南京");
        dialogAdapter.setData(list);

        dialogAdapter.setOnItemClickListener(new TailListDialogAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position, int type) {
                city.setText(dialogAdapter.getData().get(position).toString());
                bottomDialog.dismiss();
            }
        });
    }
}
