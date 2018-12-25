package com.youweihui.tourismstore.ui.fragment;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.youweihui.tourismstore.R;
import com.youweihui.tourismstore.adapter.ForumTabRecycleAdapter;
import com.youweihui.tourismstore.base.BaseFragment;
import com.youweihui.tourismstore.bean.ForumEntity;
import com.youweihui.tourismstore.bean.ForumTabEntity2;
import com.youweihui.tourismstore.bean.HomeTailOrderEntity;
import com.youweihui.tourismstore.ui.activity.ArticleDetailActivity;
import com.youweihui.tourismstore.ui.activity.ReleaseActivity;
import com.youweihui.tourismstore.utils.DensityUtil;
import com.youweihui.tourismstore.utils.GlideUtils;
import com.youweihui.tourismstore.view.BannerView;
import com.youweihui.tourismstore.view.CustomScrollView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by ${范泽宁} on 2018/12/10.
 */

public class ForumFragment extends BaseFragment implements ForumTabRecycleAdapter.OnItemClickListener {

    @BindView(R.id.forum_banner)
    BannerView bannerView;

    @BindView(R.id.forum_tb_seat)
    TabLayout seatLayout;

    @BindView(R.id.forum_tb_real)
    TabLayout realLayout;

    @BindView(R.id.fragment_forum_relative)
    RelativeLayout relativeLayout3;

    @BindView(R.id.forum_scroll)
    CustomScrollView customScrollView;

    @BindView(R.id.forum_recycle)
    RecyclerView recyclerView;

    @BindView(R.id.forum_relative)
    RelativeLayout relativeLayout;

    @BindView(R.id.forum_relative2)
    RelativeLayout relativeLayout2;

    @BindView(R.id.forum_release)
    ImageView release;

    private ArrayList<String> imgList;

    private ArrayList<String> titleList;

    private ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;

    private ForumTabRecycleAdapter recycleAdapter;

    private int scrollX;

    private int scrollY;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_forum;
    }

    @Override
    protected void initView() {
        titleList = new ArrayList<>();
        imgList = new ArrayList<>();
        recycleAdapter = new ForumTabRecycleAdapter(new ArrayList<ForumEntity>());
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(recycleAdapter);

        recycleAdapter.setOnItemClickListener(this);
        addData();

        setBannerData();

        for (int i = 0; i < titleList.size(); i++) {
            seatLayout.addTab(seatLayout.newTab().setText(titleList.get(i).toString()));
            realLayout.addTab(realLayout.newTab().setText(titleList.get(i).toString()));
        }

        realLayout.setTabMode(titleList.size() <= 4 ? TabLayout.MODE_FIXED : TabLayout.MODE_SCROLLABLE);
        seatLayout.setTabMode(titleList.size() <= 4 ? TabLayout.MODE_FIXED : TabLayout.MODE_SCROLLABLE);
        realLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.orange));
        seatLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.orange));

        onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() {
            @SuppressLint("NewApi")
            @Override
            public void onGlobalLayout() {
                relativeLayout2.setTranslationY(relativeLayout.getTop());
                relativeLayout2.setVisibility(View.VISIBLE);
                recyclerView.getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
            }
        };

        recyclerView.getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);

        customScrollView.setCallbacks(new CustomScrollView.Callbacks() {
            @Override
            public void onScrollChanged(int x, int y, int oldx, int oldy) {
                int translation = Math.max(y, relativeLayout.getTop());
                relativeLayout2.setTranslationY(translation);
                if (y > relativeLayout.getHeight()) {
                } else {
                }
            }
        });

        realLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setBannerData() {
        List<View> list = new ArrayList<>();

        for (int i = 0; i < imgList.size(); i++) {
            ImageView imageView = new ImageView(getActivity());
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            GlideUtils.showToImageView(context, imageView, imgList.get(i).toString());
            list.add(imageView);
        }

        bannerView.setPageViewPics(list);

        bannerView.setOnPageViewClicked(new BannerView.OnPageViewClicked() {
            @Override
            public void onPageViewClicked(int position) {

            }
        });
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden) {
            if (scrollX == 0 && scrollY == 0) {
            } else {
            }
            scrollX = customScrollView.getScrollX();
            scrollY = customScrollView.getScrollY();
            bannerView.stop();
        } else {
            bannerView.start();
            customScrollView.scrollTo(scrollX, scrollY);


        }
    }

    private void addData() {
        HomeTailOrderEntity entity1 = new HomeTailOrderEntity();
        HomeTailOrderEntity entity2 = new HomeTailOrderEntity();
        HomeTailOrderEntity entity3 = new HomeTailOrderEntity();
        HomeTailOrderEntity entity4 = new HomeTailOrderEntity();
        HomeTailOrderEntity entity5 = new HomeTailOrderEntity();
        HomeTailOrderEntity entity6 = new HomeTailOrderEntity();
        HomeTailOrderEntity entity7 = new HomeTailOrderEntity();
        HomeTailOrderEntity entity8 = new HomeTailOrderEntity();

        entity1.setImg("http://you.lumeilvyou3.cn/wenda/01/images/b2367f36779e3fa7fe3a2c131b3d7a84.jpg");
        entity8.setImg("http://you.lumeilvyou3.cn/wenda/01/images/b2367f36779e3fa7fe3a2c131b3d7a84.jpg");
        entity2.setImg("http://you.lumeilvyou3.cn/wenda/01/images/a6ad9024c244ffbd20427c37a1e691a8.jpg");
        entity7.setImg("http://you.lumeilvyou3.cn/wenda/01/images/55b79ae2e0296aef854d03289e4f0664.jpg");
        entity3.setImg("http://you.lumeilvyou3.cn/wenda/01/images/55b79ae2e0296aef854d03289e4f0664.jpg");
        entity4.setImg("http://you.lumeilvyou3.cn/wenda/01/images/eecdc2b9be66398a43d57430138cef4a.jpg");
        entity6.setImg("http://you.lumeilvyou3.cn/wenda/01/images/eecdc2b9be66398a43d57430138cef4a.jpg");
        entity5.setImg("http://you.lumeilvyou3.cn/wenda/01/images/a6ad9024c244ffbd20427c37a1e691a8.jpg");

        titleList.add("热门推荐");
        titleList.add("旅游咨询");
        titleList.add("旅游指南");

        imgList.add("http://img17.3lian.com/d/file/201702/16/17cd567662bafc8d63d73d41444585d2.jpg");
        imgList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1544426740841&di=1aa67a38806d3cb35d77a1e9bce4d707&imgtype=0&src=http%3A%2F%2Fimg.pptjia.com%2Fimage%2F20180117%2Ff4b76385a3ccdbac48893cc6418806d5.jpg");
        imgList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1544426787463&di=423811f8e34002b14a8039e9ec53bf75&imgtype=0&src=http%3A%2F%2Fimg17.3lian.com%2Fd%2Ffile%2F201701%2F09%2F7d3cdc209be727aef32d28795dd58b3b.jpg");
        addData2();
    }

    private void addData2() {
        List<ForumEntity> list = new ArrayList<>();
        List<ForumTabEntity2> list2 = new ArrayList<>();

        ForumEntity entity1 = new ForumEntity();
        ForumEntity entity2 = new ForumEntity();
        ForumEntity entity3 = new ForumEntity();
        ForumEntity entity4 = new ForumEntity();
        ForumEntity entity5 = new ForumEntity();
        ForumEntity entity6 = new ForumEntity();
        ForumEntity entity7 = new ForumEntity();
        ForumEntity entity8 = new ForumEntity();

        ForumTabEntity2 entity21 = new ForumTabEntity2();
        ForumTabEntity2 entity22 = new ForumTabEntity2();
        ForumTabEntity2 entity23 = new ForumTabEntity2();
        ForumTabEntity2 entity24 = new ForumTabEntity2();
        ForumTabEntity2 entity25 = new ForumTabEntity2();
        ForumTabEntity2 entity26 = new ForumTabEntity2();
        ForumTabEntity2 entity27 = new ForumTabEntity2();
        ForumTabEntity2 entity28 = new ForumTabEntity2();

        entity1.setImg("http://you.lumeilvyou3.cn/wenda/01/images/b2367f36779e3fa7fe3a2c131b3d7a84.jpg");
        entity8.setImg("http://you.lumeilvyou3.cn/wenda/01/images/b2367f36779e3fa7fe3a2c131b3d7a84.jpg");
        entity2.setImg("http://you.lumeilvyou3.cn/wenda/01/images/a6ad9024c244ffbd20427c37a1e691a8.jpg");
        entity7.setImg("http://you.lumeilvyou3.cn/wenda/01/images/55b79ae2e0296aef854d03289e4f0664.jpg");
        entity3.setImg("http://you.lumeilvyou3.cn/wenda/01/images/55b79ae2e0296aef854d03289e4f0664.jpg");
        entity4.setImg("http://you.lumeilvyou3.cn/wenda/01/images/eecdc2b9be66398a43d57430138cef4a.jpg");
        entity6.setImg("http://you.lumeilvyou3.cn/wenda/01/images/eecdc2b9be66398a43d57430138cef4a.jpg");
        entity5.setImg("http://you.lumeilvyou3.cn/wenda/01/images/a6ad9024c244ffbd20427c37a1e691a8.jpg");

        entity21.setImg("http://you.lumeilvyou3.cn/wenda/01/images/b2367f36779e3fa7fe3a2c131b3d7a84.jpg");
        entity22.setImg("http://you.lumeilvyou3.cn/wenda/01/images/b2367f36779e3fa7fe3a2c131b3d7a84.jpg");
        entity23.setImg("http://you.lumeilvyou3.cn/wenda/01/images/a6ad9024c244ffbd20427c37a1e691a8.jpg");
        entity24.setImg("http://you.lumeilvyou3.cn/wenda/01/images/55b79ae2e0296aef854d03289e4f0664.jpg");
        entity25.setImg("http://you.lumeilvyou3.cn/wenda/01/images/55b79ae2e0296aef854d03289e4f0664.jpg");
        entity26.setImg("http://you.lumeilvyou3.cn/wenda/01/images/eecdc2b9be66398a43d57430138cef4a.jpg");
        entity27.setImg("http://you.lumeilvyou3.cn/wenda/01/images/eecdc2b9be66398a43d57430138cef4a.jpg");
        entity28.setImg("http://you.lumeilvyou3.cn/wenda/01/images/a6ad9024c244ffbd20427c37a1e691a8.jpg");

        list.add(entity1);
        list.add(entity2);
        list.add(entity3);
        list.add(entity4);
        list.add(entity5);
        list.add(entity6);
        list.add(entity7);
        list.add(entity8);

        list2.add(entity21);
        list2.add(entity22);
        list2.add(entity23);
        list2.add(entity24);
        list2.add(entity25);
        list2.add(entity26);
        list2.add(entity27);
        list2.add(entity28);

        recycleAdapter.setData(list);
    }

    @OnClick({R.id.forum_release})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.forum_release:
                showDialog();
                break;
        }
    }

    private void showDialog() {
        final Dialog bottomDialog = new Dialog(context, R.style.BottomDialog);
        View contentView = LayoutInflater.from(context).inflate(R.layout.dialog_content, null);
        bottomDialog.setContentView(contentView);
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) contentView.getLayoutParams();
        params.width = getResources().getDisplayMetrics().widthPixels - DensityUtil.dp2px(context, 16f);
        params.bottomMargin = DensityUtil.dp2px(context, 8f);
        contentView.setLayoutParams(params);
        bottomDialog.setCanceledOnTouchOutside(true);
        bottomDialog.getWindow().setGravity(Gravity.BOTTOM);
        bottomDialog.getWindow().setWindowAnimations(R.style.BottomDialog_Animation);
        bottomDialog.show();

        contentView.findViewById(R.id.dialog_question).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ReleaseActivity.class);
                intent.putExtra("title", "发布提问");
                startActivity(intent);
                bottomDialog.dismiss();
            }
        });

        contentView.findViewById(R.id.dialog_record).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ReleaseActivity.class);
                intent.putExtra("title", "发布游记");
                startActivity(intent);
                bottomDialog.dismiss();
            }
        });

        contentView.findViewById(R.id.dialog_photo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ReleaseActivity.class);
                intent.putExtra("title", "发布图片");
                startActivity(intent);
                bottomDialog.dismiss();
            }
        });
    }

    @Override
    public void onItemClick(View v, int position, int type) {
        Intent intent = new Intent(context, ArticleDetailActivity.class);
        startActivity(intent);
    }
}
