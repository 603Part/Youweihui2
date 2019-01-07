package com.youweihui.tourismstore.bean;

import java.util.List;

/**
 * Created by ${范泽宁} on 2019/1/3.
 */

public class SpecialBean {


    /**
     * msg : success
     * code : 0
     * data : {"featureName":"圣诞专题","featureTitleList":[{"productClassifyId":4,"titleName":"圣诞小标题1","titleId":1,"procuctList":[{"productClassifyId":4,"productId":1,"pictureUrl":null,"productSubtitle":null,"productName":"非洲第一大峡谷鱼河峡谷","productType":1,"productPrice":null},{"productClassifyId":4,"productId":2,"pictureUrl":null,"productSubtitle":null,"productName":"中国长城","productType":1,"productPrice":null}]},{"productClassifyId":6,"titleName":"圣诞小标题2","titleId":2,"procuctList":[{"productClassifyId":6,"productId":3,"pictureUrl":null,"productSubtitle":null,"productName":"悉尼歌剧院","productType":2,"productPrice":null}]},{"productClassifyId":1,"titleName":"圣诞小标题3","titleId":3,"procuctList":[]}],"featureUrl":"1","featureId":1,"picture":"http://lfjoss.oss-cn-hangzhou.aliyuncs.com/temp/20190105/41858f5a217a4c57b023a1634731021d.jpg"}
     */

    private String msg;
    private int code;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * featureName : 圣诞专题
         * featureTitleList : [{"productClassifyId":4,"titleName":"圣诞小标题1","titleId":1,"procuctList":[{"productClassifyId":4,"productId":1,"pictureUrl":null,"productSubtitle":null,"productName":"非洲第一大峡谷鱼河峡谷","productType":1,"productPrice":null},{"productClassifyId":4,"productId":2,"pictureUrl":null,"productSubtitle":null,"productName":"中国长城","productType":1,"productPrice":null}]},{"productClassifyId":6,"titleName":"圣诞小标题2","titleId":2,"procuctList":[{"productClassifyId":6,"productId":3,"pictureUrl":null,"productSubtitle":null,"productName":"悉尼歌剧院","productType":2,"productPrice":null}]},{"productClassifyId":1,"titleName":"圣诞小标题3","titleId":3,"procuctList":[]}]
         * featureUrl : 1
         * featureId : 1
         * picture : http://lfjoss.oss-cn-hangzhou.aliyuncs.com/temp/20190105/41858f5a217a4c57b023a1634731021d.jpg
         */

        private String featureName;
        private String featureUrl;
        private int featureId;
        private String picture;
        private List<FeatureTitleListBean> featureTitleList;

        public String getFeatureName() {
            return featureName;
        }

        public void setFeatureName(String featureName) {
            this.featureName = featureName;
        }

        public String getFeatureUrl() {
            return featureUrl;
        }

        public void setFeatureUrl(String featureUrl) {
            this.featureUrl = featureUrl;
        }

        public int getFeatureId() {
            return featureId;
        }

        public void setFeatureId(int featureId) {
            this.featureId = featureId;
        }

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }

        public List<FeatureTitleListBean> getFeatureTitleList() {
            return featureTitleList;
        }

        public void setFeatureTitleList(List<FeatureTitleListBean> featureTitleList) {
            this.featureTitleList = featureTitleList;
        }

        public static class FeatureTitleListBean {
            /**
             * productClassifyId : 4
             * titleName : 圣诞小标题1
             * titleId : 1
             * procuctList : [{"productClassifyId":4,"productId":1,"pictureUrl":null,"productSubtitle":null,"productName":"非洲第一大峡谷鱼河峡谷","productType":1,"productPrice":null},{"productClassifyId":4,"productId":2,"pictureUrl":null,"productSubtitle":null,"productName":"中国长城","productType":1,"productPrice":null}]
             */

            private int productClassifyId;
            private String titleName;
            private int titleId;
            private List<ProcuctListBean> procuctList;

            public int getProductClassifyId() {
                return productClassifyId;
            }

            public void setProductClassifyId(int productClassifyId) {
                this.productClassifyId = productClassifyId;
            }

            public String getTitleName() {
                return titleName;
            }

            public void setTitleName(String titleName) {
                this.titleName = titleName;
            }

            public int getTitleId() {
                return titleId;
            }

            public void setTitleId(int titleId) {
                this.titleId = titleId;
            }

            public List<ProcuctListBean> getProcuctList() {
                return procuctList;
            }

            public void setProcuctList(List<ProcuctListBean> procuctList) {
                this.procuctList = procuctList;
            }

            public static class ProcuctListBean {
                /**
                 * productClassifyId : 4
                 * productId : 1
                 * pictureUrl : null
                 * productSubtitle : null
                 * productName : 非洲第一大峡谷鱼河峡谷
                 * productType : 1
                 * productPrice : null
                 */

                private int productClassifyId;
                private int productId;
                private Object pictureUrl;
                private Object productSubtitle;
                private String productName;
                private int productType;
                private Object productPrice;

                public int getProductClassifyId() {
                    return productClassifyId;
                }

                public void setProductClassifyId(int productClassifyId) {
                    this.productClassifyId = productClassifyId;
                }

                public int getProductId() {
                    return productId;
                }

                public void setProductId(int productId) {
                    this.productId = productId;
                }

                public Object getPictureUrl() {
                    return pictureUrl;
                }

                public void setPictureUrl(Object pictureUrl) {
                    this.pictureUrl = pictureUrl;
                }

                public Object getProductSubtitle() {
                    return productSubtitle;
                }

                public void setProductSubtitle(Object productSubtitle) {
                    this.productSubtitle = productSubtitle;
                }

                public String getProductName() {
                    return productName;
                }

                public void setProductName(String productName) {
                    this.productName = productName;
                }

                public int getProductType() {
                    return productType;
                }

                public void setProductType(int productType) {
                    this.productType = productType;
                }

                public Object getProductPrice() {
                    return productPrice;
                }

                public void setProductPrice(Object productPrice) {
                    this.productPrice = productPrice;
                }
            }
        }
    }
}
