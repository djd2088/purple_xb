package com.rui.xb.purple.ui.adapter.model;

import android.content.Intent;

/**
 * Created by Rui on 2018/7/4.
 */

public class ProductAdapterModel {

    private Integer id;
    private String imageUrl;
    private String productName;
    private String price;
    private String brows;
    private String schoolName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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
}
