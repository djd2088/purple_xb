package com.rui.xb.purple.ui.fragment.tablayout.home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.flyco.tablayout.SlidingTabLayout;
import com.rui.xb.purple.R;
import com.rui.xb.purple.base.BaseFragment;
import com.rui.xb.purple.mvp.presenter.home.TabMasterRegionPresenter;
import com.rui.xb.purple.mvp.view.home.TabMasterRegionView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabMasterRegionFragment extends BaseFragment<TabMasterRegionPresenter> implements
        TabMasterRegionView {


    @BindView(R.id.tv_category_level2)
    TextView tvCategoryLevel2;
    @BindView(R.id.tl_category_level3)
    SlidingTabLayout tlCategoryLevel3;
    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.rv_category_product)
    RecyclerView rvCategoryProduct;
    @BindView(R.id.refreshLayout_category_product)
    SmartRefreshLayout refreshLayoutCategoryProduct;

    @Inject
    public TabMasterRegionFragment() {
        // Required empty public constructor
    }


    @Override
    protected void initTitleBar() {
        hideTitleBar();
        avoidWhiteStatusBar();
    }

    @Override
    protected int initMainView() {
        return R.layout.fragment_tab_master_region;
    }

    @Override
    protected void initDataAndView() {
        mPresenter.onAttachView(this,getActivity());
        mPresenter.initView(getFragmentManager());
    }

    @Override
    public SlidingTabLayout getTabLayout() {
        return tlCategoryLevel3;
    }

    @Override
    public ViewPager getViewPage() {
        return vp;
    }

    @Override
    public RecyclerView getRvProduct() {
        return rvCategoryProduct;
    }

    @Override
    public SmartRefreshLayout getFreshLayout() {
        return refreshLayoutCategoryProduct;
    }
}
