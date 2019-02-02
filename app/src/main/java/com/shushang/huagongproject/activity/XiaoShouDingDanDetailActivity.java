package com.shushang.huagongproject.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.shushang.huagongproject.R;
import com.shushang.huagongproject.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class XiaoShouDingDanDetailActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.jichuxinxi)
    TextView mJichuxinxi;
    @BindView(R.id.jichuxinxi_title)
    LinearLayout mJichuxinxiTitle;
    @BindView(R.id.line)
    View mLine;
    @BindView(R.id.xiadanriqi_text)
    TextView mXiadanriqiText;
    @BindView(R.id.xiadanriqi)
    RelativeLayout mXiadanriqi;
    @BindView(R.id.line_second)
    View mLineSecond;
    @BindView(R.id.dingdanhao_text)
    TextView mDingdanhaoText;
    @BindView(R.id.dingdanhao)
    RelativeLayout mDingdanhao;
    @BindView(R.id.line_third)
    View mLineThird;
    @BindView(R.id.kehumingcheng_text)
    TextView mKehumingchengText;
    @BindView(R.id.kehumingcheng)
    RelativeLayout mKehumingcheng;
    @BindView(R.id.line_four)
    View mLineFour;
    @BindView(R.id.fahuoriqi_text)
    TextView mFahuoriqiText;
    @BindView(R.id.fahuoriqi)
    RelativeLayout mFahuoriqi;
    @BindView(R.id.line_five)
    View mLineFive;
    @BindView(R.id.yifahuoshuliang_text)
    TextView mYifahuoshuliangText;
    @BindView(R.id.yifahuoshuliang)
    RelativeLayout mYifahuoshuliang;
    @BindView(R.id.line_six)
    View mLineSix;
    @BindView(R.id.yingfahuoshuliang_text)
    TextView mYingfahuoshuliangText;
    @BindView(R.id.yingfahuoshuliang)
    RelativeLayout mYingfahuoshuliang;
    @BindView(R.id.shangpin)
    TextView mShangpin;
    @BindView(R.id.shangpin_title)
    LinearLayout mShangpinTitle;
    @BindView(R.id.line2)
    View mLine2;
    @BindView(R.id.yicaigou)
    TextView mYicaigou;
    @BindView(R.id.dingdanshangpin_text)
    TextView mDingdanshangpinText;
    @BindView(R.id.dingdanshangpin)
    RelativeLayout mDingdanshangpin;
    @BindView(R.id.line3)
    View mLine3;
    @BindView(R.id.yingshoukuanjine_text)
    TextView mYingshoukuanjineText;
    @BindView(R.id.yingshoukuanjine)
    RelativeLayout mYingshoukuanjine;
    @BindView(R.id.line4)
    View mLine4;
    @BindView(R.id.yikaipiaojine_text)
    TextView mYikaipiaojineText;
    @BindView(R.id.yikaipiaojine)
    RelativeLayout mYikaipiaojine;
    @BindView(R.id.beizhu_text)
    TextView mBeizhuText;
    @BindView(R.id.beizhu_title)
    LinearLayout mBeizhuTitle;
    @BindView(R.id.line_beizhu)
    View mLineBeizhu;
    @BindView(R.id.beizhu_content)
    EditText mBeizhuContent;
    @BindView(R.id.beizhu)
    RelativeLayout mBeizhu;
    @BindView(R.id.zhangdan_text)
    TextView mZhangdanText;
    @BindView(R.id.zhangdan_title)
    LinearLayout mZhangdanTitle;
    @BindView(R.id.line_zhangdan)
    View mLineZhangdan;
    @BindView(R.id.zhangdan_content)
    EditText mZhangdanContent;
    @BindView(R.id.zhangdan)
    RelativeLayout mZhangdan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        //设置支持toolbar
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public int setLayout() {
        return R.layout.activity_xiao_shou_ding_dan_detail;
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
