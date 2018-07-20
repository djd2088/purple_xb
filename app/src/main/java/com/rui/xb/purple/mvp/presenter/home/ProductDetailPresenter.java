package com.rui.xb.purple.mvp.presenter.home;

import com.rui.xb.purple.R;
import com.rui.xb.purple.mvp.base.BaseMVPPresenter;
import com.rui.xb.purple.mvp.model.home.ProductDetailModel;
import com.rui.xb.purple.mvp.view.home.ProductDetailView;
import com.rui.xb.purple.utils.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Rui on 2018/7/18.
 */

public class ProductDetailPresenter extends BaseMVPPresenter<ProductDetailModel,ProductDetailView> {


    @Inject
    public ProductDetailPresenter() {
    }



    public void initView(){
        initBanner(mView.getBanner());
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
