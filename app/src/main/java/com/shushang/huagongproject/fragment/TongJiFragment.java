package com.shushang.huagongproject.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.shushang.huagongproject.R;
import com.shushang.huagongproject.activity.CaiGouDingDanTongjiActivity;
import com.shushang.huagongproject.activity.ShengChanRenWuDanTongJiActivity;
import com.shushang.huagongproject.activity.TuiHuoTongJIActivity;
import com.shushang.huagongproject.activity.XiaoShouDingDanTongJiActivity;
import com.shushang.huagongproject.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class TongJiFragment extends BaseFragment {


    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.caigoudingdantongji)
    LinearLayout mCaigoudingdantongji;
    @BindView(R.id.xiaoshoudingdantongjin)
    LinearLayout mXiaoshoudingdantongjin;
    @BindView(R.id.line3)
    View mLine3;
    @BindView(R.id.shengchanrenwudantongji)
    LinearLayout mShengchanrenwudantongji;
    @BindView(R.id.tuihuotongji)
    LinearLayout mTuihuotongji;
    Unbinder unbinder;

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        unbinder = ButterKnife.bind(this, rootView);
    }

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_tongji, null);
        return view;
    }


    @OnClick(R.id.caigoudingdantongji)
    void CaiGou() {
        startActivity(new Intent(getActivity(),CaiGouDingDanTongjiActivity.class));
    }

    @OnClick(R.id.xiaoshoudingdantongjin)
    void Xiaoshou() {
        startActivity(new Intent(getActivity(),XiaoShouDingDanTongJiActivity.class));
    }

    @OnClick(R.id.shengchanrenwudantongji)
    void ShengChan() {
        startActivity(new Intent(getActivity(),ShengChanRenWuDanTongJiActivity.class));
    }

    @OnClick(R.id.tuihuotongji)
    void TuiHuo() {
        startActivity(new Intent(getActivity(),TuiHuoTongJIActivity.class));
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
