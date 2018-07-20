package com.rui.xb.purple.mvp.view.me;

import android.support.v7.widget.RecyclerView;

import com.rui.xb.purple.mvp.base.BaseMVPView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/**
 * Created by Rui on 2018/7/14.
 */

public interface MyRequestView extends BaseMVPView {

    SmartRefreshLayout getRefreshLayout();

    RecyclerView getRecyclerView();
}
