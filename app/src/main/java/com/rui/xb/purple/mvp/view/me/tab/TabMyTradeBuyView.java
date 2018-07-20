package com.rui.xb.purple.mvp.view.me.tab;

import android.support.v7.widget.RecyclerView;

import com.rui.xb.purple.mvp.base.BaseMVPView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/**
 * Created by Rui on 2018/7/17.
 */

public interface TabMyTradeBuyView extends BaseMVPView {

    SmartRefreshLayout getRefreshLayout();

    RecyclerView getRecyclerView();
}
