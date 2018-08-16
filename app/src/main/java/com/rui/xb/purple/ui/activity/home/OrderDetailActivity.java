package com.rui.xb.purple.ui.activity.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rui.xb.purple.R;
import com.rui.xb.purple.base.BaseActivity;
import com.rui.xb.purple.mvp.presenter.home.OrderDetailPresenter;
import com.rui.xb.purple.mvp.view.home.OrderDetailView;
import com.rui.xb.purple.ui.activity.me.address.AddressListActivity;
import com.rui.xb.rui_core.app.enums.ECommon;
import com.rui.xb.rui_core.utils.UiUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OrderDetailActivity extends BaseActivity<OrderDetailPresenter> implements
        OrderDetailView {

    @BindView(R.id.iv_product_pic)
    ImageView ivProductPic;
    @BindView(R.id.tv_product_name)
    TextView tvProductName;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.tv_name_phone)
    TextView tvNamePhone;
    @BindView(R.id.tv_add)
    TextView tvAdd;
//    @BindView(R.id.rl_add)
//    RelativeLayout rlAdd;
    @BindView(R.id.tv_t_type)
    TextView tvTType;
//    @BindView(R.id.rl_t_type)
//    RelativeLayout rlTType;
    @BindView(R.id.tv_t_fee)
    TextView tvTFee;
    @BindView(R.id.tv_real_pay)
    TextView tvRealPay;
    @BindView(R.id.tv_submit_order)
    TextView tvSubmitOrder;

    @Override
    protected void initTitleBar() {
        setTvTitle("订单详情");
        avoidWhiteStatusBar();
        leftClose();
    }

    @Override
    protected int initMainView() {
        return R.layout.activity_order_detail;
    }

    @Override
    protected void initDataAndView() {
        mPresenter.onAttachView(this, this);
        Bundle param = getBundle();
        mPresenter.initView(param.getString("productId"), param.getString("num"));


    }

    @Override
    public ImageView getProIv() {
        return ivProductPic;
    }

    @Override
    public TextView getProName() {
        return tvProductName;
    }

    @Override
    public TextView getProPrice() {
        return tvPrice;
    }

    @Override
    public TextView getTvPhoneAndName() {
        return tvNamePhone;
    }

    @Override
    public TextView getTvAdd() {
        return tvAdd;
    }

    @Override
    public TextView getTvTtype() {
        return tvTType;
    }

    @Override
    public TextView getTvTfee() {
        return tvTFee;
    }

    @Override
    public TextView getTvRealPrice() {
        return tvRealPay;
    }

    @Override
    public TextView getTvSubmitOrder() {
        return tvSubmitOrder;
    }


    @OnClick({R.id.rl_add, R.id.rl_t_type})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_add:
                UiUtil.startForResult(this, 1, AddressListActivity.class);
                break;
            case R.id.rl_t_type:
                mPresenter.showTransportDialog();
                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            Bundle bundle = data.getBundleExtra(ECommon.BUNDLE.name());
            String addId = bundle.getString("addId");
            String nameAndPhone = bundle.getString("nameAndPhone");
            String addDetail = bundle.getString("addDetail");
            mPresenter.setAddress(addId, nameAndPhone, addDetail);
        }
    }
}
