package com.youweihui.tourismstore.bean;

import java.util.List;

/**
 * Created by ${范泽宁} on 2019/1/3.
 */

public class ForumTabBean {

    /**
     * msg : success
     * code : 0
     * data : [{"id":6,"classifyName":"二级分类1","parentId":1,"level":2,"sort":1,"display":0,"navDisplay":0,"keyword":"二级分类1","flag":0,"createUserId":null,"updateUserId":null,"createUserTime":"2018-12-29T15:25:08.000+0000","updateUserTime":"2018-12-29T15:25:11.000+0000"},{"id":7,"classifyName":"游记-二级","parentId":3,"level":2,"sort":1,"display":0,"navDisplay":0,"keyword":"游记-二级分类","flag":0,"createUserId":null,"updateUserId":null,"createUserTime":"2018-12-29T15:25:08.000+0000","updateUserTime":"2018-12-29T15:25:11.000+0000"}]
     */

    private String msg;
    private int code;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 6
         * classifyName : 二级分类1
         * parentId : 1
         * level : 2
         * sort : 1
         * display : 0
         * navDisplay : 0
         * keyword : 二级分类1
         * flag : 0
         * createUserId : null
         * updateUserId : null
         * createUserTime : 2018-12-29T15:25:08.000+0000
         * updateUserTime : 2018-12-29T15:25:11.000+0000
         */

        private int id;
        private String classifyName;
        private int parentId;
        private int level;
        private int sort;
        private int display;
        private int navDisplay;
        private String keyword;
        private int flag;
        private Object createUserId;
        private Object updateUserId;
        private String createUserTime;
        private String updateUserTime;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getClassifyName() {
            return classifyName;
        }

        public void setClassifyName(String classifyName) {
            this.classifyName = classifyName;
        }

        public int getParentId() {
            return parentId;
        }

        public void setParentId(int parentId) {
            this.parentId = parentId;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public int getDisplay() {
            return display;
        }

        public void setDisplay(int display) {
            this.display = display;
        }

        public int getNavDisplay() {
            return navDisplay;
        }

        public void setNavDisplay(int navDisplay) {
            this.navDisplay = navDisplay;
        }

        public String getKeyword() {
            return keyword;
        }

        public void setKeyword(String keyword) {
            this.keyword = keyword;
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
