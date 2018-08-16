package com.rui.xb.purple.mvp.view.home;

import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rui.xb.purple.mvp.base.BaseMVPView;

/**
 * Created by Rui on 2018/7/19.
 */

public interface OrderDetailView extends BaseMVPView {

    ImageView getProIv();

    TextView getProName();

    TextView getProPrice();

    TextView getTvPhoneAndName();

    TextView getTvAdd();

    TextView getTvTtype();

    TextView getTvTfee();

    TextView getTvRealPrice();

    TextView getTvSubmitOrder();
}
