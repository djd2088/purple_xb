package com.rui.xb.purple.ui.fragment;


import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;

import com.rui.xb.purple.R;
import com.rui.xb.purple.base.BaseFragment;
import com.rui.xb.purple.mvp.presenter.home.HomePresenter;
import com.rui.xb.purple.mvp.view.home.HomeView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.youth.banner.Banner;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment<HomePresenter> implements HomeView{


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
        showTvLeft("上海大学",R.color.white,0);
        setIvLeftRes(R.mipmap.password_hidden);
    }

    @Override
    protected int initMainView() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initDataAndView() {
        mPresenter.onAttachView(this,getActivity());
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
}
