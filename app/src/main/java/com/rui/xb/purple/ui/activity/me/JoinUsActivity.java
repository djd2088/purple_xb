package com.rui.xb.purple.ui.activity.me;

import com.rui.xb.purple.R;
import com.rui.xb.purple.base.BaseActivity;
import com.rui.xb.purple.mvp.presenter.me.JoinUsPresenter;
import com.rui.xb.purple.mvp.view.me.JoinUsView;

public class JoinUsActivity extends BaseActivity<JoinUsPresenter> implements JoinUsView {


    @Override
    protected void initTitleBar() {
        setTvTitle("加入我们");
        transparentStatusBar(true);
        leftClose();
    }

    @Override
    protected int initMainView() {
        return R.layout.activity_join_us;
    }

    @Override
    protected void initDataAndView() {

    }
}
