package com.rui.xb.purple.mvp.dagger;



import com.rui.xb.purple.MainFragmentActivity;
import com.rui.xb.purple.mvp.dagger.annotation.ActivityScoped;
import com.rui.xb.purple.ui.activity.home.OrderDetailActivity;
import com.rui.xb.purple.ui.activity.category.CategoryActivity;
import com.rui.xb.purple.ui.activity.dispatch.idle.DispatchIdleActivity;
import com.rui.xb.purple.ui.activity.dispatch.request.DispatchRequestActivity;
import com.rui.xb.purple.ui.activity.home.GroupBuyingActivity;
import com.rui.xb.purple.ui.activity.home.MasterLifeActivity;
import com.rui.xb.purple.ui.activity.home.ProductDetailActivity;
import com.rui.xb.purple.ui.activity.home.RequestRegionActivity;
import com.rui.xb.purple.ui.activity.home.SearchActivity;
import com.rui.xb.purple.ui.activity.me.AdviceUsActivity;
import com.rui.xb.purple.ui.activity.me.JoinUsActivity;
import com.rui.xb.purple.ui.activity.me.MyCollectActivity;
import com.rui.xb.purple.ui.activity.me.MyDispatchActivity;
import com.rui.xb.purple.ui.activity.me.MyRequestActivity;
import com.rui.xb.purple.ui.activity.me.MyTradeActivity;
import com.rui.xb.purple.ui.activity.me.SetActivity;
import com.rui.xb.purple.ui.activity.me.SponsorUsActivity;
import com.rui.xb.purple.zFunctionTest.ui.Test1Activity;

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
    abstract MainFragmentActivity mainFragmentActivity();


    @ActivityScoped
    @ContributesAndroidInjector
    abstract DispatchIdleActivity idleActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract DispatchRequestActivity dispatchRequestActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract CategoryActivity categoryActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract MyDispatchActivity dispatchActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract MyCollectActivity collectActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract MyRequestActivity myRequestActivity ();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract MyTradeActivity tradeActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract SponsorUsActivity sponsorUsActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract JoinUsActivity joinUsActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract AdviceUsActivity adviceUsActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract SetActivity setActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract ProductDetailActivity productDetailActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract OrderDetailActivity orderDetailActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract RequestRegionActivity requestRegionActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract MasterLifeActivity masterRegionActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract GroupBuyingActivity groupBuyingActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract SearchActivity searchActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract Test1Activity test1Activity();










}
