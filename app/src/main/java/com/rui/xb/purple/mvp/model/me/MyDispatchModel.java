package com.rui.xb.purple.mvp.model.me;

import com.rui.xb.purple.app.UrlRouter;
import com.rui.xb.purple.mvp.base.BaseMVPModule;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Created by Rui on 2018/7/14.
 */

public class MyDispatchModel extends BaseMVPModule {

    @Inject
    public MyDispatchModel() {
    }

    public Disposable requestMyDispatch(Consumer<String> success,Consumer<Throwable> fail,int
            type,int pageNo,int pageSize){
        Map<String,Object> map = new HashMap<>();
        map.put("pageNo",pageNo);
        map.put("pageSize",pageSize);
        map.put("userId","2");
        map.put("type",type);
        map = encodeByDes(map);
        return requestByGet(UrlRouter.MY_DISPATCH_REQUEST,map).subscribe(success,fail);
    }
}
