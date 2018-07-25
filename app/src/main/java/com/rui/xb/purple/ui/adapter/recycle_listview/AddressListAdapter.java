package com.rui.xb.purple.ui.adapter.recycle_listview;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.rui.xb.purple.R;
import com.rui.xb.purple.ui.adapter.recycle_listview.model.AddressListAdapterModel;

import java.util.List;

/**
 * Created by Rui on 2018/7/24.
 */

public class AddressListAdapter extends BaseQuickAdapter<AddressListAdapterModel,BaseViewHolder> {

    public AddressListAdapter(int layoutResId, @Nullable List<AddressListAdapterModel> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, AddressListAdapterModel item) {

        helper.setText(R.id.tv_add_name,item.getName());
        helper.setText(R.id.tv_add_phone,item.getPhone());
        helper.setText(R.id.tv_add_detail,item.getAddress());
    }
}
