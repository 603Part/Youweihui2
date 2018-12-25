package com.youweihui.tourismstore.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.view.View;

import com.youweihui.tourismstore.R;
import com.youweihui.tourismstore.base.BaseActivity;
import com.youweihui.tourismstore.view.CalendarView;

import butterknife.BindView;
import butterknife.OnClick;


public class OrderWriteActivity extends BaseActivity {

    @BindView(R.id.order_write_calendar)
    CalendarView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_write);

    }

//    @OnClick({R.id.visa_detail_back, R.id.visa_detail_start})
//    public void onViewClicked(View view) {
//        switch (view.getId()) {
//            case R.id.visa_detail_back:
//                finish();
//                break;
//            case R.id.visa_detail_start:
//
//                break;
//        }
//    }
}
