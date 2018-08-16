package com.rui.xb.purple.mvp.presenter.home;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.rui.xb.purple.R;
import com.rui.xb.purple.base.BaseResponseEntity;
import com.rui.xb.purple.mvp.base.BaseMVPPresenter;
import com.rui.xb.purple.mvp.model.home.OrderDetailModel;
import com.rui.xb.purple.mvp.model.me.address.AddressListModel;
import com.rui.xb.purple.mvp.view.home.OrderDetailView;
import com.rui.xb.purple.adapter.recycle_listview.model.AddressListAdapterModel;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;

/**
 * Created by Rui on 2018/7/19.
 */

public class OrderDetailPresenter extends BaseMVPPresenter<OrderDetailModel, OrderDetailView> {

    @Inject
    public OrderDetailPresenter() {
    }

    @Inject
    AddressListModel addressModel;

    private String productID;

    private String addressId;

    private String address;

    private String number;

    private int type = 2; //1普通 2自提

    private AddressListAdapterModel addressEntity;

    private AlertDialog dialogTransType;

    public void initView(String productId, String buyNum) {
        productID = productId;
        number = buyNum;
        initAddress();
        confirmOrder(productId, buyNum);

        mView.getTvSubmitOrder().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (type == 2){
                    mModule.requestSubmitOrder(new Consumer<String>() {
                        @Override
                        public void accept(String s) throws Exception {
                            Toast.makeText(mContext, "提交成功", Toast.LENGTH_SHORT).show();
                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Exception {
                        }
                    }, "1", productID, "1", "123", type, number);
                }else {
                    Toast.makeText(mContext,"暂时只支持自提方式",Toast.LENGTH_LONG).show();
                }
            }
        });


    }

    private void initAddress() {
        addressModel.requestAddList(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                BaseResponseEntity model = gsonSingle.fromJson(s, BaseResponseEntity.class);
                if (model.getCode() == 1) {
                    List<Map> tempList = (List<Map>) model.getData();
                    if (tempList.size() > 0) {
                        Map<String, Object> map = tempList.get(0);
                        addressEntity = new AddressListAdapterModel();
                        addressEntity.setName(map.get("name").toString());
                        addressEntity.setPhone(map.get("phone").toString());
                        addressEntity.setId(map.get("id").toString());
                        addressEntity.setLocation(map.get("location").toString());
                        addressEntity.setProvince(map.get("province").toString());
                        mView.getTvPhoneAndName().setText(addressEntity.getName() + addressEntity
                                .getPhone());
                        mView.getTvAdd().setText(addressEntity.getProvince() + addressEntity
                                .getLocation());

                        //无地址界面hide
                    }else {
                        //无地址界面show
                    }
                }
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {

            }
        }, "2");

    }


    private void confirmOrder(String productId, String buyNum) {
        mModule.requestConfirmOrder(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                BaseResponseEntity model = gsonSingle.fromJson(s, BaseResponseEntity.class);
                if (model.getCode() == 1) {
                    Map<String, Object> data = (Map<String, Object>) model.getData();
                    Map<String, Object> productInfo = (Map<String, Object>) data.get("productInfo");
                    mView.getProName().setText(productInfo.get("productName").toString());
//                    productInfo.get("mainPic").toString();
                    mView.getProPrice().setText(String.format("￥ : %1s", productInfo.get("price")
                            .toString()));
                    mView.getTvRealPrice().setText(String.format("￥ : %1s", data.get("totalFee")
                            .toString()));
                    mView.getTvTfee().setText(String.format("￥ : %1s", data.get("freight").toString
                            ()));
                }
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {

            }
        }, productId, buyNum);
    }


    public void setAddress(String addId, String phoneAndName, String addDetail) {
        addressId = addId;
        address = addDetail;

        mView.getTvPhoneAndName().setText(phoneAndName);
        mView.getTvAdd().setText(addDetail);

    }

    public void showTransportDialog(){
        dialogTransType = new AlertDialog.Builder(mContext).create();
        dialogTransType.show();
        final Window window = dialogTransType.getWindow();
            window.setContentView(R.layout.dialog_transport_type_panel);
            window.setGravity(Gravity.BOTTOM);
            window.setWindowAnimations(R.style.anim_panel_up_from_bottom);
            window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            //设置属性
            final WindowManager.LayoutParams params = window.getAttributes();
            params.width = WindowManager.LayoutParams.MATCH_PARENT;
            params.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
            params.dimAmount = 0.5f;
            window.setAttributes(params);

            window.findViewById(R.id.btn_by_self).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mView.getTvTtype().setText("自提");
                    type = 2;
                    dialogTransType.cancel();
                }
            });
            window.findViewById(R.id.btn_pay_online).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mView.getTvTtype().setText("线上支付");
                    type = 1;
                    dialogTransType.cancel();
                }
            });
    }

}
