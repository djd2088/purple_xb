package com.rui.xb.purple.mvp.presenter.me;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.rui.xb.purple.R;
import com.rui.xb.purple.base.BaseResponseEntity;
import com.rui.xb.purple.mvp.base.BaseMVPPresenter;
import com.rui.xb.purple.mvp.model.me.MyDispatchModel;
import com.rui.xb.purple.mvp.view.me.MyDispatchView;
import com.rui.xb.purple.adapter.recycle_listview.MyDispatchAdapter;
import com.rui.xb.purple.adapter.recycle_listview.model.ProductAdapterModel;
import com.rui.xb.purple.ui.activity.home.ProductDetailActivity;
import com.rui.xb.rui_core.utils.UiUtil;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;

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
    private List<ProductAdapterModel> listModels = new ArrayList<>();
    private int pageNo = 1;
    private int pageSize = 5;
    private boolean isOver;

    public void initView() {

        initRefreshLayout();
        initRecyclerView();
        initAdapter();
    }

    private void initAdapter() {
        mAdapter = new MyDispatchAdapter(R.layout.item_my_dispatch, listModels);
        mRecyclerView.setAdapter(mAdapter);

        mModule.requestMyDispatch(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                BaseResponseEntity response = gsonSingle.fromJson(s, BaseResponseEntity.class);
                if (response.getCode() == 1) {
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
        }, 1, pageNo, pageSize);

        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Bundle bundle = new Bundle();
                bundle.putString("productId",mAdapter.getItem(position).getId().toString());
                UiUtil.startIntent(mContext, ProductDetailActivity.class,bundle);
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

    private void dealData(List<Map<String, Object>> productList) {
        for (Map map : productList) {
            ProductAdapterModel product = new ProductAdapterModel();
            product.setId(Integer.parseInt(map.get("id").toString()));
            product.setProductName(map.get("productName").toString());
            product.setDesc(map.get("productDesc").toString());
            product.setMainPic(map.get("mainPic").toString());
            product.setPrice(map.get("price").toString());
            product.setBrows(map.get("clickCount").toString().substring(0, map.get("clickCount")
                    .toString().lastIndexOf(".")));
            product.setSchoolName(map.get("schoolName").toString());
            product.setOnlineTime(map.get("onlineTime").toString());
            product.setCollect((Boolean) map.get("isCollect"));
            product.setAuthen((Boolean) map.get("isAuthen"));
            product.setState(map.get("state").toString());
            listModels.add(product);
        }
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
                if (!isOver) {
                    mModule.requestMyDispatch(new Consumer<String>() {
                        @Override
                        public void accept(String s) throws Exception {
                            BaseResponseEntity response = gsonSingle.fromJson(s,
                                    BaseResponseEntity.class);
                            if (response.getCode() == 1) {
                                Map<String, Object> data = (Map<String, Object>) response.getData();
                                List<Map<String, Object>> productList = (List<Map<String,
                                        Object>>) data.get("productList");
                                dealData(productList);
                                mAdapter.notifyDataSetChanged();
                                isOver = (boolean)data.get("isOver");
                            }
                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Exception {

                        }
                    }, 1, ++pageNo, pageSize);
                }
                if (isOver)mRefreshLayout.setNoMoreData(true);
                mRefreshLayout.finishLoadMore();
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {

            }
        });
    }

}
