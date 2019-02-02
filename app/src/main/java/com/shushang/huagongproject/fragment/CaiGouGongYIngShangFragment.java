package com.shushang.huagongproject.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.shushang.huagongproject.R;
import com.shushang.huagongproject.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class CaiGouGongYIngShangFragment extends BaseFragment {


    @BindView(R.id.rv_gongyingshang)
    RecyclerView mRvGongyingshang;
    @BindView(R.id.srl_gongyingshang)
    SwipeRefreshLayout mSrlGongyingshang;
    @BindView(R.id.ll_no_data)
    LinearLayout mLlNoData;
    Unbinder unbinder;

    public CaiGouGongYIngShangFragment() {
        // Required empty public constructor
    }

    public static CaiGouGongYIngShangFragment newInstance() {
        return new CaiGouGongYIngShangFragment();
    }


    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        unbinder = ButterKnife.bind(this, rootView);
    }

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_caigou_gongyingshang, null);
        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
