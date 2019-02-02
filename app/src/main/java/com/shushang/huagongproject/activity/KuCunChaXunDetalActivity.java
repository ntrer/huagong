package com.shushang.huagongproject.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.shushang.huagongproject.R;
import com.shushang.huagongproject.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class KuCunChaXunDetalActivity extends BaseActivity {


    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.jichuxinxi)
    TextView mJichuxinxi;
    @BindView(R.id.jichuxinxi_title)
    LinearLayout mJichuxinxiTitle;
    @BindView(R.id.line)
    View mLine;
    @BindView(R.id.renwudanhao_text)
    TextView mRenwudanhaoText;
    @BindView(R.id.renwudanhao)
    RelativeLayout mRenwudanhao;
    @BindView(R.id.line_second)
    View mLineSecond;
    @BindView(R.id.rukuriqi_text)
    TextView mRukuriqiText;
    @BindView(R.id.rukuriqi)
    RelativeLayout mRukuriqi;
    @BindView(R.id.line_third)
    View mLineThird;
    @BindView(R.id.fangongpihao_text)
    TextView mFangongpihaoText;
    @BindView(R.id.fangongpihao)
    RelativeLayout mFangongpihao;
    @BindView(R.id.line_four)
    View mLineFour;
    @BindView(R.id.fangongpihaoshuliang_text)
    TextView mFangongpihaoshuliangText;
    @BindView(R.id.fangongpihaoshuliang)
    RelativeLayout mFangongpihaoshuliang;
    @BindView(R.id.line_five)
    View mLineFive;
    @BindView(R.id.caozuoren_text)
    TextView mCaozuorenText;
    @BindView(R.id.caozuoren)
    RelativeLayout mCaozuoren;
    @BindView(R.id.line_six)
    View mLineSix;
    @BindView(R.id.laiwangqingkuangtext)
    TextView mLaiwangqingkuangtext;
    @BindView(R.id.laiwangqingkuang)
    RelativeLayout mLaiwangqingkuang;
    @BindView(R.id.shangpin)
    TextView mShangpin;
    @BindView(R.id.shangpin_title)
    LinearLayout mShangpinTitle;
    @BindView(R.id.line2)
    View mLine2;
    @BindView(R.id.daitibaodingdan)
    RelativeLayout mDaitibaodingdan;
    @BindView(R.id.beizhu_text)
    TextView mBeizhuText;
    @BindView(R.id.beizhu_title)
    LinearLayout mBeizhuTitle;
    @BindView(R.id.line_beizhu)
    View mLineBeizhu;
    @BindView(R.id.beizhu_content)
    TextView mBeizhuContent;
    @BindView(R.id.beizhu)
    RelativeLayout mBeizhu;

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
        return R.layout.activity_ku_cun_cha_xun_detal;
    }

    @Override
    public void init() {

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
