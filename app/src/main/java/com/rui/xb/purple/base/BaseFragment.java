package com.rui.xb.purple.base;


import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rui.xb.purple.R;
import com.rui.xb.purple.mvp.base.BaseMVPPresenter;
import com.rui.xb.purple.mvp.base.BaseMVPView;
import com.rui.xb.purple.utils.StatusBarUtil;
import com.rui.xb.rui_core.ui.loader.RuiLoader;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.support.DaggerFragment;
import qiu.niorgai.StatusBarCompat;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseFragment<P extends BaseMVPPresenter>  extends DaggerFragment
        implements BaseMVPView {


    @BindView(R.id.ll_title)
    LinearLayout llTitleBar;

    @BindView(R.id.iv_left)
    ImageView ivLeft;

    @BindView(R.id.tv_title)
    TextView tvTitle;

    @BindView(R.id.iv_right)
    ImageView ivRight;

    @BindView(R.id.tv_right)
    TextView tvRight;

    @BindView(R.id.tv_left)
    TextView tvLeft;

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
        View rootView = inflater.inflate(R.layout.activity_fragment_base, null);
        llContent = rootView.findViewById(R.id.ll_content);
        inflater.inflate(initMainView(), llContent);
        unbinder = ButterKnife.bind(this,rootView);
        transparentStatusBar(false);
        // 初始化标题栏
        initTitleBar();
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


    /**
     * 初始化标题栏
     */
    protected abstract void initTitleBar();
    /**
     * 初始化主视图
     */
    protected abstract int initMainView();

    /**
     * 初始化数据和视图
     */
    protected abstract void initDataAndView();

    /**
     * 设置titleBarColor
     */
    protected void setLlTitleBgColor(int color){
        llTitleBar.setBackgroundResource(color);
    }

    /**
     * 设置titleBarDrawble
     */
    protected void setLlTitleBgDrawable(int drawable){
        llTitleBar.setBackgroundResource(drawable);
    }

    /**
     * 设置沉侵式状态栏
     */
    protected void transparentStatusBar(boolean avoidWhite){
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
            StatusBarCompat.translucentStatusBar(getActivity(),true);
            if (avoidWhite){
                StatusBarUtil.StatusBarLightMode(getActivity());//避免白色
            }
        }


    }
    /**
     * 隐藏titleBar
     */
    protected void hideTitleBar(){
        llTitleBar.setVisibility(View.GONE);
    }

    /**
     * 设置title
     */
    protected void setTvTitleAndColor(String title,int color){
        tvTitle.setText(title);
        tvTitle.setTextColor(getResources().getColor(color));
    }
    protected void setTvTitle(String title){
        tvTitle.setText(title);
    }

    /**
     * 隐藏ivLeft
     */
    protected void hideIvLeft(){
        ivLeft.setVisibility(View.GONE);
    }

    /**
     * 设置ivLeft图片
     */
    protected void setIvLeftRes(int resId){
        ivLeft.setImageResource(resId);
    }

    /**
     * 设置left文字
     */
    protected void showTvLeft(String lt,int color ,int rightDrawable){
        tvLeft.setVisibility(View.VISIBLE);
        tvLeft.setText(lt);
        tvLeft.setTextColor(getResources().getColor(color));
        if (rightDrawable != 0){
            Drawable rightDraw = getResources().getDrawable(rightDrawable);
            rightDraw.setBounds(0,0,30,35);//第一0是距左边距离，第二0是距上边距离，30、35分别是长宽
            tvLeft.setCompoundDrawables(null,null,rightDraw,null);//只放左边
        }
    }


    /**
     * 设置ivRight图片
     */
    protected void showIvRightSetRes(int resId){
        ivRight.setVisibility(View.VISIBLE);
        ivRight.setImageResource(resId);
    }

    /**
     * 设置Right文字
     */
    protected void showTvRightSetText(String rt,int color){
        tvRight.setVisibility(View.VISIBLE);
        tvRight.setText(rt);
        tvRight.setTextColor(getResources().getColor(color));
    }

    /**
     * 获取左边iv
     */
    protected ImageView getIvLeft(){
        return ivLeft;
    }
    /**
     * 获取右边iv
     */
    protected ImageView getIvRight(){
        return ivRight;
    }
    /**
     * 获取右边tv
     */
    protected TextView getTvRight(){
        return tvRight;
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
