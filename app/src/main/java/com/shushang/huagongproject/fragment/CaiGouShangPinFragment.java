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

public class CaiGouShangPinFragment extends BaseFragment {


    @BindView(R.id.rv_shangpin)
    RecyclerView mRvShangpin;
    @BindView(R.id.srl_shangpin)
    SwipeRefreshLayout mSrlShangpin;
    @BindView(R.id.ll_no_data)
    LinearLayout mLlNoData;
    Unbinder unbinder;

    public CaiGouShangPinFragment() {
        // Required empty public constructor
    }

    public static CaiGouShangPinFragment newInstance() {
        return new CaiGouShangPinFragment();
    }


    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        unbinder = ButterKnife.bind(this, rootView);
    }

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_caigou_shangpin, null);
        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
