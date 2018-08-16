package com.rui.xb.purple.ui.activity.home;

import android.support.v4.app.Fragment;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.rui.xb.purple.R;
import com.rui.xb.purple.base.BaseActivity;
import com.rui.xb.purple.mvp.presenter.home.MasterLifePresenter;
import com.rui.xb.purple.mvp.view.home.MasterLifeView;
import com.rui.xb.purple.ui.fragment.tablayout.home.TabMasterHotTopicFragment;
import com.rui.xb.purple.ui.fragment.tablayout.home.TabMasterRegionFragment;
import com.rui.xb.purple.ui.fragment.tablayout.mycollect.TabMyCollectIdleFragment;
import com.rui.xb.purple.ui.fragment.tablayout.mycollect.TabMyCollectRequestFragment;
import com.rui.xb.purple.ui.tablayout.TabEntity;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;

public class MasterLifeActivity extends BaseActivity<MasterLifePresenter> implements
        MasterLifeView {


    @Inject
    TabMasterRegionFragment masterRegionFragment;

    @Inject
    TabMasterHotTopicFragment hotTopicFragment;

    @BindView(R.id.tl_master)
    CommonTabLayout tlMaster;

    private String[] mTitles = {"考研专区", "热门话题"};
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private int[] mIconUnselectIds = {
            R.mipmap.ic_launcher, R.mipmap.ic_launcher};
    private int[] mIconSelectIds = {
            R.mipmap.ic_launcher, R.mipmap.ic_launcher};

    @Override
    protected void initTitleBar() {
        setTvTitle("考研人生");
        avoidWhiteStatusBar();
        leftClose();
    }

    @Override
    protected int initMainView() {
        return R.layout.activity_master_life;
    }

    @Override
    protected void initDataAndView() {

        mPresenter.onAttachView(this, this);

        mFragments.add(masterRegionFragment);
        mFragments.add(hotTopicFragment);

        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        tlMaster.setTabData(mTabEntities, this, R.id.fl_master, mFragments);

    }

}
