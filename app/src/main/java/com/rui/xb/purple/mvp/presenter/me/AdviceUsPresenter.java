package com.rui.xb.purple.mvp.presenter.me;

import com.rui.xb.purple.mvp.base.BaseMVPPresenter;
import com.rui.xb.purple.mvp.model.me.AdviceUsModel;
import com.rui.xb.purple.mvp.model.me.JoinUsModel;
import com.rui.xb.purple.mvp.view.me.AdviceUsView;
import com.rui.xb.purple.mvp.view.me.JoinUsView;

import javax.inject.Inject;

/**
 * Created by Rui on 2018/7/16.
 */

public class AdviceUsPresenter extends BaseMVPPresenter<AdviceUsModel,AdviceUsView> {

    @Inject
    public AdviceUsPresenter() {
    }
}
