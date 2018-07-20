package com.rui.xb.purple.mvp.presenter.message;

import com.rui.xb.purple.mvp.base.BaseMVPPresenter;
import com.rui.xb.purple.mvp.model.message.MessageModel;
import com.rui.xb.purple.mvp.view.message.MessageView;

import javax.inject.Inject;

/**
 * Created by Rui on 2018/7/16.
 */

public class MessagePresenter extends BaseMVPPresenter<MessageModel,MessageView> {

    @Inject
    public MessagePresenter() {
    }
}
