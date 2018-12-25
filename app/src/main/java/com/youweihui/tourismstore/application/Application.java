package com.youweihui.tourismstore.application;

import android.content.Context;
import android.support.multidex.MultiDexApplication;

public class Application extends MultiDexApplication {
    private static Application application;
    private static Context context;

    @Override
    public void onCreate() {
        application = (Application) getApplicationContext();
        super.onCreate();
        context = this;
    }
}
