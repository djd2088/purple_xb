package com.rui.xb.purple.ui.activity.home;

import com.rui.xb.purple.R;
import com.rui.xb.purple.base.BaseNoTitleActivity;
import com.rui.xb.purple.mvp.presenter.me.SearchPresenter;
import com.rui.xb.purple.mvp.view.me.SearchView;

public class SearchActivity extends BaseNoTitleActivity<SearchPresenter> implements SearchView {


    @Override
    protected int initMainView() {
        return R.layout.activity_search;
    }

    @Override
    protected void initDataAndView() {
        transparentStatusBar(true);

    }
}
