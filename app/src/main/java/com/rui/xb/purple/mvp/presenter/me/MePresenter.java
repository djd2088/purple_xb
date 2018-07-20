package com.rui.xb.purple.mvp.presenter.me;

import com.rui.xb.purple.mvp.base.BaseMVPPresenter;
import com.rui.xb.purple.mvp.model.me.MeModel;
import com.rui.xb.purple.mvp.view.me.MeView;

import javax.inject.Inject;

/**
 * Created by Rui on 2018/7/13.
 */

public class MePresenter extends BaseMVPPresenter<MeModel,MeView> {

    @Inject
    public MePresenter() {
    }
}
