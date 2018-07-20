package com.rui.xb.purple.ui.adapter.recycle_listview;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.rui.xb.purple.R;
import com.rui.xb.purple.ui.adapter.recycle_listview.model.MyDispatchAdapterModel;
import com.rui.xb.purple.ui.adapter.recycle_listview.model.ProductAdapterModel;

import java.util.List;

/**
 * Created by Rui on 2018/7/16.
 */

public class MyDispatchAdapter extends BaseQuickAdapter<ProductAdapterModel,BaseViewHolder> {


    public MyDispatchAdapter(int layoutResId, @Nullable List<ProductAdapterModel> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ProductAdapterModel item) {
        helper.setText(R.id.tv_name,item.getProductName());
        helper.setText(R.id.tv_brows,String.format("浏览：%1s",item.getBrows()));
        helper.setText(R.id.tv_note,String.format("留言：%1s",item.getNotes()));
        helper.setText(R.id.tv_price,String.format("￥：%1s",item.getPrice()));
        helper.addOnClickListener(R.id.tv_share);
        helper.addOnClickListener(R.id.tv_edit);
        helper.addOnClickListener(R.id.tv_delete);
    }
}
