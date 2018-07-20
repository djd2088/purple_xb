package com.rui.xb.purple.ui.adapter.recycle_listview;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.rui.xb.purple.R;
import com.rui.xb.purple.ui.adapter.recycle_listview.model.MyTradeBuyAdapterModel;

import java.util.List;

/**
 * Created by Rui on 2018/7/18.
 */

public class MyTradeBuyAdapter extends BaseQuickAdapter<MyTradeBuyAdapterModel,BaseViewHolder> {

    public MyTradeBuyAdapter(int layoutResId, @Nullable List<MyTradeBuyAdapterModel> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MyTradeBuyAdapterModel item) {

        helper.setText(R.id.tv_product_name,item.getProductName());
        helper.setText(R.id.tv_price,item.getPrice());
        helper.setText(R.id.tv_state,item.getOrderState());
    }
}
