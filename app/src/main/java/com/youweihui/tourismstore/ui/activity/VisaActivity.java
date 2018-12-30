package com.youweihui.tourismstore.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.youweihui.tourismstore.R;
import com.youweihui.tourismstore.adapter.VisaBottomAdapter;
import com.youweihui.tourismstore.adapter.VisaTopAdapter;
import com.youweihui.tourismstore.base.BaseActivity;
import com.youweihui.tourismstore.bean.VisaBottomEntity;
import com.youweihui.tourismstore.bean.VisaEntity;
import com.youweihui.tourismstore.bean.VisaListEntity;
import com.youweihui.tourismstore.utils.GlideUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

public class VisaActivity extends BaseActivity implements VisaTopAdapter.OnItemClickListener {

    @BindView(R.id.visa_recycle)
    RecyclerView recyclerView;

    @BindView(R.id.visa_recycle2)
    RecyclerView recyclerView2;

    @BindView(R.id.visa_back)
    ImageButton back;

    @BindView(R.id.visa_more)
    TextView more;

    @BindView(R.id.visa_top_img)
    ImageView topImg;

    private ArrayList<VisaEntity> list;

    private ArrayList<VisaBottomEntity> list2;

    private VisaTopAdapter adapter;

    private VisaBottomAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visa);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

        list = new ArrayList<>();
        list2 = new ArrayList<>();

        adapter = new VisaTopAdapter(new ArrayList<VisaEntity>());
        listAdapter = new VisaBottomAdapter(new ArrayList<VisaBottomEntity>());
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, 0, true));
        recyclerView.setHasFixedSize(true);
        recyclerView.setFocusable(false);
        recyclerView.setAdapter(adapter);

        recyclerView2.setHasFixedSize(true);
        recyclerView2.setFocusable(false);
        recyclerView2.setAdapter(listAdapter);

        adapter.setOnItemClickListener(this);

        setData();
    }

    private void setData() {
        GlideUtils.showToImageView(this, topImg, "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1545132843472&di=e9ab06ec96b9e1352f3f5a069f47b4aa&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimage%2Fc0%253Dshijue1%252C0%252C0%252C294%252C40%2Fsign%3Db7b8893a68d0f703f2bf9d9f60933b48%2F908fa0ec08fa513d1b3cb3f3376d55fbb2fbd90d.jpg");

        for (int i = 0; i < 6; i++) {
            VisaEntity visaEntity = new VisaEntity();
            VisaBottomEntity visaBottomEntity = new VisaBottomEntity();
            switch (i) {
                case 0:
                    visaEntity.setImg("http://imgsrc.baidu.com/forum/pic/item/124e510fd9f9d72ac213bca3d92a2834349bbb1f.jpg");
                    visaBottomEntity.setImg("http://imgsrc.baidu.com/forum/pic/item/124e510fd9f9d72ac213bca3d92a2834349bbb1f.jpg");
                    visaBottomEntity.setTitle("澳大利亚旅游签证");
                    break;
                case 1:
                    visaEntity.setImg("http://you.lumeilvyou3.cn/wenda/01/images/b2367f36779e3fa7fe3a2c131b3d7a84.jpg");
                    visaBottomEntity.setImg("http://you.lumeilvyou3.cn/wenda/01/images/b2367f36779e3fa7fe3a2c131b3d7a84.jpg");
                    visaBottomEntity.setTitle("澳大利亚旅游签证");
                    break;
                case 2:
                    visaEntity.setImg("http://you.lumeilvyou3.cn/wenda/01/images/a6ad9024c244ffbd20427c37a1e691a8.jpg");
                    visaBottomEntity.setImg("http://you.lumeilvyou3.cn/wenda/01/images/a6ad9024c244ffbd20427c37a1e691a8.jpg");
                    visaBottomEntity.setTitle("澳大利亚旅游签证");
                    break;
                case 3:
                    visaEntity.setImg("http://you.lumeilvyou3.cn/wenda/01/images/55b79ae2e0296aef854d03289e4f0664.jpg");
                    visaBottomEntity.setImg("http://you.lumeilvyou3.cn/wenda/01/images/55b79ae2e0296aef854d03289e4f0664.jpg");
                    visaBottomEntity.setTitle("澳大利亚旅游签证");
                    break;
                case 4:
                    visaEntity.setImg("http://you.lumeilvyou3.cn/wenda/01/images/55b79ae2e0296aef854d03289e4f0664.jpg");
                    visaBottomEntity.setImg("http://you.lumeilvyou3.cn/wenda/01/images/55b79ae2e0296aef854d03289e4f0664.jpg");
                    visaBottomEntity.setTitle("澳大利亚旅游签证");
                    break;
                case 5:
                    visaEntity.setImg("http://you.lumeilvyou3.cn/wenda/01/images/b2367f36779e3fa7fe3a2c131b3d7a84.jpg");
                    visaBottomEntity.setImg("http://you.lumeilvyou3.cn/wenda/01/images/b2367f36779e3fa7fe3a2c131b3d7a84.jpg");
                    visaBottomEntity.setTitle("澳大利亚旅游签证");
                    break;
            }
            list.add(visaEntity);
            list2.add(visaBottomEntity);
        }
        adapter.setData(list);
        listAdapter.setData(list2);
    }

    @OnClick({R.id.visa_back, R.id.visa_more})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.visa_back:
                finish();
                break;

            case R.id.visa_more:
                Intent intent = new Intent(this, VisaListActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onItemClick(View v, int position, int type) {
        if (type == 0) {
            Intent intent = new Intent(this, VisaDetailActivity.class);
            startActivity(intent);
        }
    }
}
