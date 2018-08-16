package com.rui.xb.purple.ui.activity.me.address;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.rui.xb.purple.R;
import com.rui.xb.purple.base.BaseActivity;
import com.rui.xb.purple.mvp.presenter.me.address.AddressListPresenter;
import com.rui.xb.purple.mvp.view.me.address.AddressListView;
import com.rui.xb.rui_core.utils.UiUtil;

import butterknife.BindView;
import butterknife.OnClick;

public class AddressListActivity extends BaseActivity<AddressListPresenter> implements
        AddressListView {


    @BindView(R.id.rv_address)
    RecyclerView rvAddress;

    @Override
    protected void initTitleBar() {
        setTvTitle("选择收货地址");
        showTvRightSetText("管理");
        avoidWhiteStatusBar();
        leftClose();


    }

    @Override
    protected int initMainView() {
        return R.layout.activity_address_list;
    }

    @Override
    protected void initDataAndView() {
        mPresenter.onAttachView(this, this);

        getTvRight().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UiUtil.startIntent(AddressListActivity.this, AddressManageActivity.class);
            }
        });
    }

    @Override
    public RecyclerView getRvAddList() {
        return rvAddress;
    }

    @OnClick(R.id.ll_add_new)
    public void onViewClicked() {
        UiUtil.startIntent(AddressListActivity.this, AddressAddActivity.class);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.initView(this);
    }
}
