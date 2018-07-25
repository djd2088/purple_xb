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
import com.rui.xb.purple.mvp.base.BaseMVPPresenter;
import com.rui.xb.purple.mvp.model.me.address.AddressListModel;
import com.rui.xb.purple.mvp.model.me.address.AddressManageModel;
import com.rui.xb.purple.mvp.view.me.address.AddressAddView;
import com.rui.xb.purple.mvp.view.me.address.AddressListView;
import com.rui.xb.purple.mvp.view.me.address.AddressManageView;
import com.rui.xb.purple.ui.adapter.recycle_listview.AddressListAdapter;
import com.rui.xb.purple.ui.adapter.recycle_listview.model.AddressListAdapterModel;
import com.rui.xb.rui_core.utils.UiUtil;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Rui on 2018/7/13.
 */

public class AddressManagePresenter extends BaseMVPPresenter<AddressManageModel, AddressManageView> {

    @Inject
    public AddressManagePresenter() {
    }

    private RecyclerView mRecyclerView;

    private AddressListAdapter mAdapter;



    public void initView() {
        initRecyclerView();
        initAdapter();

    }

    private void initAdapter() {
        List<AddressListAdapterModel> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            AddressListAdapterModel model = new AddressListAdapterModel();
            model.setName("name" + i);
            model.setPhone("phone" + i);
            model.setAddress("address" + i);
            list.add(model);
        }

        mAdapter = new AddressListAdapter(R.layout.item_address_manage, list);
        mRecyclerView.setAdapter(mAdapter);

    }

    private void initRecyclerView() {
        mRecyclerView = mView.getRvAddList();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }


}
