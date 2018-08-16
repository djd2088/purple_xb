package com.rui.xb.purple.base;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.rui.xb.purple.R;
import com.rui.xb.purple.mvp.base.BaseMVPPresenter;
import com.rui.xb.purple.mvp.base.BaseMVPView;
import com.rui.xb.purple.utils.StatusBarUtil;
import com.rui.xb.rui_core.ui.loader.RuiLoader;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.support.DaggerFragment;
import qiu.niorgai.StatusBarCompat;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseNoTitleFragment<P extends BaseMVPPresenter>  extends DaggerFragment
        implements BaseMVPView {

    LinearLayout llContent;

    @Inject
    protected P mPresenter;

    Unbinder unbinder;

    /** Context对象，保存当前Activity */
    protected FragmentActivity mContext;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.activity_fragment_base_no_title, null);
        llContent = rootView.findViewById(R.id.ll_content);
        inflater.inflate(initMainView(), llContent);
        unbinder = ButterKnife.bind(this,rootView);
        transparentStatusBar();
        // 初始化布局
        initDataAndView();
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();

        if (mPresenter != null) {
            mPresenter.dispose();
            mPresenter.onDetachView();
        }
    }


//
    /**
     * 初始化主视图
     */
    protected abstract int initMainView();

    /**
     * 初始化数据和视图
     */
    protected abstract void initDataAndView();

    /**
     * 设置沉侵式状态栏
     */
    protected void transparentStatusBar(){
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
            StatusBarCompat.translucentStatusBar(getActivity(),true);
        }
    }

    protected void avoidWhiteStatusBar(){
        StatusBarUtil.StatusBarLightMode(getActivity());//避免白色
    }


    @Override
    public void showLoading() {
        RuiLoader.showLoading(mContext);
    }

    @Override
    public void disLoading() {
        RuiLoader.stopLoading();
    }

    
    
}
