package com.shushang.huagongproject.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.shushang.huagongproject.Bean.PurchaseOrderItemModel;
import com.shushang.huagongproject.Bean.XinZengRenYuan;
import com.shushang.huagongproject.LoginActivity;
import com.shushang.huagongproject.R;
import com.shushang.huagongproject.activity.adapter.CaiGouDingDanAdapter;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;

public class XinZengCaiGouDingDanActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.jiahao)
    ImageView mJiahao;
    @BindView(R.id.more_menu)
    LinearLayout mMoreMenu;
    @BindView(R.id.rv_recycleview)
    RecyclerView mRvRecycleview;
    @BindView(R.id.ll_no_data)
    LinearLayout mLlNoData;
    @BindView(R.id.submit)
    LinearLayout mSubmit;
    private CaiGouDingDanAdapter mCaiGouDingDanAdapter;
    private List<PurchaseOrderItemModel> datas=new ArrayList<>();
    private List<PurchaseOrderItemModel> datas2=new ArrayList<>();
    private List<PurchaseOrderItemModel> datas3=new ArrayList<>();
    private PurchaseOrderItemModel mPurchaseOrderItemModel;
    private static final int REQUEST_CODE_GOODS = 1004;
    private Dialog mRequestDialog;
    private String Note,Items;
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
        initRecyclerview();
    }

    private void initRecyclerview() {
        final LinearLayoutManager linermanager = new LinearLayoutManager(getApplicationContext());
        mRvRecycleview.setLayoutManager(linermanager);
        mCaiGouDingDanAdapter = new CaiGouDingDanAdapter(R.layout.item_caigoudingdan, datas);
        //重复执行动画
        mCaiGouDingDanAdapter.isFirstOnly(false);
        mRvRecycleview.setAdapter(mCaiGouDingDanAdapter);
        mCaiGouDingDanAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                mCaiGouDingDanAdapter.remove(position);
                mCaiGouDingDanAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public int setLayout() {
        return R.layout.activity_xin_zeng_cai_gou_ding_dan2;
    }

    @Override
    public void init() {

    }


    @OnClick(R.id.more_menu)
    void more() {
      startActivityForResult(new Intent(XinZengCaiGouDingDanActivity.this,CaiGouDingDanActivity.class),REQUEST_CODE_GOODS);
    }

    @OnClick(R.id.submit)
    void submit() {

        new ActionSheetDialog(XinZengCaiGouDingDanActivity.this)
                .builder()
                .setCancelable(false)
                .setCanceledOnTouchOutside(true)
                .addSheetItem("添加备注", ActionSheetDialog.SheetItemColor.Blue,
                        new ActionSheetDialog.OnSheetItemClickListener() {
                            @Override
                            public void onClick(int which) {
                                ExtAlertDialog.showEditDlg2(XinZengCaiGouDingDanActivity.this, "添加备注", "修改", false, new ExtAlertDialog.IExtDlgClick2() {
                                    @Override
                                    public void Oclick(int result, Editable text) {
                                        if (result == 1) {
                                            if (text == null) {
                                                ToastUtils.showLong("请填写备注");
                                            } else {
                                                Note=text.toString();
                                                postData(Note,datas3);
                                            }
                                        }
                                    }
                                });
                            }
                        })
                .addSheetItem("直接提交", ActionSheetDialog.SheetItemColor.Blue,
                        new ActionSheetDialog.OnSheetItemClickListener() {
                            @Override
                            public void onClick(int which) {
                                postData(Note,datas3);
                            }
                        })
                .show();

    }

    private void postData(String note, List<PurchaseOrderItemModel> datas3) {
        mRequestDialog.show();
        String url =  BaseUrl.BASE_URL + "PurchaseOrder/CreatePurchaseOrder?tid="+BaseUrl.TOKEN;
        Log.d("创建活动", url);
        HashMap<String, String> paramsMap = new HashMap<>();
        Items=JSONUtil.toJSON(datas3);
        paramsMap.put("Items", Items);
        if(note!=null){
            paramsMap.put("Note",note);
        }
        else {
            paramsMap.put("Note","");
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
                            EventBus.getDefault().post(new MessageEvent("采购"));
                            finish();
                        }
                        else if(response1.getCode()==-5){
                            if(mRequestDialog!=null&&mRequestDialog.isShowing()){
                                mRequestDialog.dismiss();
                            }
                            Toast.makeText(XinZengCaiGouDingDanActivity.this, ""+response1.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                        else if (response1.getCode()==101) {
                            Toast.makeText(XinZengCaiGouDingDanActivity.this, ""+response1.getMessage()
                                    , Toast.LENGTH_SHORT).show();
                            PreferencesUtils.putString(XinZengCaiGouDingDanActivity.this, "token_id", null);
                            startActivity(new Intent(XinZengCaiGouDingDanActivity.this, LoginActivity.class));
                            finish();
                        }
                        else {
                            if(mRequestDialog!=null&&mRequestDialog.isShowing()){
                                mRequestDialog.dismiss();
                            }
                            Toast.makeText(XinZengCaiGouDingDanActivity.this, ""+response1.getMessage(), Toast.LENGTH_SHORT).show();
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
        if (requestCode==REQUEST_CODE_GOODS&&resultCode==RESULT_OK){
            mPurchaseOrderItemModel= (PurchaseOrderItemModel) data.getSerializableExtra("data");
            if(mPurchaseOrderItemModel!=null){
                datas2.clear();
                datas2.add(mPurchaseOrderItemModel);
                datas3.add(mPurchaseOrderItemModel);
                mCaiGouDingDanAdapter.addData(datas2);
                mLlNoData.setVisibility(View.GONE);
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
