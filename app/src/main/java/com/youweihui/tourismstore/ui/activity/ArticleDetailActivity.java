package com.youweihui.tourismstore.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.youweihui.tourismstore.R;
import com.youweihui.tourismstore.adapter.ArticleAdapter;
import com.youweihui.tourismstore.base.BaseActivity;
import com.youweihui.tourismstore.bean.ForumEntity;
import com.youweihui.tourismstore.utils.GlideUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


public class ArticleDetailActivity extends BaseActivity {

    //    @BindView(R.id.release_title)
//    TextView title;
//
    @BindView(R.id.article_img)
    ImageView imageView;

    private ArticleAdapter articleAdapter;

    @BindView(R.id.article_recycle)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);

        GlideUtils.showToImageView(this,imageView,"https://dimg04.c-ctrip.com/images/300b0s000000hrt4kD200.jpg");
        articleAdapter = new ArticleAdapter(new ArrayList<ForumEntity>());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(articleAdapter);

        List<ForumEntity> list = new ArrayList<>();

        ForumEntity entity1 = new ForumEntity();
        ForumEntity entity2 = new ForumEntity();
        ForumEntity entity3 = new ForumEntity();
        ForumEntity entity4 = new ForumEntity();
        ForumEntity entity5 = new ForumEntity();
        ForumEntity entity6 = new ForumEntity();
        ForumEntity entity7 = new ForumEntity();
        ForumEntity entity8 = new ForumEntity();


        list.add(entity1);
        list.add(entity2);
        list.add(entity3);
        list.add(entity4);
        list.add(entity5);
        list.add(entity6);
        list.add(entity7);
        list.add(entity8);

        articleAdapter.setData(list);
    }

    @OnClick({R.id.article_img})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.article_img:

                break;
        }
    }
}
