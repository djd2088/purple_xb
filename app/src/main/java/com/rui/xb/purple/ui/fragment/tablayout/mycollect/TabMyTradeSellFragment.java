package com.rui.xb.purple.ui.fragment.tablayout.mycollect;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rui.xb.purple.R;
import com.rui.xb.purple.base.BaseFragment;
import com.rui.xb.purple.mvp.presenter.me.tab.TabMyTradeSellPresenter;
import com.rui.xb.purple.mvp.view.me.tab.TabMyTradeSellView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabMyTradeSellFragment extends BaseFragment<TabMyTradeSellPresenter> implements
        TabMyTradeSellView {


    @BindView(R.id.rv_trade_sell)
    RecyclerView rvTradeSell;
    @BindView(R.id.refreshLayout_trade_sell)
    SmartRefreshLayout refreshLayoutTradeSell;

    @Inject
    public TabMyTradeSellFragment() {
        // Required empty public constructor
    }


    @Override
    protected void initTitleBar() {
        hideTitleBar();
        transparentStatusBar(true);
    }

    @Override
    protected int initMainView() {
        return R.layout.fragment_tab_my_trade_sell;
    }

    @Override
    protected void initDataAndView() {
        mPresenter.onAttachView(this, getActivity());
        mPresenter.initView();
    }

    @Override
    public SmartRefreshLayout getRefreshLayout() {
        return refreshLayoutTradeSell;
    }

    @Override
    public RecyclerView getRecyclerView() {
        return rvTradeSell;
    }
}
