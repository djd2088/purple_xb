package com.rui.xb.purple.ui.activity.me;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.rui.xb.purple.R;
import com.rui.xb.purple.base.BaseActivity;
import com.rui.xb.purple.mvp.presenter.me.MyRequestPresenter;
import com.rui.xb.purple.mvp.view.me.MyRequestView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyRequestActivity extends BaseActivity<MyRequestPresenter> implements MyRequestView {


    @BindView(R.id.rv_my_request)
    RecyclerView rvMyRequest;
    @BindView(R.id.refreshLayout_request)
    SmartRefreshLayout refreshLayoutRequest;

    @Override
    protected void initTitleBar() {
        setTvTitle("我的求购");
        transparentStatusBar(true);
        leftClose();
    }

    @Override
    protected int initMainView() {
        return R.layout.activity_my_request;
    }

    @Override
    protected void initDataAndView() {
        mPresenter.onAttachView(this,this);
        mPresenter.initView();

    }

    @Override
    public SmartRefreshLayout getRefreshLayout() {
        return refreshLayoutRequest;
    }

    @Override
    public RecyclerView getRecyclerView() {
        return rvMyRequest;
    }
}
