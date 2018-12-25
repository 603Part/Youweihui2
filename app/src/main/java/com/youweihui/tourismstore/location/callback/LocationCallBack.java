package com.youweihui.tourismstore.location.callback;

public interface LocationCallBack {
    void onSuccess(String province,String city,String district);

    void onFailure(String msg,String code);
}
