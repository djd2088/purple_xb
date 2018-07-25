package com.rui.xb.purple.mvp.view.home;

import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rui.xb.purple.mvp.base.BaseMVPView;
import com.youth.banner.Banner;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Rui on 2018/7/18.
 */

public interface ProductDetailView extends BaseMVPView {

    Banner getBanner();

    TextView getTvProName();

    TextView getTvProDesc();

    TextView getTvPrice();

    TextView getTvBrows();

    TextView getTvOnlineTime();

    CircleImageView getSellerImg();

    TextView getTvSellerNick();

    TextView getTvPhone();

    TextView getTvQq();

    TextView getTvWechat();

    TextView getTvSchoolName();

    TextView getTvAuthen();

    TextView getBuyOrManage();

    RelativeLayout getRlBuyOrManage();
}
