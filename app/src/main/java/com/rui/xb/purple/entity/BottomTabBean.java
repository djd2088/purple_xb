package com.rui.xb.purple.entity;

import android.graphics.drawable.Drawable;


public final class BottomTabBean {

    private final Drawable ICON_NORMAL;
    private final String TITLE;
    private final Drawable ICON_CHOOSE;

    public BottomTabBean(String title,Drawable icon_normal, Drawable icon_choose) {
        this.ICON_NORMAL = icon_normal;
        this.TITLE = title;
        this.ICON_CHOOSE = icon_choose;
    }

    public Drawable getICON_NORMAL() {
        return ICON_NORMAL;
    }

    public String getTitle() {
        return TITLE;
    }

    public Drawable getICON_CHOOSE() {
        return ICON_CHOOSE;
    }
}
