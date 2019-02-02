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
import com.shushang.huagongproject.activity.CaiGouDingDanGuanLiActivity;
import com.shushang.huagongproject.activity.DiaoBoDanActivity;
import com.shushang.huagongproject.activity.KaiPiaoDanGuanLiActivity;
import com.shushang.huagongproject.activity.KeHuGuanLiActivity;
import com.shushang.huagongproject.activity.KuCunChaXunActivity;
import com.shushang.huagongproject.activity.RenYuanGuanLiActivity;
import com.shushang.huagongproject.activity.RukuGuanLiActivity;
import com.shushang.huagongproject.activity.ShangPinGuanLiActivity;
import com.shushang.huagongproject.activity.ShengChanRenWuDanGuanLiActivity;
import com.shushang.huagongproject.activity.TuiHuoDanGuanLiActivity;
import com.shushang.huagongproject.activity.XiaoShouDingDanGuanLiActivity;
import com.shushang.huagongproject.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class ShouYeFragment extends BaseFragment {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.benyuexiaoshoue)
    TextView mBenyuexiaoshoue;
    @BindView(R.id.benyuexiaoshoue_text)
    TextView mBenyuexiaoshoueText;
    @BindView(R.id.bishu)
    TextView mBishu;
    @BindView(R.id.xiaoshouliang)
    TextView mXiaoshouliang;
    @BindView(R.id.money)
    TextView mMoney;
    @BindView(R.id.yishouzhangdan)
    TextView mYishouzhangdan;
    @BindView(R.id.header)
    RelativeLayout mHeader;
    @BindView(R.id.icon1)
    ImageView mIcon1;
    @BindView(R.id.tab1)
    RelativeLayout mTab1;
    @BindView(R.id.activity_kehuguanli)
    LinearLayout mActivityKehuguanli;
    @BindView(R.id.activity_shanghuguanli)
    LinearLayout mActivityShanghuguanli;
    @BindView(R.id.activity_renyuangunali)
    LinearLayout mActivityRenyuangunali;
    @BindView(R.id.first_line)
    LinearLayout mFirstLine;
    @BindView(R.id.icon2)
    ImageView mIcon2;
    @BindView(R.id.tab2)
    RelativeLayout mTab2;
    @BindView(R.id.activity_caigoudanguanli)
    LinearLayout mActivityCaigoudanguanli;
    @BindView(R.id.activity_shengchanrenwu)
    LinearLayout mActivityShengchanrenwu;
    @BindView(R.id.second_line)
    LinearLayout mSecondLine;
    @BindView(R.id.icon3)
    ImageView mIcon3;
    @BindView(R.id.tab3)
    RelativeLayout mTab3;
    @BindView(R.id.activity_kucunchaxun)
    LinearLayout mActivityKucunchaxun;
    @BindView(R.id.activity_diaobodan)
    LinearLayout mActivityDiaobodan;
    @BindView(R.id.activity_rukuguanli)
    LinearLayout mActivityRukuguanli;
    @BindView(R.id.third_line)
    LinearLayout mThirdLine;
    @BindView(R.id.icon4)
    ImageView mIcon4;
    @BindView(R.id.tab4)
    RelativeLayout mTab4;
    @BindView(R.id.activity_xiaoshoudanguanli)
    LinearLayout mActivityXiaoshoudanguanli;
    @BindView(R.id.activity_tuihuodanguanli)
    LinearLayout mActivityTuihuodanguanli;
    @BindView(R.id.four_line)
    LinearLayout mFourLine;
    @BindView(R.id.icon5)
    ImageView mIcon5;
    @BindView(R.id.tab5)
    RelativeLayout mTab5;
    @BindView(R.id.activity_kaipiao)
    LinearLayout mActivityKaipiao;
    @BindView(R.id.activity_shoukuan)
    LinearLayout mActivityShoukuan;
    @BindView(R.id.five_line)
    LinearLayout mFiveLine;
    Unbinder unbinder;

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        unbinder = ButterKnife.bind(this, rootView);

    }

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_shouye, null);
        return view;
    }



    @OnClick(R.id.activity_caigoudanguanli)
    void startCaigou(){
       startActivity(new Intent(getActivity(),CaiGouDingDanGuanLiActivity.class));
    }

    @OnClick(R.id.activity_kucunchaxun)
    void startKunCunChaXun(){
        startActivity(new Intent(getActivity(),KuCunChaXunActivity.class));
    }

    @OnClick(R.id.activity_renyuangunali)
    void startRenYuan(){
        startActivity(new Intent(getActivity(),RenYuanGuanLiActivity.class));
    }

    @OnClick(R.id.activity_diaobodan)
    void startDiaobodan(){
        startActivity(new Intent(getActivity(),DiaoBoDanActivity.class));
    }

    @OnClick(R.id.activity_rukuguanli)
    void startRuku(){
        startActivity(new Intent(getActivity(),RukuGuanLiActivity.class));
    }

    @OnClick(R.id.activity_xiaoshoudanguanli)
    void startXiaoShou(){
        startActivity(new Intent(getActivity(),XiaoShouDingDanGuanLiActivity.class));
    }


    @OnClick(R.id.activity_tuihuodanguanli)
    void startTuiHuo(){
        startActivity(new Intent(getActivity(),TuiHuoDanGuanLiActivity.class));
    }


    @OnClick(R.id.activity_kehuguanli)
    void startKeHu(){
        startActivity(new Intent(getActivity(),KeHuGuanLiActivity.class));
    }

    @OnClick(R.id.activity_shengchanrenwu)
    void startShengchan(){
        startActivity(new Intent(getActivity(),ShengChanRenWuDanGuanLiActivity.class));
    }

    @OnClick(R.id.activity_kaipiao)
    void startKaiPiao(){
        startActivity(new Intent(getActivity(),KaiPiaoDanGuanLiActivity.class));
    }

    @OnClick(R.id.activity_shanghuguanli)
    void startShangpin(){
        startActivity(new Intent(getActivity(),ShangPinGuanLiActivity.class));
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
