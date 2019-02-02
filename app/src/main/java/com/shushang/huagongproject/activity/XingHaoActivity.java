package com.shushang.huagongproject.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.shushang.huagongproject.Bean.GuiGe;
import com.shushang.huagongproject.R;
import com.shushang.huagongproject.activity.adapter.XingHaoAdapter;
import com.shushang.huagongproject.base.BaseActivity;
import com.shushang.huagongproject.base.BaseUrl;
import com.shushang.huagongproject.net.RestClient;
import com.shushang.huagongproject.net.callback.IError;
import com.shushang.huagongproject.net.callback.IFailure;
import com.shushang.huagongproject.net.callback.ISuccess;
import com.shushang.huagongproject.utils.Json.JSONUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class XingHaoActivity  extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.rv_recyclerView)
    RecyclerView mRvRecyclerView;
    @BindView(R.id.loading)
    ProgressBar mLoading;
    private String isfinish = null;
    private XingHaoAdapter mXingHaoAdapter;
    private  List<GuiGe.DataBean> data=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        //设置支持toolbar
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        String xinghao = getIntent().getStringExtra("xinghao");
        initData(xinghao);
        initRecyclerView();
    }

    @Override
    public int setLayout() {
        return R.layout.activity_xing_hao;
    }

    @Override
    public void init() {

    }


    private void initData(String xinghao) {
        mLoading.setVisibility(View.VISIBLE);
        String url= BaseUrl.BASE_URL+"Spec/GetSpecs?series="+xinghao;
        Log.d("BaseUrl",url);
        try {
            RestClient.builder()
                    .url(url)
                    .success(new ISuccess() {
                        @Override
                        public void onSuccess(String response) {
                            if(response!=null){
                                mLoading.setVisibility(View.GONE);
                                GuiGe buMen = JSONUtil.fromJson(response, GuiGe.class);
                                if(buMen.getCode()==0){
                                    mLoading.setVisibility(View.GONE);
                                    List<GuiGe.DataBean> data = buMen.getData();
                                    showData(data);
                                }
                                else {
                                    mLoading.setVisibility(View.GONE);
                                    ToastUtils.showLong(""+buMen.getMessage());
                                }
                            }
                            else {
                                mLoading.setVisibility(View.GONE);
                            }
                        }
                    })
                    .failure(new IFailure() {
                        @Override
                        public void onFailure() {
                            mLoading.setVisibility(View.GONE);
                            Toast.makeText(XingHaoActivity.this, "获取数据错误了！！！！", Toast.LENGTH_SHORT).show();
                        }
                    }).error(new IError() {
                @Override
                public void onError(int code, String msg) {
                    mLoading.setVisibility(View.GONE);
                    Toast.makeText(XingHaoActivity.this, ""+msg, Toast.LENGTH_SHORT).show();
                }
            })
                    .build()
                    .post();
        }
        catch (Exception e){
              ToastUtils.showLong(e.toString());
        }
    }

    private void initRecyclerView() {
        final LinearLayoutManager linermanager=new LinearLayoutManager(this);
        mRvRecyclerView.setLayoutManager(linermanager);
    }

    private void showData(final List<GuiGe.DataBean> data) {
        mXingHaoAdapter=new XingHaoAdapter(R.layout.item_xinghao, data);
        mRvRecyclerView.setAdapter(mXingHaoAdapter);
        mRvRecyclerView.scrollToPosition(0);
        mXingHaoAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                bumen_code=data.get(position).getDepartmentId();
//                bumen_name=data.get(position).getDepartmentName();
//                Intent intent=new Intent();
//                intent.putExtra("bumen_code",bumen_code);
//                intent.putExtra("bumen_name",bumen_name);
//                intent.setClass(XingHaoActivity.this,ZhiWuActivity.class);
//                startActivity(intent);
//                PreferencesUtils.putString(XingHaoActivity.this, "bumen_code", null);
//                PreferencesUtils.putString(XingHaoActivity.this, "bumen_name", null);
//                isfinish="1";
//                finish();
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
