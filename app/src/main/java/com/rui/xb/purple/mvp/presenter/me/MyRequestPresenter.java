package com.rui.xb.purple.mvp.presenter.me;

import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.rui.xb.purple.R;
import com.rui.xb.purple.adapter.recycle_listview.model.ProductAdapterModel;
import com.rui.xb.purple.base.BaseResponseEntity;
import com.rui.xb.purple.mvp.base.BaseMVPPresenter;
import com.rui.xb.purple.mvp.model.me.MyDispatchModel;
import com.rui.xb.purple.mvp.model.me.MyRequestModel;
import com.rui.xb.purple.mvp.view.me.MyRequestView;
import com.rui.xb.purple.adapter.recycle_listview.MyRequestAdapter;
import com.rui.xb.purple.adapter.recycle_listview.model.MyRequestAdapterModel;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;

/**
 * Created by Rui on 2018/7/14.
 */

public class MyRequestPresenter extends BaseMVPPresenter<MyRequestModel,MyRequestView> {

    @Inject
    public MyRequestPresenter() {
    }

    private SmartRefreshLayout mRefreshLayout;
    private RecyclerView mRecyclerView;
    private MyRequestAdapter mAdapter;
    private List<MyRequestAdapterModel> listModels = new ArrayList<>();
    private int pageNo = 1;
    private int pageSize = 10;
    private boolean isOver;
    @Inject
    MyDispatchModel myDispatchModel;

    public void initView() {

        initRefreshLayout();
        initRecyclerView();

        List<MyRequestAdapterModel> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {

        }
        initAdapter();
    }

    private void initAdapter() {
        mAdapter = new MyRequestAdapter(R.layout.item_request_card, listModels);
        mRecyclerView.setAdapter(mAdapter);

        myDispatchModel.requestMyDispatch(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                BaseResponseEntity response = gsonSingle.fromJson(s,BaseResponseEntity.class);
                if (response.getCode() == 1){
                    Map<String, Object> data = (Map<String, Object>) response.getData();
                    List<Map<String, Object>> productList = (List<Map<String, Object>>) data.get
                            ("productList");
                    dealData(productList);
                    mAdapter.notifyDataSetChanged();
                    isOver = (boolean) data.get("isOver");
                }
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {

            }
        },2,pageNo,pageSize);

        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(mContext, position + "", Toast.LENGTH_SHORT).show();
            }
        });

//        mAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
//            @Override
//            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
//                switch (view.getId()) {
//                    case R.id.tv_share:
//                        Toast.makeText(mContext, "share" + position, Toast.LENGTH_SHORT).show();
//                        break;
//                    case R.id.tv_edit:
//                        Toast.makeText(mContext, "edit" + position, Toast.LENGTH_SHORT).show();
//                        break;
//                    case R.id.tv_delete:
//                        Toast.makeText(mContext, "delete" + position, Toast.LENGTH_SHORT).show();
//                        break;
//                }
//            }
//        });

    }

    private void dealData(List<Map<String, Object>> productList) {
        for (Map<String,Object> map : productList){
            MyRequestAdapterModel model = new MyRequestAdapterModel();
            model.setTitle(map.get("productName").toString());
            model.setDesc(map.get("productDesc").toString());
            model.setSchoolName(map.get("schoolName").toString());
            model.setDesirePrice(map.get("price").toString());
            model.setTime(map.get("onlineTime").toString());
            ProductAdapterModel.UserInfo userInfo = gsonSingle.fromJson(map.get("sellerInfo")
                    .toString(), ProductAdapterModel.UserInfo.class);
            model.setRequesterName(userInfo.getNickname());
            model.setPhone(userInfo.getPhone());
            model.setQq(userInfo.getQq());
            model.setWx(userInfo.getWechat());
            listModels.add(model);
        }
    }


    private void initRecyclerView() {
        mRecyclerView = mView.getRecyclerView();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
//        mRecyclerView.addItemDecoration(new DividerItemDecoration(mContext, VERTICAL));

    }

    private void initRefreshLayout() {
        mRefreshLayout = mView.getRefreshLayout();
//        mRefreshLayout.autoRefresh();
        mRefreshLayout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {

            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {

            }
        });
    }
}
