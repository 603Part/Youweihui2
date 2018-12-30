package com.youweihui.tourismstore.application;

import android.content.Context;
import android.support.multidex.MultiDexApplication;

public class Application extends MultiDexApplication {

    private static Application instance;

    private static Context context;

    public synchronized static Application getInstance() {
        if (null == instance) {
            instance = new Application();
        }
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        context = this;
    }
}
