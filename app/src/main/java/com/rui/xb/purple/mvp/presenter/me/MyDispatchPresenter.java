package com.rui.xb.purple.mvp.presenter.me;

import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.rui.xb.purple.R;
import com.rui.xb.purple.mvp.base.BaseMVPPresenter;
import com.rui.xb.purple.mvp.model.me.MyDispatchModel;
import com.rui.xb.purple.mvp.view.me.MyDispatchView;
import com.rui.xb.purple.ui.adapter.recycle_listview.MyDispatchAdapter;
import com.rui.xb.purple.ui.adapter.recycle_listview.model.ProductAdapterModel;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import static android.widget.LinearLayout.VERTICAL;

/**
 * Created by Rui on 2018/7/14.
 */

public class MyDispatchPresenter extends BaseMVPPresenter<MyDispatchModel, MyDispatchView> {

    @Inject
    public MyDispatchPresenter() {
    }

    private SmartRefreshLayout mRefreshLayout;
    private RecyclerView mRecyclerView;
    private MyDispatchAdapter mAdapter;


    public void initView() {

        initRefreshLayout();
        initRecyclerView();

        List<ProductAdapterModel> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ProductAdapterModel model = new ProductAdapterModel();
            model.setId(i);
            model.setBrows(i + "");
            model.setMainPic(i + "");
            model.setPrice(i + "");
            model.setProductName("商品" + i);
            model.setSchoolName("大学" + i);
            list.add(model);
        }
        initAdapter(list);
    }

    private void initAdapter(List<ProductAdapterModel> list) {
        mAdapter = new MyDispatchAdapter(R.layout.item_my_dispatch, list);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(mContext, position + "", Toast.LENGTH_SHORT).show();
            }
        });

        mAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.tv_share:
                        Toast.makeText(mContext, "share" + position, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.tv_edit:
                        Toast.makeText(mContext, "edit" + position, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.tv_delete:
                        Toast.makeText(mContext, "delete" + position, Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

    }

    private void initRecyclerView() {
        mRecyclerView = mView.getRecyclerView();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.addItemDecoration(new DividerItemDecoration(mContext, VERTICAL));

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
