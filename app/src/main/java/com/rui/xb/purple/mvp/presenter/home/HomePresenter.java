package com.rui.xb.purple.mvp.presenter.home;

import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.rui.xb.purple.R;
import com.rui.xb.purple.mvp.base.BaseMVPPresenter;
import com.rui.xb.purple.mvp.model.home.HomeModel;
import com.rui.xb.purple.mvp.view.home.HomeView;
import com.rui.xb.purple.ui.activity.home.GroupBuyingActivity;
import com.rui.xb.purple.ui.activity.home.MasterLifeActivity;
import com.rui.xb.purple.ui.activity.home.ProductDetailActivity;
import com.rui.xb.purple.ui.activity.home.RequestRegionActivity;
import com.rui.xb.purple.ui.adapter.recycle_listview.ProductAdapter;
import com.rui.xb.purple.ui.adapter.recycle_listview.model.ProductAdapterModel;
import com.rui.xb.purple.utils.GlideImageLoader;
import com.rui.xb.rui_core.app.Rui;
import com.rui.xb.rui_core.utils.UiUtil;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;

/**
 * Created by Rui on 2018/7/4.
 */

public class HomePresenter extends BaseMVPPresenter<HomeModel, HomeView> {

    private static final String TAG = "HomePresenter";

    @Inject
    public HomePresenter() {
    }

    private ProductAdapter adapter;

    private SmartRefreshLayout refreshLayout;

    private RecyclerView recyclerView;


    public void initView() {
        initRvProduct();
    }


    public void initRvProduct() {

        mModule.login(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.i(TAG, "accept_login=: " + s);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                Log.i(TAG, "accept: " + throwable);
                Toast.makeText(Rui.getApplicationContext(), throwable.toString(), Toast
                        .LENGTH_SHORT).show();
            }
        });

        mModule.logout(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.i(TAG, "accept_logout=: " + s);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {

            }
        });

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

        initRefreshLayout();
        initRecyclerView();
        initAdapter(list, recyclerView);

    }

    private void initRecyclerView() {
        recyclerView = mView.getRvProduct();
        recyclerView.setLayoutManager(new GridLayoutManager(mContext, 2));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    private void initRefreshLayout() {
        refreshLayout = mView.getSmartRefresh();
        refreshLayout.autoRefresh();
        refreshLayout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                refreshLayout.finishRefresh(1000);
                refreshLayout.setNoMoreData(false);

            }

            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                refreshLayout.finishLoadMore(1000);
            }
        });
    }

    private void initAdapter(List<ProductAdapterModel> list, RecyclerView recyclerView) {
        adapter = new ProductAdapter(R.layout.item_product_card, list);
        adapter.openLoadAnimation();
        View view = LayoutInflater.from(mContext).inflate(R.layout.home_header, (ViewGroup)
                recyclerView.getParent(), false);
        Banner banner = view.findViewById(R.id.banner_home);
        initBanner(banner);
        adapter.addHeaderView(view);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                UiUtil.startIntent(mContext, ProductDetailActivity.class);
            }
        });
        recyclerView.setAdapter(adapter);

        init3Btn(view);
    }


    public void initBanner(Banner banner) {
        List<Integer> images = new ArrayList<>();
        images.add(R.mipmap.banner1);
        images.add(R.mipmap.banner2);
        images.add(R.mipmap.banner3);
        images.add(R.mipmap.banner4);
        banner.setIndicatorGravity(BannerConfig.CENTER)
                .setImageLoader(new GlideImageLoader())
                .setImages(images).start();
    }


    private void init3Btn(View view) {
        LinearLayout llRequestRegion = view.findViewById(R.id.ll_request_region);
        LinearLayout llMasterLife = view.findViewById(R.id.ll_master_life);
        LinearLayout llGroupBuy = view.findViewById(R.id.ll_group_buy);


        llRequestRegion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UiUtil.startIntent(mContext, RequestRegionActivity.class);
            }
        });

        llMasterLife.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UiUtil.startIntent(mContext, MasterLifeActivity.class);
            }
        });

        llGroupBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UiUtil.startIntent(mContext, GroupBuyingActivity.class);
            }
        });
    }
}
