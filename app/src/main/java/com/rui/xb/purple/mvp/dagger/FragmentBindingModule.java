package com.rui.xb.purple.mvp.dagger;

import com.rui.xb.purple.ui.fragment.CategoryFragment;
import com.rui.xb.purple.ui.fragment.DispatchFragment;
import com.rui.xb.purple.ui.fragment.FirstFragment;
import com.rui.xb.purple.ui.fragment.HomeFragment;

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

}
