package com.rui.xb.purple.mvp.view.category;

import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;

import com.flyco.tablayout.SlidingTabLayout;
import com.rui.xb.purple.mvp.base.BaseMVPView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/**
 * Created by Rui on 2018/7/11.
 */

public interface CategoryActivityView extends BaseMVPView {

    SlidingTabLayout getTabLayout();

    ViewPager getViewPage();

    RecyclerView getRvProduct();

    SmartRefreshLayout getFreshLayout();
}
