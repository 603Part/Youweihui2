package com.youweihui.tourismstore.net.client;

import com.youweihui.tourismstore.bean.FindRecommendGoodsBean;
import com.youweihui.tourismstore.bean.FindRecommendGoodsListBean;
import com.youweihui.tourismstore.bean.ForumBean;
import com.youweihui.tourismstore.bean.ForumTabBean;
import com.youweihui.tourismstore.bean.GoodInfoBean;
import com.youweihui.tourismstore.bean.SpecialBean;
import com.youweihui.tourismstore.net.Const;
import com.youweihui.tourismstore.net.api.IntegralAPI;
import com.youweihui.tourismstore.net.request.EmptyRequest;
import com.youweihui.tourismstore.net.request.GoodsInfoRequest;
import com.youweihui.tourismstore.net.request.GoodsListRequest;
import com.youweihui.tourismstore.net.request.GoodsRequest;
import com.youweihui.tourismstore.net.request.ReleaseListByClassIfyIdRequest;
import com.youweihui.tourismstore.net.request.SubmitOrderRequest;
import com.youweihui.tourismstore.net.response.BaseResponse;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient extends BaseClient {
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

    public Observable<FindRecommendGoodsListBean> getFindRecommendGoodsList(GoodsListRequest listRequest) {
        return retrofit.getFindRecommendGoodsList(Const.TOKEN,listRequest);
    }

    public Observable<GoodInfoBean> getGoodsInfo(GoodsInfoRequest infoRequest) {
        return retrofit.getGoodsInfo(Const.TOKEN,infoRequest);
    }

    public Observable<SpecialBean> getTitleProcuctList(EmptyRequest emptyRequest) {
        return retrofit.getTitleProcuctList(Const.TOKEN,emptyRequest);
    }

    public Observable<ForumTabBean> getClassIfyList(EmptyRequest emptyRequest) {
        return retrofit.getClassIfyList(Const.TOKEN,emptyRequest);
    }

    public Observable<ForumBean> getReleaseListByClassIfyId(ReleaseListByClassIfyIdRequest releaseListByClassIfyIdRequest) {
        return retrofit.getReleaseListByClassIfyId(Const.TOKEN,releaseListByClassIfyIdRequest);
    }

    public Observable<ForumBean> getSubmitOrder(SubmitOrderRequest submitOrderRequest) {
        return retrofit.getSubmitOrder(Const.TOKEN,submitOrderRequest);
    }
}
