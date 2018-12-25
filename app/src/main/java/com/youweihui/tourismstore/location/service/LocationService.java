package com.youweihui.tourismstore.location.service;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.youweihui.tourismstore.location.callback.LocationListener;
import com.youweihui.tourismstore.utils.Utils;


public class LocationService extends Service implements AMapLocationListener {
    private static final String TAG = "LocationService";
    private LocationBinder mBinder = new LocationBinder();

    private LocationListener mLocationListener;
    private AMapLocationClient locationClient = null;
    private AMapLocationClientOption locationOption = null;

    private static final int LOCATION_SUCCESS = 0x0001;
    private static final int LOCATION_FAILURE = 0x0002;
    private static final int LOCATION_RETRY = 0x0003;

    @Override
    public void onCreate() {
        super.onCreate();
        initLocation();
    }

    private void initLocation() {
        locationClient = new AMapLocationClient(this);
        locationOption = getDefaultOption();
        locationClient.setLocationListener(this);
    }

    @SuppressLint("HandlerLeak")
    private Handler mLocationHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            AMapLocation location = (AMapLocation)msg.obj;
            switch (msg.what) {
                case LOCATION_SUCCESS:
                    mLocationListener.onSuccess(location.getProvince(),location.getCity(),location.getDistrict());
                    break;
                case LOCATION_FAILURE:
                    mLocationListener.onFailure(location.getErrorInfo(),location.getErrorCode()+"");
                    sendEmptyMessageDelayed(LOCATION_RETRY, 2000); //失败后每两秒重试
                    break;
                case LOCATION_RETRY:
                    removeMessages(LOCATION_RETRY);
                    startLocation();
                    break;
            }
        }
    };

    /**
     * 默认的定位参数
     */
    private AMapLocationClientOption getDefaultOption(){
        AMapLocationClientOption mOption = new AMapLocationClientOption();
        mOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        mOption.setGpsFirst(false);
        mOption.setHttpTimeOut(30000);
        mOption.setNeedAddress(true);
        mOption.setOnceLocation(true); // 单次定位
        mOption.setOnceLocationLatest(false);
        AMapLocationClientOption.setLocationProtocol(AMapLocationClientOption.AMapLocationProtocol.HTTP);
        mOption.setSensorEnable(false);
        mOption.setWifiScan(true);
        mOption.setLocationCacheEnable(true);
        mOption.setGeoLanguage(AMapLocationClientOption.GeoLanguage.DEFAULT);
        return mOption;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    public void setmLocationListener(LocationListener mLocationListener) {
        this.mLocationListener = mLocationListener;
    }

    @Override
    public void onLocationChanged(AMapLocation location) {
        if (null != location) {
            locationResult(location);
        } else {
            Log.d(TAG, "onLocationChanged: 定位失败,原因未知");
            mLocationListener.onFailure("未知原因","-1");
        }
    }

    private void locationResult(AMapLocation location) {
        Message message = mLocationHandler.obtainMessage();
        //errCode等于0代表定位成功，其他的为定位失败，具体的可以参照官网定位错误码说明
        if(location.getErrorCode() == 0){
            message.what = LOCATION_SUCCESS;
        } else {
            //定位失败
            message.what = LOCATION_FAILURE;
        }
        message.obj = location;
        mLocationHandler.sendMessage(message);

        //解析定位结果，
        Log.d(TAG, "onLocationChanged: " + message.what);
    }

    private void startLocation() {
        locationClient.setLocationOption(locationOption);
        locationClient.startLocation();
    }


    public class LocationBinder extends Binder {

        public LocationService getInstance() {
            return LocationService.this;
        }

        public void getCurrentLocation() {
            startLocation();
        }
    }

}
