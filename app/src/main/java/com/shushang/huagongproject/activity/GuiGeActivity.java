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
import android.widget.LinearLayout;
import android.widget.Toast;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.shushang.huagongproject.Bean.GuiGe;
import com.shushang.huagongproject.LoginActivity;
import com.shushang.huagongproject.R;
import com.shushang.huagongproject.activity.adapter.GuiGeGuanliAdapter;
import com.shushang.huagongproject.application.MyApplication;
import com.shushang.huagongproject.base.BaseActivity;
import com.shushang.huagongproject.base.BaseUrl;
import com.shushang.huagongproject.net.RestClient;
import com.shushang.huagongproject.net.callback.IError;
import com.shushang.huagongproject.net.callback.IFailure;
import com.shushang.huagongproject.net.callback.ISuccess;
import com.shushang.huagongproject.ui.ActionSheetDialog;
import com.shushang.huagongproject.utils.Json.JSONUtil;
import com.shushang.huagongproject.utils.SharePreferences.PreferencesUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GuiGeActivity  extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.rv_recycleview)
    RecyclerView mRvRecycleview;
    @BindView(R.id.srl_refresh)
    SwipeRefreshLayout mSrlRefresh;
    @BindView(R.id.ll_no_data)
    LinearLayout mLlNoData;
    private GuiGeGuanliAdapter mGuiGeGuanliAdapter;
    private List<GuiGe.DataBean> data=new ArrayList<>();
    private List<String> canshu=new ArrayList<>();
    private List<String> canshu2=new ArrayList<>();
    private String series;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        //设置支持toolbar
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mSrlRefresh.setOnRefreshListener(this);
        series=getIntent().getStringExtra("series");
        getData(series);
    }


    @Override
    public int setLayout() {
        return R.layout.activity_gui_ge;
    }

    @Override
    public void init() {

    }


    private void getData(String series) {
        mSrlRefresh.setRefreshing(true);
        String url = BaseUrl.BASE_URL+"Spec/GetSpecs?series="+series+"&tid="+BaseUrl.TOKEN;
        Log.d("BaseUrl", url);
        try {
            RestClient.builder()
                    .url(url)
                    .success(new ISuccess() {
                        @Override
                        public void onSuccess(String response) {
                            Log.d("SignP",response);
                            mSrlRefresh.setRefreshing(false);
                            if (response != null) {
                                try {
                                    GuiGe yiXiangJin = JSONUtil.fromJson(response, GuiGe.class);
                                    if(yiXiangJin.getCode()==0){
                                        data = yiXiangJin.getData();
                                        if(data.size()!=0){
                                            showData(data);
                                            mLlNoData.setVisibility(View.GONE);
                                        }
                                        else {
                                            showData(data);
                                            mLlNoData.setVisibility(View.VISIBLE);
                                        }
                                    }
                                    else if(yiXiangJin.getCode()==101){
                                        Toast.makeText(GuiGeActivity.this, ""+yiXiangJin.getMessage(), Toast.LENGTH_SHORT).show();
                                        PreferencesUtils.putString(GuiGeActivity.this,"token_id",null);
                                        startActivity(new Intent(GuiGeActivity.this, LoginActivity.class));
                                        finish();
                                    }
                                    else if(yiXiangJin.getCode()==201){
                                        Toast.makeText(GuiGeActivity.this, ""+yiXiangJin.getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                }
                                catch (Exception e){
                                    ToastUtils.showLong(e.toString());
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
        }
        catch (Exception e){
            ToastUtils.showLong("获取数据错误了");
        }
    }


//    @OnClick(R.id.shaixun)
//    void startShaiXuan(){
//
//        new ActionSheetDialog(ShangPinGuanLiActivity.this)
//                .builder()
//                .setCancelable(false)
//                .setCanceledOnTouchOutside(true)
//                .addSheetItem("CPC", ActionSheetDialog.SheetItemColor.Blue,
//                        new ActionSheetDialog.OnSheetItemClickListener() {
//                            @Override
//                            public void onClick(int which) {
//                                Intent intent=new Intent(ShangPinGuanLiActivity.this,XingHaoActivity.class);
//                                intent.putExtra("xinghao","CPC");
//                                startActivity(intent);
//                            }
//                        })
//                .addSheetItem("S103", ActionSheetDialog.SheetItemColor.Blue,
//                        new ActionSheetDialog.OnSheetItemClickListener() {
//                            @Override
//                            public void onClick(int which) {
//                                Intent intent=new Intent(ShangPinGuanLiActivity.this,XingHaoActivity.class);
//                                intent.putExtra("xinghao","S103");
//                                startActivity(intent);
//                            }
//                        })
//                .addSheetItem("CT919", ActionSheetDialog.SheetItemColor.Blue,
//                        new ActionSheetDialog.OnSheetItemClickListener() {
//                            @Override
//                            public void onClick(int which) {
//                                Intent intent=new Intent(ShangPinGuanLiActivity.this,XingHaoActivity.class);
//                                intent.putExtra("xinghao","CT919");
//                                startActivity(intent);
//                            }
//                        })
//                .show();
//
//    }


    private void showData(final List<GuiGe.DataBean> data) {
        final LinearLayoutManager linermanager=new LinearLayoutManager(getApplicationContext());
        mRvRecycleview.setLayoutManager(linermanager);
        mGuiGeGuanliAdapter = new GuiGeGuanliAdapter(R.layout.item_shangpinguanli, data);
        //重复执行动画
        mGuiGeGuanliAdapter.isFirstOnly(false);
        mRvRecycleview.setAdapter(mGuiGeGuanliAdapter);
        mGuiGeGuanliAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, final int position) {
                if(data.get(position).getSeries().equals("CPC")){
                   canshu.clear();
                   canshu=data.get(position).getPeelStrengthArray();
                    new ActionSheetDialog(GuiGeActivity.this)
                            .builder()
                            .setTitle("选择剥离力")
                            .setCancelable(false)
                            .setCanceledOnTouchOutside(true)
                            .addSheetItem(canshu.get(0), ActionSheetDialog.SheetItemColor.Blue,
                                    new ActionSheetDialog.OnSheetItemClickListener() {
                                        @Override
                                        public void onClick(int which) {
                                            PreferencesUtils.putString(GuiGeActivity.this,"Seriers",data.get(position).getSpecId());
                                            PreferencesUtils.putString(GuiGeActivity.this,"PeelStrengthStr",canshu.get(0));
                                            PreferencesUtils.putString(GuiGeActivity.this,"TemperatureResistStr ",data.get(position).getTemperatureResistMin()+"-"+data.get(position).getTemperatureResistMax());
                                            finish();
                                        }
                                    })
                            .addSheetItem(canshu.get(1), ActionSheetDialog.SheetItemColor.Blue,
                                    new ActionSheetDialog.OnSheetItemClickListener() {
                                        @Override
                                        public void onClick(int which) {
                                            PreferencesUtils.putString(GuiGeActivity.this,"Seriers",data.get(position).getSpecId());
                                            PreferencesUtils.putString(GuiGeActivity.this,"PeelStrengthStr",canshu.get(1));
                                            PreferencesUtils.putString(GuiGeActivity.this,"TemperatureResistStr ",data.get(position).getTemperatureResistMin()+"-"+data.get(position).getTemperatureResistMax());

                                            finish();
                                        }
                                    })
                            .addSheetItem(canshu.get(2), ActionSheetDialog.SheetItemColor.Blue,
                                    new ActionSheetDialog.OnSheetItemClickListener() {
                                        @Override
                                        public void onClick(int which) {
                                            PreferencesUtils.putString(GuiGeActivity.this,"Seriers",data.get(position).getSpecId());
                                            PreferencesUtils.putString(GuiGeActivity.this,"PeelStrengthStr",canshu.get(2));
                                            PreferencesUtils.putString(GuiGeActivity.this,"TemperatureResistStr ",data.get(position).getTemperatureResistMin()+"-"+data.get(position).getTemperatureResistMax());

                                            finish();
                                        }
                                    })
                            .show();
                }
                else if(data.get(position).getSeries().equals("S103")){
                    canshu.clear();
                    canshu2.clear();
                    canshu=  data.get(position).getMolecularWeightArray();
                    canshu2=  data.get(position).getLowBoilingContentArray();
                    new ActionSheetDialog(GuiGeActivity.this)
                            .builder()
                            .setTitle("选择分子量")
                            .setCancelable(false)
                            .setCanceledOnTouchOutside(true)
                            .addSheetItem(canshu.get(0), ActionSheetDialog.SheetItemColor.Blue,
                                    new ActionSheetDialog.OnSheetItemClickListener() {
                                        @Override
                                        public void onClick(int which) {
                                            PreferencesUtils.putString(GuiGeActivity.this,"Seriers",data.get(position).getSpecId());
                                            PreferencesUtils.putString(GuiGeActivity.this,"MolecularWeightStr",canshu.get(0));
                                            new ActionSheetDialog(GuiGeActivity.this)
                                                    .builder()
                                                    .setTitle("选择低沸含量")
                                                    .setCancelable(false)
                                                    .setCanceledOnTouchOutside(true)
                                                    .addSheetItem(canshu2.get(0), ActionSheetDialog.SheetItemColor.Blue,
                                                            new ActionSheetDialog.OnSheetItemClickListener() {
                                                                @Override
                                                                public void onClick(int which) {
                                                                    PreferencesUtils.putString(GuiGeActivity.this,"TemperatureResistStr ",data.get(position).getTemperatureResistMin()+"-"+data.get(position).getTemperatureResistMax());

                                                                    PreferencesUtils.putString(GuiGeActivity.this,"LowBoilingContentStr",canshu2.get(0));
                                                                    finish();
                                                                }
                                                            })
                                                    .addSheetItem(canshu2.get(1), ActionSheetDialog.SheetItemColor.Blue,
                                                            new ActionSheetDialog.OnSheetItemClickListener() {
                                                                @Override
                                                                public void onClick(int which) {
                                                                    PreferencesUtils.putString(GuiGeActivity.this,"TemperatureResistStr ",data.get(position).getTemperatureResistMin()+"-"+data.get(position).getTemperatureResistMax());

                                                                    PreferencesUtils.putString(GuiGeActivity.this,"LowBoilingContentStr",canshu2.get(1));
                                                                    finish();
                                                                }
                                                            })
                                                    .addSheetItem(canshu2.get(2), ActionSheetDialog.SheetItemColor.Blue,
                                                            new ActionSheetDialog.OnSheetItemClickListener() {
                                                                @Override
                                                                public void onClick(int which) {
                                                                    PreferencesUtils.putString(GuiGeActivity.this,"TemperatureResistStr ",data.get(position).getTemperatureResistMin()+"-"+data.get(position).getTemperatureResistMax());

                                                                    PreferencesUtils.putString(GuiGeActivity.this,"LowBoilingContentStr",canshu2.get(2));
                                                                    finish();
                                                                }
                                                            })
                                                    .show();
                                        }
                                    })
                            .addSheetItem(canshu.get(1), ActionSheetDialog.SheetItemColor.Blue,
                                    new ActionSheetDialog.OnSheetItemClickListener() {
                                        @Override
                                        public void onClick(int which) {
                                            PreferencesUtils.putString(GuiGeActivity.this,"Seriers",data.get(position).getSpecId());
                                            PreferencesUtils.putString(GuiGeActivity.this,"MolecularWeightStr",canshu.get(1));
                                            new ActionSheetDialog(GuiGeActivity.this)
                                                    .builder()
                                                    .setTitle("选择低沸含量")
                                                    .setCancelable(false)
                                                    .setCanceledOnTouchOutside(true)
                                                    .addSheetItem(canshu2.get(0), ActionSheetDialog.SheetItemColor.Blue,
                                                            new ActionSheetDialog.OnSheetItemClickListener() {
                                                                @Override
                                                                public void onClick(int which) {
                                                                    PreferencesUtils.putString(GuiGeActivity.this,"TemperatureResistStr ",data.get(position).getTemperatureResistMin()+"-"+data.get(position).getTemperatureResistMax());

                                                                    PreferencesUtils.putString(GuiGeActivity.this,"LowBoilingContentStr",canshu2.get(0));
                                                                    finish();

                                                                }
                                                            })
                                                    .addSheetItem(canshu2.get(1), ActionSheetDialog.SheetItemColor.Blue,
                                                            new ActionSheetDialog.OnSheetItemClickListener() {
                                                                @Override
                                                                public void onClick(int which) {
                                                                    PreferencesUtils.putString(GuiGeActivity.this,"TemperatureResistStr ",data.get(position).getTemperatureResistMin()+"-"+data.get(position).getTemperatureResistMax());
                                                                    PreferencesUtils.putString(GuiGeActivity.this,"LowBoilingContentStr",canshu2.get(1));
                                                                    finish();

                                                                }
                                                            })
                                                    .addSheetItem(canshu2.get(2), ActionSheetDialog.SheetItemColor.Blue,
                                                            new ActionSheetDialog.OnSheetItemClickListener() {
                                                                @Override
                                                                public void onClick(int which) {
                                                                    PreferencesUtils.putString(GuiGeActivity.this,"TemperatureResistStr ",data.get(position).getTemperatureResistMin()+"-"+data.get(position).getTemperatureResistMax());

                                                                    PreferencesUtils.putString(GuiGeActivity.this,"LowBoilingContentStr",canshu2.get(2));
                                                                    finish();
                                                                }
                                                            })
                                                    .show();
                                        }
                                    })
                            .show();
                }
                else if(data.get(position).getSeries().equals("CT919")){
                    canshu.clear();
                    canshu=  data.get(position).getSolidContentArray();
                    new ActionSheetDialog(GuiGeActivity.this)
                            .builder()
                            .setTitle("选择固含量")
                            .setCancelable(false)
                            .setCanceledOnTouchOutside(true)
                            .addSheetItem(canshu.get(0), ActionSheetDialog.SheetItemColor.Blue,
                                    new ActionSheetDialog.OnSheetItemClickListener() {
                                        @Override
                                        public void onClick(int which) {
                                            PreferencesUtils.putString(GuiGeActivity.this,"Seriers",data.get(position).getSpecId());
                                            PreferencesUtils.putString(GuiGeActivity.this,"SolidContentStr",canshu.get(0));
                                            finish();
                                        }
                                    })
                            .show();
                }
            }
        });
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
        getData(series);
    }
}
