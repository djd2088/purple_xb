package com.rui.xb.purple.adapter.recycle_listview;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.rui.xb.purple.R;
import com.rui.xb.purple.adapter.recycle_listview.model.AddressListAdapterModel;

import java.util.List;

/**
 * Created by Rui on 2018/7/24.
 */

public class AddressManageAdapter extends BaseQuickAdapter<AddressListAdapterModel,BaseViewHolder> {

    public AddressManageAdapter(int layoutResId, @Nullable List<AddressListAdapterModel> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, AddressListAdapterModel item) {

        helper.setText(R.id.tv_add_name,item.getName());
        helper.setText(R.id.tv_add_phone,item.getPhone());
        helper.setText(R.id.tv_add_detail,item.getProvince() + item.getLocation());
        if (item.isDefault()){
            ImageView ivSetDefault = helper.getView(R.id.iv_set_default);
            ivSetDefault.setImageResource(R.mipmap.selected_yes);
        }
        //helper.addOnClickListener(R.id.ll_set_default);
        helper.addOnClickListener(R.id.ll_edit);
        helper.addOnClickListener(R.id.ll_delete);


    }
}
