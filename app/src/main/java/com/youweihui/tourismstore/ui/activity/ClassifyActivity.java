package com.youweihui.tourismstore.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.youweihui.tourismstore.R;
import com.youweihui.tourismstore.adapter.ClassifyLeftAdapter;
import com.youweihui.tourismstore.adapter.ClassifyRightAdapter;
import com.youweihui.tourismstore.base.BaseActivity;
import com.youweihui.tourismstore.bean.ClassifyLeftEntity;
import com.youweihui.tourismstore.bean.ClassifyRightEntity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


public class ClassifyActivity extends BaseActivity implements ClassifyLeftAdapter.OnItemClickListener, ClassifyRightAdapter.OnItemClickListener {

    @BindView(R.id.classify_cancel)
    TextView cancel;

    @BindView(R.id.classify_left_recycle)
    RecyclerView leftRecycle;

    @BindView(R.id.classify_right_recycle)
    RecyclerView rightRecycle;

    private ClassifyLeftAdapter leftAdapter;

    private ClassifyRightAdapter rightAdapter;

    private List<ClassifyLeftEntity> leftList;

    private List<ClassifyRightEntity> rightList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classify);

        leftList = new ArrayList<>();

        rightList = new ArrayList<>();

        leftAdapter = new ClassifyLeftAdapter(leftList);

        rightAdapter = new ClassifyRightAdapter(rightList);

        leftRecycle.setLayoutManager(new LinearLayoutManager(this));
        rightRecycle.setLayoutManager(new LinearLayoutManager(this));

        leftRecycle.setAdapter(leftAdapter);
        rightRecycle.setAdapter(rightAdapter);

        leftAdapter.setOnItemClickListener(this);
        rightAdapter.setOnItemClickListener(this);

        for (int i = 0; i < 10; i++) {
            ClassifyLeftEntity leftEntity = new ClassifyLeftEntity();
            ClassifyRightEntity rightEntity = new ClassifyRightEntity();
            switch (i) {
                case 0:
                    leftEntity.setTitle("中国");
                    rightEntity.setTitle("中国");
                    break;
                case 1:
                    leftEntity.setTitle("日本");
                    rightEntity.setTitle("日本");
                    break;
                case 2:
                    leftEntity.setTitle("美国");
                    rightEntity.setTitle("美国");
                    break;
                case 3:
                    leftEntity.setTitle("俄罗斯");
                    rightEntity.setTitle("俄罗斯");
                    break;
                case 4:
                    leftEntity.setTitle("澳大利亚");
                    rightEntity.setTitle("澳大利亚");
                    break;
                case 5:
                    leftEntity.setTitle("德国");
                    rightEntity.setTitle("德国");
                    break;
                case 6:
                    leftEntity.setTitle("沙特阿拉伯");
                    rightEntity.setTitle("沙特阿拉伯");
                    break;
                case 7:
                    leftEntity.setTitle("印度");
                    rightEntity.setTitle("印度");
                    break;
                case 8:
                    leftEntity.setTitle("加拿大");
                    rightEntity.setTitle("加拿大");
                    break;
                case 9:
                    leftEntity.setTitle("阿根廷");
                    rightEntity.setTitle("阿根廷");
                    break;
            }
            leftList.add(leftEntity);
            rightList.add(rightEntity);
        }
        leftAdapter.setData(leftList);
        rightAdapter.setData(rightList);
    }

    @OnClick({R.id.classify_cancel})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.classify_cancel:
                InputMethodManager inputmanger = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputmanger.hideSoftInputFromWindow(view.getWindowToken(), 0);
                finish();
                break;
        }
    }

    @Override
    public void onItemClick(View v, int position, int type) {
        switch (type) {
            case 0:
                leftAdapter.setSelectPos(position);
                leftAdapter.notifyDataSetChanged();
                break;
            case 1:
                rightAdapter.getData().get(position).setCheck(true);
                for (int i = 0; i < rightAdapter.getData().size(); i++) {
                    if (i != position) {
                        rightAdapter.getData().get(i).setCheck(false);
                    }
                }
                rightAdapter.notifyDataSetChanged();

                Intent intent = new Intent(ClassifyActivity.this, EndDetailsActivity.class);
                startActivity(intent);
                break;
        }
    }
}
