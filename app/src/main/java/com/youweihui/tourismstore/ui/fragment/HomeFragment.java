package com.youweihui.tourismstore.ui.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.youweihui.tourismstore.R;
import com.youweihui.tourismstore.adapter.HomeTabListAdapter;
import com.youweihui.tourismstore.adapter.HomeTailOrderAdapter;
import com.youweihui.tourismstore.adapter.HomeTopAdapter;
import com.youweihui.tourismstore.adapter.VerticalScrollAdapter;
import com.youweihui.tourismstore.base.BaseFragment;
import com.youweihui.tourismstore.bean.HomeEntity;
import com.youweihui.tourismstore.ui.activity.ProductActivity;
import com.youweihui.tourismstore.ui.activity.SpecialActivity;
import com.youweihui.tourismstore.ui.activity.TailListActivity;
import com.youweihui.tourismstore.ui.activity.VisaActivity;
import com.youweihui.tourismstore.utils.GlideUtils;
import com.youweihui.tourismstore.utils.SpaceItemDecoration;
import com.youweihui.tourismstore.view.BannerView;
import com.youweihui.tourismstore.view.CustomScrollView;
import com.youweihui.tourismstore.view.VerticalScrollView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by ${范泽宁} on 2018/12/10.
 */

public class HomeFragment extends BaseFragment implements HomeTopAdapter.OnItemClickListener, BannerView.OnPageViewClicked, TabLayout.OnTabSelectedListener {

    @BindView(R.id.home_banner)
    BannerView bannerView;

    @BindView(R.id.home_vertical_scroll)
    VerticalScrollView scrollLayout;

    @BindView(R.id.home_recycle)
    RecyclerView recyclerView;

    @BindView(R.id.home_recommend)
    TextView recommend;

    @BindView(R.id.home_recycle2)
    RecyclerView recyclerView2;

    @BindView(R.id.home_recycle3)
    RecyclerView recyclerView3;

//    @BindView(R.id.home_tb_layout)
//    TabLayout tabLayout;

    @BindView(R.id.home_tb_layout2)
    TabLayout tabLayout2;

    @BindView(R.id.home_scroll)
    CustomScrollView customScrollView;

    @BindView(R.id.home_abroad_linear)
    LinearLayout linearLayout;

    @BindView(R.id.home_relative)
    RelativeLayout relativeLayout;

    @BindView(R.id.home_relative2)
    RelativeLayout relativeLayout2;

    @BindView(R.id.home_more2)
    ImageView more2;

    private ArrayList<String> imgList;

    private ArrayList<HomeEntity> autoList;

    private List<HomeEntity.HomeTopEntity> topEntityList;

    private ArrayList<HomeEntity.HomeTailOrderEntity> tailOrderList;

    private List<HomeEntity> tabList;

    private VerticalScrollAdapter scrollAdapter;

    private HomeTailOrderAdapter tailOrderAdapter;

    private HomeTabListAdapter tabRecycleAdapter;

    private HomeTopAdapter homeTopAdapter;

    private ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;

    private int scrollX;

    private int scrollY;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        init();
        setData();
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
            scrollLayout.stopFlipping();
        } else {
            customScrollView.scrollTo(scrollX, scrollY);
            bannerView.start();
            scrollLayout.startFlipping();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        bannerView.stop();
        scrollLayout.stopFlipping();
    }

    @Override
    public void onStop() {
        super.onStop();
        bannerView.stop();
        scrollLayout.stopFlipping();
    }

    @OnClick({R.id.home_recommend})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.home_recommend:
                Intent intent = new Intent(context, TailListActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onItemClick(View v, int position) {
        if (position == topEntityList.size() - 2) {
            Intent intent = new Intent(context, TailListActivity.class);
            startActivity(intent);
        } else if (position == topEntityList.size() - 1) {
            Intent intent1 = new Intent(context, VisaActivity.class);
            startActivity(intent1);
        } else {
            Intent intent = new Intent(context, ProductActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void onPageViewClicked(int position) {
        Intent intent = new Intent(context, SpecialActivity.class);
        startActivity(intent);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    private void init() {
        imgList = new ArrayList<>();
        autoList = new ArrayList<>();
        tailOrderList = new ArrayList<>();
        tabList = new ArrayList<>();
        topEntityList = new ArrayList<>();

        LinearLayoutManager manager = new LinearLayoutManager(context);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(manager);

        recyclerView2.setLayoutManager(new LinearLayoutManager(context));
        recyclerView3.setLayoutManager(new GridLayoutManager(context, 4));
        recyclerView3.addItemDecoration(new SpaceItemDecoration(1, 1));
        scrollAdapter = new VerticalScrollAdapter(new ArrayList<HomeEntity>());
        tailOrderAdapter = new HomeTailOrderAdapter(new ArrayList<HomeEntity.HomeTailOrderEntity>());
        tabRecycleAdapter = new HomeTabListAdapter(new ArrayList<HomeEntity.HomeListEntity>());
        homeTopAdapter = new HomeTopAdapter(new ArrayList<HomeEntity.HomeTopEntity>());

        scrollLayout.setAdapter(scrollAdapter);
        recyclerView.setAdapter(tailOrderAdapter);
        recyclerView2.setAdapter(tabRecycleAdapter);
        recyclerView3.setAdapter(homeTopAdapter);
        homeTopAdapter.setOnItemClickListener(this);
        tabLayout2.addOnTabSelectedListener(this);
        bannerView.setOnPageViewClicked(this);

        onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() {
            @SuppressLint("NewApi")
            @Override
            public void onGlobalLayout() {
                relativeLayout2.setTranslationY(relativeLayout.getTop());
                relativeLayout2.setVisibility(View.VISIBLE);
                recyclerView2.getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
            }
        };

        recyclerView2.getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);

        customScrollView.setCallbacks(new CustomScrollView.Callbacks() {
            @Override
            public void onScrollChanged(int x, int y, int oldx, int oldy) {
                int translation = Math.max(y, relativeLayout.getTop());
                relativeLayout2.setTranslationY(translation);
                if (y > linearLayout.getHeight() - 20) {

                } else {

                }
            }
        });
    }

    private void setData() {
        List<HomeEntity.HomeListEntity> entityList = new ArrayList<>();

        List<View> viewList = new ArrayList<>();

        imgList.add("http://img17.3lian.com/d/file/201702/16/17cd567662bafc8d63d73d41444585d2.jpg");
        imgList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1544426740841&di=1aa67a38806d3cb35d77a1e9bce4d707&imgtype=0&src=http%3A%2F%2Fimg.pptjia.com%2Fimage%2F20180117%2Ff4b76385a3ccdbac48893cc6418806d5.jpg");
        imgList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1544426787463&di=423811f8e34002b14a8039e9ec53bf75&imgtype=0&src=http%3A%2F%2Fimg17.3lian.com%2Fd%2Ffile%2F201701%2F09%2F7d3cdc209be727aef32d28795dd58b3b.jpg");

        for (String path : imgList) {
            ImageView imageView = new ImageView(getActivity());
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            GlideUtils.showToImageView(context, imageView, path);
            viewList.add(imageView);
        }

        for (int i = 0; i < 8; i++) {
            HomeEntity homeEntity = new HomeEntity();
            HomeEntity.HomeTopEntity topEntity = new HomeEntity.HomeTopEntity();
            HomeEntity.HomeListEntity homeListEntity = new HomeEntity.HomeListEntity();
            HomeEntity.HomeTailOrderEntity tailOrderEntity = new HomeEntity.HomeTailOrderEntity();
            switch (i) {
                case 0:
                    topEntity.setTitle("亚洲");
                    homeListEntity.setTitle("除夕不回家，想旅游过年 ");
                    homeListEntity.setImg("http://imgsrc.baidu.com/forum/pic/item/124e510fd9f9d72ac213bca3d92a2834349bbb1f.jpg");
                    tailOrderEntity.setImg("http://imgsrc.baidu.com/forum/pic/item/124e510fd9f9d72ac213bca3d92a2834349bbb1f.jpg");
                    tailOrderEntity.setTitle("除夕不回家，想旅游过年 ");
                    homeEntity.setTabTitle("推荐");
                    homeEntity.setVerticalScroll("阿布扎比魅力四射的多元文化、动人心魄的奢华体验、惊险刺激的探险经历和阿拉伯人的热情好客等待您来发现。");
                    break;
                case 1:
                    topEntity.setTitle("欧洲");
                    homeEntity.setTabTitle("当季热门");
                    homeListEntity.setTitle("小象优品：冬季旅游安全攻略，你Get了吗？ 小象优品：冬季旅游安全攻略");
                    homeListEntity.setImg("http://you.lumeilvyou3.cn/wenda/01/images/b2367f36779e3fa7fe3a2c131b3d7a84.jpg");
                    tailOrderEntity.setTitle("小象优品：冬季旅游安全攻略，你Get了吗？ 小象优品：冬季旅游安全攻略");
                    tailOrderEntity.setImg("http://you.lumeilvyou3.cn/wenda/01/images/b2367f36779e3fa7fe3a2c131b3d7a84.jpg");
                    homeEntity.setVerticalScroll("许魏洲中欧旅游年宣传片曝光，带粉丝“畅游”意大利与克罗地亚");
                    break;
                case 2:
                    topEntity.setTitle("非洲");
                    homeListEntity.setTitle("听说张家界蹦极可以玩了，有没有想找刺激的");
                    homeListEntity.setImg("http://you.lumeilvyou3.cn/wenda/01/images/a6ad9024c244ffbd20427c37a1e691a8.jpg");
                    homeEntity.setTabTitle("海岛");
                    tailOrderEntity.setTitle("听说张家界蹦极可以玩了，有没有想找刺激的");
                    tailOrderEntity.setImg("http://you.lumeilvyou3.cn/wenda/01/images/a6ad9024c244ffbd20427c37a1e691a8.jpg");
                    homeEntity.setVerticalScroll("至尊漠北探寻北的神奇与梦幻哈尔滨漠河北极村第一湾北红村圣诞村九曲十八湾全");
                    break;
                case 3:
                    topEntity.setTitle("美洲");
                    homeEntity.setTabTitle("名胜古迹");
                    homeListEntity.setTitle("都想来云南来吧 希望能给个终生难忘的旅程");
                    homeListEntity.setImg("http://you.lumeilvyou3.cn/wenda/01/images/55b79ae2e0296aef854d03289e4f0664.jpg");
                    tailOrderEntity.setTitle("都想来云南来吧 希望能给个终生难忘的旅程");
                    tailOrderEntity.setImg("http://you.lumeilvyou3.cn/wenda/01/images/55b79ae2e0296aef854d03289e4f0664.jpg");
                    homeEntity.setVerticalScroll("世界地理杂志推荐全球20大必游综合性景区、国家5A【黄果树风景名胜区】 （核心景区—黄果树大瀑布、天星桥水上石林、陡坡塘瀑布）");
                    break;
                case 4:
                    topEntity.setTitle("澳洲");
                    homeEntity.setTabTitle("旅游景点");
                    tailOrderEntity.setTitle("春节漠河寻北之旅");
                    tailOrderEntity.setImg("http://you.lumeilvyou3.cn/wenda/01/images/55b79ae2e0296aef854d03289e4f0664.jpg");
                    homeListEntity.setTitle("春节漠河寻北之旅");
                    homeListEntity.setImg("http://you.lumeilvyou3.cn/wenda/01/images/55b79ae2e0296aef854d03289e4f0664.jpg");
                    homeEntity.setVerticalScroll("惠游贵州全景双卧7日游");
                    break;
                case 5:
                    topEntity.setTitle("国内");
                    homeEntity.setTabTitle("上海");
                    tailOrderEntity.setTitle("【旅行】有没有一起旅行的小伙伴");
                    homeListEntity.setTitle("【旅行】有没有一起旅行的小伙伴");
                    tailOrderEntity.setImg("http://you.lumeilvyou3.cn/wenda/01/images/b2367f36779e3fa7fe3a2c131b3d7a84.jpg");
                    homeListEntity.setImg("http://you.lumeilvyou3.cn/wenda/01/images/b2367f36779e3fa7fe3a2c131b3d7a84.jpg");
                    homeEntity.setVerticalScroll("全球保存最完整、规模最大的原生态苗族部落【西江千户苗寨】");
                    break;
                case 6:
                    topEntity.setTitle("邮轮");
                    homeEntity.setTabTitle("广州");
                    tailOrderEntity.setTitle("打算最近去东北玩，行程攻略已经做好，本人热情幽默，不矫情，爱");
                    homeListEntity.setTitle("打算最近去东北玩，行程攻略已经做好，本人热情幽默，不矫情，爱");
                    tailOrderEntity.setImg("http://imgsrc.baidu.com/forum/pic/item/9020720e0cf3d7ca905048cbff1fbe096a63a9ef.jpg");
                    homeListEntity.setImg("http://imgsrc.baidu.com/forum/pic/item/9020720e0cf3d7ca905048cbff1fbe096a63a9ef.jpg");
                    homeEntity.setVerticalScroll("直达丽江，逛束河古镇感受纳西族篝火晚会");
                    break;
                case 7:
                    topEntity.setTitle("签证");
                    homeEntity.setTabTitle("北京");
                    tailOrderEntity.setTitle("福州出发寻找旅友！地点你定！");
                    homeListEntity.setTitle("福州出发寻找旅友！地点你定！");
                    homeListEntity.setImg("http://you.lumeilvyou3.cn/wenda/01/images/b2367f36779e3fa7fe3a2c131b3d7a84.jpg");
                    homeEntity.setVerticalScroll("一路向西去大理，看蝴蝶泉、游轮深度游玩洱海，登南诏风情岛俯览洱海风光");
                    break;
            }
            topEntityList.add(topEntity);
            autoList.add(homeEntity);
            tailOrderList.add(tailOrderEntity);
            tabList.add(homeEntity);
            entityList.add(homeListEntity);
        }
        bannerView.setPageViewPics(viewList);
        homeTopAdapter.setData(topEntityList);
        scrollAdapter.setList(autoList);
        tailOrderAdapter.setData(tailOrderList);
        tabRecycleAdapter.setData(entityList);

        for (int i = 0; i < tabList.size(); i++) {
//            tabLayout.addTab(tabLayout.newTab().setText(tabList.get(i).getTabTitle().toString()));
            tabLayout2.addTab(tabLayout2.newTab().setText(tabList.get(i).getTabTitle().toString()));
        }

//        tabLayout.setTabMode(tabList.size() <= 4 ? TabLayout.MODE_FIXED : TabLayout.MODE_SCROLLABLE);
        tabLayout2.setTabMode(tabList.size() <= 4 ? TabLayout.MODE_FIXED : TabLayout.MODE_SCROLLABLE);
//        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.orange));
        tabLayout2.setSelectedTabIndicatorColor(getResources().getColor(R.color.orange));
        //        tabLayout.setSelectedTabIndicatorHeight((int) getResources().getDimension(R.dimen.indicatorHeight));
    }
}
