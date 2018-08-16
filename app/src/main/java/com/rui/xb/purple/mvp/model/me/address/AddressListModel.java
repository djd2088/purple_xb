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

public class AddressListModel extends BaseMVPModule {

    @Inject
    public AddressListModel() {
    }

    public Disposable requestAddList(Consumer<String> success,Consumer<Throwable> fail,String
            userId){
        Map<String,Object> map = new HashMap<>();
        map.put("userId",userId);
        map = encodeByDes(map);
        return requestByGet(UrlRouter.ADDRESS_LIST,map).subscribe(success,fail);

    }
}
