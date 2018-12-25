package com.youweihui.tourismstore.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.youweihui.tourismstore.R;
import com.youweihui.tourismstore.adapter.BannerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class BannerView extends FrameLayout implements OnPageChangeListener {

    private Context context;

    private ViewPager viewPager;

    private List<View> imgList = null;

    private int curItemPic = 0;

    private LinearLayout lineary;

    private List<ImageView> pointImg;

    private Timer timer = null;

    private TimerTask task;

    private int tempCurrentSelect = -1;

    private boolean isPause = false;

    private OnPageViewClicked onPageViewClicked;

    public int getSize() {
        if (imgList == null)
            return 0;
        return imgList.size();
    }

    public void clearData() {
        imgList.clear();
        pointImg.clear();
    }


    public void stop() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }

        if (task != null) {
            task.cancel();
            task = null;
        }
        curItemPic = 0;
    }

    public void start() {
        if (timer == null) {
            timer = new Timer();
            task = new TimerTask() {
                @Override
                public void run() {
                    if (imgList.size() == 0) {
                        return;
                    } else {
                        synchronized (viewPager) {
                            setCurItemPic((getCurItemPic() + 1) % imgList.size());
                            handler.obtainMessage().sendToTarget();
                        }
                    }
                }
            };
            timer.schedule(task, 5000, 5000);
        }
    }

    private Handler handler = new Handler() {

        public void handleMessage(Message msg) {
            viewPager.setCurrentItem(getCurItemPic());
        }

    };


    public BannerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs);
    }

    public BannerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public BannerView(Context context) {
        super(context);
        init(context, null);
    }

    public void init(Context context, AttributeSet attrs) {
        this.context = context;

        pointImg = new ArrayList<>();

        FrameLayout frameContainer = new FrameLayout(context);

        LayoutParams containerParams = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);

        addView(frameContainer, containerParams);

        viewPager = new ViewPager(context);

        frameContainer.addView(viewPager);

        lineary = new LinearLayout(context);

        LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM);
        lineary.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM);
        lineary.setPadding(0, 0, 0, 50);
        frameContainer.addView(lineary, layoutParams);
    }

    public void changeCurPontImg(int curPos) {
        for (int i = 0; i < imgList.size(); i++) {
            if (i == curPos) {
				pointImg.get(i).setBackgroundResource(R.mipmap.ic_home_banner1);
            } else {
				pointImg.get(i).setBackgroundResource(R.mipmap.ic_home_banner2);
            }
        }
    }

    public void setPageViewPics(List<View> picPageList) {
        this.imgList = picPageList;
        BannerAdapter adapter = new BannerAdapter(this.imgList);
        viewPager.setAdapter(adapter);
        if (picPageList.size() == 0) {
            return;
        }

        adapter.setmOnItemClick(new BannerAdapter.OnItemClick() {
            @Override
            public void onItemClick(int position) {
                if (onPageViewClicked != null) {
                    onPageViewClicked.onPageViewClicked(position);
                }
            }
        });
        viewPager.setOnPageChangeListener(this);
        pointImg.clear();
        lineary.removeAllViews();
        for (int i = 0; i < this.imgList.size(); i++) {
            ImageView imageview = new ImageView(context);
			imageview.setBackgroundResource(R.mipmap.ic_home_banner2);
            pointImg.add(imageview);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            params.setMargins(0, 10, 10, 0);
            imageview.setLayoutParams(params);
            lineary.addView(imageview);
        }

        viewPager.setCurrentItem(0);

		pointImg.get(0).setBackgroundResource(R.mipmap.ic_home_banner1);

        if (timer == null) {
            timer = new Timer();
            task = new TimerTask() {
                @Override
                public void run() {
                    if (imgList.size() == 0) {
                        return;
                    } else {
                        synchronized (viewPager) {
                            setCurItemPic((getCurItemPic() + 1) % imgList.size());
                            handler.obtainMessage().sendToTarget();
                        }
                    }
                }
            };
            timer.schedule(task, 5000, 5000);
        }
    }

    /**
     * state
     * 1:表示正在滑动
     * 2:表示滑动完毕
     * 0:表示什么都没做，就是停在那
     */
    @Override
    public void onPageScrollStateChanged(int state) {

        int size = viewPager.getAdapter().getCount();

        switch (state) {
            case 1:
                tempCurrentSelect = getCurItemPic();
                break;
            case 2:
                break;
            case 0:
                if (tempCurrentSelect == getCurItemPic()) {
                    if (getCurItemPic() == size - 1) {
                        setCurItemPic(0);
                        viewPager.setCurrentItem(getCurItemPic());
                    } else if (getCurItemPic() == 0) {
                        setCurItemPic(size - 1);
                        viewPager.setCurrentItem(getCurItemPic());
                    }
                }
                tempCurrentSelect = -1;
                break;
        }

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        this.setCurItemPic(position);
        changeCurPontImg(position);
    }

    public int getCurItemPic() {
        return curItemPic;
    }

    public void setCurItemPic(int curItemPic) {
        this.curItemPic = curItemPic;
    }

    public void setOnPageViewClicked(OnPageViewClicked onPageViewClicked) {
        this.onPageViewClicked = onPageViewClicked;
    }

    public interface OnPageViewClicked {
        void onPageViewClicked(int position);
    }
}
