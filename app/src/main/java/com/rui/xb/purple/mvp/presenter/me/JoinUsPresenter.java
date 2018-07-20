package com.rui.xb.purple.mvp.presenter.me;

import com.rui.xb.purple.mvp.base.BaseMVPPresenter;
import com.rui.xb.purple.mvp.model.me.JoinUsModel;
import com.rui.xb.purple.mvp.model.me.SponsorUsModel;
import com.rui.xb.purple.mvp.view.me.JoinUsView;
import com.rui.xb.purple.mvp.view.me.SponsorUsView;

import javax.inject.Inject;

/**
 * Created by Rui on 2018/7/16.
 */

public class JoinUsPresenter extends BaseMVPPresenter<JoinUsModel,JoinUsView> {

    @Inject
    public JoinUsPresenter() {
    }
}
