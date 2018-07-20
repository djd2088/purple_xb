package com.rui.xb.purple.ui.activity.me;

import android.support.v4.app.Fragment;
import android.widget.FrameLayout;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.rui.xb.purple.R;
import com.rui.xb.purple.base.BaseActivity;
import com.rui.xb.purple.mvp.presenter.me.MyCollectPresenter;
import com.rui.xb.purple.mvp.view.me.MyCollectView;
import com.rui.xb.purple.ui.fragment.tablayout.mycollect.TabMyCollectIdleFragment;
import com.rui.xb.purple.ui.fragment.tablayout.mycollect.TabMyCollectRequestFragment;
import com.rui.xb.purple.ui.tablayout.TabEntity;
import com.rui.xb.purple.ui.fragment.tablayout.TabLayoutFragment;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;

public class MyCollectActivity extends BaseActivity<MyCollectPresenter> implements MyCollectView {

    @BindView(R.id.tl_collect)
    CommonTabLayout tlCollect;

    @Inject
    TabMyCollectIdleFragment idleFragment;

    @Inject
    TabMyCollectRequestFragment requestFragment;

    private String[] mTitles = {"闲置", "求购"};
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private int[] mIconUnselectIds = {
            R.mipmap.tab_class, R.mipmap.tab_home};
    private int[] mIconSelectIds = {
            R.mipmap.tab_class_hover, R.mipmap.tab_home_hover};

    @Override
    protected void initTitleBar() {
        setTvTitle("我的收藏");
        transparentStatusBar(true);
        leftClose();
    }

    @Override
    protected int initMainView() {
        return R.layout.activity_my_collect;
    }

    @Override
    protected void initDataAndView() {

        mFragments.add(idleFragment);
        mFragments.add(requestFragment);

        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        tlCollect.setTabData(mTabEntities, this, R.id.fl_collect, mFragments);

    }

}
