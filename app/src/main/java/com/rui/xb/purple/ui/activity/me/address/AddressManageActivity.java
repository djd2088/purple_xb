package com.rui.xb.purple.ui.activity.me.address;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.rui.xb.purple.R;
import com.rui.xb.purple.base.BaseActivity;
import com.rui.xb.purple.mvp.presenter.me.address.AddressManagePresenter;
import com.rui.xb.purple.mvp.view.me.address.AddressManageView;
import com.rui.xb.rui_core.utils.UiUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddressManageActivity extends BaseActivity<AddressManagePresenter> implements
        AddressManageView {


    @BindView(R.id.rv_manage_address)
    RecyclerView rvManageAddress;

    @Override
    protected void initTitleBar() {
        setTvTitle("管理收货地址");
        transparentStatusBar(true);
        leftClose();
    }

    @Override
    protected int initMainView() {
        return R.layout.activity_address_manage;
    }

    @Override
    protected void initDataAndView() {
        mPresenter.onAttachView(this, this);
        mPresenter.initView();
    }

    @Override
    public RecyclerView getRvAddList() {
        return rvManageAddress;
    }


    @OnClick(R.id.ll_add_new)
    public void onViewClicked() {
        UiUtil.startIntent(AddressManageActivity.this,AddressAddActivity.class);
    }
}
