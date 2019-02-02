package com.shushang.huagongproject.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.shushang.huagongproject.Bean.Zhiwu;
import com.shushang.huagongproject.R;
import com.shushang.huagongproject.activity.adapter.ZhiWuAdapter;
import com.shushang.huagongproject.base.BaseActivity;
import com.shushang.huagongproject.base.BaseUrl;
import com.shushang.huagongproject.net.RestClient;
import com.shushang.huagongproject.net.callback.IError;
import com.shushang.huagongproject.net.callback.IFailure;
import com.shushang.huagongproject.net.callback.ISuccess;
import com.shushang.huagongproject.utils.Json.JSONUtil;
import com.shushang.huagongproject.utils.SharePreferences.PreferencesUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ZhiWuActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.select_zhiwu)
    TextView mSelectZhiwu;
    @BindView(R.id.rv_recyclerView)
    RecyclerView mRvRecyclerView;
    @BindView(R.id.loading)
    ProgressBar mLoading;
    private String isfinish = null;
    private  List<Zhiwu.DataBean> data = new ArrayList<>();
    private int duty_code = 0;
    private String duty_name = null;
    private int bumen_code=0;
    private String bumen_name=null;
    private ZhiWuAdapter mZhiWuAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        //设置支持toolbar
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent intent=getIntent();
        bumen_code=intent.getIntExtra("bumen_code",0);
        bumen_name=intent.getStringExtra("bumen_name");
        mSelectZhiwu.setText(bumen_name);
        initData();
        initRecyclerView();
    }

    @Override
    public int setLayout() {
        return R.layout.activity_zhi_wu;
    }

    @Override
    public void init() {
    }


    private void initData() {
        mLoading.setVisibility(View.VISIBLE);
        String url = BaseUrl.BASE_URL + "/Duty/GetDuties?departmentId="+bumen_code;
        Log.d("BaseUrl", url);
        try {
            RestClient.builder()
                    .url(url)
                    .success(new ISuccess() {
                        @Override
                        public void onSuccess(String response) {
                            if (response != null) {
                                mLoading.setVisibility(View.GONE);
                                Zhiwu zhiwu = JSONUtil.fromJson(response, Zhiwu.class);
                                if (zhiwu.getCode() == 0) {
                                    mLoading.setVisibility(View.GONE);
                                    data = zhiwu.getData();
                                    showData(data);
                                } else {
                                    mLoading.setVisibility(View.GONE);
                                    ToastUtils.showLong("" + zhiwu.getMessage());
                                }
                            } else {
                                mLoading.setVisibility(View.GONE);
                            }
                        }
                    })
                    .failure(new IFailure() {
                        @Override
                        public void onFailure() {
                            mLoading.setVisibility(View.GONE);
                            Toast.makeText(ZhiWuActivity.this, "获取数据错误了！！！！", Toast.LENGTH_SHORT).show();
                        }
                    }).error(new IError() {
                @Override
                public void onError(int code, String msg) {
                    mLoading.setVisibility(View.GONE);
                    Toast.makeText(ZhiWuActivity.this, "" + msg, Toast.LENGTH_SHORT).show();
                }
            })
                    .build()
                    .get();
        } catch (Exception e) {

        }
    }

    private void initRecyclerView() {
        final LinearLayoutManager linermanager = new LinearLayoutManager(this);
        mRvRecyclerView.setLayoutManager(linermanager);
    }

    private void showData(final List<Zhiwu.DataBean> data) {
        mZhiWuAdapter = new ZhiWuAdapter(R.layout.item_bumen, data);
        mRvRecyclerView.setAdapter(mZhiWuAdapter);
        mRvRecyclerView.scrollToPosition(0);
        mZhiWuAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                duty_code = data.get(position).getDutyId();
                duty_name = data.get(position).getDutyName();
                PreferencesUtils.putInt(ZhiWuActivity.this, "duty_code", duty_code);
                PreferencesUtils.putString(ZhiWuActivity.this, "duty_name", duty_name);
                PreferencesUtils.putInt(ZhiWuActivity.this,"bumen_code",bumen_code);
                PreferencesUtils.putString(ZhiWuActivity.this,"bumen_name",bumen_name);
                isfinish = "0";
                finish();
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                isfinish = "0";
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    //对返回键进行监听
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            isfinish = "0";
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     * 退出activity的动画效果不起作用，要在java代码里写
     * 复写activity的finish方法，在overridePendingTransition中写入自己的动画效果
     */
    @Override
    public void finish() {
        super.finish();
        if (isfinish != null) {
            if (isfinish.equals("0")) {
                overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
            }
        }
    }
}
