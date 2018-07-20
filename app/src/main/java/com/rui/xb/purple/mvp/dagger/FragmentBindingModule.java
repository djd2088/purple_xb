package com.rui.xb.purple.mvp.dagger;

import com.rui.xb.purple.mvp.dagger.annotation.FragmentScoped;
import com.rui.xb.purple.ui.fragment.CategoryFragment;
import com.rui.xb.purple.ui.fragment.DispatchFragment;
import com.rui.xb.purple.ui.fragment.FirstFragment;
import com.rui.xb.purple.ui.fragment.HomeFragment;
import com.rui.xb.purple.ui.fragment.MeFragment;
import com.rui.xb.purple.ui.fragment.MessageFragment;
import com.rui.xb.purple.ui.fragment.tablayout.home.TabMasterHotTopicFragment;
import com.rui.xb.purple.ui.fragment.tablayout.home.TabMasterRegionFragment;
import com.rui.xb.purple.ui.fragment.tablayout.mycollect.TabMyCollectIdleFragment;
import com.rui.xb.purple.ui.fragment.tablayout.mycollect.TabMyCollectRequestFragment;
import com.rui.xb.purple.ui.fragment.tablayout.mycollect.TabMyTradeBuyFragment;
import com.rui.xb.purple.ui.fragment.tablayout.mycollect.TabMyTradeSellFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Rui on 2018/6/1.
 */
@Module
public abstract class FragmentBindingModule {


    @FragmentScoped
    @ContributesAndroidInjector
    abstract FirstFragment firstFragment();

    @FragmentScoped
    @ContributesAndroidInjector
    abstract HomeFragment homeFragment();

    @FragmentScoped
    @ContributesAndroidInjector
    abstract DispatchFragment dispatchFragment();

    @FragmentScoped
    @ContributesAndroidInjector
    abstract CategoryFragment categoryFragment();


    @FragmentScoped
    @ContributesAndroidInjector
    abstract MessageFragment messageFragment();


    @FragmentScoped
    @ContributesAndroidInjector
    abstract MeFragment meFragment();

    @FragmentScoped
    @ContributesAndroidInjector
    abstract TabMyCollectIdleFragment tabMyCollectIdleFragment();

    @FragmentScoped
    @ContributesAndroidInjector
    abstract TabMyCollectRequestFragment tabMyCollectRequestFragment();

    @FragmentScoped
    @ContributesAndroidInjector
    abstract TabMyTradeBuyFragment tabMyTradeBuyFragment();

    @FragmentScoped
    @ContributesAndroidInjector
    abstract TabMyTradeSellFragment tabMyTradeSellFragment();

    @FragmentScoped
    @ContributesAndroidInjector
    abstract TabMasterRegionFragment tabMasterRegionFragment();

    @FragmentScoped
    @ContributesAndroidInjector
    abstract TabMasterHotTopicFragment tabMasterHotTopicFragment();



}
