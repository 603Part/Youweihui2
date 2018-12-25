package com.youweihui.tourismstore.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.youweihui.tourismstore.R;
import com.youweihui.tourismstore.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;


public class ReleaseActivity extends BaseActivity {

    @BindView(R.id.release_title)
    TextView title;

    @BindView(R.id.release_linear)
    LinearLayout linearLayout;

    @BindView(R.id.release_linear2)
    LinearLayout linearLayout2;

    @BindView(R.id.release_relative)
    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_release);

        title.setText(getIntent().getStringExtra("title"));

        if (title.getText().toString().equals("发布提问")) {
            linearLayout.setVisibility(View.GONE);
            relativeLayout.setVisibility(View.GONE);
            linearLayout2.setVisibility(View.GONE);
        } else if (title.getText().toString().equals("发布游记")) {

        } else {
            linearLayout.setVisibility(View.GONE);
            linearLayout2.setVisibility(View.GONE);
        }
    }

    @OnClick({R.id.release_back, R.id.release_destination})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.release_back:
                InputMethodManager inputmanger = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputmanger.hideSoftInputFromWindow(view.getWindowToken(), 0);
                finish();
                break;
            case R.id.release_destination:
                Intent intent = new Intent(this, ClassifyActivity.class);
                startActivity(intent);
                break;
        }
    }
}
