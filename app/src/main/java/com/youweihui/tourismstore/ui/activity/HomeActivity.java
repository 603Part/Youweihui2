package com.youweihui.tourismstore.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.youweihui.tourismstore.R;
import com.youweihui.tourismstore.base.BaseActivity;
import com.youweihui.tourismstore.location.CheckPermissionsActivity;
import com.youweihui.tourismstore.location.callback.LocationCallBack;
import com.youweihui.tourismstore.location.service.LocationImpl;
import com.youweihui.tourismstore.location.service.LocationServiceProxy;
import com.youweihui.tourismstore.ui.fragment.ForumFragment;
import com.youweihui.tourismstore.ui.fragment.HomeFragment;
import com.youweihui.tourismstore.ui.fragment.MyFragment;
import com.youweihui.tourismstore.ui.fragment.ShopFragment;
import com.youweihui.tourismstore.ui.fragment.TailOrderFragment;

import butterknife.BindView;

/**
 * 〈网络请求〉
 * 〈功能详细描述: 〉
 *
 * @return [返回类型: S]
 * @exception/throws [违例类型: 无] [违例说明: 无]
 * @author: [范泽宁]
 * @date 2018/12/9 22:25
 * @history [历史修改]     [参数说明: 标识]
 * @unfinish [未完成]     [参数说明: 标识]
 * @see [类、类#方法、类#成员]
 */
public class HomeActivity extends CheckPermissionsActivity implements RadioGroup.OnCheckedChangeListener {

    //首页
    @BindView(R.id.group_home)
    RadioButton rbHome;

    //实时尾单
    @BindView(R.id.group_tail_order)
    RadioButton rbTailOrder;

    //论坛
    @BindView(R.id.group_forum)
    RadioButton rbForum;

    //商城
    @BindView(R.id.group_shop)
    RadioButton rbShop;

    //个人中心
    @BindView(R.id.group_my)
    RadioButton rbMy;

    //外部布局
    @BindView(R.id.home_radio_group)
    RadioGroup rgHome;

    //内容
    @BindView(R.id.home_layout_frame)
    FrameLayout frameLayout;

    //首页内容页
    HomeFragment homeFragment;

    //实时尾单内容页
    TailOrderFragment orderFragment;

    //论坛内容页
    ForumFragment forumFragment;

    //商城内容页
    ShopFragment shopFragment;

    //个人中心
    MyFragment myFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        homeFragment = (HomeFragment) getSupportFragmentManager().findFragmentByTag("home");
        orderFragment = (TailOrderFragment) getSupportFragmentManager().findFragmentByTag("order");
        forumFragment = (ForumFragment) getSupportFragmentManager().findFragmentByTag("forum");
        shopFragment = (ShopFragment) getSupportFragmentManager().findFragmentByTag("shop");
        myFragment = (MyFragment) getSupportFragmentManager().findFragmentByTag("shop");
        rgHome.setOnCheckedChangeListener(this);
        rbHome.performClick();
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        hideAllFragment(transaction);

        switch (i) {
            case R.id.group_home:
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                    transaction.add(R.id.home_layout_frame, homeFragment, "home");
                } else {
                    transaction.show(homeFragment);
                }
                break;

            case R.id.group_tail_order:
                if (orderFragment == null) {
                    orderFragment = new TailOrderFragment();
                    transaction.add(R.id.home_layout_frame, orderFragment, "order");
                } else {
                    transaction.show(orderFragment);
                }
                break;

            case R.id.group_forum:
                if (forumFragment == null) {
                    forumFragment = new ForumFragment();
                    transaction.add(R.id.home_layout_frame, forumFragment, "forum");
                } else {
                    transaction.show(forumFragment);
                }
                break;

            case R.id.group_shop:
                if (shopFragment == null) {
                    shopFragment = new ShopFragment();
                    transaction.add(R.id.home_layout_frame, shopFragment, "shop");
                } else {
                    transaction.show(shopFragment);
                }
                break;

            case R.id.group_my:
                if (myFragment == null) {
                    myFragment = new MyFragment();
                    transaction.add(R.id.home_layout_frame, myFragment, "my");
                } else {
                    transaction.show(myFragment);
                }
                break;
        }

        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        transaction.commit();
    }

    private void hideAllFragment(FragmentTransaction transaction) {
        if (homeFragment != null) {
            transaction.hide(homeFragment);
        }
        if (orderFragment != null) {
            transaction.hide(orderFragment);
        }
        if (forumFragment != null) {
            transaction.hide(forumFragment);
        }
        if (shopFragment != null) {
            transaction.hide(shopFragment);
        }

        if (myFragment != null) {
            transaction.hide(myFragment);
        }
    }
}
