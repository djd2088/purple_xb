package com.rui.xb.purple.ui.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.rui.xb.purple.R;
import com.rui.xb.purple.ui.adapter.model.ProductAdapterModel;

import java.util.List;

/**
 * Created by Rui on 2018/7/4.
 */

public class ProductAdapter extends BaseQuickAdapter<ProductAdapterModel,BaseViewHolder> {


    public ProductAdapter(int layoutResId, @Nullable List<ProductAdapterModel> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ProductAdapterModel item) {
//        helper.setText(R.id.iv_main_pic,item.getImageUrl());
        helper.setText(R.id.tv_price,item.getPrice());
        helper.setText(R.id.tv_brows,item.getBrows());
        helper.setText(R.id.tv_product_name,item.getProductName());
        helper.setText(R.id.tv_school_name,item.getSchoolName());
    }
}
