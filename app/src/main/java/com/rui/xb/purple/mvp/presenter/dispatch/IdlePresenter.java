package com.rui.xb.purple.mvp.presenter.dispatch;

import com.rui.xb.purple.mvp.base.BaseMVPPresenter;
import com.rui.xb.purple.mvp.model.dispatch.IdleModel;
import com.rui.xb.purple.mvp.view.dispatch.IdleView;

import javax.inject.Inject;

/**
 * Created by Rui on 2018/7/5.
 */

public class IdlePresenter extends BaseMVPPresenter<IdleModel,IdleView> {

    @Inject
    public IdlePresenter() {
    }
}
