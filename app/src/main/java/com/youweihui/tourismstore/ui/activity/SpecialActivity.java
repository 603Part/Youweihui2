package com.youweihui.tourismstore.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.youweihui.tourismstore.R;
import com.youweihui.tourismstore.adapter.SpecialAdapter;
import com.youweihui.tourismstore.base.BaseActivity;
import com.youweihui.tourismstore.bean.ForumEntity;
import com.youweihui.tourismstore.utils.GlideUtils;
import com.youweihui.tourismstore.view.BannerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class SpecialActivity extends BaseActivity implements BannerView.OnPageViewClicked,SpecialAdapter.OnItemClickListener {

    @BindView(R.id.special_banner)
    BannerView bannerView;

    @BindView(R.id.special_recycle)
    RecyclerView recyclerView;

    @BindView(R.id.special_back)
    ImageButton back;

    private ArrayList<String> imgList;

    private SpecialAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_special);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

        imgList = new ArrayList<>();

        adapter = new SpecialAdapter(new ArrayList<ForumEntity>());
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setHasFixedSize(true);
        recyclerView.setFocusable(false);
        recyclerView.setAdapter(adapter);
        bannerView.setOnPageViewClicked(this);
        adapter.setOnItemClickListener(this);
        setData();
    }

    private void setData() {
        imgList.add("http://img17.3lian.com/d/file/201702/16/17cd567662bafc8d63d73d41444585d2.jpg");
        imgList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1544426740841&di=1aa67a38806d3cb35d77a1e9bce4d707&imgtype=0&src=http%3A%2F%2Fimg.pptjia.com%2Fimage%2F20180117%2Ff4b76385a3ccdbac48893cc6418806d5.jpg");
        imgList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1544426787463&di=423811f8e34002b14a8039e9ec53bf75&imgtype=0&src=http%3A%2F%2Fimg17.3lian.com%2Fd%2Ffile%2F201701%2F09%2F7d3cdc209be727aef32d28795dd58b3b.jpg");

        List<View> list = new ArrayList<>();

        for (int i = 0; i < imgList.size(); i++) {
            ImageView imageView = new ImageView(this);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            GlideUtils.showToImageView(this, imageView, imgList.get(i).toString());
            list.add(imageView);
        }

        bannerView.setPageViewPics(list);

        List<ForumEntity> list2 = new ArrayList<>();


        for (int i = 0; i < 8; i++) {
            ForumEntity forumEntity = new ForumEntity();
            switch (i){
                case 0:
                    forumEntity.setImg("http://imgsrc.baidu.com/forum/pic/item/124e510fd9f9d72ac213bca3d92a2834349bbb1f.jpg");
                    break;
                case 1:
                    forumEntity.setImg("http://you.lumeilvyou3.cn/wenda/01/images/b2367f36779e3fa7fe3a2c131b3d7a84.jpg");
                    break;
                case 2:
                    forumEntity.setImg("http://you.lumeilvyou3.cn/wenda/01/images/a6ad9024c244ffbd20427c37a1e691a8.jpg");
                    break;
                case 3:
                    forumEntity.setImg("http://you.lumeilvyou3.cn/wenda/01/images/55b79ae2e0296aef854d03289e4f0664.jpg");
                    break;
                case 4:
                    forumEntity.setImg("http://you.lumeilvyou3.cn/wenda/01/images/55b79ae2e0296aef854d03289e4f0664.jpg");
                    break;
                case 5:
                    forumEntity.setImg("http://you.lumeilvyou3.cn/wenda/01/images/b2367f36779e3fa7fe3a2c131b3d7a84.jpg");
                    break;
                case 6:
                    forumEntity.setImg("http://imgsrc.baidu.com/forum/pic/item/9020720e0cf3d7ca905048cbff1fbe096a63a9ef.jpg");
                    break;
                case 7:
                    forumEntity.setImg("http://you.lumeilvyou3.cn/wenda/01/images/b2367f36779e3fa7fe3a2c131b3d7a84.jpg");
                    break;
            }
            list2.add(forumEntity);
        }
        adapter.setData(list2);
    }

    @OnClick({R.id.special_back, R.id.special_nav_text1, R.id.special_nav_text2, R.id.special_nav_text3, R.id.special_nav_text4})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.special_back:
                finish();
                break;
            case R.id.special_nav_text1:
                Intent intent = new Intent(this, TailListActivity.class);
                startActivity(intent);
                break;
            case R.id.special_nav_text2:
                Intent intent1 = new Intent(this, TailListActivity.class);
                startActivity(intent1);
                break;
            case R.id.special_nav_text3:
                Intent intent2 = new Intent(this, TailListActivity.class);
                startActivity(intent2);
                break;
            case R.id.special_nav_text4:
                Intent intent3 = new Intent(this, TailListActivity.class);
                startActivity(intent3);
                break;
        }
    }

    @Override
    public void onPageViewClicked(int position) {
        Intent intent = new Intent(this, TailOrderDetailActivity.class);
        startActivity(intent);
    }

    @Override
    public void onItemClick(View v, int position, int type) {
        Intent intent = new Intent(this, TailListActivity.class);
        startActivity(intent);
    }
}
