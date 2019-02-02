package com.shushang.huagongproject.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shushang.huagongproject.R;
import com.shushang.huagongproject.activity.adapter.CaiGouDingDanTongJIAdapter;
import com.shushang.huagongproject.base.BaseActivity;
import com.shushang.huagongproject.fragment.CaiGouGongYIngShangFragment;
import com.shushang.huagongproject.fragment.CaiGouShangPinFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CaiGouDingDanTongjiActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.tab_selected)
    LinearLayout mTabSelected;
    @BindView(R.id.viewpager)
    ViewPager mViewpager;
    @BindView(R.id.shangpin)
    TextView mShangpin;
    @BindView(R.id.gongyingshang)
    TextView mGongyingshang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        //设置支持toolbar
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mShangpin.setSelected(true);
        SetUpViewPager(mViewpager);
        mViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position==0){
                    mShangpin.setSelected(true);
                    mGongyingshang.setSelected(false);
                }
                else {
                    mGongyingshang.setSelected(true);
                    mShangpin.setSelected(false);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public int setLayout() {
        return R.layout.activity_cai_gou_ding_dan_tongji;
    }

    @Override
    public void init() {

    }


    @OnClick(R.id.shangpin)
    void shangpin(){
        mShangpin.setSelected(true);
        mGongyingshang.setSelected(false);
        mViewpager.setCurrentItem(0,true);
    }


    @OnClick(R.id.gongyingshang)
    void gongyingshang(){
        mShangpin.setSelected(false);
        mGongyingshang.setSelected(true);
        mViewpager.setCurrentItem(1,true);
    }



    private void SetUpViewPager(ViewPager bookViewpager) {
        CaiGouDingDanTongJIAdapter adapter = new CaiGouDingDanTongJIAdapter(getSupportFragmentManager());
        adapter.addFragment(CaiGouShangPinFragment.newInstance(), "");
        adapter.addFragment(CaiGouGongYIngShangFragment.newInstance(), "");
        bookViewpager.setAdapter(adapter);
        bookViewpager.setCurrentItem(0, true);
        bookViewpager.setOffscreenPageLimit(2);
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
