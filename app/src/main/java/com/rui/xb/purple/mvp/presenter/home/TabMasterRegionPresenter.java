package com.rui.xb.purple.mvp.presenter.home;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.rui.xb.purple.R;
import com.rui.xb.purple.base.BaseResponseModel;
import com.rui.xb.purple.mvp.base.BaseMVPPresenter;
import com.rui.xb.purple.mvp.model.home.TabMasterRegionModel;
import com.rui.xb.purple.mvp.view.home.TabMasterRegionView;
import com.rui.xb.purple.ui.adapter.recycle_listview.ProductAdapter;
import com.rui.xb.purple.ui.adapter.recycle_listview.model.CategoryLeftRightAdapterModel;
import com.rui.xb.purple.ui.adapter.recycle_listview.model.ProductAdapterModel;
import com.rui.xb.purple.ui.fragment.tablayout.TabLayoutFragment;
import com.rui.xb.purple.ui.tablayout.SimplePageAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Created by Rui on 2018/7/19.
 */

public class TabMasterRegionPresenter extends BaseMVPPresenter<TabMasterRegionModel,TabMasterRegionView> {

    @Inject
    public TabMasterRegionPresenter() {
    }

    private List<CategoryLeftRightAdapterModel> categoryLevel3 = new ArrayList<>();

    private List<Fragment> mFragments = new ArrayList<>();

    private String[] mTitles;

    private SimplePageAdapter adapter;

    private FragmentManager mFragmentManager;


    private ProductAdapter proAdapter;

    private SmartRefreshLayout refreshLayout;

    private RecyclerView recyclerView;

    public void initView(FragmentManager fm) {
        mFragmentManager = fm;
        initTabLayout();

    }



    private void initTabLayout() {
        Disposable disposable = mModule.requestSubClass(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                BaseResponseModel model = gsonSingle.fromJson(s, BaseResponseModel.class);
                dealData(model);

            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {

            }
        }, "11");
        addDisposable(disposable);
    }

    private void dealData(BaseResponseModel model) {
        if (model.getCode() == 1) {
            List<Map<String, Object>> maps = (List<Map<String, Object>>) model.getData();
            mTitles = new String[maps.size()];
            for (int i = 0; i < maps.size(); i++) {
                CategoryLeftRightAdapterModel adapterModel = new CategoryLeftRightAdapterModel();
                String id = maps.get(i).get("id").toString();
                String name = maps.get(i).get("name").toString();
                adapterModel.setId(id);
                adapterModel.setName(name);
                categoryLevel3.add(adapterModel);
                mTitles[i] = name;
                mFragments.add(TabLayoutFragment.getInstance(""));
            }
        }
        adapter = new SimplePageAdapter(mFragmentManager, mFragments, mTitles);
        mView.getViewPage().setAdapter(adapter);
        mView.getTabLayout().setViewPager(mView.getViewPage(), mTitles);

        initRvProduct(categoryLevel3.get(0).getId());
    }

    private void initRvProduct(String subId) {

        recyclerView = mView.getRvProduct();
        recyclerView.setLayoutManager(new GridLayoutManager(mContext, 2));
        List<ProductAdapterModel> list = new ArrayList<>();
        //网络请求
        for (int i = 0; i < 10;i++){
            ProductAdapterModel model = new ProductAdapterModel();
            model.setId(i);
            model.setBrows(i +"");
            model.setMainPic(i + "");
            model.setPrice(i + "");
            model.setProductName("商品" + i);
            model.setSchoolName("大学" + i);
            list.add(model);
        }
        //
        initAdapter(list,recyclerView);
        initRefreshLayout();


    }

    private void initRefreshLayout() {
        refreshLayout = mView.getFreshLayout();
        refreshLayout.setEnableRefresh(false);
        refreshLayout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                Toast.makeText(mContext,"",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                refreshLayout.finishLoadMore(1000);
            }
        });
    }


    private void initAdapter(List<ProductAdapterModel> list, RecyclerView recyclerView) {
        proAdapter = new ProductAdapter(R.layout.item_product_card,list);
        proAdapter.openLoadAnimation();
        recyclerView.setAdapter(proAdapter);
    }
}
