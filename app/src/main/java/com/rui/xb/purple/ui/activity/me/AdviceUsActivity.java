package com.rui.xb.purple.ui.activity.me;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rui.xb.purple.R;
import com.rui.xb.purple.base.BaseActivity;
import com.rui.xb.purple.mvp.presenter.me.AdviceUsPresenter;
import com.rui.xb.purple.mvp.view.me.AdviceUsView;

public class AdviceUsActivity extends BaseActivity<AdviceUsPresenter> implements AdviceUsView {

    @Override
    protected void initTitleBar() {
        setTvTitle("意见反馈");
        transparentStatusBar(true);
        leftClose();
    }

    @Override
    protected int initMainView() {
        return R.layout.activity_advice_us;
    }

    @Override
    protected void initDataAndView() {

    }
}
