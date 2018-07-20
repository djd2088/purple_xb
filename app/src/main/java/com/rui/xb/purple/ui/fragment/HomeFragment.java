package com.rui.xb.purple.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rui.xb.purple.R;
import com.rui.xb.purple.base.BaseFragment;
import com.rui.xb.purple.mvp.presenter.home.HomePresenter;
import com.rui.xb.purple.mvp.view.home.HomeView;
import com.rui.xb.purple.ui.activity.home.SearchActivity;
import com.rui.xb.purple.zFunctionTest.ui.Test1Activity;
import com.rui.xb.rui_core.utils.UiUtil;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment<HomePresenter> implements HomeView {

    @Inject
    public HomeFragment() {
        // Required empty public constructor
    }

    @BindView(R.id.rv_product)
    RecyclerView rvProduct;

    @BindView(R.id.refreshLayout_product)
    SmartRefreshLayout refreshLayoutProduct;

    @Override
    protected void initTitleBar() {
        setLlTitleBgDrawable(R.drawable.status_bar_background);
        setTvTitle("");
        showTvLeft("上海大学", R.color.white, 0);
        setIvLeftRes(R.mipmap.password_hidden);
    }

    @Override
    protected int initMainView() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initDataAndView() {
        mPresenter.onAttachView(this, getActivity());
        mPresenter.initView();
    }

    @Override
    public RecyclerView getRvProduct() {
        return rvProduct;
    }

    @Override
    public SmartRefreshLayout getSmartRefresh() {
        return refreshLayoutProduct;
    }


    @OnClick(R.id.ll_search)
    public void onViewClicked() {
        UiUtil.startIntent(mContext, Test1Activity.class);
    }
}
