package com.youweihui.tourismstore.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.youweihui.tourismstore.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 如何设置标题？
 * 1.* extends BaseActivity
 * 2.layout <include layout=“title_bar"/>
 * 3.AndroidManifest.xml <activity title="title name"></activity>
 */

public class BaseActivity extends AppCompatActivity {

    @Nullable
    @BindView(R.id.title)
    TextView title;

    @Nullable
    @BindView(R.id.title_back)
    ImageView back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
        initTitle();
        initBack();
    }

    private void initTitle() {
        if (title != null) {
            title.setText(getTitle());
        }
    }

    private void initBack() {
        if (back != null) {
            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
