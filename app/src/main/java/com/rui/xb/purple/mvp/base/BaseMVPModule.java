package com.rui.xb.purple.mvp.base;



import com.google.gson.Gson;
import com.rui.xb.purple.utils.Des;
import com.rui.xb.rui_core.net.rx.IRxRestService;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * MVP Module基类
 */
public class BaseMVPModule {

    @Inject
    protected IRxRestService netClient;

    @Inject
    protected Gson gsonSingle;

    @Inject
    protected BaseMVPModule() {
    }

    protected Observable<String> requestByGet(String url, Map<String,Object> params){
        return netClient.get(url,params).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

    protected Observable<String> requestByPostForm(String url, Map<String,Object> params){
        return netClient.postForm(url,params).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

    protected Observable<String> requestByPostJson(String url, Map<String,Object> params){
        return netClient.postJson(url,params).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

    protected Observable<String> requestByPut(String url, Map<String,Object> params){
        return netClient.put(url,params).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

//    protected Observable<String> requestByUpload(String url, Map params){
//        return netClient.upload(url,params).observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io());
//    }
//


    protected Map encodeByDes(Map<String,Object> param){
        String encodeString = Des.strEnc(gsonSingle.toJson(param),"100001","","");
        Map<String,Object> request = new HashMap<>();
        request.put("param",encodeString);
        return request;
    }

}
