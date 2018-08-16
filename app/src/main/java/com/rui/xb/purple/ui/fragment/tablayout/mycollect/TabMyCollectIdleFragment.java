package com.rui.xb.purple.ui.fragment.tablayout.mycollect;


import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;

import com.rui.xb.purple.R;
import com.rui.xb.purple.base.BaseFragment;
import com.rui.xb.purple.mvp.presenter.me.tab.TabMyCollectIdlePresenter;
import com.rui.xb.purple.mvp.view.me.tab.TabMyCollectIdleView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabMyCollectIdleFragment extends BaseFragment<TabMyCollectIdlePresenter> implements
        TabMyCollectIdleView {


    @BindView(R.id.rv_collect_idle)
    RecyclerView rvCollectIdle;
    @BindView(R.id.refreshLayout_collect_idle)
    SmartRefreshLayout refreshLayoutCollectIdle;

    @Inject
    public TabMyCollectIdleFragment() {
        // Required empty public constructor
    }


    @Override
    protected void initTitleBar() {
        hideTitleBar();
        avoidWhiteStatusBar();
    }

    @Override
    protected int initMainView() {
        return R.layout.fragment_tab_my_collect_idle;
    }

    @Override
    protected void initDataAndView() {
        mPresenter.onAttachView(this, getActivity());
        mPresenter.initView();

    }

    @Override
    public SmartRefreshLayout getRefreshLayout() {
        return refreshLayoutCollectIdle;
    }

    @Override
    public RecyclerView getRecyclerView() {
        return rvCollectIdle;
    }
}
