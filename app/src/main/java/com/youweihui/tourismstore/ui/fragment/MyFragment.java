package com.youweihui.tourismstore.ui.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.youweihui.tourismstore.R;
import com.youweihui.tourismstore.adapter.ShopTabAdapter;
import com.youweihui.tourismstore.base.BaseFragment;
import com.youweihui.tourismstore.bean.HomeTailOrderEntity;
import com.youweihui.tourismstore.ui.activity.TailListActivity;
import com.youweihui.tourismstore.utils.GlideUtils;
import com.youweihui.tourismstore.view.BannerView;
import com.youweihui.tourismstore.view.CustomScrollView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by ${范泽宁} on 2018/12/10.
 */

public class MyFragment extends BaseFragment {

    private static final String INJECTION_TOKEN = "**injection**";

    @BindView(R.id.fragment_web_my)
    WebView myWeb;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_my;
    }

    @Override
    protected void initView() {
        setStatusBarColor(false);

        //将网页标题设置给title
        WebChromeClient chromeClient = new WebChromeClient() {
            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);

            }
        };

        // 设置setWebChromeClient对象
        myWeb.setWebChromeClient(chromeClient);

        myWeb.setWebViewClient(new WebViewClient() {

            @Override
            public WebResourceResponse shouldInterceptRequest(WebView view, String url) {

                WebResourceResponse response = super.shouldInterceptRequest(view, url);
                if (url != null && url.contains(INJECTION_TOKEN)) {
                    String assetPath = url.substring(url.indexOf(INJECTION_TOKEN) + INJECTION_TOKEN.length(), url.length());
                    try {
                        response = new WebResourceResponse("application/javascript", "UTF8", context.getAssets().open(assetPath));
                    } catch (IOException e) {
                        e.printStackTrace(); // Failed to load asset file
                    }
                }
                return response;
            }

            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                if (url.startsWith("tel:")) {
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(url));
                    startActivity(intent);
                    return true;
                } else if (url.startsWith("http:") || url.startsWith("https:")) {
                    view.loadUrl(url);
                    return false;
                } else {
//                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
//                    startActivity(intent);
                    myWeb.loadUrl(url);
                    return true;
                }
            }

            public void onLoadResource(WebView view, String url) {

            }

            public void onPageFinished(WebView view, String url) {
                try {

                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }

        });

        myWeb.getSettings().setJavaScriptEnabled(true);
        myWeb.getSettings().setJavaScriptEnabled(true);
        myWeb.getSettings().setDomStorageEnabled(true);
        myWeb.loadUrl("file:///android_asset/personal.html");
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        myWeb.destroy();
    }

    @Override
    public void onPause() {
        super.onPause();
        myWeb.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        myWeb.onResume();
    }
}
