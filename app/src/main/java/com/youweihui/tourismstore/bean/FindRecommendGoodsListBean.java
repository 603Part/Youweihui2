package com.youweihui.tourismstore.bean;

import java.util.List;

/**
 * Created by ${范泽宁} on 2019/1/3.
 */

public class FindRecommendGoodsListBean {


    /**
     * msg : success
     * code : 0
     * page : {"totalCount":0,"pageSize":1,"totalPage":0,"currPage":1,"list":[{"goodsId":1,"classifyId":3,"classifyName":"爆款推荐","goodsName":"手机1","goodsType":1,"deduction":100.99,"conditionNum":null,"integral":500,"expiryDate":"2019-01-05T13:30:49.000+0000","stock":98,"salesVolume":5,"collection":4,"pictureUrl":"http://pasqvoice.oss-cn-beijing.aliyuncs.com/15460333211461088562432.jpg","goodsDescription":"描述写啥呢","goodsState":0,"flag":0,"createUserId":null,"updateUserId":null,"createUserTime":"2018-12-30T04:03:22.000+0000","updateUserTime":"2018-12-30T04:03:16.000+0000"}]}
     */

    private String msg;
    private int code;
    private PageBean page;

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

    public PageBean getPage() {
        return page;
    }

    public void setPage(PageBean page) {
        this.page = page;
    }

    public static class PageBean {
        /**
         * totalCount : 0
         * pageSize : 1
         * totalPage : 0
         * currPage : 1
         * list : [{"goodsId":1,"classifyId":3,"classifyName":"爆款推荐","goodsName":"手机1","goodsType":1,"deduction":100.99,"conditionNum":null,"integral":500,"expiryDate":"2019-01-05T13:30:49.000+0000","stock":98,"salesVolume":5,"collection":4,"pictureUrl":"http://pasqvoice.oss-cn-beijing.aliyuncs.com/15460333211461088562432.jpg","goodsDescription":"描述写啥呢","goodsState":0,"flag":0,"createUserId":null,"updateUserId":null,"createUserTime":"2018-12-30T04:03:22.000+0000","updateUserTime":"2018-12-30T04:03:16.000+0000"}]
         */

        private int totalCount;
        private int pageSize;
        private int totalPage;
        private int currPage;
        private List<ListBean> list;

        public int getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(int totalCount) {
            this.totalCount = totalCount;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getTotalPage() {
            return totalPage;
        }

        public void setTotalPage(int totalPage) {
            this.totalPage = totalPage;
        }

        public int getCurrPage() {
            return currPage;
        }

        public void setCurrPage(int currPage) {
            this.currPage = currPage;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
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
             * collection : 4
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
}
