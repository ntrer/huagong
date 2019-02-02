package com.shushang.huagongproject.activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
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
import com.borax12.materialdaterangepicker.date.DatePickerDialog;
import com.borax12.materialdaterangepicker.time.RadialPickerLayout;
import com.borax12.materialdaterangepicker.time.TimePickerDialog;
import com.shushang.huagongproject.Bean.SalesOrderItemModel;
import com.shushang.huagongproject.Bean.XiaoShouDingDan;
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

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;

public class EditXiaoShouDingDanActivity extends BaseActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.jichuxinxi)
    TextView mJichuxinxi;
    @BindView(R.id.jichuxinxi_title)
    LinearLayout mJichuxinxiTitle;
    @BindView(R.id.line)
    View mLine;
    @BindView(R.id.dingdanbianhao_text)
    TextView mDingdanbianhaoText;
    @BindView(R.id.dingdanbianhao)
    RelativeLayout mDingdanbianhao;
    @BindView(R.id.line_second)
    View mLineSecond;
    @BindView(R.id.maijia_text)
    TextView mMaijiaText;
    @BindView(R.id.maijia)
    RelativeLayout mMaijia;
    @BindView(R.id.line_third)
    View mLineThird;
    @BindView(R.id.fukuantiaojian_text)
    TextView mFukuantiaojianText;
    @BindView(R.id.fukuantiaojian)
    RelativeLayout mFukuantiaojian;
    @BindView(R.id.line_four)
    View mLineFour;
    @BindView(R.id.fahuoriqi_text)
    TextView mFahuoriqiText;
    @BindView(R.id.fahuoriqi)
    RelativeLayout mFahuoriqi;
    @BindView(R.id.shangpin)
    TextView mShangpin;
    @BindView(R.id.shangpin_title)
    LinearLayout mShangpinTitle;
    @BindView(R.id.line6)
    View mLine6;
    @BindView(R.id.dingdanshangpin)
    TextView mDingdanshangpin;
    @BindView(R.id.dingdanshangpin_text)
    TextView mDingdanshangpinText;
    @BindView(R.id.daitibaodingdan)
    RelativeLayout mDaitibaodingdan;
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
    @BindView(R.id.line_five)
    View mLineFive;
    @BindView(R.id.zhuangtai_text)
    TextView mZhuangtaiText;
    @BindView(R.id.zhuangtai)
    RelativeLayout mZhuangtai;
    private Dialog mRequestDialog;
    private String BuyerId, BuyerName, PaymentTerm, SalesOrderId, Other, EstimatedDeliveryTime;
    private XiaoShouDingDan.DataBean mDataBean;
    private List<XiaoShouDingDan.DataBean.ItemsBean> mItemsBean = new ArrayList<>();
    private List<SalesOrderItemModel> datas=new ArrayList<>();
    private List<SalesOrderItemModel> datas2=new ArrayList<>();
    private SalesOrderItemModel mSalesOrderItemModel;
    private String salesOrderId;
    private int salesOrderStatus;
    private int select_year, select_mounth, select_day;
    private int now_year, now_mounth, now_day;
    private String times,Items;
    private static final int REQUEST_CODE_SHANGPIN = 1007;
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
            mDataBean = (XiaoShouDingDan.DataBean) getIntent().getSerializableExtra("data");
            BuyerId = mDataBean.getBuyerId();
            BuyerName = mDataBean.getBuyerTitle();
            PaymentTerm = mDataBean.getPaymentTerm();
            SalesOrderId = mDataBean.getSalesOrderId();
            salesOrderId=SalesOrderId;
            Other = mDataBean.getOther();
            EstimatedDeliveryTime = mDataBean.getEstimatedDeliveryTime();
            mItemsBean = mDataBean.getItems();
            mMaijiaText.setText(BuyerName);
            if(PaymentTerm!=null){
                mFukuantiaojianText.setText(PaymentTerm);
            }
            else {
                mFukuantiaojianText.setText("");
            }
            mDingdanbianhaoText.setText(SalesOrderId);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date=new Date(Long.parseLong(mDataBean.getEstimatedDeliveryTime().substring(6,19)));
            String time=simpleDateFormat.format(date);
            mFahuoriqiText.setText(time);
            mDingdanshangpin.setText("订单包含"+mItemsBean.size()+"件商品");

            if(Other!=null){
                mBeizhuContent.setText(Other);
            }
            else {
                mBeizhuContent.setText("无");
            }

            if(mDataBean.getStatus()==0){
                mZhuangtaiText.setText("待审核");
            }
            else if(mDataBean.getStatus()==10){
                mZhuangtaiText.setText("审核通过");
            }
            else if(mDataBean.getStatus()==-10){
                mZhuangtaiText.setText("审核不通过");
            }
            else if(mDataBean.getStatus()==100){
                mZhuangtaiText.setText("已完成");
            }
            else if(mDataBean.getStatus()==-100){
                mZhuangtaiText.setText("已取消");
            }

        } catch (Exception e) {
            ToastUtils.showLong(e.toString());
        }
    }

    @Override
    public int setLayout() {
        return R.layout.activity_edit_xiao_shou_ding_dan;
    }

    @Override
    public void init() {

    }


    @OnClick(R.id.daitibaodingdan)
    void ChaKan(){
        Intent intent=new Intent(EditXiaoShouDingDanActivity.this,XiaoShouDingDanShangPinDetailActivity.class);
        if(datas2.size()!=0){
            intent.putExtra("first","false");
            intent.putExtra("data", (Serializable) datas2);
        }
        else {
            intent.putExtra("first","true");
            intent.putExtra("data", (Serializable) mItemsBean);
        }
        startActivityForResult(intent, REQUEST_CODE_SHANGPIN);
    }


    @OnClick(R.id.maijia)
    void Maijia() {
        ExtAlertDialog.showEditDlg(EditXiaoShouDingDanActivity.this, "修改买家", "修改", false, new ExtAlertDialog.IExtDlgClick2() {
            @Override
            public void Oclick(int result, Editable text) {
                if (result == 1) {
                    if (text == null) {
                        mMaijiaText.setText("");
                    } else {
                        mMaijiaText.setText(text);
                    }
                }
            }
        });
    }

    @OnClick(R.id.fahuoriqi)
    void Fahuoriqi() {
        Calendar now = Calendar.getInstance();
        DatePickerDialog dpd = DatePickerDialog.newInstance(
                EditXiaoShouDingDanActivity.this,
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
        );
        dpd.setAccentColor(getResources().getColor(R.color.colorPrimary));
        dpd.setAutoHighlight(true);
        dpd.show(getFragmentManager(), "Datepickerdialog");
    }


    @OnClick(R.id.fukuantiaojian)
    void Fukuantiaojian() {
        new ActionSheetDialog(EditXiaoShouDingDanActivity.this)
                .builder()
                .setCancelable(false)
                .setCanceledOnTouchOutside(true)
                .addSheetItem("支付宝", ActionSheetDialog.SheetItemColor.Blue,
                        new ActionSheetDialog.OnSheetItemClickListener() {
                            @Override
                            public void onClick(int which) {
                                PaymentTerm = "支付宝";
                                mFukuantiaojianText.setText(PaymentTerm);
                            }
                        })
                .addSheetItem("微信", ActionSheetDialog.SheetItemColor.Blue,
                        new ActionSheetDialog.OnSheetItemClickListener() {
                            @Override
                            public void onClick(int which) {
                                PaymentTerm = "微信";
                                mFukuantiaojianText.setText(PaymentTerm);
                            }
                        })
                .addSheetItem("其他", ActionSheetDialog.SheetItemColor.Blue,
                        new ActionSheetDialog.OnSheetItemClickListener() {
                            @Override
                            public void onClick(int which) {
                                PaymentTerm = "其他";
                                mFukuantiaojianText.setText(PaymentTerm);
                            }
                        })
                .show();
    }




    @OnClick(R.id.submit)
    void Caozuo() {
        new ActionSheetDialog(EditXiaoShouDingDanActivity.this)
                .builder()
                .setCancelable(false)
                .setCanceledOnTouchOutside(true)
                .addSheetItem("审核", ActionSheetDialog.SheetItemColor.Blue,
                        new ActionSheetDialog.OnSheetItemClickListener() {
                            @Override
                            public void onClick(int which) {
                                if(mDataBean.getStatus()==0){
                                    new ActionSheetDialog(EditXiaoShouDingDanActivity.this)
                                            .builder()
                                            .setCancelable(false)
                                            .setCanceledOnTouchOutside(true)
                                            .addSheetItem("通过", ActionSheetDialog.SheetItemColor.Blue,
                                                    new ActionSheetDialog.OnSheetItemClickListener() {
                                                        @Override
                                                        public void onClick(int which) {
                                                            salesOrderStatus=10;
                                                            shenHe(salesOrderStatus);
                                                        }
                                                    })
                                            .addSheetItem("不通过", ActionSheetDialog.SheetItemColor.Blue,
                                                    new ActionSheetDialog.OnSheetItemClickListener() {
                                                        @Override
                                                        public void onClick(int which) {
                                                            salesOrderStatus=-10;
                                                            shenHe(salesOrderStatus);
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
                .addSheetItem("反审核", ActionSheetDialog.SheetItemColor.Blue,
                        new ActionSheetDialog.OnSheetItemClickListener() {
                            @Override
                            public void onClick(int which) {
                                if(mDataBean.getStatus()==10){
                                   fanshenhe();
                                }
                                else if(mDataBean.getStatus()==0){
                                    ToastUtils.showLong("该单尚未审核");
                                }
                                else {
                                    ToastUtils.showLong("该单不能反审核");
                                }
                            }
                        })
                .addSheetItem("编辑", ActionSheetDialog.SheetItemColor.Blue,
                        new ActionSheetDialog.OnSheetItemClickListener() {
                            @Override
                            public void onClick(int which) {
                                if(mDataBean.getStatus()==0){
                                    bianJi();
                                }
                                else {
                                    ToastUtils.showLong("该单不能被编辑");
                                }
                            }
                        })
                .addSheetItem("取消该单", ActionSheetDialog.SheetItemColor.Blue,
                        new ActionSheetDialog.OnSheetItemClickListener() {
                            @Override
                            public void onClick(int which) {
                                if(mDataBean.getStatus()==10){
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

    private void fanshenhe() {
        mRequestDialog.show();
        String url =  BaseUrl.BASE_URL + "SalesOrder/DisauditSalesOrder?tid="+BaseUrl.TOKEN;
        Log.d("创建活动", url);
        HashMap<String, String> paramsMap = new HashMap<>();
        paramsMap.put("salesOrderId", salesOrderId);
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
                            Toast.makeText(EditXiaoShouDingDanActivity.this, "成功", Toast.LENGTH_SHORT).show();
                            EventBus.getDefault().post(new MessageEvent("操作"));
                            finish();
                        }
                        else if(response1.getCode()==-5){
                            if(mRequestDialog!=null&&mRequestDialog.isShowing()){
                                mRequestDialog.dismiss();
                            }
                            Toast.makeText(EditXiaoShouDingDanActivity.this, ""+response1.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                        else if (response1.getCode()==101) {
                            Toast.makeText(EditXiaoShouDingDanActivity.this, ""+response1.getMessage()
                                    , Toast.LENGTH_SHORT).show();
                            PreferencesUtils.putString(EditXiaoShouDingDanActivity.this, "token_id", null);
                            startActivity(new Intent(EditXiaoShouDingDanActivity.this, LoginActivity.class));
                            finish();
                        }
                        else {
                            if(mRequestDialog!=null&&mRequestDialog.isShowing()){
                                mRequestDialog.dismiss();
                            }
                            Toast.makeText(EditXiaoShouDingDanActivity.this, ""+response1.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                    catch (Exception e){
                        ToastUtils.showLong(e.toString());
                    }

                }

            }
        });
    }

    private void bianJi() {
        SalesOrderId = mDingdanbianhaoText.getText().toString();
        PaymentTerm = mFukuantiaojianText.getText().toString();
        Other = mBeizhuContent.getText().toString();
        String pattern="yyyy-MM-dd HH:mm:ss";
        EstimatedDeliveryTime =  mFahuoriqiText.getText().toString();
        if (SalesOrderId.equals("") || PaymentTerm.equals("") || EstimatedDeliveryTime.equals("")) {
            ToastUtils.showLong("请填写完整");
            return;
        }

//        for (int i=0;i<mItemsBean.size();i++){
//            mSalesOrderItemModel=new SalesOrderItemModel();
//            mSalesOrderItemModel=new SalesOrderItemModel();
//            mSalesOrderItemModel.setSpecId(mItemsBean.get(i).getSpecId());
//            mSalesOrderItemModel.setCount(mItemsBean.get(i).getCount());
//            mSalesOrderItemModel.setUnitPrice(mItemsBean.get(i).getUnitPrice());
//            mSalesOrderItemModel.setItemTotalPrice(mItemsBean.get(i).getItemTotalPrice());
//            if(mItemsBean.get(i).getPeelStrengthStr()!=null){
//                mSalesOrderItemModel.setPeelStrengthStr(mItemsBean.get(i).getPeelStrengthStr());
//            }
//            else {
//                mSalesOrderItemModel.setPeelStrengthStr("");
//            }
//
//            if(mItemsBean.get(i).getMolecularWeightStr()!=null){
//                mSalesOrderItemModel.setMolecularWeightStr(mItemsBean.get(i).getMolecularWeightStr());
//            }
//            else {
//                mSalesOrderItemModel.setMolecularWeightStr("");
//            }
//
//
//            if(mItemsBean.get(i).getSolidContentStr()!=null){
//                mSalesOrderItemModel.setSolidContentStr(mItemsBean.get(i).getSolidContentStr());
//            }
//            else {
//                mSalesOrderItemModel.setSolidContentStr("");
//            }
//
//            if(mItemsBean.get(i).getTemperatureResistStr()!=null){
//                mSalesOrderItemModel.setTemperatureResistStr(mItemsBean.get(i).getTemperatureResistStr());
//            }
//            else {
//                mSalesOrderItemModel.setTemperatureResistStr("");
//            }
//
//            if(mItemsBean.get(i).getLowBoilingContentStr()!=null){
//                mSalesOrderItemModel.setLowBoilingContentStr(mItemsBean.get(i).getLowBoilingContentStr());
//            }
//            else {
//                mSalesOrderItemModel.setLowBoilingContentStr("");
//            }
//
//            if (mItemsBean.get(i).getNote()!=null) {
//                mSalesOrderItemModel.setNote(mItemsBean.get(i).getNote());
//            } else {
//                mSalesOrderItemModel.setNote("");
//            }
//            datas.add(mSalesOrderItemModel);
//        }


        postData(SalesOrderId, PaymentTerm, Other, EstimatedDeliveryTime, datas2);

    }


    private void postData(String SalesOrderId, String PaymentTerm, String Other, String EstimatedDeliveryTime, List<SalesOrderItemModel> datas) {
        mRequestDialog.show();
        String url = BaseUrl.BASE_URL + "SalesOrder/EditSalesOrder?tid=" + BaseUrl.TOKEN;
        Log.d("创建活动", url);
        try {
            HashMap<String, String> paramsMap = new HashMap<>();
            Items = JSONUtil.toJSON(datas);
            paramsMap.put("BuyerId", BuyerId);
            paramsMap.put("SalesOrderId", SalesOrderId);
            paramsMap.put("PaymentTerm", PaymentTerm);
            paramsMap.put("EstimatedDeliveryTime", EstimatedDeliveryTime);
            paramsMap.put("Items", Items);
            if (Other != null) {
                paramsMap.put("Other", Other);
            } else {
                paramsMap.put("Other", "");
            }
            OkhttpUtil.okHttpPost(url, paramsMap, new CallBackUtil.CallBackString() {
                @Override
                public void onFailure(Call call, Exception e) {
                    if (mRequestDialog != null && mRequestDialog.isShowing()) {
                        mRequestDialog.dismiss();
                    }
                    ToastUtils.showLong(e.toString());
                }

                @Override
                public void onResponse(String response) {
                    Log.d("创建活动", response);
                    if (response != null) {
                        try {
                            XinZengRenYuan response1 = JSONUtil.fromJson(response, XinZengRenYuan.class);
                            if (response1.getCode() == 0) {
                                if (mRequestDialog != null && mRequestDialog.isShowing()) {
                                    mRequestDialog.dismiss();
                                }
                                EventBus.getDefault().post(new MessageEvent("销售"));
                                finish();
                            } else if (response1.getCode() == -5) {
                                if (mRequestDialog != null && mRequestDialog.isShowing()) {
                                    mRequestDialog.dismiss();
                                }
                                Toast.makeText(EditXiaoShouDingDanActivity.this, "" + response1.getMessage(), Toast.LENGTH_SHORT).show();
                            } else if (response1.getCode() == 101) {
                                Toast.makeText(EditXiaoShouDingDanActivity.this, "" + response1.getMessage()
                                        , Toast.LENGTH_SHORT).show();
                                PreferencesUtils.putString(EditXiaoShouDingDanActivity.this, "token_id", null);
                                startActivity(new Intent(EditXiaoShouDingDanActivity.this, LoginActivity.class));
                                finish();
                            } else {
                                if (mRequestDialog != null && mRequestDialog.isShowing()) {
                                    mRequestDialog.dismiss();
                                }
                                Toast.makeText(EditXiaoShouDingDanActivity.this, "" + response1.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        } catch (Exception e) {
                            ToastUtils.showLong(e.toString());
                        }

                    }

                }
            });
        }
        catch (Exception e){
            ToastUtils.showLong(e.toString());
        }

    }



    private void cancle() {
        mRequestDialog.show();
        String url =  BaseUrl.BASE_URL + "SalesOrder/CancelSalesOrder/?tid="+BaseUrl.TOKEN;
        Log.d("创建活动", url);
        HashMap<String, String> paramsMap = new HashMap<>();
        paramsMap.put("salesOrderId", salesOrderId);
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
                            Toast.makeText(EditXiaoShouDingDanActivity.this, "成功", Toast.LENGTH_SHORT).show();
                            EventBus.getDefault().post(new MessageEvent("操作"));
                            finish();
                        }
                        else if(response1.getCode()==-5){
                            if(mRequestDialog!=null&&mRequestDialog.isShowing()){
                                mRequestDialog.dismiss();
                            }
                            Toast.makeText(EditXiaoShouDingDanActivity.this, ""+response1.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                        else if (response1.getCode()==101) {
                            Toast.makeText(EditXiaoShouDingDanActivity.this, ""+response1.getMessage()
                                    , Toast.LENGTH_SHORT).show();
                            PreferencesUtils.putString(EditXiaoShouDingDanActivity.this, "token_id", null);
                            startActivity(new Intent(EditXiaoShouDingDanActivity.this, LoginActivity.class));
                            finish();
                        }
                        else {
                            if(mRequestDialog!=null&&mRequestDialog.isShowing()){
                                mRequestDialog.dismiss();
                            }
                            Toast.makeText(EditXiaoShouDingDanActivity.this, ""+response1.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                    catch (Exception e){
                        ToastUtils.showLong(e.toString());
                    }

                }

            }
        });

    }

    private void shenHe(int salesOrderStatus) {
        mRequestDialog.show();
        String url =  BaseUrl.BASE_URL + "SalesOrder/AuditSalesOrder?tid="+BaseUrl.TOKEN;
        Log.d("创建活动", url);
        HashMap<String, String> paramsMap = new HashMap<>();
        paramsMap.put("salesOrderId", salesOrderId);
        paramsMap.put("salesOrderStatus", String.valueOf(salesOrderStatus));
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
                            Toast.makeText(EditXiaoShouDingDanActivity.this, "成功", Toast.LENGTH_SHORT).show();
                            EventBus.getDefault().post(new MessageEvent("操作"));
                            finish();
                        }
                        else if(response1.getCode()==-5){
                            if(mRequestDialog!=null&&mRequestDialog.isShowing()){
                                mRequestDialog.dismiss();
                            }
                            Toast.makeText(EditXiaoShouDingDanActivity.this, ""+response1.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                        else if (response1.getCode()==101) {
                            Toast.makeText(EditXiaoShouDingDanActivity.this, ""+response1.getMessage()
                                    , Toast.LENGTH_SHORT).show();
                            PreferencesUtils.putString(EditXiaoShouDingDanActivity.this, "token_id", null);
                            startActivity(new Intent(EditXiaoShouDingDanActivity.this, LoginActivity.class));
                            finish();
                        }
                        else {
                            if(mRequestDialog!=null&&mRequestDialog.isShowing()){
                                mRequestDialog.dismiss();
                            }
                            Toast.makeText(EditXiaoShouDingDanActivity.this, ""+response1.getMessage(), Toast.LENGTH_SHORT).show();
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


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_CODE_SHANGPIN&&resultCode==RESULT_OK){
            datas2= (List<SalesOrderItemModel>) data.getSerializableExtra("data");
            mDingdanshangpin.setText("订单包含"+datas2.size()+"件商品");
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
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth, int yearEnd, int monthOfYearEnd, int dayOfMonthEnd) {
        select_year = year;
        select_mounth = monthOfYear + 1;
        select_day = dayOfMonth;
        Log.d("time", select_year + "---------" + select_mounth + "---------" + select_day);
        if (select_year < now_year) {
            ToastUtils.showLong("请选择当前时间以后的年份");
        } else if (select_year == now_year && select_mounth < now_mounth) {
            ToastUtils.showLong("请选择当前时间以后的月份");
        } else if (select_mounth == now_mounth && select_day < now_day) {
            ToastUtils.showLong("请选择当前时间以后的日期");
        } else {
            Calendar now = Calendar.getInstance();
            TimePickerDialog tpd = TimePickerDialog.newInstance(
                    EditXiaoShouDingDanActivity.this,
                    now.get(Calendar.HOUR_OF_DAY),
                    now.get(Calendar.MINUTE),
                    false
            );
            tpd.setAccentColor(Color.parseColor("#2196F3"));
            tpd.setTabIndicators("", "");
            tpd.show(getFragmentManager(), "Timepickerdialog");
        }
    }

    @Override
    public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute, int hourOfDayEnd, int minuteEnd) {
        String hourString = hourOfDay < 10 ? "0" + hourOfDay : "" + hourOfDay;
        String minuteString = minute < 10 ? "0" + minute : "" + minute;
        String time = select_year + "-" + select_mounth + "-" + select_day + " " + hourString + ":" + minuteString + ":00";
        Date date = new Date(select_year - 1900, select_mounth - 1, select_day, hourOfDay, minute, 0);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// HH:mm:ss
        Log.d("time", simpleDateFormat.format(date));
        times = simpleDateFormat.format(date);
        mFahuoriqiText.setText(simpleDateFormat.format(date));
    }


    public static long getStringToDate(String dateString, String pattern) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        Date date = new Date();
        try{
            date = dateFormat.parse(dateString);
        } catch(ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return date.getTime();
    }
}
