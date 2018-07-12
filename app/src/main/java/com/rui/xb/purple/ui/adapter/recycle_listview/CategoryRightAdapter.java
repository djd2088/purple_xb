package com.rui.xb.purple.ui.adapter.recycle_listview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.rui.xb.purple.R;
import com.rui.xb.purple.ui.activity.category.CategoryActivity;
import com.rui.xb.purple.ui.adapter.recycle_listview.model.CategoryLeftRightAdapterModel;
import com.rui.xb.rui_core.utils.UiUtil;

import java.util.List;

/**
 * Created by Rui on 2018/7/10.
 */

public class CategoryRightAdapter extends BaseQuickAdapter<CategoryLeftRightAdapterModel,BaseViewHolder> {

    public CategoryRightAdapter(int layoutResId, @Nullable List<CategoryLeftRightAdapterModel> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, final CategoryLeftRightAdapterModel item) {
        helper.setText(R.id.tv_category_title,item.getName());
        RecyclerView rvLevel3 = helper.getView(R.id.rv_level3);
        rvLevel3.setLayoutManager(new GridLayoutManager(mContext,3));
        CategoryGridLevel3Adapter adapter = new CategoryGridLevel3Adapter(R.layout
                .item_category_left,item.getSubClass());
        rvLevel3.setAdapter(adapter);
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Bundle data = new Bundle();
                data.putString("categoryId",item.getId());
                data.putString("categoryName",item.getName());
                data.putString("subId",item.getSubClass().get(position).getId());
                UiUtil.startIntent(mContext, CategoryActivity.class,data);
            }
        });
    }
}
