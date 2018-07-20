package com.rui.xb.purple.ui.activity.me;

import com.rui.xb.purple.R;
import com.rui.xb.purple.base.BaseActivity;
import com.rui.xb.purple.mvp.presenter.me.SponsorUsPresenter;
import com.rui.xb.purple.mvp.view.me.SponsorUsView;

public class SponsorUsActivity extends BaseActivity<SponsorUsPresenter> implements SponsorUsView {


    @Override
    protected void initTitleBar() {
        setTvTitle("赞助我们");
        transparentStatusBar(true);
        leftClose();
    }

    @Override
    protected int initMainView() {
        return R.layout.activity_sponsor_us;
    }

    @Override
    protected void initDataAndView() {

    }
}
