package com.youweihui.tourismstore.net.api;

import com.youweihui.tourismstore.net.request.SubmitRequest;
import com.youweihui.tourismstore.net.response.BaseResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface IntegralAPI {
    @POST("submitorder")

    Call<BaseResponse> submitorderCall(@Field("token") String token,
                                       @Field("addressId") int addressId,
                                       @Field("integralGoodsId") int integralGoodsId,
                                       @Field("number") int number);

    @POST("submitorder")
    Call<BaseResponse> submitorderCall(@Body SubmitRequest submitRequest);
}
