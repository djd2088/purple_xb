package com.rui.xb.purple.mvp.view.category;

import android.support.v7.widget.RecyclerView;

import com.rui.xb.purple.mvp.base.BaseMVPView;

/**
 * Created by Rui on 2018/7/10.
 */

public interface CategoryFragmentView extends BaseMVPView {

    RecyclerView getRvCategoryLeft();

    RecyclerView getRvCategoryRight();
}
