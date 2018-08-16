package com.rui.xb.purple.ui.activity.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.rui.xb.purple.R;
import com.rui.xb.purple.base.BaseNoTitleActivity;
import com.rui.xb.purple.mvp.presenter.me.SearchPresenter;
import com.rui.xb.purple.mvp.view.me.SearchView;

import qiu.niorgai.StatusBarCompat;

public class SearchActivity extends BaseNoTitleActivity<SearchPresenter> implements SearchView {


    @Override
    protected int initMainView() {
        return R.layout.activity_search;
    }

    @Override
    protected void initDataAndView() {
        avoidWhiteStatusBar();

    }
}
