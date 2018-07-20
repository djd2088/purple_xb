package com.rui.xb.purple.mvp.presenter.home;

import com.rui.xb.purple.mvp.base.BaseMVPPresenter;
import com.rui.xb.purple.mvp.model.home.OrderDetailModel;
import com.rui.xb.purple.mvp.view.home.OrderDetailView;

import javax.inject.Inject;

/**
 * Created by Rui on 2018/7/19.
 */

public class OrderDetailPresenter extends BaseMVPPresenter<OrderDetailModel,OrderDetailView> {

    @Inject
    public OrderDetailPresenter() {
    }
}
