package com.rui.xb.purple.ui.activity.category;

import android.os.Bundle;
import android.widget.Toast;

import com.rui.xb.purple.R;
import com.rui.xb.purple.base.BaseActivity;
import com.rui.xb.purple.mvp.presenter.category.CategoryActivityPresenter;
import com.rui.xb.purple.mvp.view.category.CategoryActivityView;

public class CategoryActivity extends BaseActivity<CategoryActivityPresenter> implements CategoryActivityView{


    @Override
    protected void initTitleBar() {

        Bundle bundle = getBundle();
        String categoryId = bundle.getString("categoryId");
        String subId = bundle.getString("subId");
        String name = bundle.getString("categoryName");
        setTvTitle(name);
        Toast.makeText(CategoryActivity.this,categoryId + name + subId,Toast.LENGTH_SHORT).show();
//        setLlTitleBgColor(R.color.colorPrimary);
        transparentStatusBar(true);
        leftClose();
    }

    @Override
    protected int initMainView() {
        return R.layout.activity_category;
    }

    @Override
    protected void initDataAndView() {
        mPresenter.onAttachView(this,this);
    }
}
