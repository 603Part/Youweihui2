package com.youweihui.tourismstore.net.api;

import com.youweihui.tourismstore.bean.FindRecommendGoodsBean;
import com.youweihui.tourismstore.bean.FindRecommendGoodsListBean;
import com.youweihui.tourismstore.bean.ForumBean;
import com.youweihui.tourismstore.bean.ForumTabBean;
import com.youweihui.tourismstore.bean.GoodInfoBean;
import com.youweihui.tourismstore.bean.SpecialBean;
import com.youweihui.tourismstore.net.request.EmptyRequest;
import com.youweihui.tourismstore.net.request.GoodsInfoRequest;
import com.youweihui.tourismstore.net.request.GoodsListRequest;
import com.youweihui.tourismstore.net.request.GoodsRequest;
import com.youweihui.tourismstore.net.request.ReleaseListByClassIfyIdRequest;
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

    @POST("integral/findmoregoodslist")
    Observable<FindRecommendGoodsListBean> getFindRecommendGoodsList(@Header ("token") String token, @Body GoodsListRequest listRequest);

    @POST("integral/goodsinfo")
    Observable<GoodInfoBean> getGoodsInfo(@Header ("token") String token, @Body GoodsInfoRequest infoRequest);

    @POST("feature/titleprocuctlist")
    Observable<SpecialBean> getTitleProcuctList(@Header ("token") String token, @Body EmptyRequest emptyRequest);

    @POST("forum/classifylist")
    Observable<ForumTabBean> getClassIfyList(@Header ("token") String token, @Body EmptyRequest emptyRequest);

    @POST("forum/releaselistbyclassifyid")
    Observable<ForumBean> getReleaseListByClassIfyId(@Header ("token") String token, @Body ReleaseListByClassIfyIdRequest releaseListByClassIfyIdRequest);
}
