package com.youweihui.tourismstore.bean;

import java.util.List;

/**
 * Created by ${范泽宁} on 2019/1/3.
 */

public class ForumBean {


    /**
     * msg : success
     * code : 0
     * page : {"totalCount":9,"pageSize":10,"totalPage":1,"currPage":1,"list":[{"id":1,"articleTitle":"我发布的第一篇游记","articleState":2,"articleContent":"游记内容可多大了","destinationId":1,"destinationName":"北京","departureId":2,"departureName":"石家庄","parentClassifyId":3,"classifyId":7,"keyword":null,"pictureUrl":"1.jpg","browseNum":3,"transmitNum":0,"likeNum":0,"commentNum":0,"answerNum":0,"issuer":"fxm","headUrl":null,"issuerType":2,"flag":0,"pubdate":null,"createUserId":5,"updateUserId":null,"createUserTime":"2019-01-01T07:48:50.000+0000","updateUserTime":"2019-01-01T07:48:53.000+0000"},{"id":2,"articleTitle":"我发布的第二篇游记","articleState":2,"articleContent":"游记内容可多大了2","destinationId":1,"destinationName":"北京","departureId":2,"departureName":"石家庄","parentClassifyId":3,"classifyId":7,"keyword":"","pictureUrl":"1.jpg","browseNum":3,"transmitNum":0,"likeNum":0,"commentNum":0,"answerNum":0,"issuer":"fxm","headUrl":null,"issuerType":2,"flag":0,"pubdate":"2019-01-04T03:40:44.000+0000","createUserId":5,"updateUserId":null,"createUserTime":"2019-01-01T07:48:50.000+0000","updateUserTime":"2019-01-01T07:48:53.000+0000"},{"id":3,"articleTitle":"web端发布的游记","articleState":1,"articleContent":"去了一趟云南很美","destinationId":14,"destinationName":"北京","departureId":2,"departureName":"哈尔滨","parentClassifyId":3,"classifyId":7,"keyword":null,"pictureUrl":null,"browseNum":7,"transmitNum":0,"likeNum":0,"commentNum":0,"answerNum":0,"issuer":"机器会员1","headUrl":null,"issuerType":2,"flag":0,"pubdate":null,"createUserId":null,"updateUserId":null,"createUserTime":"2019-01-06T11:02:44.000+0000","updateUserTime":"2019-01-06T11:02:44.000+0000"},{"id":4,"articleTitle":null,"articleState":1,"articleContent":"去了一趟云南很美","destinationId":14,"destinationName":"北京","departureId":2,"departureName":"哈尔滨","parentClassifyId":3,"classifyId":7,"keyword":null,"pictureUrl":null,"browseNum":0,"transmitNum":0,"likeNum":0,"commentNum":0,"answerNum":0,"issuer":"机器会员1","headUrl":null,"issuerType":2,"flag":0,"pubdate":null,"createUserId":null,"updateUserId":null,"createUserTime":"2019-01-06T11:19:39.000+0000","updateUserTime":"2019-01-06T11:19:39.000+0000"},{"id":5,"articleTitle":"web端发布的游记","articleState":1,"articleContent":"去了一趟云南很美","destinationId":14,"destinationName":"北京","departureId":null,"departureName":"哈尔滨","parentClassifyId":3,"classifyId":7,"keyword":null,"pictureUrl":"111","browseNum":0,"transmitNum":0,"likeNum":0,"commentNum":0,"answerNum":0,"issuer":"机器会员1","headUrl":null,"issuerType":2,"flag":0,"pubdate":null,"createUserId":null,"updateUserId":null,"createUserTime":"2019-01-06T11:22:04.000+0000","updateUserTime":"2019-01-06T11:22:04.000+0000"},{"id":7,"articleTitle":"web端发布的游记","articleState":1,"articleContent":"去了一趟云南很美","destinationId":14,"destinationName":"北京","departureId":2,"departureName":"哈尔滨","parentClassifyId":3,"classifyId":7,"keyword":null,"pictureUrl":"111","browseNum":0,"transmitNum":0,"likeNum":0,"commentNum":0,"answerNum":0,"issuer":"机器会员1","headUrl":null,"issuerType":2,"flag":0,"pubdate":null,"createUserId":null,"updateUserId":null,"createUserTime":"2019-01-06T11:25:52.000+0000","updateUserTime":"2019-01-06T11:25:52.000+0000"},{"id":8,"articleTitle":"web端发布的游记","articleState":2,"articleContent":"去了一趟云南很美","destinationId":14,"destinationName":"北京","departureId":2,"departureName":"哈尔滨","parentClassifyId":3,"classifyId":7,"keyword":null,"pictureUrl":"111","browseNum":0,"transmitNum":0,"likeNum":0,"commentNum":0,"answerNum":0,"issuer":"机器会员1","headUrl":null,"issuerType":2,"flag":0,"pubdate":null,"createUserId":null,"updateUserId":null,"createUserTime":"2019-01-06T11:27:10.000+0000","updateUserTime":"2019-01-06T11:27:10.000+0000"}]}
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
         * totalCount : 9
         * pageSize : 10
         * totalPage : 1
         * currPage : 1
         * list : [{"id":1,"articleTitle":"我发布的第一篇游记","articleState":2,"articleContent":"游记内容可多大了","destinationId":1,"destinationName":"北京","departureId":2,"departureName":"石家庄","parentClassifyId":3,"classifyId":7,"keyword":null,"pictureUrl":"1.jpg","browseNum":3,"transmitNum":0,"likeNum":0,"commentNum":0,"answerNum":0,"issuer":"fxm","headUrl":null,"issuerType":2,"flag":0,"pubdate":null,"createUserId":5,"updateUserId":null,"createUserTime":"2019-01-01T07:48:50.000+0000","updateUserTime":"2019-01-01T07:48:53.000+0000"},{"id":2,"articleTitle":"我发布的第二篇游记","articleState":2,"articleContent":"游记内容可多大了2","destinationId":1,"destinationName":"北京","departureId":2,"departureName":"石家庄","parentClassifyId":3,"classifyId":7,"keyword":"","pictureUrl":"1.jpg","browseNum":3,"transmitNum":0,"likeNum":0,"commentNum":0,"answerNum":0,"issuer":"fxm","headUrl":null,"issuerType":2,"flag":0,"pubdate":"2019-01-04T03:40:44.000+0000","createUserId":5,"updateUserId":null,"createUserTime":"2019-01-01T07:48:50.000+0000","updateUserTime":"2019-01-01T07:48:53.000+0000"},{"id":3,"articleTitle":"web端发布的游记","articleState":1,"articleContent":"去了一趟云南很美","destinationId":14,"destinationName":"北京","departureId":2,"departureName":"哈尔滨","parentClassifyId":3,"classifyId":7,"keyword":null,"pictureUrl":null,"browseNum":7,"transmitNum":0,"likeNum":0,"commentNum":0,"answerNum":0,"issuer":"机器会员1","headUrl":null,"issuerType":2,"flag":0,"pubdate":null,"createUserId":null,"updateUserId":null,"createUserTime":"2019-01-06T11:02:44.000+0000","updateUserTime":"2019-01-06T11:02:44.000+0000"},{"id":4,"articleTitle":null,"articleState":1,"articleContent":"去了一趟云南很美","destinationId":14,"destinationName":"北京","departureId":2,"departureName":"哈尔滨","parentClassifyId":3,"classifyId":7,"keyword":null,"pictureUrl":null,"browseNum":0,"transmitNum":0,"likeNum":0,"commentNum":0,"answerNum":0,"issuer":"机器会员1","headUrl":null,"issuerType":2,"flag":0,"pubdate":null,"createUserId":null,"updateUserId":null,"createUserTime":"2019-01-06T11:19:39.000+0000","updateUserTime":"2019-01-06T11:19:39.000+0000"},{"id":5,"articleTitle":"web端发布的游记","articleState":1,"articleContent":"去了一趟云南很美","destinationId":14,"destinationName":"北京","departureId":null,"departureName":"哈尔滨","parentClassifyId":3,"classifyId":7,"keyword":null,"pictureUrl":"111","browseNum":0,"transmitNum":0,"likeNum":0,"commentNum":0,"answerNum":0,"issuer":"机器会员1","headUrl":null,"issuerType":2,"flag":0,"pubdate":null,"createUserId":null,"updateUserId":null,"createUserTime":"2019-01-06T11:22:04.000+0000","updateUserTime":"2019-01-06T11:22:04.000+0000"},{"id":7,"articleTitle":"web端发布的游记","articleState":1,"articleContent":"去了一趟云南很美","destinationId":14,"destinationName":"北京","departureId":2,"departureName":"哈尔滨","parentClassifyId":3,"classifyId":7,"keyword":null,"pictureUrl":"111","browseNum":0,"transmitNum":0,"likeNum":0,"commentNum":0,"answerNum":0,"issuer":"机器会员1","headUrl":null,"issuerType":2,"flag":0,"pubdate":null,"createUserId":null,"updateUserId":null,"createUserTime":"2019-01-06T11:25:52.000+0000","updateUserTime":"2019-01-06T11:25:52.000+0000"},{"id":8,"articleTitle":"web端发布的游记","articleState":2,"articleContent":"去了一趟云南很美","destinationId":14,"destinationName":"北京","departureId":2,"departureName":"哈尔滨","parentClassifyId":3,"classifyId":7,"keyword":null,"pictureUrl":"111","browseNum":0,"transmitNum":0,"likeNum":0,"commentNum":0,"answerNum":0,"issuer":"机器会员1","headUrl":null,"issuerType":2,"flag":0,"pubdate":null,"createUserId":null,"updateUserId":null,"createUserTime":"2019-01-06T11:27:10.000+0000","updateUserTime":"2019-01-06T11:27:10.000+0000"}]
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
             * id : 1
             * articleTitle : 我发布的第一篇游记
             * articleState : 2
             * articleContent : 游记内容可多大了
             * destinationId : 1
             * destinationName : 北京
             * departureId : 2
             * departureName : 石家庄
             * parentClassifyId : 3
             * classifyId : 7
             * keyword : null
             * pictureUrl : 1.jpg
             * browseNum : 3
             * transmitNum : 0
             * likeNum : 0
             * commentNum : 0
             * answerNum : 0
             * issuer : fxm
             * headUrl : null
             * issuerType : 2
             * flag : 0
             * pubdate : null
             * createUserId : 5
             * updateUserId : null
             * createUserTime : 2019-01-01T07:48:50.000+0000
             * updateUserTime : 2019-01-01T07:48:53.000+0000
             */

            private int id;
            private String articleTitle;
            private int articleState;
            private String articleContent;
            private int destinationId;
            private String destinationName;
            private int departureId;
            private String departureName;
            private int parentClassifyId;
            private int classifyId;
            private Object keyword;
            private String pictureUrl;
            private int browseNum;
            private int transmitNum;
            private int likeNum;
            private int commentNum;
            private int answerNum;
            private String issuer;
            private Object headUrl;
            private int issuerType;
            private int flag;
            private Object pubdate;
            private int createUserId;
            private Object updateUserId;
            private String createUserTime;
            private String updateUserTime;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getArticleTitle() {
                return articleTitle;
            }

            public void setArticleTitle(String articleTitle) {
                this.articleTitle = articleTitle;
            }

            public int getArticleState() {
                return articleState;
            }

            public void setArticleState(int articleState) {
                this.articleState = articleState;
            }

            public String getArticleContent() {
                return articleContent;
            }

            public void setArticleContent(String articleContent) {
                this.articleContent = articleContent;
            }

            public int getDestinationId() {
                return destinationId;
            }

            public void setDestinationId(int destinationId) {
                this.destinationId = destinationId;
            }

            public String getDestinationName() {
                return destinationName;
            }

            public void setDestinationName(String destinationName) {
                this.destinationName = destinationName;
            }

            public int getDepartureId() {
                return departureId;
            }

            public void setDepartureId(int departureId) {
                this.departureId = departureId;
            }

            public String getDepartureName() {
                return departureName;
            }

            public void setDepartureName(String departureName) {
                this.departureName = departureName;
            }

            public int getParentClassifyId() {
                return parentClassifyId;
            }

            public void setParentClassifyId(int parentClassifyId) {
                this.parentClassifyId = parentClassifyId;
            }

            public int getClassifyId() {
                return classifyId;
            }

            public void setClassifyId(int classifyId) {
                this.classifyId = classifyId;
            }

            public Object getKeyword() {
                return keyword;
            }

            public void setKeyword(Object keyword) {
                this.keyword = keyword;
            }

            public String getPictureUrl() {
                return pictureUrl;
            }

            public void setPictureUrl(String pictureUrl) {
                this.pictureUrl = pictureUrl;
            }

            public int getBrowseNum() {
                return browseNum;
            }

            public void setBrowseNum(int browseNum) {
                this.browseNum = browseNum;
            }

            public int getTransmitNum() {
                return transmitNum;
            }

            public void setTransmitNum(int transmitNum) {
                this.transmitNum = transmitNum;
            }

            public int getLikeNum() {
                return likeNum;
            }

            public void setLikeNum(int likeNum) {
                this.likeNum = likeNum;
            }

            public int getCommentNum() {
                return commentNum;
            }

            public void setCommentNum(int commentNum) {
                this.commentNum = commentNum;
            }

            public int getAnswerNum() {
                return answerNum;
            }

            public void setAnswerNum(int answerNum) {
                this.answerNum = answerNum;
            }

            public String getIssuer() {
                return issuer;
            }

            public void setIssuer(String issuer) {
                this.issuer = issuer;
            }

            public Object getHeadUrl() {
                return headUrl;
            }

            public void setHeadUrl(Object headUrl) {
                this.headUrl = headUrl;
            }

            public int getIssuerType() {
                return issuerType;
            }

            public void setIssuerType(int issuerType) {
                this.issuerType = issuerType;
            }

            public int getFlag() {
                return flag;
            }

            public void setFlag(int flag) {
                this.flag = flag;
            }

            public Object getPubdate() {
                return pubdate;
            }

            public void setPubdate(Object pubdate) {
                this.pubdate = pubdate;
            }

            public int getCreateUserId() {
                return createUserId;
            }

            public void setCreateUserId(int createUserId) {
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
