package com.youweihui.tourismstore.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;

import com.youweihui.tourismstore.R;
import com.youweihui.tourismstore.adapter.MyAddressAdapter;
import com.youweihui.tourismstore.base.BaseActivity;
import com.youweihui.tourismstore.bean.ShopTabEntity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MyAddressActivity extends BaseActivity {

    @BindView(R.id.my_address_recycle)
    RecyclerView recyclerView;

    private MyAddressAdapter recycleAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_address);

        recycleAdapter = new MyAddressAdapter(new ArrayList<ShopTabEntity>());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recycleAdapter);

        addData();
    }

    @OnClick({R.id.my_address_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.my_address_back:
                finish();
                break;
        }
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
}
