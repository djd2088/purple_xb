package com.rui.xb.purple.mvp.presenter.me.address;

import android.app.Activity;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.blankj.utilcode.util.StringUtils;
import com.rui.xb.purple.base.BaseResponseEntity;
import com.rui.xb.purple.mvp.base.BaseMVPPresenter;
import com.rui.xb.purple.mvp.model.me.address.AddressAddModel;
import com.rui.xb.purple.mvp.view.me.address.AddressAddView;
import com.rui.xb.purple.adapter.recycle_listview.model.AddressListAdapterModel;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;

/**
 * Created by Rui on 2018/7/13.
 */

public class AddressAddPresenter extends BaseMVPPresenter<AddressAddModel, AddressAddView> {

    @Inject
    public AddressAddPresenter() {
    }

    private EditText etName;
    private EditText etPhone;
    private EditText etLocation;
    private TextView tvProvince;
    private ToggleButton tbSetDefault;

    private boolean isNew = true;
    private boolean isDefault;
    private String receiveId;

    public void initView(AddressListAdapterModel address) {
        bindView();
        initDataIsEdit(address);
        initListener();
    }

    private void initListener() {
        mView.getTbSetDefault().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    isDefault = true;
                }else {
                    isDefault = false;
                }
            }
        });
    }

    private void initDataIsEdit(AddressListAdapterModel address) {
        if (address != null) {
            isNew = false;
            etName.setText(address.getName());
            etPhone.setText(address.getPhone());
            etLocation.setText(address.getLocation());
            tvProvince.setText(address.getProvince());
            receiveId = address.getId();
            isDefault = address.isDefault();
            tbSetDefault.setChecked(isDefault);
        }
    }

    private void bindView() {
        etName = mView.getEtReceiveName();
        etPhone = mView.getEtPhone();
        etLocation = mView.getEtLocation();
        tvProvince = mView.getTvProvince();
        tbSetDefault = mView.getTbSetDefault();
    }


    public void saveNewOrEdit(final Activity activity) {
        String name = etName.getText().toString();
        String phone = etPhone.getText().toString();
        String province = tvProvince.getText().toString();
        String location = etLocation.getText().toString();
        isDefault = tbSetDefault.isChecked();

        if (StringUtils.isTrimEmpty(name) || StringUtils.isTrimEmpty(province) || StringUtils
                .isTrimEmpty(location) || phone.length() != 11) {
            Toast.makeText(mContext, "请填写完整正确信息", Toast.LENGTH_SHORT).show();
            return;
        }

        if (isNew) {
            mModule.requestAddOrDeleteNewAdd(new Consumer<String>() {
                @Override
                public void accept(String s) throws Exception {
                    BaseResponseEntity model = gsonSingle.fromJson(s, BaseResponseEntity.class);
                    if (model.getCode() == 1) {
                        Toast.makeText(mContext, "操作成功", Toast.LENGTH_SHORT).show();
                        activity.finish();
                    } else {
                        Toast.makeText(mContext, model.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            }, new Consumer<Throwable>() {
                @Override
                public void accept(Throwable throwable) throws Exception {

                }
            }, 1, name, phone, province, location, null, isDefault);
        } else {  //edit
            mModule.requestAddressEdit(new Consumer<String>() {
                @Override
                public void accept(String s) throws Exception {
                    BaseResponseEntity model = gsonSingle.fromJson(s, BaseResponseEntity.class);
                    if (model.getCode() == 1) {
                        Toast.makeText(mContext, "操作成功", Toast.LENGTH_SHORT).show();
                        activity.finish();
                    } else {
                        Toast.makeText(mContext, model.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            }, new Consumer<Throwable>() {
                @Override
                public void accept(Throwable throwable) throws Exception {
                }
            }, name, phone, province, location, receiveId, isDefault);
        }

    }


}
