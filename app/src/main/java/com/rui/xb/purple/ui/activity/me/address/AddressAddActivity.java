package com.rui.xb.purple.ui.activity.me.address;

import com.rui.xb.purple.R;
import com.rui.xb.purple.base.BaseActivity;
import com.rui.xb.purple.mvp.presenter.me.address.AddressAddPresenter;
import com.rui.xb.purple.mvp.view.me.address.AddressAddView;

public class AddressAddActivity extends BaseActivity<AddressAddPresenter> implements AddressAddView {

    @Override
    protected void initTitleBar() {
        setTvTitle("添加收货地址");
        transparentStatusBar(true);
        leftClose();
    }

    @Override
    protected int initMainView() {
        return R.layout.activity_address_add;
    }

    @Override
    protected void initDataAndView() {

    }
}
