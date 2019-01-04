package com.youweihui.tourismstore.bean;

import java.util.List;

/**
 * Created by ${范泽宁} on 2019/1/3.
 */

public class FindRecommendGoodsBean {

    /**
     * msg : success
     * code : 0
     * bannerList : [{"id":1,"advertisingPositionId":5,"advertisingName":"广告1","advertisingUrl":"aa.html","orderNum":1,"webPictureUrl":"11.jpg","appPictureUrl":"2.jpg","enable":0,"flag":0,"createUserId":1,"updateUserId":1,"createUserTime":"2019-01-02T03:49:56.000+0000","updateUserTime":"2019-01-02T03:50:00.000+0000"}]
     * travellist : [{"goodsId":2,"classifyId":4,"classifyName":"旅游必备","goodsName":"旅游背包1","goodsType":1,"deduction":99,"conditionNum":null,"integral":1000,"expiryDate":"2018-12-30T03:12:50.000+0000","stock":100,"salesVolume":0,"collection":0,"pictureUrl":"http://pasqvoice.oss-cn-beijing.aliyuncs.com/15460333211461088562432.jpg","goodsDescription":"描述","goodsState":0,"flag":0,"createUserId":null,"updateUserId":null,"createUserTime":"2018-12-30T04:03:25.000+0000","updateUserTime":"2018-12-30T04:03:20.000+0000"},{"goodsId":4,"classifyId":4,"classifyName":"旅游必备","goodsName":"旅游背包2","goodsType":1,"deduction":99,"conditionNum":null,"integral":1000,"expiryDate":"2018-12-30T03:12:50.000+0000","stock":100,"salesVolume":0,"collection":0,"pictureUrl":"http://pasqvoice.oss-cn-beijing.aliyuncs.com/15460333211461088562432.jpg","goodsDescription":"描述","goodsState":0,"flag":0,"createUserId":null,"updateUserId":null,"createUserTime":"2018-12-30T04:03:01.000+0000","updateUserTime":"2018-12-30T04:03:10.000+0000"}]
     * hotlist : [{"goodsId":1,"classifyId":3,"classifyName":"爆款推荐","goodsName":"手机1","goodsType":1,"deduction":100.99,"conditionNum":null,"integral":500,"expiryDate":"2019-01-05T13:30:49.000+0000","stock":98,"salesVolume":5,"collection":5,"pictureUrl":"http://pasqvoice.oss-cn-beijing.aliyuncs.com/15460333211461088562432.jpg","goodsDescription":"描述写啥呢","goodsState":0,"flag":0,"createUserId":null,"updateUserId":null,"createUserTime":"2018-12-30T04:03:22.000+0000","updateUserTime":"2018-12-30T04:03:16.000+0000"},{"goodsId":3,"classifyId":3,"classifyName":"爆款推荐","goodsName":"手机2","goodsType":1,"deduction":100.99,"conditionNum":null,"integral":500,"expiryDate":"2019-01-05T13:30:49.000+0000","stock":10,"salesVolume":8,"collection":3,"pictureUrl":"http://pasqvoice.oss-cn-beijing.aliyuncs.com/15460333211461088562432.jpg","goodsDescription":"描述写啥呢","goodsState":0,"flag":0,"createUserId":null,"updateUserId":null,"createUserTime":"2018-12-30T04:02:58.000+0000","updateUserTime":"2018-12-30T04:03:07.000+0000"}]
     */

    private String msg;
    private int code;
    private List<BannerListBean> bannerList;
    private List<TravellistBean> travellist;
    private List<HotlistBean> hotlist;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<BannerListBean> getBannerList() {
        return bannerList;
    }

    public void setBannerList(List<BannerListBean> bannerList) {
        this.bannerList = bannerList;
    }

    public List<TravellistBean> getTravellist() {
        return travellist;
    }

    public void setTravellist(List<TravellistBean> travellist) {
        this.travellist = travellist;
    }

    public List<HotlistBean> getHotlist() {
        return hotlist;
    }

    public void setHotlist(List<HotlistBean> hotlist) {
        this.hotlist = hotlist;
    }

    public static class BannerListBean {
        /**
         * id : 1
         * advertisingPositionId : 5
         * advertisingName : 广告1
         * advertisingUrl : aa.html
         * orderNum : 1
         * webPictureUrl : 11.jpg
         * appPictureUrl : 2.jpg
         * enable : 0
         * flag : 0
         * createUserId : 1
         * updateUserId : 1
         * createUserTime : 2019-01-02T03:49:56.000+0000
         * updateUserTime : 2019-01-02T03:50:00.000+0000
         */

        private int id;
        private int advertisingPositionId;
        private String advertisingName;
        private String advertisingUrl;
        private int orderNum;
        private String webPictureUrl;
        private String appPictureUrl;
        private int enable;
        private int flag;
        private int createUserId;
        private int updateUserId;
        private String createUserTime;
        private String updateUserTime;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getAdvertisingPositionId() {
            return advertisingPositionId;
        }

        public void setAdvertisingPositionId(int advertisingPositionId) {
            this.advertisingPositionId = advertisingPositionId;
        }

        public String getAdvertisingName() {
            return advertisingName;
        }

        public void setAdvertisingName(String advertisingName) {
            this.advertisingName = advertisingName;
        }

        public String getAdvertisingUrl() {
            return advertisingUrl;
        }

        public void setAdvertisingUrl(String advertisingUrl) {
            this.advertisingUrl = advertisingUrl;
        }

        public int getOrderNum() {
            return orderNum;
        }

        public void setOrderNum(int orderNum) {
            this.orderNum = orderNum;
        }

        public String getWebPictureUrl() {
            return webPictureUrl;
        }

        public void setWebPictureUrl(String webPictureUrl) {
            this.webPictureUrl = webPictureUrl;
        }

        public String getAppPictureUrl() {
            return appPictureUrl;
        }

        public void setAppPictureUrl(String appPictureUrl) {
            this.appPictureUrl = appPictureUrl;
        }

        public int getEnable() {
            return enable;
        }

        public void setEnable(int enable) {
            this.enable = enable;
        }

        public int getFlag() {
            return flag;
        }

        public void setFlag(int flag) {
            this.flag = flag;
        }

        public int getCreateUserId() {
            return createUserId;
        }

        public void setCreateUserId(int createUserId) {
            this.createUserId = createUserId;
        }

        public int getUpdateUserId() {
            return updateUserId;
        }

        public void setUpdateUserId(int updateUserId) {
            this.updateUserId = updateUserId;
        }

        public String getCreateUserTime() {
            return createUserTime;
        }

        public void setCreateUserTime(String createUserTime) {
            this.createUserTime = createUserTime;
        }

        public String getUpdateUserTime() {
            return updateUserTime;
        }

        public void setUpdateUserTime(String updateUserTime) {
            this.updateUserTime = updateUserTime;
        }
    }

    public static class TravellistBean {
        /**
         * goodsId : 2
         * classifyId : 4
         * classifyName : 旅游必备
         * goodsName : 旅游背包1
         * goodsType : 1
         * deduction : 99
         * conditionNum : null
         * integral : 1000
         * expiryDate : 2018-12-30T03:12:50.000+0000
         * stock : 100
         * salesVolume : 0
         * collection : 0
         * pictureUrl : http://pasqvoice.oss-cn-beijing.aliyuncs.com/15460333211461088562432.jpg
         * goodsDescription : 描述
         * goodsState : 0
         * flag : 0
         * createUserId : null
         * updateUserId : null
         * createUserTime : 2018-12-30T04:03:25.000+0000
         * updateUserTime : 2018-12-30T04:03:20.000+0000
         */

        private int goodsId;
        private int classifyId;
        private String classifyName;
        private String goodsName;
        private int goodsType;
        private int deduction;
        private Object conditionNum;
        private int integral;
        private String expiryDate;
        private int stock;
        private int salesVolume;
        private int collection;
        private String pictureUrl;
        private String goodsDescription;
        private int goodsState;
        private int flag;
        private Object createUserId;
        private Object updateUserId;
        private String createUserTime;
        private String updateUserTime;

        public int getGoodsId() {
            return goodsId;
        }

        public void setGoodsId(int goodsId) {
            this.goodsId = goodsId;
        }

        public int getClassifyId() {
            return classifyId;
        }

        public void setClassifyId(int classifyId) {
            this.classifyId = classifyId;
        }

        public String getClassifyName() {
            return classifyName;
        }

        public void setClassifyName(String classifyName) {
            this.classifyName = classifyName;
        }

        public String getGoodsName() {
            return goodsName;
        }

        public void setGoodsName(String goodsName) {
            this.goodsName = goodsName;
        }

        public int getGoodsType() {
            return goodsType;
        }

        public void setGoodsType(int goodsType) {
            this.goodsType = goodsType;
        }

        public int getDeduction() {
            return deduction;
        }

        public void setDeduction(int deduction) {
            this.deduction = deduction;
        }

        public Object getConditionNum() {
            return conditionNum;
        }

        public void setConditionNum(Object conditionNum) {
            this.conditionNum = conditionNum;
        }

        public int getIntegral() {
            return integral;
        }

        public void setIntegral(int integral) {
            this.integral = integral;
        }

        public String getExpiryDate() {
            return expiryDate;
        }

        public void setExpiryDate(String expiryDate) {
            this.expiryDate = expiryDate;
        }

        public int getStock() {
            return stock;
        }

        public void setStock(int stock) {
            this.stock = stock;
        }

        public int getSalesVolume() {
            return salesVolume;
        }

        public void setSalesVolume(int salesVolume) {
            this.salesVolume = salesVolume;
        }

        public int getCollection() {
            return collection;
        }

        public void setCollection(int collection) {
            this.collection = collection;
        }

        public String getPictureUrl() {
            return pictureUrl;
        }

        public void setPictureUrl(String pictureUrl) {
            this.pictureUrl = pictureUrl;
        }

        public String getGoodsDescription() {
            return goodsDescription;
        }

        public void setGoodsDescription(String goodsDescription) {
            this.goodsDescription = goodsDescription;
        }

        public int getGoodsState() {
            return goodsState;
        }

        public void setGoodsState(int goodsState) {
            this.goodsState = goodsState;
        }

        public int getFlag() {
            return flag;
        }

        public void setFlag(int flag) {
            this.flag = flag;
        }

        public Object getCreateUserId() {
            return createUserId;
        }

        public void setCreateUserId(Object createUserId) {
            this.createUserId = createUserId;
        }

        public Object getUpdateUserId() {
            return updateUserId;
        }

        public void setUpdateUserId(Object updateUserId) {
            this.updateUserId = updateUserId;
        }

        public String getCreateUserTime() {
            return createUserTime;
        }

        public void setCreateUserTime(String createUserTime) {
            this.createUserTime = createUserTime;
        }

        public String getUpdateUserTime() {
            return updateUserTime;
        }

        public void setUpdateUserTime(String updateUserTime) {
            this.updateUserTime = updateUserTime;
        }
    }

    public static class HotlistBean {
        /**
         * goodsId : 1
         * classifyId : 3
         * classifyName : 爆款推荐
         * goodsName : 手机1
         * goodsType : 1
         * deduction : 100.99
         * conditionNum : null
         * integral : 500
         * expiryDate : 2019-01-05T13:30:49.000+0000
         * stock : 98
         * salesVolume : 5
         * collection : 5
         * pictureUrl : http://pasqvoice.oss-cn-beijing.aliyuncs.com/15460333211461088562432.jpg
         * goodsDescription : 描述写啥呢
         * goodsState : 0
         * flag : 0
         * createUserId : null
         * updateUserId : null
         * createUserTime : 2018-12-30T04:03:22.000+0000
         * updateUserTime : 2018-12-30T04:03:16.000+0000
         */

        private int goodsId;
        private int classifyId;
        private String classifyName;
        private String goodsName;
        private int goodsType;
        private double deduction;
        private Object conditionNum;
        private int integral;
        private String expiryDate;
        private int stock;
        private int salesVolume;
        private int collection;
        private String pictureUrl;
        private String goodsDescription;
        private int goodsState;
        private int flag;
        private Object createUserId;
        private Object updateUserId;
        private String createUserTime;
        private String updateUserTime;

        public int getGoodsId() {
            return goodsId;
        }

        public void setGoodsId(int goodsId) {
            this.goodsId = goodsId;
        }

        public int getClassifyId() {
            return classifyId;
        }

        public void setClassifyId(int classifyId) {
            this.classifyId = classifyId;
        }

        public String getClassifyName() {
            return classifyName;
        }

        public void setClassifyName(String classifyName) {
            this.classifyName = classifyName;
        }

        public String getGoodsName() {
            return goodsName;
        }

        public void setGoodsName(String goodsName) {
            this.goodsName = goodsName;
        }

        public int getGoodsType() {
            return goodsType;
        }

        public void setGoodsType(int goodsType) {
            this.goodsType = goodsType;
        }

        public double getDeduction() {
            return deduction;
        }

        public void setDeduction(double deduction) {
            this.deduction = deduction;
        }

        public Object getConditionNum() {
            return conditionNum;
        }

        public void setConditionNum(Object conditionNum) {
            this.conditionNum = conditionNum;
        }

        public int getIntegral() {
            return integral;
        }

        public void setIntegral(int integral) {
            this.integral = integral;
        }

        public String getExpiryDate() {
            return expiryDate;
        }

        public void setExpiryDate(String expiryDate) {
            this.expiryDate = expiryDate;
        }

        public int getStock() {
            return stock;
        }

        public void setStock(int stock) {
            this.stock = stock;
        }

        public int getSalesVolume() {
            return salesVolume;
        }

        public void setSalesVolume(int salesVolume) {
            this.salesVolume = salesVolume;
        }

        public int getCollection() {
            return collection;
        }

        public void setCollection(int collection) {
            this.collection = collection;
        }

        public String getPictureUrl() {
            return pictureUrl;
        }

        public void setPictureUrl(String pictureUrl) {
            this.pictureUrl = pictureUrl;
        }

        public String getGoodsDescription() {
            return goodsDescription;
        }

        public void setGoodsDescription(String goodsDescription) {
            this.goodsDescription = goodsDescription;
        }

        public int getGoodsState() {
            return goodsState;
        }

        public void setGoodsState(int goodsState) {
            this.goodsState = goodsState;
        }

        public int getFlag() {
            return flag;
        }

        public void setFlag(int flag) {
            this.flag = flag;
        }

        public Object getCreateUserId() {
            return createUserId;
        }

        public void setCreateUserId(Object createUserId) {
            this.createUserId = createUserId;
        }

        public Object getUpdateUserId() {
            return updateUserId;
        }

        public void setUpdateUserId(Object updateUserId) {
            this.updateUserId = updateUserId;
        }

        public String getCreateUserTime() {
            return createUserTime;
        }

        public void setCreateUserTime(String createUserTime) {
            this.createUserTime = createUserTime;
        }

        public String getUpdateUserTime() {
            return updateUserTime;
        }

        public void setUpdateUserTime(String updateUserTime) {
            this.updateUserTime = updateUserTime;
        }
    }
}
