package com.rui.xb.purple.ui.activity.dispatch.idle;

import android.widget.Button;

import com.rui.xb.purple.R;
import com.rui.xb.purple.base.BaseActivity;
import com.rui.xb.purple.mvp.presenter.dispatch.IdlePresenter;
import com.rui.xb.purple.mvp.view.dispatch.IdleView;

import butterknife.BindView;
import butterknife.OnClick;

public class DispatchIdleActivity extends BaseActivity<IdlePresenter> implements IdleView {


    @BindView(R.id.btn_dispatch)
    Button btnDispatch;

    @Override
    protected void initTitleBar() {
        setTvTitleAndColor("发布闲置", R.color.we_chat_black);
        transparentStatusBar(true);
        leftClose();
    }

    @Override
    protected int initMainView() {
        return R.layout.activity_dispatch_idle;
    }

    @Override
    protected void initDataAndView() {

    }

    @OnClick(R.id.temp_tv)
    public void onViewClicked() {
        btnDispatch.setEnabled(true);
    }


}
