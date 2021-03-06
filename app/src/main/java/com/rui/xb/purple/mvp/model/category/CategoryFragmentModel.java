package com.rui.xb.purple.mvp.model.category;

import com.rui.xb.purple.mvp.base.BaseMVPModule;
import com.rui.xb.purple.app.UrlRouter;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Created by Rui on 2018/7/10.
 */

public class CategoryFragmentModel extends BaseMVPModule {

    @Inject
    public CategoryFragmentModel() {
    }

    public Disposable requestSubClass(Consumer<String> success, Consumer<Throwable> fail,String
            parentId){
        Map<String,Object> map = new HashMap<>();
        map.put("parentId",parentId);
        map = encodeByDes(map);
        return requestByGet(UrlRouter.CATEGORY,map).subscribe(success,fail);
    }


}
