package com.rui.xb.purple.ui.fragment.tablayout.mycollect;


import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;

import com.rui.xb.purple.R;
import com.rui.xb.purple.base.BaseFragment;
import com.rui.xb.purple.mvp.presenter.me.tab.TabMyCollectRequestPresenter;
import com.rui.xb.purple.mvp.view.me.tab.TabMyCollectRequestView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabMyCollectRequestFragment extends BaseFragment<TabMyCollectRequestPresenter>
        implements TabMyCollectRequestView {


    @BindView(R.id.rv_collect_request)
    RecyclerView rvCollectRequest;
    @BindView(R.id.refreshLayout_collect_request)
    SmartRefreshLayout refreshLayoutCollectRequest;

    @Inject
    public TabMyCollectRequestFragment() {
        // Required empty public constructor
    }


    @Override
    protected void initTitleBar() {
        hideTitleBar();
        transparentStatusBar(true);
    }

    @Override
    protected int initMainView() {
        return R.layout.fragment_tab_my_collect_request;
    }

    @Override
    protected void initDataAndView() {
        mPresenter.onAttachView(this, getActivity());
        mPresenter.initView();
    }

    @Override
    public SmartRefreshLayout getRefreshLayout() {
        return refreshLayoutCollectRequest;
    }

    @Override
    public RecyclerView getRecyclerView() {
        return rvCollectRequest;
    }

}
