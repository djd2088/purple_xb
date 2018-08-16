package com.rui.xb.purple.mvp.model.home;

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

public class ProductDetailModel extends BaseMVPModule {

    @Inject
    public ProductDetailModel() {
    }


    public Disposable requestProductDetail(Consumer<String> success,Consumer<Throwable> fail,String
            productId){

        Map<String,Object> map = new HashMap<>();
        map.put("productId",productId);
        map.put("userId",0);
        map = encodeByDes(map);
        return requestByGet(UrlRouter.PRODUCT_DETAIL,map).subscribe(success,fail);
    }
}
