package com.rui.xb.purple.ui.adapter.recycle_listview.model;

import java.util.List;
import java.util.Map;

/**
 * Created by Rui on 2018/7/4.
 */

public class CategoryLeftRightAdapterModel {

    private String id;
    private String name;
    private List<CategoryLeftRightAdapterModel> subClass;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CategoryLeftRightAdapterModel> getSubClass() {
        return subClass;
    }

    public void setSubClass(List<CategoryLeftRightAdapterModel> subClass) {
        this.subClass = subClass;
    }
}
