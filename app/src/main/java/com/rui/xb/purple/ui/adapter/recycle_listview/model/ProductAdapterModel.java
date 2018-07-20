package com.rui.xb.purple.ui.adapter.recycle_listview.model;

import java.util.List;

/**
 * Created by Rui on 2018/7/4.
 */

public class ProductAdapterModel {

    private Integer id;
    private String mainPic;
    private String productName;
    private String desc;
    private String price;
    private String brows;
    private String schoolName;
    private String notes;   //留言数量
    private String onlineTime; //上架时间
    private List<String> pictures; //图片列表
    private String sellerName;
    private boolean isCollect;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMainPic() {
        return mainPic;
    }

    public void setMainPic(String mainPic) {
        this.mainPic = mainPic;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getBrows() {
        return brows;
    }

    public void setBrows(String brows) {
        this.brows = brows;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getOnlineTime() {
        return onlineTime;
    }

    public void setOnlineTime(String onlineTime) {
        this.onlineTime = onlineTime;
    }

    public List<String> getPictures() {
        return pictures;
    }

    public void setPictures(List<String> pictures) {
        this.pictures = pictures;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public boolean isCollect() {
        return isCollect;
    }

    public void setCollect(boolean collect) {
        isCollect = collect;
    }
}
