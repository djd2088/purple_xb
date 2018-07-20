package com.rui.xb.purple.mvp.presenter.me.tab;

import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.rui.xb.purple.R;
import com.rui.xb.purple.mvp.base.BaseMVPPresenter;
import com.rui.xb.purple.mvp.model.me.tab.TabMyTradeBuyModel;
import com.rui.xb.purple.mvp.view.me.tab.TabMyTradeBuyView;
import com.rui.xb.purple.ui.adapter.recycle_listview.MyCollectIdleAdapter;
import com.rui.xb.purple.ui.adapter.recycle_listview.MyTradeBuyAdapter;
import com.rui.xb.purple.ui.adapter.recycle_listview.model.MyTradeBuyAdapterModel;
import com.rui.xb.purple.ui.adapter.recycle_listview.model.ProductAdapterModel;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Rui on 2018/7/18.
 */

public class TabMyTradeBuyPresenter extends BaseMVPPresenter<TabMyTradeBuyModel,TabMyTradeBuyView> {

    @Inject
    public TabMyTradeBuyPresenter() {
    }

    private SmartRefreshLayout mRefreshLayout;
    private RecyclerView mRecyclerView;
    private MyTradeBuyAdapter mAdapter;

    public void initView() {

        initRefreshLayout();
        initRecyclerView();

        List<MyTradeBuyAdapterModel> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            MyTradeBuyAdapterModel model = new MyTradeBuyAdapterModel();
            model.setProductName("商品标题" + i);
            model.setOrderState("state" + i);
//            model.setMainPic("主图" + i);
            model.setPrice("价格" + i);
            list.add(model);
        }
        initAdapter(list);
    }

    private void initAdapter(List<MyTradeBuyAdapterModel> list) {
        mAdapter = new MyTradeBuyAdapter(R.layout.item_my_trade, list);
        mRecyclerView.setAdapter(mAdapter);
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
