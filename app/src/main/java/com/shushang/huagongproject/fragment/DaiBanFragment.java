package com.shushang.huagongproject.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.shushang.huagongproject.R;
import com.shushang.huagongproject.base.BaseFragment;

public class DaiBanFragment extends BaseFragment {

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_daiban, null);
        return view;
    }
}
