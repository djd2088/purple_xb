package com.rui.xb.purple.mvp.model.home;

import com.rui.xb.purple.mvp.base.BaseMVPModule;
import com.rui.xb.purple.app.UrlRouter;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Created by Rui on 2018/7/4.
 */

public class HomeModel extends BaseMVPModule{

    @Inject
    public HomeModel() {
    }


    public Disposable requestProductList(Consumer<String> success,Consumer<Throwable> fail,int
            pageNo,int pageSize,int type){
        Map<String,Object> map = new HashMap<>();
        map.put("pageNo",pageNo);
        map.put("pageSize",pageSize);
        map.put("type",type);
        map = encodeByDes(map);
        return requestByGet(UrlRouter.PRODUCT_LIST,map).subscribe(success,fail);
    }



}
