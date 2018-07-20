package com.rui.xb.purple.ui.activity.me;

import com.rui.xb.purple.R;
import com.rui.xb.purple.base.BaseActivity;
import com.rui.xb.purple.mvp.presenter.me.SetPresenter;
import com.rui.xb.purple.mvp.view.me.SetView;

public class SetActivity extends BaseActivity<SetPresenter> implements SetView {


    @Override
    protected void initTitleBar() {
        setTvTitle("系统设置");
        transparentStatusBar(true);
        leftClose();
    }

    @Override
    protected int initMainView() {
        return R.layout.activity_set;
    }

    @Override
    protected void initDataAndView() {

    }
}
