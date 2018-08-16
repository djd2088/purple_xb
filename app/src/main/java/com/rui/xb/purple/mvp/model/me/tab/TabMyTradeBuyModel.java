package com.rui.xb.purple.mvp.model.me.tab;

import com.rui.xb.purple.mvp.base.BaseMVPModule;
import com.rui.xb.purple.app.UrlRouter;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Created by Rui on 2018/7/18.
 */

public class TabMyTradeBuyModel extends BaseMVPModule {

    @Inject
    public TabMyTradeBuyModel() {
    }

    public Disposable requestOrderList(Consumer<String> success,Consumer<Throwable> fail,int
            type,int pageNo,int pageSize){
        Map<String,Object> map = new HashMap<>();
        map.put("userId","2");
        map.put("type",type);
        map.put("pageNo",pageNo);
        map.put("pageSize",pageSize);
        map = encodeByDes(map);
        return requestByGet(UrlRouter.ORDER_LIST,map).subscribe(success,fail);
    }
}
