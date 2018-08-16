package com.rui.xb.purple.mvp.view.me.address;

import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.rui.xb.purple.mvp.base.BaseMVPView;

/**
 * Created by Rui on 2018/7/24.
 */

public interface AddressAddView extends BaseMVPView {

    EditText getEtReceiveName();

    EditText getEtPhone();

    EditText getEtLocation();

    TextView getTvProvince();

    ToggleButton getTbSetDefault();

}
