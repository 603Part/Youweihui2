package com.youweihui.tourismstore.http;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("api/app/integral/findmoregoodslist")
    Call<String> getFindMoreGoodsList(@FieldMap Map<String, String> params);//积分商城首页查询更多产品


    @FormUrlEncoded
    @POST("api/app/integral/findrecommendgoods")
    Call<String> getFindRecommendGoods(@FieldMap Map<String, String> params);//积分商城首页查询爆款和旅行必备的推荐产品
}
