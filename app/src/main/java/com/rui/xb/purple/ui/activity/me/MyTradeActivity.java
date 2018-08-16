package com.rui.xb.purple.ui.activity.me;

import android.support.v4.app.Fragment;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.rui.xb.purple.R;
import com.rui.xb.purple.base.BaseActivity;
import com.rui.xb.purple.mvp.presenter.me.MyTradePresenter;
import com.rui.xb.purple.mvp.view.me.MyTradeView;
import com.rui.xb.purple.ui.fragment.tablayout.mycollect.TabMyTradeBuyFragment;
import com.rui.xb.purple.ui.fragment.tablayout.mycollect.TabMyTradeSellFragment;
import com.rui.xb.purple.ui.tablayout.TabEntity;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;

public class MyTradeActivity extends BaseActivity<MyTradePresenter> implements MyTradeView {


    @BindView(R.id.tl_trade)
    CommonTabLayout tlTrade;

    @Inject
    TabMyTradeBuyFragment buyFragment;

    @Inject
    TabMyTradeSellFragment sellFragment;

    private String[] mTitles = {"我买到的", "我卖出的"};
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private int[] mIconUnselectIds = {
            R.mipmap.ic_launcher, R.mipmap.ic_launcher};
    private int[] mIconSelectIds = {
            R.mipmap.ic_launcher, R.mipmap.ic_launcher};

    @Override
    protected void initTitleBar() {
        setTvTitle("我的交易");
        avoidWhiteStatusBar();
        leftClose();
    }

    @Override
    protected int initMainView() {
        return R.layout.activity_my_trade;
    }

    @Override
    protected void initDataAndView() {

        mFragments.add(buyFragment);
        mFragments.add(sellFragment);

        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        tlTrade.setTabData(mTabEntities, this, R.id.fl_trade, mFragments);

    }

}
