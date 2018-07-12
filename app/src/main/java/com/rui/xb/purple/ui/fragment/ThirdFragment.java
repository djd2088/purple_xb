package com.rui.xb.purple.ui.fragment;


import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.rui.xb.purple.R;
import com.rui.xb.purple.base.BaseFragment;
import com.rui.xb.purple.mvp.presenter.TestPresenter;
import com.rui.xb.purple.mvp.view.TestView;
import com.rui.xb.purple.ui.adapter.recycle_listview.ProductAdapter;
import com.rui.xb.purple.ui.adapter.recycle_listview.model.ProductAdapterModel;
import com.rui.xb.purple.utils.GlideImageLoader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ThirdFragment extends BaseFragment<TestPresenter> implements TestView {

    @Inject
    public ThirdFragment() {
    }

    @BindView(R.id.test_product)
    RecyclerView rvProduct;

    @BindView(R.id.test_refresh)
    SmartRefreshLayout refreshLayoutProduct;
    @Override
    protected void initTitleBar() {
        setLlTitleBgDrawable(R.drawable.status_bar_background);
        setTvTitle("");
        showTvLeft("上海大学",R.color.white,0);
        setIvLeftRes(R.mipmap.password_hidden);
    }

    @Override
    protected int initMainView() {
        return R.layout.fragment_third;
    }

    @Override
    protected void initDataAndView() {
        List<ProductAdapterModel> list = new ArrayList<>();
        for (int i = 0; i < 10;i++){
            ProductAdapterModel model = new ProductAdapterModel();
            model.setId(i);
            model.setBrows(i +"");
            model.setImageUrl(i + "");
            model.setPrice(i + "");
            model.setProductName(i + "");
            model.setSchoolName(i + "");
            list.add(model);
        }
        ProductAdapter adapter = new ProductAdapter(R.layout.item_product_card,list);
        View view = getLayoutInflater().inflate(R.layout.fragment_home, (ViewGroup) rvProduct.getParent(),false);
        Banner banner = view.findViewById(R.id.banner_home);
        initBanner(banner);
        adapter.addHeaderView(view);
//        refreshLayout.autoRefresh();
        rvProduct.setLayoutManager(new GridLayoutManager(mContext,2));
//        rvCategoryLeft.addItemDecoration(new DividerItemDecoration(mContext,DividerItemDecoration
//                .VERTICAL));
        rvProduct.setItemAnimator(new DefaultItemAnimator());
        rvProduct.setAdapter(adapter);


        refreshLayoutProduct.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {

            }

            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {

            }
        });

    }

    @Override
    public Button getBtnImButton() {
        return null;
    }

    public void initBanner(Banner banner){
        List<Integer> images = new ArrayList<>();
        images.add(R.mipmap.banner1);
        images.add(R.mipmap.banner2);
        images.add(R.mipmap.banner3);
        images.add(R.mipmap.banner4);
        banner.setIndicatorGravity(BannerConfig.CENTER)
                .setImageLoader(new GlideImageLoader())
                .setImages(images).start();

    }
}

