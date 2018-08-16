package com.rui.xb.purple.mvp.presenter.home;

import android.os.Bundle;
import android.view.View;

import com.rui.xb.purple.R;
import com.rui.xb.purple.base.BaseResponseEntity;
import com.rui.xb.purple.mvp.base.BaseMVPPresenter;
import com.rui.xb.purple.mvp.model.home.ProductDetailModel;
import com.rui.xb.purple.mvp.view.home.ProductDetailView;
import com.rui.xb.purple.ui.activity.home.OrderDetailActivity;
import com.rui.xb.purple.adapter.recycle_listview.model.ProductAdapterModel;
import com.rui.xb.purple.utils.GlideImageLoader;
import com.rui.xb.rui_core.utils.UiUtil;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;

/**
 * Created by Rui on 2018/7/18.
 */

public class ProductDetailPresenter extends BaseMVPPresenter<ProductDetailModel,ProductDetailView> {


    @Inject
    public ProductDetailPresenter() {
    }

    @Inject
    ProductAdapterModel product;

    boolean isMyself;


    public void initView(String productId){
        initBanner(mView.getBanner());
        requestDetail(productId);
    }


    public void requestDetail(final String productId){
        mModule.requestProductDetail(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                BaseResponseEntity result = gsonSingle.fromJson(s, BaseResponseEntity.class);
                if (result.getCode() == 1){
                    Map<String,Object> data = (Map<String, Object>) result.getData();
                    dealData(product, data);
                    initUi();
                }

            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {

            }
        },productId);
    }

    private void initUi() {
        mView.getTvSellerNick().setText(product.getUserInfo().getNickname());
        mView.getTvSchoolName().setText(product.getUserInfo().getSchoolName());
        mView.getTvPhone().setText(product.getUserInfo().getPhone());
        mView.getTvQq().setText(product.getUserInfo().getQq());
        mView.getTvWechat().setText(product.getUserInfo().getWechat());
        mView.getTvPrice().setText(String.format("￥ : %1s",product.getPrice()));
        mView.getTvProName().setText(product.getProductName() + " " + product.getDesc());
        mView.getTvCollectNum().setText(String.format("收藏 : %1s","88"));
        mView.getTvBrows().setText(String.format("浏览 : %1s",product.getBrows()));
        mView.getTvOnlineTime().setText(product.getOnlineTime());

        //userid对比
        if (product.getUserInfo().getId() == 1){
            mView.getBuyOrManage().setText("管理");
            isMyself = true;
        }else {
            mView.getBuyOrManage().setText("立即购买");
        }

        mView.getRlBuyOrManage().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("productId",product.getId().toString());
                bundle.putString("num","1");
                UiUtil.startIntent(mContext, OrderDetailActivity.class,bundle);
            }
        });
    }

    private void dealData(ProductAdapterModel product, Map<String, Object> data) {
        product.setAuthen((Boolean) data.get("isAuthen"));
        product.setBrows(data.get("clickCount").toString().substring(0,data.get
                ("clickCount").toString().lastIndexOf(".")));
        product.setCollect((Boolean) data.get("isCollect"));
        product.setDesc(data.get("productDesc").toString());
        product.setId((Integer.parseInt(data.get("id").toString())));
//                    product.setNotes();
        product.setOnlineTime(data.get("onlineTime").toString());
        product.setPrice(data.get("price").toString());
        product.setProductName(data.get("productName").toString());
        List<Map<String,Object>> pictures = (List<Map<String, Object>>) data.get("pictures");
        List<String> pics = new ArrayList<>();
        for (Map<String,Object> map : pictures){
            pics.add(map.get("picUrl").toString());
        }
        product.setPictures(pics);
        product.setState(data.get("state").toString());
        product.setStock(data.get("stock").toString());
        ProductAdapterModel.UserInfo userInfo = new ProductAdapterModel.UserInfo();
        Map<String,Object> user = (Map<String, Object>) data.get("sellerInfo");
        userInfo.setAuthen((Boolean) user.get("isAuthen"));
        userInfo.setAvatar(user.get("avatar").toString());
        userInfo.setId((Integer.parseInt(data.get("id").toString())));
        userInfo.setNickname(user.get("nickname").toString());
        userInfo.setPhone(user.get("phone").toString());
        userInfo.setQq(user.get("qq").toString());
        userInfo.setRealName(user.get("realName").toString());
        userInfo.setSchoolName(user.get("schoolName").toString());
        userInfo.setSex(user.get("sex").toString());
        userInfo.setWechat(user.get("wechat").toString());
        product.setUserInfo(userInfo);
    }


    private void initBanner(Banner banner){
        List<Integer> images = new ArrayList<>();
        images.add(R.mipmap.banner1);
        images.add(R.mipmap.banner2);
        images.add(R.mipmap.banner3);
        images.add(R.mipmap.banner4);
        banner.setIndicatorGravity(BannerConfig.CENTER)
                .setImageLoader(new GlideImageLoader())
                .setImages(images).start();
    }
}
