package com.rui.xb.purple.mvp.view.home;

import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.rui.xb.purple.mvp.base.BaseMVPView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/**
 * Created by Rui on 2018/7/16.
 */

public interface RequestRegionView extends BaseMVPView {

    SmartRefreshLayout getRefreshLayout();

    RecyclerView getRecyclerView();

    TextView getTvCategory();
}
