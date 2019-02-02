package com.shushang.huagongproject.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.blankj.utilcode.util.ToastUtils;
import com.shushang.huagongproject.Bean.PurchaseOrderItemModel;
import com.shushang.huagongproject.R;
import com.shushang.huagongproject.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CaiGouDingDanActivity extends BaseActivity {


    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.jichuxinxi)
    TextView mJichuxinxi;
    @BindView(R.id.jichuxinxi_title)
    LinearLayout mJichuxinxiTitle;
    @BindView(R.id.line)
    View mLine;
    @BindView(R.id.wuliao_text)
    EditText mWuliaoText;
    @BindView(R.id.wuliao)
    RelativeLayout mWuliao;
    @BindView(R.id.line_second)
    View mLineSecond;
    @BindView(R.id.guige_text)
    EditText mGuigeText;
    @BindView(R.id.guige)
    RelativeLayout mGuige;
    @BindView(R.id.line_third)
    View mLineThird;
    @BindView(R.id.gongyingshang_text)
    EditText mGongyingshangText;
    @BindView(R.id.gongyingshang)
    RelativeLayout mGongyingshang;
    @BindView(R.id.line_five)
    View mLineFive;
    @BindView(R.id.danjia_text)
    EditText mDanjiaText;
    @BindView(R.id.danjia)
    RelativeLayout mDanjia;
    @BindView(R.id.line_six)
    View mLineSix;
    @BindView(R.id.shuliang_text)
    EditText mShuliangText;
    @BindView(R.id.shuliang)
    RelativeLayout mShuliang;
    @BindView(R.id.line_seven)
    View mLineSeven;
    @BindView(R.id.fukuantiaojiantext)
    EditText mFukuantiaojiantext;
    @BindView(R.id.fukuantiaojian)
    RelativeLayout mFukuantiaojian;
    @BindView(R.id.submit)
    Button mSubmit;
    private String MaterielName,SpecificationName,SupplierName,PaymentTerm;
    private int Count;
    private double UnitPrice;
    private PurchaseOrderItemModel mPurchaseOrderItemModel;
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
        return R.layout.activity_cai_gou_ding_dan;
    }

    @Override
    public void init() {

    }


    @OnClick(R.id.submit)
    void Submit() {
        MaterielName=mWuliaoText.getText().toString();
        SpecificationName=mGuigeText.getText().toString();
        SupplierName=mGongyingshangText.getText().toString();
        PaymentTerm=mFukuantiaojiantext.getText().toString();
        if(!mShuliangText.getText().toString().equals("")){
            Count=Integer.parseInt(mShuliangText.getText().toString());
        }
        else {
            ToastUtils.showLong("请填写数量");
            return;
        }

        if(!mShuliangText.getText().toString().equals("")){
            UnitPrice=Double.parseDouble(mDanjiaText.getText().toString());
        }
        else {
            ToastUtils.showLong("请填写单价");
            return;
        }
        if(MaterielName.equals("")||SpecificationName.equals("")||SupplierName.equals("")||PaymentTerm.equals("")||String.valueOf(Count).equals("")||String.valueOf(UnitPrice).equals("")){
            Toast.makeText(this, "请填写完整信息", Toast.LENGTH_SHORT).show();
            return;
        }
        addData(MaterielName,SpecificationName,SupplierName,PaymentTerm,Count,UnitPrice);
    }

    private void addData(String materielName, String specificationName, String supplierName, String paymentTerm, int count, double unitPrice) {
        mPurchaseOrderItemModel=new PurchaseOrderItemModel();
        mPurchaseOrderItemModel.setCount(count);
        mPurchaseOrderItemModel.setMaterielName(materielName);
        mPurchaseOrderItemModel.setSpecificationName(specificationName);
        mPurchaseOrderItemModel.setPaymentTerm(paymentTerm);
        mPurchaseOrderItemModel.setUnitPrice(unitPrice);
        mPurchaseOrderItemModel.setSupplierName(supplierName);
        Intent intent=new Intent();
        intent.putExtra("data",mPurchaseOrderItemModel);
        setResult(RESULT_OK,intent);
        finish();
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
}
