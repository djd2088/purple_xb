package com.rui.xb.purple.ui.fragment.tablayout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rui.xb.purple.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class TabLayoutFragment extends Fragment {

    @BindView(R.id.tv_title)
    TextView tvTitle;

    String title;


    public static TabLayoutFragment getInstance(String title) {
        TabLayoutFragment sf = new TabLayoutFragment();
        sf.title = title;
        return sf;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        View v = inflater.inflate(R.layout.tab_layout, null);

        ButterKnife.bind(this, v);
        tvTitle.setText(title);
        return v;
    }

}