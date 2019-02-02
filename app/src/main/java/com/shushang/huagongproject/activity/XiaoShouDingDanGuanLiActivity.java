package com.shushang.huagongproject.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.shushang.huagongproject.Bean.XiaoShouDingDan;
import com.shushang.huagongproject.LoginActivity;
import com.shushang.huagongproject.R;
import com.shushang.huagongproject.activity.adapter.XiaoShouDingDanAdapter;
import com.shushang.huagongproject.application.MyApplication;
import com.shushang.huagongproject.base.BaseActivity;
import com.shushang.huagongproject.base.BaseUrl;
import com.shushang.huagongproject.base.MessageEvent;
import com.shushang.huagongproject.net.RestClient;
import com.shushang.huagongproject.net.callback.IError;
import com.shushang.huagongproject.net.callback.IFailure;
import com.shushang.huagongproject.net.callback.ISuccess;
import com.shushang.huagongproject.utils.Json.JSONUtil;
import com.shushang.huagongproject.utils.SharePreferences.PreferencesUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class XiaoShouDingDanGuanLiActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.shaixun)
    ImageView mShaixun;
    @BindView(R.id.jiahao)
    ImageView mJiahao;
    @BindView(R.id.more_menu)
    LinearLayout mMoreMenu;
    @BindView(R.id.rv_recycleview)
    RecyclerView mRvRecycleview;
    @BindView(R.id.srl_refresh)
    SwipeRefreshLayout mSrlRefresh;
    @BindView(R.id.ll_no_data)
    LinearLayout mLlNoData;

    private XiaoShouDingDanAdapter mXiaoShouDingDanAdapter;
    private List<XiaoShouDingDan.DataBean> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        //设置支持toolbar
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mSrlRefresh.setOnRefreshListener(this);
        getData();
        EventBus.getDefault().register(this);
    }

    @Override
    public int setLayout() {
        return R.layout.activity_xiao_shou_ding_dan_guan_li;
    }

    @Override
    public void init() {
    }

    private void getData() {
        mSrlRefresh.setRefreshing(true);
        String url = BaseUrl.BASE_URL + "SalesOrder/GetSalesOrders?tid=" + BaseUrl.TOKEN;
        Log.d("BaseUrl", url);
        try {
            RestClient.builder()
                    .url(url)
                    .success(new ISuccess() {
                        @Override
                        public void onSuccess(String response) {
                            Log.d("SignP", response);
                            mSrlRefresh.setRefreshing(false);
                            if (response != null) {
                                try {
                                    XiaoShouDingDan yiXiangJin = JSONUtil.fromJson(response, XiaoShouDingDan.class);
                                    if (yiXiangJin.getCode() == 0) {
                                        data = yiXiangJin.getData();
                                        if (data.size() != 0) {
                                            showData(data);
                                            mLlNoData.setVisibility(View.GONE);
                                        } else {
                                            showData(data);
                                            mLlNoData.setVisibility(View.VISIBLE);
                                        }
                                    } else if (yiXiangJin.getCode() == 101) {
                                        Toast.makeText(XiaoShouDingDanGuanLiActivity.this, "" + yiXiangJin.getMessage(), Toast.LENGTH_SHORT).show();
                                        PreferencesUtils.putString(XiaoShouDingDanGuanLiActivity.this, "token_id", null);
                                        startActivity(new Intent(XiaoShouDingDanGuanLiActivity.this, LoginActivity.class));
                                        finish();
                                    } else if (yiXiangJin.getCode() == 201) {
                                        Toast.makeText(XiaoShouDingDanGuanLiActivity.this, "" + yiXiangJin.getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                } catch (Exception e) {
                                    Log.d("出错了", e.toString());
                                }
                            }
                        }
                    })
                    .failure(new IFailure() {
                        @Override
                        public void onFailure() {
                            mSrlRefresh.setRefreshing(false);
                            Toast.makeText(MyApplication.getInstance().getApplicationContext(), "服务器内部错误1！", Toast.LENGTH_LONG).show();
                        }
                    })
                    .error(new IError() {
                        @Override
                        public void onError(int code, String msg) {
                            Toast.makeText(MyApplication.getInstance().getApplicationContext(), "服务器内部错误2！", Toast.LENGTH_LONG).show();
                            mSrlRefresh.setRefreshing(false);
                        }
                    })
                    .build()
                    .post();
        } catch (Exception e) {
            ToastUtils.showLong("获取数据错误了");
        }
    }



    private void showData(final List<XiaoShouDingDan.DataBean> data) {
        final LinearLayoutManager linermanager = new LinearLayoutManager(getApplicationContext());
        mRvRecycleview.setLayoutManager(linermanager);
        mXiaoShouDingDanAdapter = new XiaoShouDingDanAdapter(R.layout.item_xiaoshoudingdanguanli2, data);
        //重复执行动画
        mXiaoShouDingDanAdapter.isFirstOnly(false);
        mRvRecycleview.setAdapter(mXiaoShouDingDanAdapter);
        mXiaoShouDingDanAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent=new Intent(XiaoShouDingDanGuanLiActivity.this,EditXiaoShouDingDanActivity.class);
                intent.putExtra("data",data.get(position));
                startActivity(intent);
            }
        });
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void Event(MessageEvent messageEvent) {
        if(messageEvent.getMessage().equals("销售")){
            getData();
        }
        else if(messageEvent.getMessage().equals("操作")){
            getData();
        }

    }



    @OnClick(R.id.shaixun)
    void startShaiXuan() {
//        startActivity(new Intent(getActivity(),CaiGouDingDanGuanLiActivity.class));
    }

    @OnClick(R.id.jiahao)
    void startJiaHao() {
        startActivity(new Intent(this, XinZengXiaoShouDingDanActivity.class));
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

    @Override
    public void onRefresh() {
        getData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }
}
