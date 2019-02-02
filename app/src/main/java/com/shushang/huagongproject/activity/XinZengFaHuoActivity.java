package com.shushang.huagongproject.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.shushang.huagongproject.R;
import com.shushang.huagongproject.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class XinZengFaHuoActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.jichuxinxi)
    TextView mJichuxinxi;
    @BindView(R.id.jichuxinxi_title)
    LinearLayout mJichuxinxiTitle;
    @BindView(R.id.line)
    View mLine;
    @BindView(R.id.mingcheng_text)
    EditText mMingchengText;
    @BindView(R.id.mingcheng)
    RelativeLayout mMingcheng;
    @BindView(R.id.line_second)
    View mLineSecond;
    @BindView(R.id.xiadanriqi_text)
    TextView mXiadanriqiText;
    @BindView(R.id.xiadanriqi)
    RelativeLayout mXiadanriqi;
    @BindView(R.id.line2)
    View mLine2;
    @BindView(R.id.dingdanhao_text)
    EditText mDingdanhaoText;
    @BindView(R.id.dingdanhao)
    RelativeLayout mDingdanhao;
    @BindView(R.id.line_third)
    View mLineThird;
    @BindView(R.id.gukecaigoudanhao_text)
    EditText mGukecaigoudanhaoText;
    @BindView(R.id.gukecaigoudanhao)
    RelativeLayout mGukecaigoudanhao;
    @BindView(R.id.line_four)
    View mLineFour;
    @BindView(R.id.biaoqian_text)
    EditText mBiaoqianText;
    @BindView(R.id.biaoqian)
    RelativeLayout mBiaoqian;
    @BindView(R.id.shangpin)
    TextView mShangpin;
    @BindView(R.id.shangpin_title)
    LinearLayout mShangpinTitle;
    @BindView(R.id.line6)
    View mLine6;
    @BindView(R.id.dingdanshangpin)
    TextView mDingdanshangpin;
    @BindView(R.id.dingdanshangpin_text)
    TextView mDingdanshangpinText;
    @BindView(R.id.daitibaodingdan)
    RelativeLayout mDaitibaodingdan;
    @BindView(R.id.fahuo)
    TextView mFahuo;
    @BindView(R.id.fahuoxinxi_title)
    LinearLayout mFahuoxinxiTitle;
    @BindView(R.id.line3)
    View mLine3;
    @BindView(R.id.baozhuang_text)
    EditText mBaozhuangText;
    @BindView(R.id.baozhuang)
    RelativeLayout mBaozhuang;
    @BindView(R.id.line4)
    View mLine4;
    @BindView(R.id.yingfachanpin_text)
    EditText mYingfachanpinText;
    @BindView(R.id.yingfachanpin)
    RelativeLayout mYingfachanpin;
    @BindView(R.id.line5)
    View mLine5;
    @BindView(R.id.shijifahuoriqi_text)
    TextView mShijifahuoriqiText;
    @BindView(R.id.shijifahuoriqi)
    RelativeLayout mShijifahuoriqi;
    @BindView(R.id.line7)
    View mLine7;
    @BindView(R.id.wanchengzhuangtaitupian_text)
    TextView mWanchengzhuangtaitupianText;
    @BindView(R.id.wanchengzhuangtaitupian)
    RelativeLayout mWanchengzhuangtaitupian;
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
    @BindView(R.id.submit)
    Button mSubmit;

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
        return R.layout.activity_xin_zeng_fa_huo;
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
