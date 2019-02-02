package com.shushang.huagongproject.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.blankj.utilcode.util.ToastUtils;
import com.shushang.huagongproject.Bean.XinZengRenYuan;
import com.shushang.huagongproject.LoginActivity;
import com.shushang.huagongproject.R;
import com.shushang.huagongproject.base.BaseActivity;
import com.shushang.huagongproject.base.BaseUrl;
import com.shushang.huagongproject.base.MessageEvent;
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

public class XinZengRenYuanXinXiActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.jichuxinxi)
    TextView mJichuxinxi;
    @BindView(R.id.jichuxinxi_title)
    LinearLayout mJichuxinxiTitle;
    @BindView(R.id.line)
    View mLine;
    @BindView(R.id.xingming_text)
    EditText mXingmingText;
    @BindView(R.id.xingming)
    RelativeLayout mXingming;
    @BindView(R.id.line_second)
    View mLineSecond;
    @BindView(R.id.nicheng_text)
    EditText mNichengText;
    @BindView(R.id.nicheng)
    RelativeLayout mNicheng;
    @BindView(R.id.line_third)
    View mLineThird;
    @BindView(R.id.shoujihaoma_text)
    EditText mShoujihaomaText;
    @BindView(R.id.shoujihaoma)
    RelativeLayout mShoujihaoma;
    @BindView(R.id.line_five)
    View mLineFive;
    @BindView(R.id.bumen_text)
    TextView mBumenText;
    @BindView(R.id.bumen)
    RelativeLayout mBumen;
    @BindView(R.id.denglu)
    TextView mDenglu;
    @BindView(R.id.denglu_title)
    LinearLayout mDengluTitle;
    @BindView(R.id.line2)
    View mLine2;
    @BindView(R.id.isStart)
    Switch mIsStart;
    @BindView(R.id.yunxudenglu)
    RelativeLayout mYunxudenglu;
    @BindView(R.id.line3)
    View mLine3;
    @BindView(R.id.dengluzhanghao_text)
    EditText mDengluzhanghaoText;
    @BindView(R.id.dengluzhanghao)
    RelativeLayout mDengluzhanghao;
    @BindView(R.id.line4)
    View mLine4;
    @BindView(R.id.mima_text)
    EditText mMimaText;
    @BindView(R.id.mima)
    RelativeLayout mMima;
    @BindView(R.id.submit)
    Button mSubmit;

    private int duty_code = 0;
    private String duty_name = null;
    private int bumen_code = 0;
    private String Active="0";
    private String bumen_name = null;
    private String ManagerAccount, ManagerAccountPassword, NickName, RealName, Mobile;
    private int DepartmentId, DutyId;
    private Dialog mRequestDialog;
    private static final int REQUEST_CODE_BUMEN = 1000;

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
        mIsStart.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Active="1";
                }
                else {
                    Active="0";
                }
            }
        });
    }

    @Override
    public int setLayout() {
        return R.layout.activity_xin_zeng_ren_yuan_xin_xi;
    }

    @Override
    public void init() {

    }


    @OnClick(R.id.bumen)
    void Bumen() {
        startActivityForResult(new Intent(XinZengRenYuanXinXiActivity.this, BuMenActivity.class), REQUEST_CODE_BUMEN);
    }


    @OnClick(R.id.yunxudenglu)
    void EditQiyong() {
        if(Active.equals("0")){
            mIsStart.setChecked(true);
        }
        else {
            mIsStart.setChecked(false);
        }
    }


    @OnClick(R.id.submit)
    void Submit() {
        ManagerAccount=mDengluzhanghaoText.getText().toString();
        ManagerAccountPassword=mMimaText.getText().toString();
        NickName=mNichengText.getText().toString();
        RealName=mXingmingText.getText().toString();
        Mobile=mShoujihaomaText.getText().toString();
        if(mBumenText.getText().equals("")){
            ToastUtils.showLong("请选择部门");
            return;
        }
        else if(!isMobileNO(Mobile)){
            ToastUtils.showLong("手机号不合法");
            return;
        }
        else {
            if(ManagerAccount.equals("")||ManagerAccountPassword.equals("")||NickName.equals("")||RealName.equals("")||Mobile.equals("")){
                Toast.makeText(this, "请填写完整信息", Toast.LENGTH_SHORT).show();
                return;
            }
        }

        mRequestDialog.show();
        SubmitData(ManagerAccount,ManagerAccountPassword,NickName,RealName,Mobile);
    }

    private void SubmitData(String managerAccount, String managerAccountPassword, String nickName, String realName, String mobile) {
        String url =  BaseUrl.BASE_URL + "Manager/CreateManager?tid="+BaseUrl.TOKEN;
        Log.d("创建活动", url);
        HashMap<String, String> paramsMap = new HashMap<>();
        paramsMap.put("ManagerAccount", managerAccount);
        paramsMap.put("ManagerAccountPassword", managerAccountPassword);
        paramsMap.put("NickName", nickName);
        paramsMap.put("RealName", realName);
        paramsMap.put("Mobile", mobile);
        if(Active.equals("1")){
            paramsMap.put("Active","True");
        }
        else {
            paramsMap.put("Active","False");
        }
        paramsMap.put("DepartmentId", String.valueOf(DepartmentId));
        paramsMap.put("DutyId", String.valueOf(DutyId));
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
                            PreferencesUtils.putInt(XinZengRenYuanXinXiActivity.this, "duty_code", 0);
                            PreferencesUtils.putString(XinZengRenYuanXinXiActivity.this, "duty_name", null);
                            PreferencesUtils.putInt(XinZengRenYuanXinXiActivity.this,"bumen_code",0);
                            PreferencesUtils.putString(XinZengRenYuanXinXiActivity.this,"bumen_name",null);
                            Toast.makeText(XinZengRenYuanXinXiActivity.this, "成功", Toast.LENGTH_SHORT).show();
                            EventBus.getDefault().post(new MessageEvent("新增"));
                            finish();
                        }
                        else if(response1.getCode()==-5){
                            if(mRequestDialog!=null&&mRequestDialog.isShowing()){
                                mRequestDialog.dismiss();
                            }
                            Toast.makeText(XinZengRenYuanXinXiActivity.this, ""+response1.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                        else if (response1.getCode()==101) {
                            Toast.makeText(XinZengRenYuanXinXiActivity.this, ""+response1.getMessage()
                                    , Toast.LENGTH_SHORT).show();
                            PreferencesUtils.putString(XinZengRenYuanXinXiActivity.this, "token_id", null);
                            startActivity(new Intent(XinZengRenYuanXinXiActivity.this, LoginActivity.class));
                            finish();
                        }
                        else {
                            if(mRequestDialog!=null&&mRequestDialog.isShowing()){
                                mRequestDialog.dismiss();
                            }
                            Toast.makeText(XinZengRenYuanXinXiActivity.this, ""+response1.getMessage(), Toast.LENGTH_SHORT).show();
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
        if (requestCode == REQUEST_CODE_BUMEN) {
            if (String.valueOf(PreferencesUtils.getInt(XinZengRenYuanXinXiActivity.this, "bumen_code")) == null) {
                mBumenText.setText("");
            } else {
                bumen_code = PreferencesUtils.getInt(XinZengRenYuanXinXiActivity.this, "bumen_code");
                bumen_name = PreferencesUtils.getString(XinZengRenYuanXinXiActivity.this, "bumen_name");
                duty_code = PreferencesUtils.getInt(XinZengRenYuanXinXiActivity.this, "duty_code");
                duty_name = PreferencesUtils.getString(XinZengRenYuanXinXiActivity.this, "duty_name");
                DepartmentId=bumen_code;
                DutyId=duty_code;
                mBumenText.setText(bumen_name + "-" + duty_name);
            }
        }
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
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public static boolean isMobileNO(String mobiles) {
        /*
        移动：134、135、136、137、138、139、150、151、157(TD)、158、159、187、188
        联通：130、131、132、152、155、156、185、186
        电信：133、153、180、189、（1349卫通）
        总结起来就是第一位必定为1，第二位必定为3或5或8，其他位置的可以为0-9
        */
        String telRegex = "[1][123456789]\\d{9}";//"[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        if (TextUtils.isEmpty(mobiles)) return false;
        else return mobiles.matches(telRegex);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
