package com.rui.xb.purple.mvp.presenter.me.address;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.rui.xb.purple.R;
import com.rui.xb.purple.base.BaseResponseEntity;
import com.rui.xb.purple.mvp.base.BaseMVPPresenter;
import com.rui.xb.purple.mvp.model.me.address.AddressAddModel;
import com.rui.xb.purple.mvp.model.me.address.AddressManageModel;
import com.rui.xb.purple.mvp.view.me.address.AddressManageView;
import com.rui.xb.purple.ui.activity.me.address.AddressAddActivity;
import com.rui.xb.purple.adapter.recycle_listview.AddressManageAdapter;
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

public class AddressManagePresenter extends BaseMVPPresenter<AddressManageModel,
        AddressManageView> {

    @Inject
    public AddressManagePresenter() {
    }

    private RecyclerView mRecyclerView;

    private AddressManageAdapter mAdapter;

    private List<AddressListAdapterModel> addressLists = new ArrayList<>();

    @Inject
    AddressAddModel addressAddModel;

    private AlertDialog dialogMakeSure;

    public void initView() {
        initRecyclerView();
        initAdapter();

    }

    private void initAdapter() {

        mAdapter = new AddressManageAdapter(R.layout.item_address_manage, addressLists);
        mRecyclerView.setAdapter(mAdapter);
        requestList();
        initAdapterListener();

    }

    private void initAdapterListener() {
//        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                Toast.makeText(mContext, "" + position, Toast.LENGTH_SHORT).show();
//            }
//        });


        mAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, final int position) {
                switch (view.getId()) {
//                    case R.id.ll_set_default:
//                        Toast.makeText(mContext, "default" + position, Toast.LENGTH_SHORT).show();
//                        break;
                    case R.id.ll_edit:
                        Bundle bundle = new Bundle();
                        bundle.putParcelable("address", mAdapter.getItem(position));
                        UiUtil.startIntent(mContext, AddressAddActivity.class, bundle);
                        break;
                    case R.id.ll_delete:
                        showTransportDialog(position);
                        break;
                }

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
                        address.setProvince(map.get("province").toString());
                        address.setLocation(map.get("location").toString());
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
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }


    public void showTransportDialog(final int position){
        dialogMakeSure = new AlertDialog.Builder(mContext).create();
        dialogMakeSure.show();
        final Window window = dialogMakeSure.getWindow();
        window.setContentView(R.layout.dialog_make_sure_panel);
        window.setGravity(Gravity.CENTER);
        window.setWindowAnimations(R.style.anim_panel_up_from_bottom);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //设置属性
        final WindowManager.LayoutParams params = window.getAttributes();
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        params.dimAmount = 0.5f;
        window.setAttributes(params);
        TextView tvTitle = window.findViewById(R.id.tv_title);
        tvTitle.setText("确定删除收货地址吗？");
        window.findViewById(R.id.tv_sure).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addressAddModel.requestAddOrDeleteNewAdd(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        Toast.makeText(mContext, "删除成功", Toast.LENGTH_SHORT).show();
                        mAdapter.remove(position);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Toast.makeText(mContext, "删除失败", Toast.LENGTH_SHORT).show();
                    }
                }, 0, null, null, null, null, mAdapter.getItem(position).getId(), false);
                dialogMakeSure.cancel();
            }
        });
        window.findViewById(R.id.tv_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogMakeSure.cancel();
            }
        });
    }

}
