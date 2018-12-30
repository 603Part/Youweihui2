package com.youweihui.tourismstore.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.youweihui.tourismstore.R;
import com.youweihui.tourismstore.base.BaseActivity;
import com.youweihui.tourismstore.utils.GlideUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class ConfirmOrderActivity extends BaseActivity {

    @BindView(R.id.goods_detail_start)
    TextView start;

    @BindView(R.id.confirm_order_img)
    ImageView orderImg;

    @BindView(R.id.confirm_order_relative)
    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_order);
        GlideUtils.showToImageView(this, orderImg, "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1545972085020&di=96862b06e544fdb45b3b620e54745582&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2F9345d688d43f879463f38231d81b0ef41bd53aa5.jpg");
    }

    @OnClick({R.id.goods_detail_start, R.id.goods_detail_back, R.id.confirm_order_relative})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.goods_detail_start:

                break;
            case R.id.goods_detail_back:
                finish();
                break;
            case R.id.confirm_order_relative:
                Intent intent2 = new Intent(this, MyAddressActivity.class);
                startActivity(intent2);
                break;
        }
    }
}
