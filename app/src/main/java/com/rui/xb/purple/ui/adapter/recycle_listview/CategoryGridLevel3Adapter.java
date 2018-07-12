package com.rui.xb.purple.ui.adapter.recycle_listview;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.rui.xb.purple.R;
import com.rui.xb.purple.ui.adapter.recycle_listview.model.CategoryLeftRightAdapterModel;

import java.util.List;

/**
 * Created by Rui on 2018/7/11.
 */

public class CategoryGridLevel3Adapter extends BaseQuickAdapter<CategoryLeftRightAdapterModel,BaseViewHolder> {

    public CategoryGridLevel3Adapter(int layoutResId, @Nullable List<CategoryLeftRightAdapterModel> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CategoryLeftRightAdapterModel item) {
        helper.setText(R.id.tv_name,item.getName());
    }
}
