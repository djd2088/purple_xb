package com.rui.xb.purple.ui.activity.home;

import com.rui.xb.purple.R;
import com.rui.xb.purple.base.BaseActivity;
import com.rui.xb.purple.mvp.presenter.home.OrderDetailPresenter;
import com.rui.xb.purple.mvp.view.home.OrderDetailView;

public class OrderDetailActivity extends BaseActivity<OrderDetailPresenter> implements OrderDetailView {

    @Override
    protected void initTitleBar() {
        setTvTitle("订单详情");
        transparentStatusBar(true);
        leftClose();
    }

    @Override
    protected int initMainView() {
        return R.layout.activity_order_detail;
    }

    @Override
    protected void initDataAndView() {

    }
}
