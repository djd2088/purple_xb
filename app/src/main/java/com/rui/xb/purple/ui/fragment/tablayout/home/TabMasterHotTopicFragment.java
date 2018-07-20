package com.rui.xb.purple.ui.fragment.tablayout.home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rui.xb.purple.R;
import com.rui.xb.purple.base.BaseFragment;
import com.rui.xb.purple.mvp.presenter.home.TabMasterHotTopicPresenter;
import com.rui.xb.purple.mvp.view.home.TabMasterHotTopicView;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabMasterHotTopicFragment extends BaseFragment<TabMasterHotTopicPresenter>
        implements TabMasterHotTopicView {


    @Inject
    public TabMasterHotTopicFragment() {
        // Required empty public constructor
    }


    @Override
    protected void initTitleBar() {
        hideTitleBar();
        transparentStatusBar(true);
    }

    @Override
    protected int initMainView() {
        return R.layout.fragment_tab_master_hot_topic;
    }

    @Override
    protected void initDataAndView() {

    }

}
