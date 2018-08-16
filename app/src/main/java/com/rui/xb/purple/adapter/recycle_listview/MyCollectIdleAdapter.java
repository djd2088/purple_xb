package com.rui.xb.purple.adapter.recycle_listview;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.rui.xb.purple.R;
import com.rui.xb.purple.adapter.recycle_listview.model.ProductAdapterModel;

import java.util.List;

/**
 * Created by Rui on 2018/7/18.
 */

public class MyCollectIdleAdapter extends BaseQuickAdapter<ProductAdapterModel,BaseViewHolder> {

    public MyCollectIdleAdapter(int layoutResId, @Nullable List<ProductAdapterModel> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ProductAdapterModel item) {
        helper.setText(R.id.tv_seller_name,item.getUserInfo().getNickname());
        helper.setText(R.id.tv_price,item.getPrice());
        helper.setText(R.id.tv_name_and_desc,item.getProductName());
        helper.setText(R.id.tv_school_name,item.getSchoolName());
    }
}
