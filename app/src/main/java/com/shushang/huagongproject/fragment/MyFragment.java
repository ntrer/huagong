package com.shushang.huagongproject.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.shushang.huagongproject.R;
import com.shushang.huagongproject.activity.RestPwdActivity;
import com.shushang.huagongproject.activity.UserActivity;
import com.shushang.huagongproject.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MyFragment extends BaseFragment {


    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.avatar)
    ImageView mAvatar;
    @BindView(R.id.user_name)
    TextView mUserName;
    @BindView(R.id.merchant_name)
    TextView mMerchantName;
    @BindView(R.id.fragment_app_bg)
    RelativeLayout mFragmentAppBg;
    @BindView(R.id.user_profile)
    LinearLayout mLianmengZhangdan;
    @BindView(R.id.line1)
    View mLine1;
    Unbinder unbinder;
    @BindView(R.id.reset_pwd)
    LinearLayout mResetPwd;
    Unbinder unbinder1;

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        unbinder = ButterKnife.bind(this, rootView);
    }

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_my, null);
        return view;
    }


    @OnClick(R.id.user_profile)
    void Profile() {
        startActivity(new Intent(getActivity(),UserActivity.class));
    }

    @OnClick(R.id.reset_pwd)
    void ResetPwd() {
        startActivity(new Intent(getActivity(),RestPwdActivity.class));
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
