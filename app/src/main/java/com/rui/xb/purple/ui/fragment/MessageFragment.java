package com.rui.xb.purple.ui.fragment;


import android.support.v4.app.Fragment;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.rui.xb.purple.R;
import com.rui.xb.purple.base.BaseFragment;
import com.rui.xb.purple.mvp.presenter.message.MessagePresenter;
import com.rui.xb.purple.mvp.view.message.MessageView;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class MessageFragment extends BaseFragment<MessagePresenter> implements MessageView {


    @BindView(R.id.tl_message_title)
    CommonTabLayout tlMessageTitle;

    private String[] mTitles = {"消息", "通知"};
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private int[] mIconUnselectIds = {
            R.mipmap.tab_class, R.mipmap.tab_home};
    private int[] mIconSelectIds = {
            R.mipmap.tab_class_hover, R.mipmap.tab_home_hover};

    @Inject
    public MessageFragment() {
        // Required empty public constructor
    }


    @Override
    protected void initTitleBar() {
        setTvTitle("消息");
        hideIvLeft();
        transparentStatusBar(true);
    }

    @Override
    protected int initMainView() {
        return R.layout.fragment_message;
    }

    @Override
    protected void initDataAndView() {

//      if (mFragments.size() == 0){
//          for (String s : mTitles) {
//              mFragments.add(TabLayoutFragment.getInstance(s));
//          }
//
//          for (int i = 0; i < mTitles.length; i++) {
//              mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
//          }
//
//      }
//        tlMessageTitle.setTabData(mTabEntities, getActivity(),R.id.fl_change, mFragments);
    }


}
