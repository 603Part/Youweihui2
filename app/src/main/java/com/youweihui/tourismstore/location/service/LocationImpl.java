package com.youweihui.tourismstore.location.service;

import android.content.Context;

import com.youweihui.tourismstore.location.callback.Location;
import com.youweihui.tourismstore.location.callback.LocationCallBack;

public class LocationImpl implements Location,LocationCallBack{

    private Context mContext;
    private static LocationImpl instance;
    private LocationCallBack locationCallBack; // 回调给前台
    public static LocationImpl getInstance(Context mContext) {

        if (instance == null) {
            synchronized (LocationImpl.class) {
                if (instance == null) {
                    instance = new LocationImpl(mContext);
                }

            }
        }
        return instance;
    }

    public void setLocationCallBack(LocationCallBack locationCallBack) {
        this.locationCallBack = locationCallBack;
    }

    private LocationImpl(Context mContext) {
        this.mContext = mContext;
        LocationServiceProxy.getInstance(mContext).setLocationCallBack(this);
        startLocation();
    }

    @Override
    public void startLocation() {
        LocationServiceProxy.getInstance(mContext).bindService();
    }

    @Override
    public void stopLocation() {
        LocationServiceProxy.getInstance(mContext).unBinderService();
        this.mContext = null;
    }

    @Override
    public void onSuccess(String province, String city, String district) {
        locationCallBack.onSuccess(province, city, district);
    }

    @Override
    public void onFailure(String msg, String code) {
        locationCallBack.onFailure(msg, code);
    }

}
