package com.rui.xb.purple.ui.activity.home;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.rui.xb.purple.R;
import com.rui.xb.purple.base.BaseActivity;
import com.rui.xb.purple.mvp.presenter.home.ProductDetailPresenter;
import com.rui.xb.purple.mvp.view.home.ProductDetailView;
import com.youth.banner.Banner;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class ProductDetailActivity extends BaseActivity<ProductDetailPresenter> implements
        ProductDetailView {


    @BindView(R.id.banner_pics)
    Banner bannerPics;
    @BindView(R.id.iv_seller_head)
    CircleImageView ivSellerHead;
    @BindView(R.id.tv_seller_name)
    TextView tvSellerName;
    @BindView(R.id.tv_authen)
    TextView tvAuthen;
    @BindView(R.id.tv_school_name)
    TextView tvSchoolName;
    @BindView(R.id.tv_qq)
    TextView tvQq;
    @BindView(R.id.tv_wx)
    TextView tvWx;
    @BindView(R.id.rl_collect)
    RelativeLayout rlCollect;
    @BindView(R.id.rl_talk)
    RelativeLayout rlTalk;
    @BindView(R.id.rl_buy_or_manage)
    RelativeLayout rlBuyOrManage;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.tv_buy_manage)
    TextView tvBuyManage;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.tv_collect_num)
    TextView tvCollectNum;
    @BindView(R.id.tv_brows)
    TextView tvBrows;
    @BindView(R.id.tv_name_and_desc)
    TextView tvNameAndDesc;
    @BindView(R.id.tv_online_time)
    TextView tvOnlineTime;

    @Override
    protected void initTitleBar() {
        setTvTitle("宝贝详情");
        avoidWhiteStatusBar();
        leftClose();
    }

    @Override
    protected int initMainView() {
        return R.layout.activity_product_detail;
    }

    @Override
    protected void initDataAndView() {
        mPresenter.onAttachView(this, this);
        mPresenter.initView(getBundle().getString("productId"));

    }

    @Override
    public Banner getBanner() {
        return bannerPics;
    }

    @Override
    public TextView getTvProName() {
        return tvNameAndDesc;
    }

    @Override
    public TextView getTvProDesc() {
        return null;
    }

    @Override
    public TextView getTvPrice() {
        return tvPrice;
    }

    @Override
    public TextView getTvBrows() {
        return tvBrows;
    }

    @Override
    public TextView getTvOnlineTime() {
        return tvOnlineTime;
    }

    @Override
    public TextView getTvCollectNum() {
        return tvCollectNum;
    }

    @Override
    public CircleImageView getSellerImg() {
        return ivSellerHead;
    }

    @Override
    public TextView getTvSellerNick() {
        return tvSellerName;
    }

    @Override
    public TextView getTvPhone() {
        return tvPhone;
    }

    @Override
    public TextView getTvQq() {
        return tvQq;
    }

    @Override
    public TextView getTvWechat() {
        return tvWx;
    }

    @Override
    public TextView getTvSchoolName() {
        return tvSchoolName;
    }

    @Override
    public TextView getTvAuthen() {
        return tvAuthen;
    }

    @Override
    public TextView getBuyOrManage() {
        return tvBuyManage;
    }

    @Override
    public RelativeLayout getRlBuyOrManage() {
        return rlBuyOrManage;
    }


    @OnClick({R.id.rl_collect, R.id.rl_talk})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_collect:
                Toast.makeText(ProductDetailActivity.this, "1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rl_talk:
                Toast.makeText(ProductDetailActivity.this, "2", Toast.LENGTH_SHORT).show();
                break;
        }
    }

}
