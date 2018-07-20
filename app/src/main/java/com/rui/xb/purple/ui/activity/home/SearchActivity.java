package com.rui.xb.purple.ui.activity.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rui.xb.purple.R;
import com.rui.xb.purple.base.BaseActivity;
import com.rui.xb.purple.mvp.presenter.me.SearchPresenter;
import com.rui.xb.purple.mvp.view.me.SearchView;

public class SearchActivity extends BaseActivity<SearchPresenter> implements SearchView {

    @Override
    protected void initTitleBar() {
        hideTitleBar();
        transparentStatusBar(true);

    }

    @Override
    protected int initMainView() {
        return R.layout.activity_search;
    }

    @Override
    protected void initDataAndView() {

    }
}
