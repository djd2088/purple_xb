package com.rui.xb.purple.mvp.model.me.tab;

import com.rui.xb.purple.app.UrlRouter;
import com.rui.xb.purple.mvp.base.BaseMVPModule;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Created by Rui on 2018/7/17.
 */

public class TabMyCollectIdleModel extends BaseMVPModule {

    @Inject
    public TabMyCollectIdleModel() {
    }

    public Disposable requestCollectIdle(Consumer<String> success,Consumer<Throwable> fail,int
            pageNo,int pageSize,int type){
        Map<String,Object> map = new HashMap<>();
        map.put("pageNo",pageNo);
        map.put("pageSize",pageSize);
        map.put("userId","2");
        map.put("type",type);
        map = encodeByDes(map);
        return requestByGet(UrlRouter.COLLECT_LIST,map).subscribe(success,fail);

    }
}
