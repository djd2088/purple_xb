package com.rui.xb.purple.ui.activity.category;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.widget.RadioGroup;

import com.flyco.tablayout.SlidingTabLayout;
import com.rui.xb.purple.R;
import com.rui.xb.purple.base.BaseActivity;
import com.rui.xb.purple.mvp.presenter.category.CategoryActivityPresenter;
import com.rui.xb.purple.mvp.view.category.CategoryActivityView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryActivity extends BaseActivity<CategoryActivityPresenter> implements
        CategoryActivityView {


    @BindView(R.id.tl_category_level3)
    SlidingTabLayout tlCategoryLevel3;

    @BindView(R.id.vp)
    ViewPager vp;

    @BindView(R.id.rg_sort)
    RadioGroup rgSort;

    @BindView(R.id.rv_category_product)
    RecyclerView rvCategoryProduct;

    @BindView(R.id.refreshLayout_category_product)
    SmartRefreshLayout refreshLayoutCategoryProduct;

    private String titleName;
    private String categoryId;
    private String subId;

    @Override
    protected void initTitleBar() {

        Bundle bundle = getBundle();
        categoryId = bundle.getString("categoryId");
        subId = bundle.getString("subId");
        titleName = bundle.getString("categoryName");

        setTvTitle(titleName);
        avoidWhiteStatusBar();
        leftClose();
    }

    @Override
    protected int initMainView() {
        return R.layout.activity_category;
    }

    @Override
    protected void initDataAndView() {
        mPresenter.onAttachView(this, this);
        mPresenter.initView(categoryId, subId, getSupportFragmentManager());

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
