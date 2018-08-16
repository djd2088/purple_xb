package com.rui.xb.purple.ui.fragment;


import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.rui.xb.purple.R;
import com.rui.xb.purple.base.BaseFragment;
import com.rui.xb.purple.base.BaseNoTitleFragment;
import com.rui.xb.purple.mvp.presenter.me.MePresenter;
import com.rui.xb.purple.mvp.view.me.MeView;
import com.rui.xb.purple.ui.activity.me.AdviceUsActivity;
import com.rui.xb.purple.ui.activity.me.JoinUsActivity;
import com.rui.xb.purple.ui.activity.me.MyCollectActivity;
import com.rui.xb.purple.ui.activity.me.MyDispatchActivity;
import com.rui.xb.purple.ui.activity.me.MyRequestActivity;
import com.rui.xb.purple.ui.activity.me.MyTradeActivity;
import com.rui.xb.purple.ui.activity.me.SetActivity;
import com.rui.xb.purple.ui.activity.me.SponsorUsActivity;
import com.rui.xb.rui_core.utils.UiUtil;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import qiu.niorgai.StatusBarCompat;

/**
 * A simple {@link Fragment} subclass.
 */
public class MeFragment extends BaseNoTitleFragment<MePresenter> implements MeView {

    @BindView(R.id.iv_avatar)
    CircleImageView ivAvatar;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_phone)
    TextView tvPhone;

    @Inject
    public MeFragment() {
    }

//    @Override
//    protected void initTitleBar() {
////        setTvTitleAndColor("我的", R.color.white);
////        hideIvLeft();
////        setLlTitleBgDrawable(R.drawable.status_bar_background);
//    }

    @Override
    protected int initMainView() {
        return R.layout.fragment_me;
    }

    @Override
    protected void initDataAndView() {
    }


    //    , R.id.rl_join
    @OnClick({R.id.rl_person_info, R.id.ll_dispatch, R.id.ll_request, R.id.ll_collect, R.id
            .ll_trade, R.id.rl_sponsor, R.id.rl_advice, R.id.rl_set})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_person_info:
                Toast.makeText(getActivity(), "1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ll_dispatch:
                UiUtil.startIntent(getActivity(), MyDispatchActivity.class);
                break;
            case R.id.ll_request:
                UiUtil.startIntent(getActivity(), MyRequestActivity.class);
                break;
            case R.id.ll_collect:
                UiUtil.startIntent(getActivity(), MyCollectActivity.class);
                break;
            case R.id.ll_trade:
                UiUtil.startIntent(getActivity(), MyTradeActivity.class);
                break;
            case R.id.rl_sponsor:
                UiUtil.startIntent(getActivity(), SponsorUsActivity.class);
                break;
//            case R.id.rl_join:
//                UiUtil.startIntent(getActivity(), JoinUsActivity.class);
//                break;
            case R.id.rl_advice:
                UiUtil.startIntent(getActivity(), AdviceUsActivity.class);
                break;
            case R.id.rl_set:
                UiUtil.startIntent(getActivity(), SetActivity.class);
                break;
        }
    }
}
