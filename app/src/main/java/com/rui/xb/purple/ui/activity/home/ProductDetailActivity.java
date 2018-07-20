package com.rui.xb.purple.ui.activity.home;

import android.view.View;
import android.widget.Toast;

import com.rui.xb.purple.R;
import com.rui.xb.purple.base.BaseActivity;
import com.rui.xb.purple.mvp.presenter.home.ProductDetailPresenter;
import com.rui.xb.purple.mvp.view.home.ProductDetailView;
import com.rui.xb.rui_core.utils.UiUtil;
import com.youth.banner.Banner;

import butterknife.BindView;
import butterknife.OnClick;

public class ProductDetailActivity extends BaseActivity<ProductDetailPresenter> implements
        ProductDetailView {


    @BindView(R.id.banner_pics)
    Banner bannerPics;

    @Override
    protected void initTitleBar() {
        setTvTitle("宝贝详情");
        transparentStatusBar(true);
        leftClose();
    }

    @Override
    protected int initMainView() {
        return R.layout.activity_product_detail;
    }

    @Override
    protected void initDataAndView() {
        mPresenter.onAttachView(this, this);
        mPresenter.initView();

    }

    @Override
    public Banner getBanner() {
        return bannerPics;
    }


    @OnClick({R.id.rl_collect, R.id.rl_talk, R.id.rl_buy_or_manage})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_collect:
                Toast.makeText(ProductDetailActivity.this,"1",Toast.LENGTH_SHORT).show();
                break;
            case R.id.rl_talk:
                Toast.makeText(ProductDetailActivity.this,"2",Toast.LENGTH_SHORT).show();
                break;
            case R.id.rl_buy_or_manage:
                UiUtil.startIntent(this, OrderDetailActivity.class);
                break;
        }
    }
}
