package com.rui.xb.purple.mvp.model.home;

import com.rui.xb.purple.mvp.base.BaseMVPModule;
import com.rui.xb.purple.app.UrlRouter;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Created by Rui on 2018/7/19.
 */

public class OrderDetailModel extends BaseMVPModule {

    @Inject
    public OrderDetailModel() {
    }


    public Disposable requestConfirmOrder(Consumer<String> success, Consumer<Throwable> fail,
                                          String productId, String num){
        Map<String,Object> map = new HashMap<>();
        map.put("productId",productId);
        map.put("number",num);
        map = encodeByDes(map);
        return requestByGet(UrlRouter.CONFIRM_ORDER,map).subscribe(success,fail);
    }


    public Disposable requestSubmitOrder(Consumer<String> success,Consumer<Throwable> fail,String
            userId,String productId,String receiveId,String receiveAdd,int type,String num){
        Map<String,Object> map = new HashMap<>();
        map.put("productId",productId);
        map.put("number",num);
        map.put("userId",userId);
        map.put("receiveId",receiveId);
        map.put("receiveAddress",receiveAdd);
        map.put("type",type);
        map = encodeByDes(map);
        return requestByPostJson(UrlRouter.SUBMIT_ORDER,map).subscribe(success,fail);
    }
    
}
