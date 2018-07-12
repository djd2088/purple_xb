package com.rui.xb.purple.mvp.presenter.dispatch;

import com.rui.xb.purple.mvp.base.BaseMVPPresenter;
import com.rui.xb.purple.mvp.model.dispatch.RequestModel;
import com.rui.xb.purple.mvp.view.dispatch.RequestView;

import javax.inject.Inject;

/**
 * Created by Rui on 2018/7/5.
 */

public class RequestPresenter extends BaseMVPPresenter<RequestModel,RequestView> {

    @Inject
    public RequestPresenter() {
    }
}
