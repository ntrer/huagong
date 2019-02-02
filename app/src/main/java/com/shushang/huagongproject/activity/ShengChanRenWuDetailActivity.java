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

public class ShengChanRenWuDetailActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.jichuxinxi)
    TextView mJichuxinxi;
    @BindView(R.id.jichuxinxi_title)
    LinearLayout mJichuxinxiTitle;
    @BindView(R.id.line)
    View mLine;
    @BindView(R.id.shengchanpihao_text)
    TextView mShengchanpihaoText;
    @BindView(R.id.shengchanpihao)
    RelativeLayout mShengchanpihao;
    @BindView(R.id.line_second)
    View mLineSecond;
    @BindView(R.id.xiadanriqi_text)
    TextView mXiadanriqiText;
    @BindView(R.id.xiadanriqi)
    RelativeLayout mXiadanriqi;
    @BindView(R.id.line_third)
    View mLineThird;
    @BindView(R.id.zhuangtai)
    RelativeLayout mZhuangtai;
    @BindView(R.id.line_four)
    View mLineFour;
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
    @BindView(R.id.kehu_text)
    TextView mKehuText;
    @BindView(R.id.kehu_title)
    LinearLayout mKehuTitle;
    @BindView(R.id.line_kehu)
    View mLineKehu;
    @BindView(R.id.kehu_content)
    EditText mKehuContent;
    @BindView(R.id.kehu)
    RelativeLayout mKehu;
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
        return R.layout.activity_sheng_chan_ren_wu_detail;
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
