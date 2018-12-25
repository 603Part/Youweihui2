package com.youweihui.tourismstore.location.service;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;

import com.youweihui.tourismstore.location.callback.LocationCallBack;
import com.youweihui.tourismstore.location.callback.LocationListener;

public class LocationServiceProxy implements LocationListener{
    private static final String TAG = "LocationServiceProxy";
    private LocationCallBack locationCallBack;
    private static LocationServiceProxy locationServiceProxy;
    private final Context mContext;

    private LocationService.LocationBinder locationBinder;

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceDisconnected(ComponentName name) {

        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            locationBinder = (LocationService.LocationBinder) service;
            LocationService instance = locationBinder.getInstance();
            instance.setmLocationListener(LocationServiceProxy.this);
            locationBinder.getCurrentLocation();
        }
    };

    public void setLocationCallBack(LocationCallBack locationCallBack) {
        this.locationCallBack = locationCallBack;
    }

    public static LocationServiceProxy getInstance(Context mContext) {
        if (locationServiceProxy == null) {
            synchronized (LocationServiceProxy.class) {
                if (locationServiceProxy == null) {
                    locationServiceProxy = new LocationServiceProxy(mContext);
                }
            }
        }

        return locationServiceProxy;
    }

    private LocationServiceProxy(Context mContext) {
        this.mContext = mContext;
    }

    /**
     * 绑定服务
     */
    public void bindService() {
        Intent intent = new Intent(mContext, LocationService.class);
        mContext.bindService(intent, connection, Service.BIND_AUTO_CREATE);
    }

    /**
     * 解绑服务
     */
    public void unBinderService() {
        mContext.unbindService(connection);
    }

    @Override
    public void onSuccess(String provide, String city, String district) {
        Log.d(TAG, "onSuccess: " + provide + city + district);
        locationCallBack.onSuccess(provide, city, district);
    }

    @Override
    public void onFailure(String msg, String code) {
        Log.d(TAG, "onFailure: " + msg + " " + code);
        locationCallBack.onFailure(msg, code);
    }
}
