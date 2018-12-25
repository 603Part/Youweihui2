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

public class GoodsDetailActivity extends BaseActivity {

    @BindView(R.id.goods_detail_img)
    ImageView imageView;

    @BindView(R.id.goods_detail_start)
    TextView start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_detail);
        GlideUtils.showToImageView(this,imageView,"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1544938270649&di=7a48f0c72ca306e2e551e1113d5672a8&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2Ff9dcd100baa1cd116794e219b212c8fcc3ce2dec.jpg");
    }

    @OnClick({R.id.goods_detail_start})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.goods_detail_start:
                Intent intent = new Intent(this,ConfirmOrderActivity.class);
                startActivity(intent);
                break;
        }
    }
}
