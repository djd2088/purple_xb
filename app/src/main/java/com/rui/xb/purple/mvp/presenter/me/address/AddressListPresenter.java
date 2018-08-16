package com.rui.xb.purple.mvp.presenter.me.address;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.rui.xb.purple.R;
import com.rui.xb.purple.base.BaseResponseEntity;
import com.rui.xb.purple.mvp.base.BaseMVPPresenter;
import com.rui.xb.purple.mvp.model.me.address.AddressListModel;
import com.rui.xb.purple.mvp.view.me.address.AddressListView;
import com.rui.xb.purple.adapter.recycle_listview.AddressListAdapter;
import com.rui.xb.purple.adapter.recycle_listview.model.AddressListAdapterModel;
import com.rui.xb.rui_core.utils.UiUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;

/**
 * Created by Rui on 2018/7/13.
 */

public class AddressListPresenter extends BaseMVPPresenter<AddressListModel, AddressListView> {

    @Inject
    public AddressListPresenter() {
    }

    private RecyclerView mRecyclerView;

    private AddressListAdapter mAdapter;

    private List<AddressListAdapterModel> addressLists = new ArrayList<>();

    public void initView(Activity activity) {
        initRecyclerView();
        initAdapter(activity);

    }

    private void initAdapter(final Activity activity) {

        mAdapter = new AddressListAdapter(R.layout.item_address_list, addressLists);
        mRecyclerView.setAdapter(mAdapter);

        requestList();
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                AddressListAdapterModel model = mAdapter.getItem(position);
                Bundle bundle = new Bundle();
                bundle.putString("addId", model.getId());
                bundle.putString("nameAndPhone", model.getName() + " " + model.getPhone());
                bundle.putString("addDetail", model.getProvince() + model.getLocation());
                UiUtil.setResult(activity, 0, bundle);
            }
        });
    }

    private void requestList() {
        mModule.requestAddList(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                addressLists.clear();
                BaseResponseEntity model = gsonSingle.fromJson(s, BaseResponseEntity.class);
                if (model.getCode() == 1) {
                    List<Map> tempList = (List<Map>) model.getData();
                    for (Map<String, Object> map : tempList) {
                        AddressListAdapterModel address = new AddressListAdapterModel();
                        address.setName(map.get("name").toString());
                        address.setPhone(map.get("phone").toString());
                        address.setId(map.get("id").toString());
                        address.setLocation(map.get("location").toString());
                        address.setProvince(map.get("province").toString());
                        address.setDefault((Boolean) map.get("isDefault"));
                        addressLists.add(address);
                    }
                    mAdapter.notifyDataSetChanged();
                }
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {

            }
        }, "2");
    }

    private void initRecyclerView() {
        mRecyclerView = mView.getRvAddList();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
//        mRecyclerView.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration
//                .VERTICAL));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }


}
