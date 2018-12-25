package com.youweihui.tourismstore.bean;

import java.util.List;

/**
 * Created by ${范泽宁} on 2018/12/17.
 */

public class HomeEntity {

    private String img;

    private String title;

    private String verticalScroll;

    private String tabTitle;

    private List<HomeTailOrderEntity> tailOrderEntity;

    private List<HomeTopEntity> topEntityList;

    private List<HomeEntity.HomeListEntity> homeListEntityList;

    public List<HomeListEntity> getHomeListEntityList() {
        return homeListEntityList;
    }

    public void setHomeListEntityList(List<HomeListEntity> homeListEntityList) {
        this.homeListEntityList = homeListEntityList;
    }

    public List<HomeTailOrderEntity> getTailOrderEntity() {
        return tailOrderEntity;
    }

    public void setTailOrderEntity(List<HomeTailOrderEntity> tailOrderEntity) {
        this.tailOrderEntity = tailOrderEntity;
    }

    public List<HomeTopEntity> getTopEntityList() {
        return topEntityList;
    }

    public void setTopEntityList(List<HomeTopEntity> topEntityList) {
        this.topEntityList = topEntityList;
    }


    public List<HomeTopEntity> getTopEntity() {
        return topEntityList;
    }

    public void setTopEntity(List<HomeTopEntity> topEntityList) {
        this.topEntityList = topEntityList;
    }

    public String getTabTitle() {
        return tabTitle;
    }

    public void setTabTitle(String tabTitle) {
        this.tabTitle = tabTitle;
    }

    public String getVerticalScroll() {
        return verticalScroll;
    }

    public void setVerticalScroll(String vertical_scroll) {
        this.verticalScroll = vertical_scroll;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public static class HomeTopEntity {

        private String img;

        private String title;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }
    }

    public static class HomeTailOrderEntity {

        private String img;

        private String title;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }
    }

    public static class HomeListEntity {

        private String img;

        private String title;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }
    }
}
