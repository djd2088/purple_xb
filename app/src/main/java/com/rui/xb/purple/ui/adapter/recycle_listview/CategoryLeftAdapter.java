package com.rui.xb.purple.ui.adapter.recycle_listview;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.rui.xb.purple.R;
import com.rui.xb.purple.ui.adapter.recycle_listview.model.CategoryLeftRightAdapterModel;

import java.util.List;

/**
 * Created by Rui on 2018/7/10.
 */

public class CategoryLeftAdapter extends BaseQuickAdapter<CategoryLeftRightAdapterModel,BaseViewHolder> {

    private int selectItem;

    public void setClickItem(int positon){
        selectItem = positon;
    }

    public CategoryLeftAdapter(int layoutResId, @Nullable List<CategoryLeftRightAdapterModel> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CategoryLeftRightAdapterModel item) {

        helper.setText(R.id.tv_name,item.getName());

    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        if (position == selectItem){
            holder.setBackgroundColor(R.id.tv_name, mContext.getResources()
                    .getColor(R.color.white));
        }else {
            holder.setBackgroundColor(R.id.tv_name,mContext.getResources()
                    .getColor(R.color.bg_gray));
        }
    }
}
