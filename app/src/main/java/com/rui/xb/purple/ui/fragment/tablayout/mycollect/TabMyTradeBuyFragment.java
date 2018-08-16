package com.rui.xb.purple.ui.fragment.tablayout.mycollect;


import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;

import com.rui.xb.purple.R;
import com.rui.xb.purple.base.BaseFragment;
import com.rui.xb.purple.mvp.presenter.me.tab.TabMyTradeBuyPresenter;
import com.rui.xb.purple.mvp.view.me.tab.TabMyTradeBuyView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabMyTradeBuyFragment extends BaseFragment<TabMyTradeBuyPresenter> implements
        TabMyTradeBuyView {


    @BindView(R.id.rv_trade_buy)
    RecyclerView rvTradeBuy;
    @BindView(R.id.refreshLayout_trade_buy)
    SmartRefreshLayout refreshLayoutTradeBuy;

    @Inject
    public TabMyTradeBuyFragment() {
        // Required empty public constructor
    }

    @Override
    protected void initTitleBar() {
        hideTitleBar();
        avoidWhiteStatusBar();
    }

    @Override
    protected int initMainView() {
        return R.layout.fragment_tab_my_trade_buy;
    }

    @Override
    protected void initDataAndView() {
        mPresenter.onAttachView(this, getActivity());
        mPresenter.initView();
    }

    @Override
    public SmartRefreshLayout getRefreshLayout() {
        return refreshLayoutTradeBuy;
    }

    @Override
    public RecyclerView getRecyclerView() {
        return rvTradeBuy;
    }

}
