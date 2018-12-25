## 使用定位
``` 
LocationImpl.getInstance(this).setLocationCallBack(new LocationCallBack() {
               @Override
               public void onSuccess(String province, String city, String district) {
                   Log.d(TAG, "onSuccess: " + province + city + district);
               }
   
               @Override
               public void onFailure(String msg, String code) {
                   Log.d(TAG, "onFailure: " + msg + code);
               }
});

``` 

> 不要忘记在生命周期结束时候调用 LocationImpl.getInstance(this).stopLocation();