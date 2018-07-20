package com.rui.xb.purple.ui.adapter.recycle_listview;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.rui.xb.purple.R;
import com.rui.xb.purple.ui.adapter.recycle_listview.model.MyRequestAdapterModel;

import java.util.List;

/**
 * Created by Rui on 2018/7/17.
 */

public class MyRequestAdapter extends BaseQuickAdapter<MyRequestAdapterModel,BaseViewHolder> {


    public MyRequestAdapter(int layoutResId, @Nullable List<MyRequestAdapterModel> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MyRequestAdapterModel item) {

        helper.setText(R.id.tv_request_title,item.getTitle());
        helper.setText(R.id.tv_request_desc,item.getDesc());
        helper.setText(R.id.tv_requester_name,item.getRequesterName());
        helper.setText(R.id.tv_desire_price,item.getDesirePrice());
        helper.setText(R.id.tv_request_time,item.getTime());
        helper.setText(R.id.tv_phone,item.getPhone());
        helper.setText(R.id.tv_qq,item.getQq());
        helper.setText(R.id.tv_wx,item.getWx());
        helper.setText(R.id.tv_school_name,item.getSchoolName());
    }
}
