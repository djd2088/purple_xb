package com.rui.xb.purple.mvp.dagger;

import android.content.Context;
import android.os.Handler;

import com.google.gson.Gson;
import com.rui.xb.purple.app.UrlRouter;
import com.rui.xb.rui_core.net.rx.IRxRestService;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;


@Module
public class MainModule {

    private Context mContext;

    public MainModule(Context context) {
        mContext = context;
    }

    @Provides
    Context getContext() {
        return mContext;
    }

    @Provides
    @Singleton
    Handler getHandler(){
        return new Handler();
    }

    @Provides
    @Singleton
    OkHttpClient initOkHttpClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .build();
    }

    @Provides
    @Singleton
    Retrofit initRetrofit(OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl(UrlRouter.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }

    @Provides
    @Singleton
    IRxRestService rxNetClient(Retrofit retrofit) {
        return retrofit.create(IRxRestService.class);
    }


    @Provides
    @Singleton
    Gson gsonSingle(){
        return new Gson();
    }
}
