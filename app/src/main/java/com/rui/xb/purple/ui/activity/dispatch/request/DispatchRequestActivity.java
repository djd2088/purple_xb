package com.rui.xb.purple.ui.activity.dispatch.request;

import com.rui.xb.purple.R;
import com.rui.xb.purple.base.BaseActivity;
import com.rui.xb.purple.mvp.presenter.dispatch.RequestPresenter;

public class DispatchRequestActivity extends BaseActivity<RequestPresenter> {


    @Override
    protected void initTitleBar() {
        setTvTitleAndColor("发布求购",R.color.we_chat_black);
        leftClose();
        avoidWhiteStatusBar();
    }

    @Override
    protected int initMainView() {
        return R.layout.activity_dispatch_request;
    }

    @Override
    protected void initDataAndView() {

    }
}
