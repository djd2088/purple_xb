package com.rui.xb.purple.mvp.dagger;



import com.rui.xb.purple.MainFragmentActivity;
import com.rui.xb.purple.ui.activity.category.CategoryActivity;
import com.rui.xb.purple.ui.activity.dispatch.idle.DispatchIdleActivity;
import com.rui.xb.purple.ui.activity.dispatch.request.DispatchRequestActivity;
import com.rui.xb.purple.zFunctionTest.ui.MvpTestActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * We want Dagger.Android to create a Subcomponent which has a parent Component of whichever module ActivityBindingModule is on,
 * in our case that will be AppComponent. The beautiful part about this setup is that you never need to tell AppComponent that it is going to have all these subcomponents
 * nor do you need to tell these subcomponents that AppComponent exists.
 * We are also telling Dagger.Android that this generated SubComponent needs to include the specified modules and be aware of a scope annotation @ActivityScoped
 * When Dagger.Android annotation processor runs it will create 4 subcomponents for us.
 */
@Module
public abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector()
    abstract MvpTestActivity mvpTestActivity();

    @ActivityScoped
    @ContributesAndroidInjector()
    abstract MainFragmentActivity mainFragmentActivity();


    @ActivityScoped
    @ContributesAndroidInjector
    abstract DispatchIdleActivity idleActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract DispatchRequestActivity requestActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract CategoryActivity categoryActivity();



}
