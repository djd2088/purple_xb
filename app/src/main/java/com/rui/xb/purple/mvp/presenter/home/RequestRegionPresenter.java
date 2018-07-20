package com.rui.xb.purple.mvp.presenter.home;

import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.rui.xb.purple.R;
import com.rui.xb.purple.mvp.base.BaseMVPPresenter;
import com.rui.xb.purple.mvp.model.home.HomeModel;
import com.rui.xb.purple.mvp.model.home.RequestRegionModel;
import com.rui.xb.purple.mvp.view.home.HomeView;
import com.rui.xb.purple.mvp.view.home.RequestRegionView;
import com.rui.xb.purple.ui.adapter.recycle_listview.MyDispatchAdapter;
import com.rui.xb.purple.ui.adapter.recycle_listview.MyRequestAdapter;
import com.rui.xb.purple.ui.adapter.recycle_listview.ProductAdapter;
import com.rui.xb.purple.ui.adapter.recycle_listview.model.MyRequestAdapterModel;
import com.rui.xb.purple.ui.adapter.recycle_listview.model.ProductAdapterModel;
import com.rui.xb.purple.utils.GlideImageLoader;
import com.rui.xb.rui_core.app.Rui;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;

import static android.widget.LinearLayout.VERTICAL;

/**
 * Created by Rui on 2018/7/4.
 */

public class RequestRegionPresenter extends BaseMVPPresenter<RequestRegionModel,RequestRegionView> {

    @Inject
    public RequestRegionPresenter() {
    }


    private SmartRefreshLayout mRefreshLayout;
    private RecyclerView mRecyclerView;
    private MyRequestAdapter mAdapter;

    public void initView() {

        initRefreshLayout();
        initRecyclerView();

        List<MyRequestAdapterModel> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            MyRequestAdapterModel model = new MyRequestAdapterModel();
            model.setTitle("求购标题" + i);
            model.setDesc("求购描述" + i);
            model.setRequesterName("求购者name" + i);
            model.setDesirePrice("价格" + i);
            model.setTime("2018-02-19 20:19:22");
            model.setPhone("phone" + i);
            model.setQq("qq" + i);
            model.setWx("wx" + i);
            model.setSchoolName("大学" + i);
            list.add(model);
        }
        initAdapter(list);
    }

    private void initAdapter(List<MyRequestAdapterModel> list) {
        mAdapter = new MyRequestAdapter(R.layout.item_request_card, list);
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
