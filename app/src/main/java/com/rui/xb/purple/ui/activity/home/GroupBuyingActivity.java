package com.rui.xb.purple.ui.activity.home;

import com.rui.xb.purple.R;
import com.rui.xb.purple.base.BaseActivity;
import com.rui.xb.purple.mvp.presenter.home.GroupBuyingPresenter;
import com.rui.xb.purple.mvp.view.home.GroupBuyingView;

public class GroupBuyingActivity extends BaseActivity<GroupBuyingPresenter> implements GroupBuyingView {


    @Override
    protected void initTitleBar() {
        setTvTitle("集中采购");
        transparentStatusBar(true);
        leftClose();
    }

    @Override
    protected int initMainView() {
        return R.layout.activity_group_buying;
    }

    @Override
    protected void initDataAndView() {

    }
}
