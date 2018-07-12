package com.rui.xb.purple.mvp.presenter.category;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.rui.xb.purple.R;
import com.rui.xb.purple.base.BaseResponseModel;
import com.rui.xb.purple.mvp.base.BaseMVPPresenter;
import com.rui.xb.purple.mvp.model.category.CategoryFragmentModel;
import com.rui.xb.purple.mvp.view.category.CategoryFragmentView;
import com.rui.xb.purple.ui.adapter.recycle_listview.CategoryLeftAdapter;
import com.rui.xb.purple.ui.adapter.recycle_listview.CategoryRightAdapter;
import com.rui.xb.purple.ui.adapter.recycle_listview.model.CategoryLeftRightAdapterModel;
import com.rui.xb.rui_core.app.Rui;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;

/**
 * Created by Rui on 2018/7/10.
 */

public class CategoryFragmentPresenter extends BaseMVPPresenter<CategoryFragmentModel, CategoryFragmentView> {

    private static final String TAG = "CategoryFragmentPresenter";

    @Inject
    public CategoryFragmentPresenter() {
    }

    private CategoryLeftAdapter categoryLeftAdapter;

    private CategoryRightAdapter categoryRightAdapter;

    private List<CategoryLeftRightAdapterModel> leftList = new ArrayList<>();

    private List<CategoryLeftRightAdapterModel> rightList = new ArrayList<>();

    private RecyclerView rvLeft;

    private RecyclerView rvRight;

    public void initView() {
        requestCategoryLevelOne();
    }


    private void requestCategoryLevelOne() {
        initRightAdapter();
        mModule.requestSubClass(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                BaseResponseModel model = gsonSingle.fromJson(s, BaseResponseModel.class);
                initLeftAdapter(model);
                initRightData();
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                Toast.makeText(Rui.getApplicationContext(), "error", Toast.LENGTH_SHORT).show();
            }
        },"0");
    }

    private void initLeftAdapter(final BaseResponseModel model) {
        dealData(model,"left");
        categoryLeftAdapter = new CategoryLeftAdapter(R.layout.item_category_left, leftList);
        rvLeft = mView.getRvCategoryLeft();
        rvLeft.setLayoutManager(new LinearLayoutManager(mContext));
        rvLeft.setAdapter(categoryLeftAdapter);

        //监听
        categoryLeftAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(mContext, position + "", Toast
                        .LENGTH_SHORT).show();
                categoryLeftAdapter.setClickItem(position);
                categoryLeftAdapter.notifyDataSetChanged();
                rightList.clear();
                //改变right
                mModule.requestSubClass(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        BaseResponseModel model = gsonSingle.fromJson(s, BaseResponseModel.class);
                        dealData(model,"right");
                        categoryRightAdapter.setNewData(rightList);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                },leftList.get(position).getId());
            }
        });
    }

    private void dealData(BaseResponseModel model, String type) {
        if (model.getCode() == 1){
            List<Map<String,Object>> maps = (List<Map<String,Object>>) model.getData();
            for (Map<String,Object> map : maps){
                CategoryLeftRightAdapterModel adapterModel = new CategoryLeftRightAdapterModel();
                adapterModel.setId(map.get("id").toString());
                adapterModel.setName(map.get("name").toString());
                if (type.equals("left")){
                    leftList.add(adapterModel);
                }else {
                    List<Map<String,Object>> mapList = (List<Map<String, Object>>) map.get("subClass");
                    List<CategoryLeftRightAdapterModel> subClass = new ArrayList<>();
                    for (Map<String,Object> sub : mapList){
                        CategoryLeftRightAdapterModel subModel = new CategoryLeftRightAdapterModel();
                        subModel.setId(sub.get("id").toString());
                        subModel.setName(sub.get("name").toString());
                        subClass.add(subModel);
                    }
                    adapterModel.setSubClass(subClass);
                    rightList.add(adapterModel);
                }
            }
        }
    }

    private void initRightAdapter() {
        categoryRightAdapter = new CategoryRightAdapter(R.layout.item_category_right,null);
        rvRight = mView.getRvCategoryRight();
        rvRight.setLayoutManager(new LinearLayoutManager(mContext));
        rvRight.setAdapter(categoryRightAdapter);

    }

    private void initRightData() {
        //初始数据
        mModule.requestSubClass(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                BaseResponseModel model = gsonSingle.fromJson(s, BaseResponseModel.class);
                dealData(model,"right");
                categoryRightAdapter.setNewData(rightList);

            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {

            }
        },leftList.get(0).getId());
    }
}
