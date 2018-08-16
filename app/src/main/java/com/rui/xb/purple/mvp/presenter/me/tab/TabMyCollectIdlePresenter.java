package com.rui.xb.purple.mvp.presenter.me.tab;

import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.rui.xb.purple.R;
import com.rui.xb.purple.base.BaseResponseEntity;
import com.rui.xb.purple.mvp.base.BaseMVPPresenter;
import com.rui.xb.purple.mvp.model.me.tab.TabMyCollectIdleModel;
import com.rui.xb.purple.mvp.view.me.tab.TabMyCollectIdleView;
import com.rui.xb.purple.adapter.recycle_listview.MyCollectIdleAdapter;
import com.rui.xb.purple.adapter.recycle_listview.model.ProductAdapterModel;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;

/**
 * Created by Rui on 2018/7/17.
 */

public class TabMyCollectIdlePresenter extends BaseMVPPresenter<TabMyCollectIdleModel,TabMyCollectIdleView> {


    @Inject
    public TabMyCollectIdlePresenter() {
    }

    private SmartRefreshLayout mRefreshLayout;
    private RecyclerView mRecyclerView;
    private MyCollectIdleAdapter mAdapter;
    private List<ProductAdapterModel> listModels = new ArrayList<>();
    private int pageNo = 1;
    private int pageSize = 10;

    public void initView() {

        initRefreshLayout();
        initRecyclerView();
        initAdapter();
    }

    private void initAdapter() {
        mAdapter = new MyCollectIdleAdapter(R.layout.item_my_collect_idle, listModels);
        mRecyclerView.setAdapter(mAdapter);

        mModule.requestCollectIdle(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                BaseResponseEntity model = gsonSingle.fromJson(s,BaseResponseEntity.class);
                if (model.getCode() == 1){
                    Map<String, Object> data = (Map<String, Object>) model.getData();
                    List<Map<String, Object>> collectList = (List<Map<String, Object>>) data.get
                            ("collectList");
                    dealData(collectList);
                    mAdapter.notifyDataSetChanged();
                }else {
                    Toast.makeText(mContext,model.getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {

            }
        },pageNo,pageSize,1);
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

    private void dealData(List<Map<String, Object>> collectList) {
        for (Map<String,Object> map : collectList){
            ProductAdapterModel collect = new ProductAdapterModel();
            collect.setProductName(map.get("productName").toString());
            collect.setDesc(map.get("productDesc").toString());
            collect.setPrice(map.get("price").toString());
            collect.setPictures(null);
            collect.setSchoolName(map.get("schoolName").toString());
            ProductAdapterModel.UserInfo userInfo = new ProductAdapterModel.UserInfo();
            Map<String,Object> userMap = (Map<String, Object>) map.get("sellerInfo");
            userInfo.setNickname(userMap.get("nickname").toString());
            userInfo.setAvatar(userMap.get("avatar").toString());
            collect.setUserInfo(userInfo);
            listModels.add(collect);
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
