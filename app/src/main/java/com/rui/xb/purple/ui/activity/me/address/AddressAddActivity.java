package com.rui.xb.purple.ui.activity.me.address;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.rui.xb.purple.R;
import com.rui.xb.purple.adapter.recycle_listview.model.AddressListAdapterModel;
import com.rui.xb.purple.base.BaseActivity;
import com.rui.xb.purple.mvp.presenter.me.address.AddressAddPresenter;
import com.rui.xb.purple.mvp.view.me.address.AddressAddView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddressAddActivity extends BaseActivity<AddressAddPresenter> implements
        AddressAddView {

    @BindView(R.id.et_receive_name)
    EditText etReceiveName;
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.tv_province)
    TextView tvProvince;
    @BindView(R.id.et_location)
    EditText etLocation;
    @BindView(R.id.tg_btn_set_default)
    ToggleButton tgBtnSetDefault;

    private AddressListAdapterModel address;

    @Override
    protected void initTitleBar() {
        setTvTitle("添加收货地址");
        avoidWhiteStatusBar();
        leftClose();
    }

    @Override
    protected int initMainView() {
        return R.layout.activity_address_add;
    }

    @Override
    protected void initDataAndView() {
        mPresenter.onAttachView(this, this);
        Bundle bundle = getBundle();
        if (bundle != null) {
            address = (AddressListAdapterModel) getBundle().get("address");
        }
        mPresenter.initView(address);

    }

    @Override
    public EditText getEtReceiveName() {
        return etReceiveName;
    }

    @Override
    public EditText getEtPhone() {
        return etPhone;
    }

    @Override
    public EditText getEtLocation() {
        return etLocation;
    }

    @Override
    public TextView getTvProvince() {
        return tvProvince;
    }

    @Override
    public ToggleButton getTbSetDefault() {
        return tgBtnSetDefault;
    }

    @OnClick(R.id.tv_save)
    public void onViewClicked() {
        mPresenter.saveNewOrEdit(this);
    }

}
