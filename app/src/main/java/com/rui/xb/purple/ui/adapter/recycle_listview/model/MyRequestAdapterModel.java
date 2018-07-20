package com.rui.xb.purple.ui.adapter.recycle_listview.model;

/**
 * Created by Rui on 2018/7/17.
 */

public class MyRequestAdapterModel {

    private String headImg;
    private String requesterName;
    private String title;
    private String desc;
    private String desirePrice;
    private String phone;
    private String time;
    private String qq;
    private String wx;
    private String schoolName;
    private boolean isCollect;
    private String type; // personal,public

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getRequesterName() {
        return requesterName;
    }

    public void setRequesterName(String requesterName) {
        this.requesterName = requesterName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDesirePrice() {
        return desirePrice;
    }

    public void setDesirePrice(String desirePrice) {
        this.desirePrice = desirePrice;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWx() {
        return wx;
    }

    public void setWx(String wx) {
        this.wx = wx;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public boolean isCollect() {
        return isCollect;
    }

    public void setCollect(boolean collect) {
        isCollect = collect;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
