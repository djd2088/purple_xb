package com.rui.xb.purple.mvp.presenter.me;

import com.rui.xb.purple.mvp.base.BaseMVPPresenter;
import com.rui.xb.purple.mvp.model.me.SearchModel;
import com.rui.xb.purple.mvp.view.me.SearchView;

import javax.inject.Inject;

/**
 * Created by Rui on 2018/7/20.
 */

public class SearchPresenter extends BaseMVPPresenter<SearchModel,SearchView> {

    @Inject
    public SearchPresenter() {
    }
}
