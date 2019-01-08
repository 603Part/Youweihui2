package com.youweihui.tourismstore.ui.fragment;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.youweihui.tourismstore.R;
import com.youweihui.tourismstore.adapter.ForumAdapter;
import com.youweihui.tourismstore.base.BaseFragment;
import com.youweihui.tourismstore.bean.ForumEntity;
import com.youweihui.tourismstore.bean.ForumTabBean;
import com.youweihui.tourismstore.bean.ForumTabEntity2;
import com.youweihui.tourismstore.bean.HomeTailOrderEntity;
import com.youweihui.tourismstore.net.client.RetrofitClient;
import com.youweihui.tourismstore.net.request.EmptyRequest;
import com.youweihui.tourismstore.net.request.ReleaseListByClassIfyIdRequest;
import com.youweihui.tourismstore.ui.activity.ArticleDetailActivity;
import com.youweihui.tourismstore.ui.activity.ReleaseActivity;
import com.youweihui.tourismstore.utils.DensityUtil;
import com.youweihui.tourismstore.utils.GlideUtils;
import com.youweihui.tourismstore.view.BannerView;
import com.youweihui.tourismstore.view.CustomScrollView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ${范泽宁} on 2018/12/10.
 */

public class ForumFragment extends BaseFragment implements ForumAdapter.OnItemClickListener
        , ViewTreeObserver.OnGlobalLayoutListener, TabLayout.OnTabSelectedListener, CustomScrollView.Callbacks, BannerView.OnPageViewClicked {

    @BindView(R.id.forum_banner)
    BannerView bannerView;

    @BindView(R.id.forum_tb_seat)
    TabLayout seatLayout;

    @BindView(R.id.forum_tb_real)
    TabLayout realLayout;

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

    private ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;

    private ForumAdapter recycleAdapter;

    private int scrollX;

    private int scrollY;

    private Disposable disposable;

    private RetrofitClient retrofitClient = new RetrofitClient();

    private int mPage = 1;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_forum;
    }

    @Override
    protected void setAttribute() {
        super.setAttribute();
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(recycleAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        realLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.orange));
        seatLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.orange));

        recyclerView.getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    @Override
    protected void setOnClick() {
        super.setOnClick();
        customScrollView.setCallbacks(this);
        bannerView.setOnPageViewClicked(this);
        recycleAdapter.setOnItemClickListener(this);
        realLayout.addOnTabSelectedListener(this);
    }

    @Override
    protected void initView() {
        onGlobalLayoutListener = this;
        imgList = new ArrayList<>();
        recycleAdapter = new ForumAdapter(new ArrayList<>());
        setBannerData();
    }

    private void setBannerData() {
        imgList.add("http://img17.3lian.com/d/file/201702/16/17cd567662bafc8d63d73d41444585d2.jpg");
        imgList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1544426740841&di=1aa67a38806d3cb35d77a1e9bce4d707&imgtype=0&src=http%3A%2F%2Fimg.pptjia.com%2Fimage%2F20180117%2Ff4b76385a3ccdbac48893cc6418806d5.jpg");
        imgList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1544426787463&di=423811f8e34002b14a8039e9ec53bf75&imgtype=0&src=http%3A%2F%2Fimg17.3lian.com%2Fd%2Ffile%2F201701%2F09%2F7d3cdc209be727aef32d28795dd58b3b.jpg");

        List<View> list = new ArrayList<>();

        for (int i = 0; i < imgList.size(); i++) {
            ImageView imageView = new ImageView(getActivity());
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            GlideUtils.showToImageView(context, imageView, imgList.get(i).toString());
            list.add(imageView);
        }

        bannerView.setPageViewPics(list);
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

    @OnClick({R.id.forum_release})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.forum_release:
                showDialog();
                break;
        }
    }

    @Override
    public void onItemClick(View v, int position, int type) {
        Intent intent = new Intent(context, ArticleDetailActivity.class);
        startActivity(intent);
    }

    @Override
    public void getData() {
        super.getData();
        EmptyRequest emptyRequest = new EmptyRequest();
        disposable = retrofitClient.getClassIfyList(emptyRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(bean -> {
                    setData(bean);
                }, throwable -> {
                });
    }

    private void setData(ForumTabBean bean) {
        for (int i = 0; i < bean.getData().size(); i++) {
            seatLayout.addTab(seatLayout.newTab().setText(bean.getData().get(i).getClassifyName()));
            realLayout.addTab(realLayout.newTab().setText(bean.getData().get(i).getClassifyName()));
        }

        getListData();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (!disposable.isDisposed()) {
            disposable.dispose();
        }
    }

    @SuppressLint("NewApi")
    @Override
    public void onGlobalLayout() {
        relativeLayout2.setTranslationY(relativeLayout.getTop());
        relativeLayout2.setVisibility(View.VISIBLE);
        recyclerView.getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
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

    @Override
    public void onScrollChanged(int x, int y, int oldx, int oldy) {
        int translation = Math.max(y, relativeLayout.getTop());
        relativeLayout2.setTranslationY(translation);
        if (y > relativeLayout.getHeight()) {

        } else {

        }
    }

    @Override
    public void onPageViewClicked(int position) {

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

        contentView.findViewById(R.id.dialog_question).setOnClickListener(view -> {
            Intent intent = new Intent(context, ReleaseActivity.class);
            intent.putExtra("title", "发布提问");
            startActivity(intent);
            bottomDialog.dismiss();
        });

        contentView.findViewById(R.id.dialog_record).setOnClickListener(view -> {
            Intent intent = new Intent(context, ReleaseActivity.class);
            intent.putExtra("title", "发布游记");
            startActivity(intent);
            bottomDialog.dismiss();
        });

        contentView.findViewById(R.id.dialog_photo).setOnClickListener(view -> {
            Intent intent = new Intent(context, ReleaseActivity.class);
            intent.putExtra("title", "发布图片");
            startActivity(intent);
            bottomDialog.dismiss();
        });
    }

    private void getListData() {
        ReleaseListByClassIfyIdRequest classIfyIdRequest = new ReleaseListByClassIfyIdRequest();
//        classIfyIdRequest.setClassifyId(bean.getData().get(0).getId());
//        classIfyIdRequest.setLevel(bean.getData().get(0).getLevel());

        classIfyIdRequest.setClassifyId(3);
        classIfyIdRequest.setLevel(1);
        classIfyIdRequest.setPage(mPage);
        classIfyIdRequest.setLimit(10);
        disposable = retrofitClient.getReleaseListByClassIfyId(classIfyIdRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(classIfyIdBean -> {
                    if (mPage <= classIfyIdBean.getPage().getTotalPage()) {
                        mPage++;
                        recycleAdapter.setData(classIfyIdBean.getPage().getList());
                    } else {

                    }
                }, throwable -> {

                });
    }
}
