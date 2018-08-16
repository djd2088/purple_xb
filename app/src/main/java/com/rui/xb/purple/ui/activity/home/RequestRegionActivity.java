package com.rui.xb.purple.ui.activity.home;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.rui.xb.purple.R;
import com.rui.xb.purple.base.BaseActivity;
import com.rui.xb.purple.mvp.presenter.home.RequestRegionPresenter;
import com.rui.xb.purple.mvp.view.home.RequestRegionView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RequestRegionActivity extends BaseActivity<RequestRegionPresenter> implements
        RequestRegionView {


    @BindView(R.id.tv_category)
    TextView tvCategory;
    @BindView(R.id.rv_my_request_list)
    RecyclerView rvMyRequestList;
    @BindView(R.id.refreshLayout_request_list)
    SmartRefreshLayout refreshLayoutRequestList;

    @Override
    protected void initTitleBar() {
        setTvTitle("求购专区");
        avoidWhiteStatusBar();
        leftClose();
    }

    @Override
    protected int initMainView() {
        return R.layout.activity_request_region;
    }

    @Override
    protected void initDataAndView() {
        mPresenter.onAttachView(this,this);
        mPresenter.initView();
    }

    @Override
    public SmartRefreshLayout getRefreshLayout() {
        return refreshLayoutRequestList;
    }

    @Override
    public RecyclerView getRecyclerView() {
        return rvMyRequestList;
    }

    @Override
    public TextView getTvCategory() {
        return tvCategory;
    }

}
