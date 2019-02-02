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

public class XinZengShengChanRenWuActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.jichuxinxi)
    TextView mJichuxinxi;
    @BindView(R.id.jichuxinxi_title)
    LinearLayout mJichuxinxiTitle;
    @BindView(R.id.line_second)
    View mLineSecond;
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
    EditText mShuliangText;
    @BindView(R.id.shuliang)
    RelativeLayout mShuliang;
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
    private static final int REQUEST_CODE_KEHU = 1005;
    private static final int REQUEST_CODE_CANSHU = 1006;
    private String BuyerId,BuyerName,PeelStrengthStr,Seriers,SpecId,Count,Note,MolecularWeightStr,SolidContentStr,LowBoilingContentStr;
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
    }

    @Override
    public int setLayout() {
        return R.layout.activity_xin_zeng_sheng_chan_ren_wu;
    }

    @Override
    public void init() {

    }



    @OnClick(R.id.kehu)
    void Kehu() {
        Intent intent=new Intent(XinZengShengChanRenWuActivity.this,KeHuActivity.class);
        startActivityForResult(intent,REQUEST_CODE_KEHU);
    }

    @OnClick(R.id.guige)
    void GuiGe() {
        PreferencesUtils.putString(XinZengShengChanRenWuActivity.this,"Seriers",null);
        PreferencesUtils.putString(XinZengShengChanRenWuActivity.this,"PeelStrengthStr",null);
        PreferencesUtils.putString(XinZengShengChanRenWuActivity.this,"SolidContentStr",null);
        PreferencesUtils.putString(XinZengShengChanRenWuActivity.this,"MolecularWeightStr",null);
        PreferencesUtils.putString(XinZengShengChanRenWuActivity.this,"LowBoilingContentStr",null);
        final Intent intent=new Intent(XinZengShengChanRenWuActivity.this,GuiGeActivity.class);
        new ActionSheetDialog(XinZengShengChanRenWuActivity.this)
                .builder()
                .setTitle("选择系列")
                .setCancelable(false)
                .setCanceledOnTouchOutside(true)
                .addSheetItem("CPC", ActionSheetDialog.SheetItemColor.Blue,
                        new ActionSheetDialog.OnSheetItemClickListener() {
                            @Override
                            public void onClick(int which) {
                               intent.putExtra("series","CPC");
                                startActivityForResult(intent,REQUEST_CODE_CANSHU);
                            }
                        })
                .addSheetItem("S103", ActionSheetDialog.SheetItemColor.Blue,
                        new ActionSheetDialog.OnSheetItemClickListener() {
                            @Override
                            public void onClick(int which) {
                                intent.putExtra("series","S103");
                                startActivityForResult(intent,REQUEST_CODE_CANSHU);
                            }
                        })
                .addSheetItem("CT919", ActionSheetDialog.SheetItemColor.Blue,
                        new ActionSheetDialog.OnSheetItemClickListener() {
                            @Override
                            public void onClick(int which) {
                                intent.putExtra("series","CT919");
                                startActivityForResult(intent,REQUEST_CODE_CANSHU);
                            }
                        })
                .show();
    }



    @OnClick(R.id.submit)
    void submit() {
        SpecId=Seriers;
        Count=mShuliangText.getText().toString();
        Note=mBeizhuContent.getText().toString();
        if(SpecId.equals("")||Count.equals("")||BuyerName.equals("")){
            ToastUtils.showLong("请填写完整");
            return;
        }
        submitData(SpecId,Count,Note);
    }

    private void submitData(String specId, String count, String note) {
        mRequestDialog.show();
        String url =  BaseUrl.BASE_URL + "JobOrder/CreateJobOrder?tid="+BaseUrl.TOKEN;
        Log.d("创建活动", url);
        HashMap<String, String> paramsMap = new HashMap<>();
        paramsMap.put("BuyerId", BuyerId);
        paramsMap.put("SpecId", specId);
        paramsMap.put("Count", count);
        if(note!=null){
            paramsMap.put("Note",note);
        }
        else {
            paramsMap.put("Note","");
        }

        if(PeelStrengthStr!=null){
            paramsMap.put("PeelStrengthStr",PeelStrengthStr);
        }
        else {
            paramsMap.put("PeelStrengthStr","");
        }

        if(MolecularWeightStr!=null){
            paramsMap.put("MolecularWeightStr",MolecularWeightStr);
        }
        else {
            paramsMap.put("MolecularWeightStr","");
        }

        if(SolidContentStr!=null){
            paramsMap.put("SolidContentStr",SolidContentStr);
        }
        else {
            paramsMap.put("SolidContentStr","");
        }

        if(LowBoilingContentStr!=null){
            paramsMap.put("LowBoilingContentStr",LowBoilingContentStr);
        }
        else {
            paramsMap.put("LowBoilingContentStr","");
        }


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
                            Toast.makeText(XinZengShengChanRenWuActivity.this, "成功", Toast.LENGTH_SHORT).show();
                            EventBus.getDefault().post(new MessageEvent("生产"));
                            finish();
                        }
                        else if(response1.getCode()==-5){
                            if(mRequestDialog!=null&&mRequestDialog.isShowing()){
                                mRequestDialog.dismiss();
                            }
                            Toast.makeText(XinZengShengChanRenWuActivity.this, ""+response1.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                        else if (response1.getCode()==101) {
                            Toast.makeText(XinZengShengChanRenWuActivity.this, ""+response1.getMessage()
                                    , Toast.LENGTH_SHORT).show();
                            PreferencesUtils.putString(XinZengShengChanRenWuActivity.this, "token_id", null);
                            startActivity(new Intent(XinZengShengChanRenWuActivity.this, LoginActivity.class));
                            finish();
                        }
                        else {
                            if(mRequestDialog!=null&&mRequestDialog.isShowing()){
                                mRequestDialog.dismiss();
                            }
                            Toast.makeText(XinZengShengChanRenWuActivity.this, ""+response1.getMessage(), Toast.LENGTH_SHORT).show();
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
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_CODE_KEHU&&resultCode==RESULT_OK){
            BuyerId=data.getStringExtra("kehuId");
            BuyerName=data.getStringExtra("kehuName");
            mKehuText.setText(BuyerName);
        }
        else if(requestCode==REQUEST_CODE_CANSHU){
            if(PreferencesUtils.getString(XinZengShengChanRenWuActivity.this,"PeelStrengthStr")!=null){
                PeelStrengthStr=PreferencesUtils.getString(XinZengShengChanRenWuActivity.this,"PeelStrengthStr");
                Seriers=PreferencesUtils.getString(XinZengShengChanRenWuActivity.this,"Seriers");
                mGuigeText.setText(Seriers+"("+PeelStrengthStr+")");
            }
            else if(PreferencesUtils.getString(XinZengShengChanRenWuActivity.this,"SolidContentStr")!=null){
                SolidContentStr=PreferencesUtils.getString(XinZengShengChanRenWuActivity.this,"SolidContentStr");
                Seriers=PreferencesUtils.getString(XinZengShengChanRenWuActivity.this,"Seriers");
                mGuigeText.setText(Seriers+"("+SolidContentStr+")");
            }
            else if(PreferencesUtils.getString(XinZengShengChanRenWuActivity.this,"MolecularWeightStr")!=null){
                MolecularWeightStr=PreferencesUtils.getString(XinZengShengChanRenWuActivity.this,"MolecularWeightStr");
                LowBoilingContentStr=PreferencesUtils.getString(XinZengShengChanRenWuActivity.this,"LowBoilingContentStr");
                Seriers=PreferencesUtils.getString(XinZengShengChanRenWuActivity.this,"Seriers");
                mGuigeText.setText(Seriers+"("+MolecularWeightStr+")-"+"("+LowBoilingContentStr+")");
            }

        }
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
