package com.rui.xb.purple.mvp.presenter.me;

import com.rui.xb.purple.mvp.base.BaseMVPPresenter;
import com.rui.xb.purple.mvp.model.me.MyRequestModel;
import com.rui.xb.purple.mvp.model.me.MyTradeModel;
import com.rui.xb.purple.mvp.view.me.MyRequestView;
import com.rui.xb.purple.mvp.view.me.MyTradeView;

import javax.inject.Inject;

/**
 * Created by Rui on 2018/7/14.
 */

public class MyTradePresenter extends BaseMVPPresenter<MyTradeModel,MyTradeView> {

    @Inject
    public MyTradePresenter() {
    }
}
