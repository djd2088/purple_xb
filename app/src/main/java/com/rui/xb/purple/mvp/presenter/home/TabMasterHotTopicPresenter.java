package com.rui.xb.purple.mvp.presenter.home;

import com.rui.xb.purple.mvp.base.BaseMVPPresenter;
import com.rui.xb.purple.mvp.model.home.TabMasterHotTopicModel;
import com.rui.xb.purple.mvp.model.home.TabMasterRegionModel;
import com.rui.xb.purple.mvp.view.home.TabMasterHotTopicView;
import com.rui.xb.purple.mvp.view.home.TabMasterRegionView;

import javax.inject.Inject;

/**
 * Created by Rui on 2018/7/19.
 */

public class TabMasterHotTopicPresenter extends BaseMVPPresenter<TabMasterHotTopicModel,TabMasterHotTopicView> {

    @Inject
    public TabMasterHotTopicPresenter() {
    }
}
