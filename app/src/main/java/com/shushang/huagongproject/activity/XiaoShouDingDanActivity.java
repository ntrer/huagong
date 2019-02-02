package com.shushang.huagongproject.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.blankj.utilcode.util.ToastUtils;
import com.shushang.huagongproject.Bean.SalesOrderItemModel;
import com.shushang.huagongproject.R;
import com.shushang.huagongproject.base.BaseActivity;
import com.shushang.huagongproject.ui.ActionSheetDialog;
import com.shushang.huagongproject.utils.SharePreferences.PreferencesUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class XiaoShouDingDanActivity extends BaseActivity {


    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    private static final int EDIT_SUCCESS = 5680;
    private static final int REQUEST_CODE_CANSHU = 1006;
    @BindView(R.id.jichuxinxi)
    TextView mJichuxinxi;
    @BindView(R.id.jichuxinxi_title)
    LinearLayout mJichuxinxiTitle;
    @BindView(R.id.line_second)
    View mLineSecond;
    @BindView(R.id.guige_text)
    TextView mGuigeText;
    @BindView(R.id.guige)
    RelativeLayout mGuige;
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
    @BindView(R.id.zongjia_text)
    EditText mZongjiaText;
    @BindView(R.id.zongjia)
    RelativeLayout mZongjia;
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
    private double UnitPrice, Count, ItemTotalPrice;
    private SalesOrderItemModel mSalesOrderItemModel;
    private String SalesOrderItemId, SpecId, guige, PeelStrengthStr, TemperatureResistStr,Seriers, Note, MolecularWeightStr, SolidContentStr, LowBoilingContentStr, Tack, ApplicationDetection;
    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (EDIT_SUCCESS == msg.what) {
                if (!mDanjiaText.getText().toString().equals("") && !mShuliangText.getText().toString().equals("")) {
                    mZongjiaText.setText(String.valueOf(String.format("%.2f", (Double.parseDouble(mDanjiaText.getText().toString()) * Double.parseDouble(mShuliangText.getText().toString())))));
                }
            }

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        //设置支持toolbar
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        mShuliangText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mHandler.removeCallbacks(mRunnable);
                //800毫秒没有输入认为输入完毕
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mHandler.sendEmptyMessage(EDIT_SUCCESS);
                    }
                }, 800);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }


    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {

            mHandler.sendEmptyMessage(EDIT_SUCCESS);
        }
    };


    @Override
    public int setLayout() {
        return R.layout.activity_xiao_shou_ding_dan;
    }

    @Override
    public void init() {

    }


    @OnClick(R.id.guige)
    void GuiGe() {
        PreferencesUtils.putString(XiaoShouDingDanActivity.this, "Seriers", null);
        PreferencesUtils.putString(XiaoShouDingDanActivity.this, "PeelStrengthStr", null);
        PreferencesUtils.putString(XiaoShouDingDanActivity.this, "SolidContentStr", null);
        PreferencesUtils.putString(XiaoShouDingDanActivity.this, "MolecularWeightStr", null);
        PreferencesUtils.putString(XiaoShouDingDanActivity.this, "LowBoilingContentStr", null);
        PreferencesUtils.putString(XiaoShouDingDanActivity.this, "TemperatureResistStr", null);
        PreferencesUtils.putString(XiaoShouDingDanActivity.this,"guige",null);
        final Intent intent = new Intent(XiaoShouDingDanActivity.this, GuiGeActivity.class);
        new ActionSheetDialog(XiaoShouDingDanActivity.this)
                .builder()
                .setTitle("选择系列")
                .setCancelable(false)
                .setCanceledOnTouchOutside(true)
                .addSheetItem("CPC", ActionSheetDialog.SheetItemColor.Blue,
                        new ActionSheetDialog.OnSheetItemClickListener() {
                            @Override
                            public void onClick(int which) {
                                intent.putExtra("series", "CPC");
                                startActivityForResult(intent, REQUEST_CODE_CANSHU);
                            }
                        })
                .addSheetItem("S103", ActionSheetDialog.SheetItemColor.Blue,
                        new ActionSheetDialog.OnSheetItemClickListener() {
                            @Override
                            public void onClick(int which) {
                                intent.putExtra("series", "S103");
                                startActivityForResult(intent, REQUEST_CODE_CANSHU);
                            }
                        })
                .addSheetItem("CT919", ActionSheetDialog.SheetItemColor.Blue,
                        new ActionSheetDialog.OnSheetItemClickListener() {
                            @Override
                            public void onClick(int which) {
                                intent.putExtra("series", "CT919");
                                startActivityForResult(intent, REQUEST_CODE_CANSHU);
                            }
                        })
                .show();
    }



    @OnClick(R.id.submit)
    void Submit() {
        SpecId = Seriers;
        Note = mBeizhuContent.getText().toString();
        if (!mShuliangText.getText().toString().equals("")) {
            Count = Integer.parseInt(mShuliangText.getText().toString());
        } else {
            ToastUtils.showLong("请填写数量");
            return;
        }

        if (!mShuliangText.getText().toString().equals("")) {
            UnitPrice = Double.parseDouble(mDanjiaText.getText().toString());
        } else {
            ToastUtils.showLong("请填写单价");
            return;
        }

        if (!mZongjiaText.getText().toString().equals("")) {
            ItemTotalPrice = Double.parseDouble(mZongjiaText.getText().toString());
        } else {
            ToastUtils.showLong("请填写单价");
            return;
        }


        if (SpecId.equals("") || String.valueOf(Count).equals("") || String.valueOf(UnitPrice).equals("") || String.valueOf(ItemTotalPrice).equals("")) {
            Toast.makeText(this, "请填写完整信息", Toast.LENGTH_SHORT).show();
            return;
        }
        addData(SpecId, Count, UnitPrice, ItemTotalPrice, Note);
    }

    private void addData( String specId, double count, double unitPrice, double itemTotalPrice, String note) {
        mSalesOrderItemModel=new SalesOrderItemModel();
        mSalesOrderItemModel.setSpecId(specId);
        mSalesOrderItemModel.setCount(count);
        mSalesOrderItemModel.setUnitPrice(unitPrice);
        mSalesOrderItemModel.setItemTotalPrice(itemTotalPrice);
        if(PeelStrengthStr!=null){
            mSalesOrderItemModel.setPeelStrengthStr(PeelStrengthStr);
        }
        else {
            mSalesOrderItemModel.setPeelStrengthStr("");
        }

        if(MolecularWeightStr!=null){
            mSalesOrderItemModel.setMolecularWeightStr(MolecularWeightStr);
        }
        else {
            mSalesOrderItemModel.setMolecularWeightStr("");
        }


        if(SolidContentStr!=null){
            mSalesOrderItemModel.setSolidContentStr(SolidContentStr);
        }
        else {
            mSalesOrderItemModel.setSolidContentStr("");
        }

        if(TemperatureResistStr!=null){
            mSalesOrderItemModel.setTemperatureResistStr(TemperatureResistStr);
        }
        else {
            mSalesOrderItemModel.setTemperatureResistStr("");
        }

        if(LowBoilingContentStr!=null){
            mSalesOrderItemModel.setLowBoilingContentStr(LowBoilingContentStr);
        }
        else {
            mSalesOrderItemModel.setLowBoilingContentStr("");
        }


        if (note!=null) {
            mSalesOrderItemModel.setNote(note);
        } else {
            mSalesOrderItemModel.setNote("");
        }

        Intent intent = new Intent();
        intent.putExtra("data", mSalesOrderItemModel);
        setResult(RESULT_OK, intent);
        finish();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_CANSHU) {
            if (PreferencesUtils.getString(XiaoShouDingDanActivity.this, "PeelStrengthStr") != null) {
                PeelStrengthStr = PreferencesUtils.getString(XiaoShouDingDanActivity.this, "PeelStrengthStr");
                TemperatureResistStr=PreferencesUtils.getString(XiaoShouDingDanActivity.this, "TemperatureResistStr");
                Seriers = PreferencesUtils.getString(XiaoShouDingDanActivity.this, "Seriers");
                mGuigeText.setText(Seriers + "(" + PeelStrengthStr + ")");
                guige = mGuigeText.getText().toString();
                PreferencesUtils.putString(XiaoShouDingDanActivity.this,"guige",guige);
            } else if (PreferencesUtils.getString(XiaoShouDingDanActivity.this, "SolidContentStr") != null) {
                SolidContentStr = PreferencesUtils.getString(XiaoShouDingDanActivity.this, "SolidContentStr");
                Seriers = PreferencesUtils.getString(XiaoShouDingDanActivity.this, "Seriers");
                mGuigeText.setText(Seriers + "(" + SolidContentStr + ")");
                guige = mGuigeText.getText().toString();
                PreferencesUtils.putString(XiaoShouDingDanActivity.this,"guige",guige);
            } else if (PreferencesUtils.getString(XiaoShouDingDanActivity.this, "MolecularWeightStr") != null) {
                MolecularWeightStr = PreferencesUtils.getString(XiaoShouDingDanActivity.this, "MolecularWeightStr");
                LowBoilingContentStr = PreferencesUtils.getString(XiaoShouDingDanActivity.this, "LowBoilingContentStr");
                TemperatureResistStr=PreferencesUtils.getString(XiaoShouDingDanActivity.this, "TemperatureResistStr");
                Seriers = PreferencesUtils.getString(XiaoShouDingDanActivity.this, "Seriers");
                mGuigeText.setText(Seriers + "(" + MolecularWeightStr + ")-" + "(" + LowBoilingContentStr + ")");
                guige = mGuigeText.getText().toString();
                PreferencesUtils.putString(XiaoShouDingDanActivity.this,"guige",guige);
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
}
