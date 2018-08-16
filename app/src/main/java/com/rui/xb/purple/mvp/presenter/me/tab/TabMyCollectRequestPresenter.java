package com.rui.xb.purple.mvp.presenter.me.tab;

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
import com.rui.xb.purple.mvp.model.me.tab.TabMyCollectIdleModel;
import com.rui.xb.purple.mvp.model.me.tab.TabMyCollectRequestModel;
import com.rui.xb.purple.mvp.view.me.tab.TabMyCollectRequestView;
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
 * Created by Rui on 2018/7/17.
 */

public class TabMyCollectRequestPresenter extends BaseMVPPresenter<TabMyCollectRequestModel,
        TabMyCollectRequestView> {


    @Inject
    public TabMyCollectRequestPresenter() {
    }

    private SmartRefreshLayout mRefreshLayout;
    private RecyclerView mRecyclerView;
    private MyRequestAdapter mAdapter;
    private List<MyRequestAdapterModel> listModels = new ArrayList<>();
    @Inject
    TabMyCollectIdleModel tabModel;
    private int pageNo = 1;
    private int pageSize = 10;

    public void initView() {

        initRefreshLayout();
        initRecyclerView();

//        List<MyRequestAdapterModel> list = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            MyRequestAdapterModel model = new MyRequestAdapterModel();
//            model.setTitle("求购标题" + i);
//            model.setDesc("求购描述" + i);
//            model.setRequesterName("求购者name" + i);
//            model.setDesirePrice("价格" + i);
//            model.setTime("2018-02-19 20:19:22");
//            model.setPhone("phone" + i);
//            model.setQq("qq" + i);
//            model.setWx("wx" + i);
//            model.setSchoolName("大学" + i);
//            list.add(model);
//        }
        initAdapter();
    }

    private void initAdapter() {
        mAdapter = new MyRequestAdapter(R.layout.item_request_card, listModels);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(mContext, position + "", Toast.LENGTH_SHORT).show();
            }
        });

        tabModel.requestCollectIdle(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                BaseResponseEntity response = gsonSingle.fromJson(s,BaseResponseEntity.class);
                if (response.getCode() == 1){
                    Map<String, Object> data = (Map<String, Object>) response.getData();
                    List<Map<String, Object>> collectList = (List<Map<String, Object>>) data.get
                            ("collectList");
                    dealData(collectList);
                    mAdapter.notifyDataSetChanged();
                }
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {

            }
        },pageNo,pageSize,2);

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
            MyRequestAdapterModel collect = new MyRequestAdapterModel();
            collect.setTitle(map.get("productName").toString());
            collect.setDesc(map.get("productDesc").toString());
            collect.setDesirePrice(map.get("price").toString());
            collect.setSchoolName(map.get("schoolName").toString());
            collect.setTime(map.get("onlineTime").toString());
            Map<String,Object> userMap = (Map<String, Object>) map.get("sellerInfo");
            collect.setRequesterName(userMap.get("nickname").toString());
            collect.setHeadImg(userMap.get("avatar").toString());
            collect.setPhone(userMap.get("phone").toString());
            collect.setQq(userMap.get("qq").toString());
            collect.setWx(userMap.get("wechat").toString());
            collect.setRequesterId(userMap.get("id").toString());
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
