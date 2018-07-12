package com.rui.xb.purple.mvp.presenter.dispatch;

import com.rui.xb.purple.mvp.base.BaseMVPPresenter;
import com.rui.xb.purple.mvp.model.dispatch.DispatchModel;
import com.rui.xb.purple.mvp.view.dispatch.DispatchView;

import javax.inject.Inject;

/**
 * Created by Rui on 2018/7/5.
 */

public class DispatchPresenter extends BaseMVPPresenter<DispatchModel,DispatchView> {

    @Inject
    public DispatchPresenter() {
    }
}
