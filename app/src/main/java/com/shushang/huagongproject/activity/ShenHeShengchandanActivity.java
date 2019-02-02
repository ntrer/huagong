package com.shushang.huagongproject.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.blankj.utilcode.util.ToastUtils;
import com.shushang.huagongproject.Bean.ShengChanRenWuDan;
import com.shushang.huagongproject.Bean.XinZengRenYuan;
import com.shushang.huagongproject.LoginActivity;
import com.shushang.huagongproject.R;
import com.shushang.huagongproject.base.BaseActivity;
import com.shushang.huagongproject.base.BaseUrl;
import com.shushang.huagongproject.base.MessageEvent;
import com.shushang.huagongproject.ui.ActionSheetDialog;
import com.shushang.huagongproject.ui.ExtAlertDialog;
import com.shushang.huagongproject.utils.Json.JSONUtil;
import com.shushang.huagongproject.utils.OkhttpUtils.CallBackUtil;
import com.shushang.huagongproject.utils.OkhttpUtils.OkhttpUtil;
import com.shushang.huagongproject.utils.SharePreferences.PreferencesUtils;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;

public class ShenHeShengchandanActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.jichuxinxi)
    TextView mJichuxinxi;
    @BindView(R.id.jichuxinxi_title)
    LinearLayout mJichuxinxiTitle;
    @BindView(R.id.line_second)
    View mLineSecond;
    @BindView(R.id.chuangjianren_text)
    TextView mChuangjianrenText;
    @BindView(R.id.chuangjianren)
    RelativeLayout mChuangjianren;
    @BindView(R.id.line2)
    View mLine2;
    @BindView(R.id.kehu_text)
    TextView mKehuText;
    @BindView(R.id.kehu)
    RelativeLayout mKehu;
    @BindView(R.id.line_third)
    View mLineThird;
    @BindView(R.id.guige_text)
    TextView mGuigeText;
    @BindView(R.id.guige)
    RelativeLayout mGuige;
    @BindView(R.id.line_four)
    View mLineFour;
    @BindView(R.id.shuliang_text)
    TextView mShuliangText;
    @BindView(R.id.shuliang)
    RelativeLayout mShuliang;
    @BindView(R.id.line_five)
    View mLineFive;
    @BindView(R.id.zhuangtai_text)
    TextView mZhuangtaiText;
    @BindView(R.id.zhuangtai)
    RelativeLayout mZhuangtai;
    @BindView(R.id.guigexinxi)
    TextView mGuigexinxi;
    @BindView(R.id.guigexinxi_title)
    LinearLayout mGuigexinxiTitle;
    @BindView(R.id.line3)
    View mLine3;
    @BindView(R.id.bolili_text)
    TextView mBoliliText;
    @BindView(R.id.bolili)
    RelativeLayout mBolili;
    @BindView(R.id.line4)
    View mLine4;
    @BindView(R.id.naiwenxing_text)
    TextView mNaiwenxingText;
    @BindView(R.id.naiwenxing)
    RelativeLayout mNaiwenxing;
    @BindView(R.id.line5)
    View mLine5;
    @BindView(R.id.fenziliang_text)
    TextView mFenziliangText;
    @BindView(R.id.fenziliang)
    RelativeLayout mFenziliang;
    @BindView(R.id.line6)
    View mLine6;
    @BindView(R.id.guhanliang_text)
    TextView mGuhanliangText;
    @BindView(R.id.guhanliang)
    RelativeLayout mGuhanliang;
    @BindView(R.id.line7)
    View mLine7;
    @BindView(R.id.difeihanliang_text)
    TextView mDifeihanliangText;
    @BindView(R.id.difeihanliang)
    RelativeLayout mDifeihanliang;
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
    private Dialog mRequestDialog;
    private ShengChanRenWuDan.DataBean mDataBean;
    private String jobOrderId;
    private int jobOrderStatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        //设置支持toolbar
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mRequestDialog = ExtAlertDialog.creatRequestDialog(this, getString(R.string.submit));
        mRequestDialog.setCancelable(false);
        try {
            mDataBean = (ShengChanRenWuDan.DataBean) getIntent().getSerializableExtra("data");
            mKehuText.setText(mDataBean.getBuyerTitle());
            jobOrderId=mDataBean.getJobOrderId();
            mChuangjianrenText.setText(mDataBean.getCreaterName());
            mGuigeText.setText(mDataBean.getSpecId());
            mShuliangText.setText(String.valueOf(mDataBean.getCount()));
            if(mDataBean.getStatus()==0){
               mZhuangtaiText.setText("待审核");
            }
            else if(mDataBean.getStatus()==10){
                mZhuangtaiText.setText("审核通过,待生产");
            }
            else if(mDataBean.getStatus()==-10){
                mZhuangtaiText.setText("审核不通过");
            }
            else if(mDataBean.getStatus()==30){
                mZhuangtaiText.setText("正在生产");
            }
            else if(mDataBean.getStatus()==40){
                mZhuangtaiText.setText("部分完成");
            }
            else if(mDataBean.getStatus()==100){
                mZhuangtaiText.setText("已完成");
            }
            else if(mDataBean.getStatus()==-100){
                mZhuangtaiText.setText("已取消");
            }
            if(mDataBean.getPeelStrengthMax()!=0){
                mBoliliText.setText(mDataBean.getPeelStrengthMin()+"-"+mDataBean.getPeelStrengthMax());
            }
            else {
                mBoliliText.setText("0");
            }

            if(mDataBean.getSpec().getTemperatureResistMax()!=0){
                mNaiwenxingText.setText(mDataBean.getSpec().getTemperatureResistMin()+"-"+mDataBean.getSpec().getTemperatureResistMax());
            }
            else {
                mNaiwenxingText.setText("0");
            }

            if(mDataBean.getMolecularWeightMax()!=0){
                mFenziliangText.setText(mDataBean.getMolecularWeightMin()+"-"+mDataBean.getMolecularWeightMax());
            }
            else {
                mFenziliangText.setText("0");
            }

            if(mDataBean.getSolidContentMax()!=0){
                mGuhanliangText.setText(mDataBean.getSolidContentMin()+"-"+mDataBean.getSolidContentMax());
            }
            else {
                mGuhanliangText.setText("0");
            }

            if(mDataBean.getLowBoilingContentMax()!=0){
                mDifeihanliangText.setText(mDataBean.getLowBoilingContentMin()+"-"+mDataBean.getLowBoilingContentMax());
            }
            else {
                mDifeihanliangText.setText("0");
            }

            if(mDataBean.getNote()!=null){
                mBeizhuContent.setText(mDataBean.getNote());
            }

        }
        catch (Exception e){
            ToastUtils.showLong(e.toString());
        }

    }

    @Override
    public int setLayout() {
        return R.layout.activity_shen_he_shengchandan;
    }

    @Override
    public void init() {

    }


    @OnClick(R.id.submit)
    void Caozuo() {
        new ActionSheetDialog(ShenHeShengchandanActivity.this)
                .builder()
                .setCancelable(false)
                .setCanceledOnTouchOutside(true)
                .addSheetItem("审核", ActionSheetDialog.SheetItemColor.Blue,
                        new ActionSheetDialog.OnSheetItemClickListener() {
                            @Override
                            public void onClick(int which) {
                                if(mDataBean.getStatus()==0){
                                    new ActionSheetDialog(ShenHeShengchandanActivity.this)
                                            .builder()
                                            .setCancelable(false)
                                            .setCanceledOnTouchOutside(true)
                                            .addSheetItem("通过", ActionSheetDialog.SheetItemColor.Blue,
                                                    new ActionSheetDialog.OnSheetItemClickListener() {
                                                        @Override
                                                        public void onClick(int which) {
                                                            jobOrderStatus=10;
                                                            shenHe(jobOrderStatus);
                                                        }
                                                    })
                                            .addSheetItem("不通过", ActionSheetDialog.SheetItemColor.Blue,
                                                    new ActionSheetDialog.OnSheetItemClickListener() {
                                                        @Override
                                                        public void onClick(int which) {
                                                            jobOrderStatus=-10;
                                                            shenHe(jobOrderStatus);
                                                        }
                                                    })
                                            .show();
                                }
                                else if(mDataBean.getStatus()==-100){
                                    ToastUtils.showLong("已取消该单");
                                }
                                else {
                                    ToastUtils.showLong("已审核过该单");
                                }
                            }
                        })
                .addSheetItem("生产", ActionSheetDialog.SheetItemColor.Blue,
                        new ActionSheetDialog.OnSheetItemClickListener() {
                            @Override
                            public void onClick(int which) {
                                if(mDataBean.getStatus()==10){
                                    shengChan();
                                }
                                else if(mDataBean.getStatus()==0){
                                    ToastUtils.showLong("该单尚未审核");
                                }
                                else if(mDataBean.getStatus()==-100){
                                    ToastUtils.showLong("该单已被取消");
                                }
                                else if(mDataBean.getStatus()==100){
                                    ToastUtils.showLong("已生产完成该单");
                                }
                                else {
                                    ToastUtils.showLong("该单正在生产中");
                                }
                            }
                        })
                .addSheetItem("取消该单", ActionSheetDialog.SheetItemColor.Blue,
                        new ActionSheetDialog.OnSheetItemClickListener() {
                            @Override
                            public void onClick(int which) {
                                if(mDataBean.getStatus()==-10||mDataBean.getStatus()==30||mDataBean.getStatus()==40){
                                    cancle();
                                }
                                else if(mDataBean.getStatus()==-100){
                                    ToastUtils.showLong("该单已取消");
                                }
                                else {
                                    ToastUtils.showLong("该单不能被取消");
                                }
                            }
                        })
                .show();
    }

    private void shengChan() {
        mRequestDialog.show();
        String url =  BaseUrl.BASE_URL + "JobOrder/DoingJobOrder?tid="+BaseUrl.TOKEN;
        Log.d("创建活动", url);
        HashMap<String, String> paramsMap = new HashMap<>();
        paramsMap.put("jobOrderId", jobOrderId);
        OkhttpUtil.okHttpPost(url, paramsMap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                if(mRequestDialog!=null&&mRequestDialog.isShowing()){
                    mRequestDialog.dismiss();
                }
                ToastUtils.showLong(e.toString());
            }

            @Override
            public void onResponse(String response) {
                Log.d("创建活动",response);
                if(response!=null){
                    try {
                        XinZengRenYuan response1 = JSONUtil.fromJson(response, XinZengRenYuan.class);
                        if(response1.getCode()==0){
                            if(mRequestDialog!=null&&mRequestDialog.isShowing()){
                                mRequestDialog.dismiss();
                            }
                            Toast.makeText(ShenHeShengchandanActivity.this, "成功", Toast.LENGTH_SHORT).show();
                            EventBus.getDefault().post(new MessageEvent("操作"));
                            finish();
                        }
                        else if(response1.getCode()==-5){
                            if(mRequestDialog!=null&&mRequestDialog.isShowing()){
                                mRequestDialog.dismiss();
                            }
                            Toast.makeText(ShenHeShengchandanActivity.this, ""+response1.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                        else if (response1.getCode()==101) {
                            Toast.makeText(ShenHeShengchandanActivity.this, ""+response1.getMessage()
                                    , Toast.LENGTH_SHORT).show();
                            PreferencesUtils.putString(ShenHeShengchandanActivity.this, "token_id", null);
                            startActivity(new Intent(ShenHeShengchandanActivity.this, LoginActivity.class));
                            finish();
                        }
                        else {
                            if(mRequestDialog!=null&&mRequestDialog.isShowing()){
                                mRequestDialog.dismiss();
                            }
                            Toast.makeText(ShenHeShengchandanActivity.this, ""+response1.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                    catch (Exception e){
                        ToastUtils.showLong(e.toString());
                    }

                }

            }
        });
    }

    private void cancle() {
        mRequestDialog.show();
        String url =  BaseUrl.BASE_URL + "JobOrder/CancelJobOrder?tid="+BaseUrl.TOKEN;
        Log.d("创建活动", url);
        HashMap<String, String> paramsMap = new HashMap<>();
        paramsMap.put("jobOrderId", jobOrderId);
        OkhttpUtil.okHttpPost(url, paramsMap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                if(mRequestDialog!=null&&mRequestDialog.isShowing()){
                    mRequestDialog.dismiss();
                }
                ToastUtils.showLong(e.toString());
            }

            @Override
            public void onResponse(String response) {
                Log.d("创建活动",response);
                if(response!=null){
                    try {
                        XinZengRenYuan response1 = JSONUtil.fromJson(response, XinZengRenYuan.class);
                        if(response1.getCode()==0){
                            if(mRequestDialog!=null&&mRequestDialog.isShowing()){
                                mRequestDialog.dismiss();
                            }
                            Toast.makeText(ShenHeShengchandanActivity.this, "成功", Toast.LENGTH_SHORT).show();
                            EventBus.getDefault().post(new MessageEvent("操作"));
                            finish();
                        }
                        else if(response1.getCode()==-5){
                            if(mRequestDialog!=null&&mRequestDialog.isShowing()){
                                mRequestDialog.dismiss();
                            }
                            Toast.makeText(ShenHeShengchandanActivity.this, ""+response1.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                        else if (response1.getCode()==101) {
                            Toast.makeText(ShenHeShengchandanActivity.this, ""+response1.getMessage()
                                    , Toast.LENGTH_SHORT).show();
                            PreferencesUtils.putString(ShenHeShengchandanActivity.this, "token_id", null);
                            startActivity(new Intent(ShenHeShengchandanActivity.this, LoginActivity.class));
                            finish();
                        }
                        else {
                            if(mRequestDialog!=null&&mRequestDialog.isShowing()){
                                mRequestDialog.dismiss();
                            }
                            Toast.makeText(ShenHeShengchandanActivity.this, ""+response1.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                    catch (Exception e){
                        ToastUtils.showLong(e.toString());
                    }

                }

            }
        });
    }

    private void shenHe(int jobOrderStatus) {
        mRequestDialog.show();
        String url =  BaseUrl.BASE_URL + "JobOrder/AuditJobOrder?jobOrderStatus="+jobOrderStatus+"tid="+BaseUrl.TOKEN;
        Log.d("创建活动", url);
        HashMap<String, String> paramsMap = new HashMap<>();
        paramsMap.put("jobOrderId", jobOrderId);
        paramsMap.put("jobOrderStatus", String.valueOf(jobOrderStatus));
        OkhttpUtil.okHttpPost(url, paramsMap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                if(mRequestDialog!=null&&mRequestDialog.isShowing()){
                    mRequestDialog.dismiss();
                }
                ToastUtils.showLong(e.toString());
            }

            @Override
            public void onResponse(String response) {
                Log.d("创建活动",response);
                if(response!=null){
                    try {
                        XinZengRenYuan response1 = JSONUtil.fromJson(response, XinZengRenYuan.class);
                        if(response1.getCode()==0){
                            if(mRequestDialog!=null&&mRequestDialog.isShowing()){
                                mRequestDialog.dismiss();
                            }
                            Toast.makeText(ShenHeShengchandanActivity.this, "成功", Toast.LENGTH_SHORT).show();
                            EventBus.getDefault().post(new MessageEvent("操作"));
                            finish();
                        }
                        else if(response1.getCode()==-5){
                            if(mRequestDialog!=null&&mRequestDialog.isShowing()){
                                mRequestDialog.dismiss();
                            }
                            Toast.makeText(ShenHeShengchandanActivity.this, ""+response1.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                        else if (response1.getCode()==101) {
                            Toast.makeText(ShenHeShengchandanActivity.this, ""+response1.getMessage()
                                    , Toast.LENGTH_SHORT).show();
                            PreferencesUtils.putString(ShenHeShengchandanActivity.this, "token_id", null);
                            startActivity(new Intent(ShenHeShengchandanActivity.this, LoginActivity.class));
                            finish();
                        }
                        else {
                            if(mRequestDialog!=null&&mRequestDialog.isShowing()){
                                mRequestDialog.dismiss();
                            }
                            Toast.makeText(ShenHeShengchandanActivity.this, ""+response1.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                    catch (Exception e){
                        ToastUtils.showLong(e.toString());
                    }

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
}
