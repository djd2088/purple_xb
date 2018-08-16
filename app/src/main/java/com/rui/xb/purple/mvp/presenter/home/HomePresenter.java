package com.rui.xb.purple.mvp.presenter.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.rui.xb.purple.R;
import com.rui.xb.purple.base.BaseResponseEntity;
import com.rui.xb.purple.mvp.base.BaseMVPPresenter;
import com.rui.xb.purple.mvp.model.home.HomeModel;
import com.rui.xb.purple.mvp.view.home.HomeView;
import com.rui.xb.purple.ui.activity.home.GroupBuyingActivity;
import com.rui.xb.purple.ui.activity.home.MasterLifeActivity;
import com.rui.xb.purple.ui.activity.home.ProductDetailActivity;
import com.rui.xb.purple.ui.activity.home.RequestRegionActivity;
import com.rui.xb.purple.adapter.recycle_listview.ProductAdapter;
import com.rui.xb.purple.adapter.recycle_listview.model.ProductAdapterModel;
import com.rui.xb.purple.utils.GlideImageLoader;
import com.rui.xb.rui_core.utils.UiUtil;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;
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

    private List<ProductAdapterModel> products = new ArrayList<>();

    private int pageNo = 1;

    private int pageSize = 8;

    private boolean isOver;


    public void initView() {
        initRvProduct();
    }


    public void initRvProduct() {

        initRefreshLayout();
        initRecyclerView();
        requestFirstTime();
        initAdapter(products, recyclerView);

    }

    private void requestFirstTime() {
        Disposable disposable = mModule.requestProductList(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                BaseResponseEntity model = gsonSingle.fromJson(s, BaseResponseEntity.class);
                if (model.getCode() == 1) {
                    Map<String, Object> data = (Map<String, Object>) model.getData();
                    List<Map<String, Object>> productList = (List<Map<String, Object>>) data.get
                            ("productList");
                    dealData(productList);
                }
            }

        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                Log.i(TAG, "accept: " + throwable);
            }
        }, pageNo, pageSize, 1);
        addDisposable(disposable);
    }

    private void initRecyclerView() {
        recyclerView = mView.getRvProduct();
        recyclerView.setLayoutManager(new GridLayoutManager(mContext, 2));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    private void initRefreshLayout() {
        refreshLayout = mView.getSmartRefresh();
        refreshLayout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onRefresh(@NonNull final RefreshLayout refreshLayout) {
                products.clear();
                pageNo = 1;
                Disposable disposable = mModule.requestProductList(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        BaseResponseEntity model = gsonSingle.fromJson(s, BaseResponseEntity.class);
                        if (model.getCode() == 1) {
                            Map<String, Object> data = (Map<String, Object>) model.getData();
                            List<Map<String, Object>> productList = (List<Map<String, Object>>)
                                    data.get("productList");
                            dealData(productList);
                            adapter.notifyDataSetChanged();
                            refreshLayout.finishRefresh(1000);
                            refreshLayout.setNoMoreData(false);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.i(TAG, "accept: " + throwable);
                    }
                }, pageNo, pageSize, 1);
                addDisposable(disposable);
            }

            @Override
            public void onLoadMore(@NonNull final RefreshLayout refreshLayout) {
                if (!isOver) {
                    Disposable disposable = mModule.requestProductList(new Consumer<String>() {
                        @Override
                        public void accept(String s) throws Exception {
                            BaseResponseEntity model = gsonSingle.fromJson(s, BaseResponseEntity
                                    .class);
                            if (model.getCode() == 1) {
                                Map<String, Object> data = (Map<String, Object>) model.getData();
                                List<Map<String, Object>> productList = (List<Map<String,
                                        Object>>) data.get("productList");
                                dealData(productList);
                                adapter.notifyDataSetChanged();
                                isOver = (boolean) data.get("isOver");
                            }
                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Exception {
                            Log.i(TAG, "accept: " + throwable);
                        }
                    }, ++pageNo, pageSize, 1);
                    addDisposable(disposable);
                }
                if (isOver)refreshLayout.setNoMoreData(true);
                refreshLayout.finishLoadMore();

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
                ProductAdapterModel item = (ProductAdapterModel) adapter.getItem(position);
                Bundle data = new Bundle();
                data.putString("productId", item.getId().toString());
                UiUtil.startIntent(mContext, ProductDetailActivity.class, data);
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
            products.add(product);
        }
    }
}
