package com.youweihui.tourismstore.bean;

import java.util.List;

/**
 * Created by ${范泽宁} on 2019/1/3.
 */

public class GoodInfoBean {


    /**
     * msg : success
     * code : 0
     * GoodsInfo : {"goodsId":1,"classifyId":3,"goodsName":"手机1","goodsType":1,"deduction":100.99,"conditionNum":null,"integral":500,"expiryDate":"2019-01-05T13:30:49.000+0000","stock":98,"salesVolume":5,"collection":4,"pictureUrl":"http://pasqvoice.oss-cn-beijing.aliyuncs.com/15460333211461088562432.jpg","goodsDescription":"描述写啥呢","goodsState":0,"collectionSign":0,"pictureList":[]}
     */

    private String msg;
    private int code;
    private GoodsInfoBean GoodsInfo;

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

    public GoodsInfoBean getGoodsInfo() {
        return GoodsInfo;
    }

    public void setGoodsInfo(GoodsInfoBean GoodsInfo) {
        this.GoodsInfo = GoodsInfo;
    }

    public static class GoodsInfoBean {
        /**
         * goodsId : 1
         * classifyId : 3
         * goodsName : 手机1
         * goodsType : 1
         * deduction : 100.99
         * conditionNum : null
         * integral : 500
         * expiryDate : 2019-01-05T13:30:49.000+0000
         * stock : 98
         * salesVolume : 5
         * collection : 4
         * pictureUrl : http://pasqvoice.oss-cn-beijing.aliyuncs.com/15460333211461088562432.jpg
         * goodsDescription : 描述写啥呢
         * goodsState : 0
         * collectionSign : 0
         * pictureList : []
         */

        private int goodsId;
        private int classifyId;
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
        private int collectionSign;
        private List<?> pictureList;

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

        public int getCollectionSign() {
            return collectionSign;
        }

        public void setCollectionSign(int collectionSign) {
            this.collectionSign = collectionSign;
        }

        public List<?> getPictureList() {
            return pictureList;
        }

        public void setPictureList(List<?> pictureList) {
            this.pictureList = pictureList;
        }
    }
}
