package com.rui.xb.purple.mvp.presenter.home;

import android.view.View;
import android.widget.Toast;

import com.rui.xb.purple.base.BaseResponseModel;
import com.rui.xb.purple.mvp.base.BaseMVPPresenter;
import com.rui.xb.purple.mvp.model.home.OrderDetailModel;
import com.rui.xb.purple.mvp.view.home.OrderDetailView;

import java.util.Map;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;

/**
 * Created by Rui on 2018/7/19.
 */

public class OrderDetailPresenter extends BaseMVPPresenter<OrderDetailModel,OrderDetailView> {

    @Inject
    public OrderDetailPresenter() {
    }

    private String productID;

    private String addressId;

    private String address;

    private String number;

    private int type = 2;


    public void initView(String productId, String buyNum){
        productID = productId;
        number = buyNum;
        confirmOrder(productId, buyNum);

        mView.getTvSubmitOrder().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mModule.requestSubmitOrder(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        Toast.makeText(mContext,"提交成功",Toast.LENGTH_SHORT).show();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                    }
                },"1",productID,"1","123",type,number);
            }
        });
    }



    private void confirmOrder(String productId, String buyNum) {
        mModule.requestConfirmOrder(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                BaseResponseModel model = gsonSingle.fromJson(s,BaseResponseModel.class);
                if (model.getCode() == 1){
                    Map<String,Object> data = (Map<String, Object>) model.getData();
                    Map<String,Object> productInfo = (Map<String, Object>) data.get("productInfo");
                    mView.getProName().setText(productInfo.get("productName").toString());
//                    productInfo.get("mainPic").toString();
                    mView.getProPrice().setText(String.format("￥ : %1s",productInfo.get("price").toString()));
                    mView.getTvRealPrice().setText(String.format("￥ : %1s",data.get("totalFee").toString()));
                    mView.getTvTfee().setText(String.format("￥ : %1s",data.get("freight").toString
                            ()));
                }
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {

            }
        },productId,buyNum);
    }


    public void setAddress(String addId,String phoneAndName,String addDetail){
        addressId = addId;
        address = addDetail;

        mView.getTvPhoneAndName().setText(phoneAndName);
        mView.getTvAdd().setText(addDetail);

    }

}
