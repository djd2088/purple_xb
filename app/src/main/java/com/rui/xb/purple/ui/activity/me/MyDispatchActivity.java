package com.rui.xb.purple.ui.activity.me;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.rui.xb.purple.R;
import com.rui.xb.purple.base.BaseActivity;
import com.rui.xb.purple.mvp.presenter.me.MyDispatchPresenter;
import com.rui.xb.purple.mvp.view.me.MyDispatchView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyDispatchActivity extends BaseActivity<MyDispatchPresenter> implements
        MyDispatchView {


    @BindView(R.id.rv_my_dispatch)
    RecyclerView rvMyDispatch;
    @BindView(R.id.refreshLayout_dispatch)
    SmartRefreshLayout refreshLayoutDispatch;

    @Override
    protected void initTitleBar() {
        setTvTitle("我的发布");
        transparentStatusBar(true);
        leftClose();

    }

    @Override
    protected int initMainView() {
        return R.layout.activity_my_dispatch;
    }

    @Override
    protected void initDataAndView() {
        mPresenter.onAttachView(this,this);
        mPresenter.initView();

    }

    @Override
    public SmartRefreshLayout getRefreshLayout() {
        return refreshLayoutDispatch;
    }

    @Override
    public RecyclerView getRecyclerView() {
        return rvMyDispatch;
    }
}
