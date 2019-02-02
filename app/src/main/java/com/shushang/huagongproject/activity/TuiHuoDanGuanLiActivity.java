package com.shushang.huagongproject.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.shushang.huagongproject.R;
import com.shushang.huagongproject.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TuiHuoDanGuanLiActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.rv_recycleview)
    RecyclerView mRvRecycleview;
    @BindView(R.id.srl_refresh)
    SwipeRefreshLayout mSrlRefresh;
    @BindView(R.id.ll_no_data)
    LinearLayout mLlNoData;
    @BindView(R.id.shaixun)
    ImageView mShaixun;
    @BindView(R.id.jiahao)
    ImageView mJiahao;
    @BindView(R.id.more_menu)
    LinearLayout mMoreMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        //设置支持toolbar
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public int setLayout() {
        return R.layout.activity_tui_huo_dan_guan_li;
    }

    @Override
    public void init() {

    }

    @OnClick(R.id.shaixun)
    void startShaiXuan(){
//        startActivity(new Intent(getActivity(),CaiGouDingDanGuanLiActivity.class));
    }

    @OnClick(R.id.jiahao)
    void startJiaHao(){
        startActivity(new Intent(this,XinZengTuiHuoDingDanActivity.class));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * 退出activity的动画效果不起作用，要在java代码里写
     * 复写activity的finish方法，在overridePendingTransition中写入自己的动画效果
     */
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
    }
}
