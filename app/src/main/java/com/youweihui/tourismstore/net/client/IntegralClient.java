package com.youweihui.tourismstore.net.client;

import com.youweihui.tourismstore.net.Const;
import com.youweihui.tourismstore.net.api.IntegralAPI;
import com.youweihui.tourismstore.net.request.GoodsRequest;
import com.youweihui.tourismstore.net.request.SubmitRequest;
import com.youweihui.tourismstore.net.response.BaseResponse;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class IntegralClient extends BaseClient {
    private IntegralAPI retrofit = new Retrofit.Builder()
            .baseUrl(Const.URL)
            .client(getOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(IntegralAPI.class);


    public Call<BaseResponse> submitorderCall(int addressId,int goodsId,int num) {
        return retrofit.submitorderCall(Const.TOKEN,addressId, goodsId, num);
    }
    public Call<BaseResponse> submitorderCall(GoodsRequest submitRequest) {
        return retrofit.submitorderCall(Const.TOKEN,submitRequest);
    }
}
