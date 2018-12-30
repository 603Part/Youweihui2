package com.youweihui.tourismstore.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.youweihui.tourismstore.R;
import com.youweihui.tourismstore.base.BaseActivity;
import com.youweihui.tourismstore.bean.CalenderBean;
import com.youweihui.tourismstore.view.CalendarView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


public class OrderWriteActivity extends BaseActivity {

    @BindView(R.id.order_write_calendar)
    CalendarView calendarView;

    private List<CalenderBean> calenderBeans;
    String date = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_write);
        calenderBeans = new ArrayList<>();
        JSONObject jsonObject = null;
        try {
            jsonObject = new org.json.JSONObject(String.valueOf(R.string.json));
            String str = jsonObject.getString("return");
            calenderBeans = JSON.parseArray(str, CalenderBean.class);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        calendarView.setGroups(calenderBeans);
        calendarView.showCalendar();
        if (TextUtils.isEmpty(date) && calenderBeans.size() > 0) {
            date = calenderBeans.get(0).getDate();//获取第一天的
            int years = Integer.parseInt(date.substring(0,
                    date.indexOf("-")));
            int month = Integer.parseInt(date.substring(
                    date.indexOf("-") + 1, date.lastIndexOf("-")));
//            txtv_calendar_month.setText(years + "年" + month + "月");
            calendarView.showCalendar(years, month);//设置初始日子
        }

        calendarView.setOnCalendarClickListener(new CalendarView.OnCalendarClickListener() {

            public void onCalendarClick(int row, int col, String dateFormat) {

                int month = Integer.parseInt(dateFormat.substring(
                        dateFormat.indexOf("-") + 1,
                        dateFormat.lastIndexOf("-")));

                if (calendarView.getCalendarMonth() - month == 1//跨年跳转
                        || calendarView.getCalendarMonth() - month == -11) {
                    calendarView.lastMonth();

                } else if (month - calendarView.getCalendarMonth() == 1 //跨年跳转
                        || month - calendarView.getCalendarMonth() == -11) {
                    calendarView.nextMonth();

                } else {
                    //                    date = dateFormat;//最后返回给全局 date
                    for (int i = 0; i < calenderBeans.size(); i++) {
                        calenderBeans.get(i).getDate();
                        int stock = Integer.parseInt(calenderBeans.get(i).getStock());
                        Log.i("SHF", "dateFormat--->" + dateFormat + "date--->" + calenderBeans.get(i).getDate() + "peopleNumCur--->" + "stock--->" + stock);
                        if (dateFormat.equals(calenderBeans.get(i).getDate())
                                && (stock) > 0) {

                            //设置背景色
                            calendarView.removeAllBgColor();
                            calendarView.setCalendarDayBgColor(dateFormat,
                                    Color.parseColor("#45BDEF"));

                        } else if (date.equals(calenderBeans.get(i).getDate())
                                && (stock) > 0) {
//                            ToastCommon.toastShortShow(PriceCanlendarActivity.this, null, "此团期剩余空位不足，请选择其他团期或减少参团人数");
                        }
                    }
                }
            }
        });
        calendarView.setOnCalendarDateChangedListener(new CalendarView.OnCalendarDateChangedListener() {
            @Override
            public void onCalendarDateChanged(int year, int month) {
//                txtv_calendar_month.setText(year + "年" + month + "月");
            }
        });
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
