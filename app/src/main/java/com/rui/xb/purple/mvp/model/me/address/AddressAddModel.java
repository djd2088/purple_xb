package com.rui.xb.purple.mvp.model.me.address;

import com.rui.xb.purple.mvp.base.BaseMVPModule;
import com.rui.xb.purple.app.UrlRouter;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Created by Rui on 2018/7/16.
 */

public class AddressAddModel extends BaseMVPModule {

    @Inject
    public AddressAddModel() {
    }

    public Disposable requestAddOrDeleteNewAdd(Consumer<String> success,Consumer<Throwable> fail,
                                               int type,String name,String phone,String province,
                                               String location,String receiveId,boolean isDefault){
        Map<String,Object> map = new HashMap<>();
        map.put("userId","2");
        map.put("type",type);
        if (type == 0){
            map.put("receiveId",receiveId);
        }else {
            map.put("name",name);
            map.put("province",province);
            map.put("location",location);
            map.put("phone",phone);
            map.put("isDefault",isDefault);
        }
        map = encodeByDes(map);
        return requestByPostJson(UrlRouter.ADDRESS_ADD_DELETE,map).subscribe(success,fail);
    }

    public Disposable requestAddressEdit(Consumer<String> success,Consumer<Throwable> fail,
                                         String name,String phone,String province,String
                                                 location,String receiveId,boolean isDefault){
        Map<String,Object> map = new HashMap<>();
        map.put("userId","2");
        map.put("name",name);
        map.put("phone",phone);
        map.put("province",province);
        map.put("location",location);
        map.put("isDefault",isDefault);
        map.put("receiveId",receiveId);
        map = encodeByDes(map);
        return requestByPostJson(UrlRouter.ADDRESS_EDIT,map).subscribe(success,fail);
    }
}
