package com.youweihui.tourismstore.net.api;

import com.youweihui.tourismstore.bean.FindRecommendGoodsBean;
import com.youweihui.tourismstore.net.request.EmptyRequest;
import com.youweihui.tourismstore.net.request.GoodsRequest;
import com.youweihui.tourismstore.net.response.BaseResponse;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface IntegralAPI {

    @POST("integral/submitorder")
    Observable<BaseResponse> submitorderCall(@Field("token") String token,
                                       @Field("addressId") int addressId,
                                       @Field("integralGoodsId") int integralGoodsId,
                                       @Field("number") int number);

    @POST("integral/submitorder")
    Observable<BaseResponse> submitorderCall(@Header ("token") String token, @Body GoodsRequest submitRequest);

    @POST("integral/findrecommendgoods")
    Observable<FindRecommendGoodsBean> getFindRecommendGoods(@Header ("token") String token, @Body EmptyRequest emptyRequest);
}
