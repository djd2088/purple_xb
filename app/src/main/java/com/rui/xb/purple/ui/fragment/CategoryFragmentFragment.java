package com.rui.xb.purple.ui.fragment;


import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;

import com.rui.xb.purple.R;
import com.rui.xb.purple.base.BaseFragment;
import com.rui.xb.purple.mvp.presenter.category.CategoryFragmentPresenter;
import com.rui.xb.purple.mvp.view.category.CategoryFragmentView;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragmentFragment extends BaseFragment<CategoryFragmentPresenter> implements CategoryFragmentView {

    @BindView(R.id.rv_level_left)
    RecyclerView rvCategoryLeft;

    @BindView(R.id.rv_level_right)
    RecyclerView rvCategoryRight;


    @Inject
    public CategoryFragmentFragment() {
        // Required empty public constructor
    }


    @Override
    protected void initTitleBar() {
        setTvTitleAndColor("分类", R.color.we_chat_black);
        hideIvLeft();
        transparentStatusBar(true);
    }

    @Override
    protected int initMainView() {
        return R.layout.fragment_category;
    }

    @Override
    protected void initDataAndView() {
        mPresenter.onAttachView(this,getActivity());
        mPresenter.initView();
    }

    @Override
    public RecyclerView getRvCategoryLeft() {
        return rvCategoryLeft;
    }

    @Override
    public RecyclerView getRvCategoryRight() {
        return rvCategoryRight;
    }
}
