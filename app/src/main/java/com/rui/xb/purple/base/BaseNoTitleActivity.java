package com.rui.xb.purple.base;

import android.content.Context;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.rui.xb.purple.R;
import com.rui.xb.purple.mvp.base.BaseMVPPresenter;
import com.rui.xb.purple.mvp.base.BaseMVPView;
import com.rui.xb.purple.utils.StatusBarUtil;
import com.rui.xb.rui_core.app.AppManager;
import com.rui.xb.rui_core.app.enums.ECommon;
import com.rui.xb.rui_core.ui.loader.RuiLoader;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.support.DaggerAppCompatActivity;
import qiu.niorgai.StatusBarCompat;

public abstract class BaseNoTitleActivity<P extends BaseMVPPresenter> extends
        DaggerAppCompatActivity implements BaseMVPView {


    LinearLayout llContent;

    @Inject
    protected P mPresenter;

    Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_no_title);
        unbinder = ButterKnife.bind(this);
        transparentStatusBar(false);
        bindView(initMainView());
        initDataAndView();
        // 添加到应用管理
        AppManager.getInstance().addActivity(this);
    }


    @Override
    protected void onDestroy() {
        // 从应用管理移除
        AppManager.getInstance().removeActivity(this);
        // 界面销毁时取消订阅
        if (mPresenter != null) {
            mPresenter.dispose();
            mPresenter.onDetachView();
        }
        unbinder.unbind();
        super.onDestroy();
    }


    /**
     * 初始化主视图
     */
    protected abstract int initMainView();


    /**
     * 初始化数据和视图
     */
    protected abstract void initDataAndView();

    /**
     * 设置内容View
     */
    private void bindView(int resId){
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        llContent = findViewById(R.id.ll_content);
        inflater.inflate(resId, llContent);
    }

    protected void transparentStatusBar(boolean avoidWhite){
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
            StatusBarCompat.translucentStatusBar(this,true);
            if (avoidWhite){
                StatusBarUtil.StatusBarLightMode(this);//避免白色
            }
        }

    }


    @Override
    public void showLoading() {
        RuiLoader.showLoading(this);
    }

    @Override
    public void disLoading() {
        RuiLoader.stopLoading();
    }

    protected Bundle getBundle(){
        return getIntent().getBundleExtra(ECommon.BUNDLE.name());
    }
}
