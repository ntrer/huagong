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

public class XInZengShangPinXinXiActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.jichuxinxi)
    TextView mJichuxinxi;
    @BindView(R.id.jichuxinxi_title)
    LinearLayout mJichuxinxiTitle;
    @BindView(R.id.line)
    View mLine;
    @BindView(R.id.shengchanpinhao_text)
    EditText mShengchanpinhaoText;
    @BindView(R.id.shengchanpinhao)
    RelativeLayout mShengchanpinhao;
    @BindView(R.id.line_second)
    View mLineSecond;
    @BindView(R.id.guige_text)
    EditText mGuigeText;
    @BindView(R.id.guige)
    RelativeLayout mGuige;
    @BindView(R.id.line_third)
    View mLineThird;
    @BindView(R.id.leibie_text)
    EditText mLeibieText;
    @BindView(R.id.leibie)
    RelativeLayout mLeibie;
    @BindView(R.id.line_four)
    View mLineFour;
    @BindView(R.id.boliloi_text)
    EditText mBoliloiText;
    @BindView(R.id.boliloi)
    RelativeLayout mBoliloi;
    @BindView(R.id.line_five)
    View mLineFive;
    @BindView(R.id.PIbolili_text)
    EditText mPIboliliText;
    @BindView(R.id.PIbolili)
    RelativeLayout mPIbolili;
    @BindView(R.id.line_six)
    View mLineSix;
    @BindView(R.id.naiwenxing_text)
    EditText mNaiwenxingText;
    @BindView(R.id.naiwenxing)
    RelativeLayout mNaiwenxing;
    @BindView(R.id.line_seven)
    View mLineSeven;
    @BindView(R.id.chunianxing_text)
    EditText mChunianxingText;
    @BindView(R.id.chunianxing)
    RelativeLayout mChunianxing;
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
        return R.layout.activity_xin_zeng_shang_pin_xin_xi;
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
