package com.youweihui.tourismstore.net.client;

import com.youweihui.tourismstore.bean.FindRecommendGoodsBean;
import com.youweihui.tourismstore.net.Const;
import com.youweihui.tourismstore.net.api.IntegralAPI;
import com.youweihui.tourismstore.net.request.EmptyRequest;
import com.youweihui.tourismstore.net.request.GoodsRequest;
import com.youweihui.tourismstore.net.response.BaseResponse;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class IntegralClient extends BaseClient {
    private IntegralAPI retrofit = new Retrofit.Builder()
            .baseUrl(Const.URL)
            .client(getOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(IntegralAPI.class);


    public Observable<BaseResponse> submitorderCall(int addressId, int goodsId, int num) {
        return retrofit.submitorderCall(Const.TOKEN,addressId, goodsId, num);
    }

    public Observable<BaseResponse> submitorderCall(GoodsRequest submitRequest) {
        return retrofit.submitorderCall(Const.TOKEN,submitRequest);
    }

    public Observable<FindRecommendGoodsBean> getFindRecommendGoods(EmptyRequest emptyRequest) {
        return retrofit.getFindRecommendGoods(Const.TOKEN,emptyRequest);
    }
}
