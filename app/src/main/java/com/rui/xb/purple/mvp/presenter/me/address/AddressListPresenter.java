package com.rui.xb.purple.mvp.presenter.me.address;

import android.app.Activity;
import android.content.Intent;
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
import com.rui.xb.purple.mvp.view.me.address.AddressListView;
import com.rui.xb.purple.ui.activity.home.OrderDetailActivity;
import com.rui.xb.purple.ui.adapter.recycle_listview.AddressListAdapter;
import com.rui.xb.purple.ui.adapter.recycle_listview.model.AddressListAdapterModel;
import com.rui.xb.rui_core.utils.UiUtil;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import static android.icu.lang.UCharacter.DecompositionType.VERTICAL;

/**
 * Created by Rui on 2018/7/13.
 */

public class AddressListPresenter extends BaseMVPPresenter<AddressListModel, AddressListView> {

    @Inject
    public AddressListPresenter() {
    }

    private RecyclerView mRecyclerView;

    private AddressListAdapter mAdapter;



    public void initView(Activity activity) {
        initRecyclerView();
        initAdapter(activity);

    }

    private void initAdapter(final Activity activity) {
        List<AddressListAdapterModel> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            AddressListAdapterModel model = new AddressListAdapterModel();
            model.setName("name" + i);
            model.setPhone("phone" + i);
            model.setAddress("address" + i);
            list.add(model);
        }

        mAdapter = new AddressListAdapter(R.layout.item_address_list, list);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                AddressListAdapterModel model = mAdapter.getItem(position);
                Bundle bundle = new Bundle();
                bundle.putString("addId",model.getId());
                bundle.putString("nameAndPhone",model.getName() + " " + model.getPhone());
                bundle.putString("addDetail",model.getAddress());
                UiUtil.setResult(activity,0,bundle);
            }
        });
    }

    private void initRecyclerView() {
        mRecyclerView = mView.getRvAddList();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration
                .VERTICAL));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }


}
