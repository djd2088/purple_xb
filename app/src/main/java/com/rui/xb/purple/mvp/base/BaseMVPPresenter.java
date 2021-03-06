package com.rui.xb.purple.mvp.base;


import android.content.Context;

import com.google.gson.Gson;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Presenter基类
 */
public class BaseMVPPresenter<M extends BaseMVPModule,V extends BaseMVPView> {


    protected V mView;

    @Inject
    protected M mModule;

    protected Context mContext;

    @Inject
    protected Gson gsonSingle;

    private CompositeDisposable disposables;

    public BaseMVPPresenter() {
        disposables = new CompositeDisposable();
    }


    public void onAttachView(V view,Context context) {
        mView = view;
        mContext = context;
    }

    public void onDetachView() {
        mView = null;
    }

    /**
     * RxJava生命周期
     */
    protected void addDisposable(Disposable dis) {
        if (dis != null) {
            disposables.add(dis);
        }
    }

    /**
     * 消费所有事件
     */
    public void dispose() {
        if (!disposables.isDisposed() && disposables.size() > 0) {
            disposables.dispose();
        }
    }

}
