package com.rui.xb.purple.mvp.model.home;

import com.rui.xb.purple.mvp.base.BaseMVPModule;
import com.rui.xb.purple.utils.UrlRouter;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Created by Rui on 2018/7/19.
 */

public class TabMasterRegionModel extends BaseMVPModule {

    @Inject
    public TabMasterRegionModel() {
    }

    public Disposable requestSubClass(Consumer<String> success, Consumer<Throwable> fail, String
            parentId){
        Map<String,Object> map = new HashMap<>();
        map.put("parentId",parentId);
        map = encodeByDes(map);
        return requestByGet(UrlRouter.CATEGORY,map).subscribe(success,fail);
    }
}
