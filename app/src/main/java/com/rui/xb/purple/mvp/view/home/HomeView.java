package com.rui.xb.purple.mvp.view.home;

import android.support.v7.widget.RecyclerView;

import com.rui.xb.purple.mvp.base.BaseMVPView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.youth.banner.Banner;

/**
 * Created by Rui on 2018/7/4.
 */

public interface HomeView extends BaseMVPView {


    RecyclerView getRvProduct();

    SmartRefreshLayout getSmartRefresh();
}
