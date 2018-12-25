package com.youweihui.tourismstore.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.youweihui.tourismstore.R;
import com.youweihui.tourismstore.base.BaseActivity;
import com.youweihui.tourismstore.utils.GlideUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class ConfirmOrderActivity extends BaseActivity {

    @BindView(R.id.goods_detail_start)
    TextView start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_order);
    }

    @OnClick({R.id.goods_detail_start})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.goods_detail_start:
                Intent intent = new Intent(this,TailListActivity.class);
                startActivity(intent);
                break;
        }
    }
}
