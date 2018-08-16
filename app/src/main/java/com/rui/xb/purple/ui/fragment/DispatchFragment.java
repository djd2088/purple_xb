package com.rui.xb.purple.ui.fragment;


import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Toast;

import com.rui.xb.purple.R;
import com.rui.xb.purple.base.BaseFragment;
import com.rui.xb.purple.mvp.presenter.dispatch.DispatchPresenter;
import com.rui.xb.purple.mvp.view.dispatch.DispatchView;
import com.rui.xb.purple.ui.activity.dispatch.idle.DispatchIdleActivity;
import com.rui.xb.purple.ui.activity.dispatch.request.DispatchRequestActivity;
import com.rui.xb.rui_core.utils.UiUtil;

import javax.inject.Inject;

import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class DispatchFragment extends BaseFragment<DispatchPresenter> implements DispatchView {


    @Inject
    public DispatchFragment() {
        // Required empty public constructor
    }

    @Override
    protected void initTitleBar() {
        setTvTitleAndColor("发布", R.color.we_chat_black);
        hideIvLeft();
        avoidWhiteStatusBar();

    }

    @Override
    protected int initMainView() {
        return R.layout.fragment_dispatch;
    }

    @Override
    protected void initDataAndView() {

    }




    @OnClick({R.id.ll_idle, R.id.ll_request, R.id.ll_free})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_idle:
                Toast.makeText(getActivity(),"1",Toast.LENGTH_SHORT).show();
                UiUtil.startIntent(getActivity(), DispatchIdleActivity.class);
                break;
            case R.id.ll_request:
                Toast.makeText(getActivity(),"2",Toast.LENGTH_SHORT).show();
                UiUtil.startIntent(getActivity(), DispatchRequestActivity.class);
                break;
            case R.id.ll_free:
                Toast.makeText(getActivity(),"3",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
