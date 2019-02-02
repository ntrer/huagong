package com.shushang.huagongproject.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.shushang.huagongproject.Bean.SalesOrderItemModel;
import com.shushang.huagongproject.Bean.XiaoShouDingDan;
import com.shushang.huagongproject.R;
import com.shushang.huagongproject.activity.adapter.XiaoShouDingDanShangPinAdapter;
import com.shushang.huagongproject.base.BaseActivity;
import com.shushang.huagongproject.ui.ExtAlertDialog;
import com.shushang.huagongproject.utils.SharePreferences.PreferencesUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class XiaoShouDingDanShangPinDetailActivity extends BaseActivity {
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
    private XiaoShouDingDanShangPinAdapter mXiaoShouDingDanShangPinAdapter;
    private List<XiaoShouDingDan.DataBean.ItemsBean> mItemsBean = new ArrayList<>();
    private List<SalesOrderItemModel> data=new ArrayList<>();
    private List<SalesOrderItemModel> datas=new ArrayList<>();
    private List<SalesOrderItemModel> datas2=new ArrayList<>();
    private List<SalesOrderItemModel> datas3=new ArrayList<>();
    private SalesOrderItemModel mSalesOrderItemModel;
    private static final int REQUEST_CODE_GOODS = 1004;
    private Dialog mRequestDialog;
    private String Note,Items,guige,first;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        //设置支持toolbar
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        first=getIntent().getStringExtra("first");
        try {
            if(first.equals("true")){
                datas2.clear();
                datas3.clear();
                mItemsBean= (List<XiaoShouDingDan.DataBean.ItemsBean>) getIntent().getSerializableExtra("data");
                if(mItemsBean.size()>0){
                    mLlNoData.setVisibility(View.GONE);
                }
                for (int i=0;i<mItemsBean.size();i++){
                    mSalesOrderItemModel=new SalesOrderItemModel();
                    mSalesOrderItemModel.setSpecId(mItemsBean.get(i).getSpecId());
                    mSalesOrderItemModel.setCount(mItemsBean.get(i).getCount());
                    mSalesOrderItemModel.setUnitPrice(mItemsBean.get(i).getUnitPrice());
                    mSalesOrderItemModel.setItemTotalPrice(mItemsBean.get(i).getItemTotalPrice());
                    if(mItemsBean.get(i).getPeelStrengthStr()!=null){
                        mSalesOrderItemModel.setPeelStrengthStr(mItemsBean.get(i).getPeelStrengthStr());
                    }
                    else {
                        mSalesOrderItemModel.setPeelStrengthStr("");
                    }

                    if(mItemsBean.get(i).getMolecularWeightStr()!=null){
                        mSalesOrderItemModel.setMolecularWeightStr(mItemsBean.get(i).getMolecularWeightStr());
                    }
                    else {
                        mSalesOrderItemModel.setMolecularWeightStr("");
                    }


                    if(mItemsBean.get(i).getSolidContentStr()!=null){
                        mSalesOrderItemModel.setSolidContentStr(mItemsBean.get(i).getSolidContentStr());
                    }
                    else {
                        mSalesOrderItemModel.setSolidContentStr("");
                    }

                    if(mItemsBean.get(i).getTemperatureResistStr()!=null){
                        mSalesOrderItemModel.setTemperatureResistStr(mItemsBean.get(i).getTemperatureResistStr());
                    }
                    else {
                        mSalesOrderItemModel.setTemperatureResistStr("");
                    }

                    if(mItemsBean.get(i).getLowBoilingContentStr()!=null){
                        mSalesOrderItemModel.setLowBoilingContentStr(mItemsBean.get(i).getLowBoilingContentStr());
                    }
                    else {
                        mSalesOrderItemModel.setLowBoilingContentStr("");
                    }

                    if (mItemsBean.get(i).getNote()!=null) {
                        mSalesOrderItemModel.setNote(mItemsBean.get(i).getNote());
                    } else {
                        mSalesOrderItemModel.setNote("");
                    }
                    datas2.add(mSalesOrderItemModel);
                    datas3.add(mSalesOrderItemModel);
                }
            }
            else {
                datas2.clear();
                datas3.clear();
                datas=(List<SalesOrderItemModel>) getIntent().getSerializableExtra("data");
                datas2.addAll(datas);
                datas3.addAll(datas);
                if(datas2.size()>0){
                    mLlNoData.setVisibility(View.GONE);
                }
            }
        }
        catch (Exception e){
            ToastUtils.showLong(e.toString());
        }

        mRequestDialog = ExtAlertDialog.creatRequestDialog(this, getString(R.string.submit));
        mRequestDialog.setCancelable(false);
        initRecyclerview(datas2);
    }

    private void initRecyclerview(List<SalesOrderItemModel> datas2) {
        final LinearLayoutManager linermanager = new LinearLayoutManager(getApplicationContext());
        mRvRecycleview.setLayoutManager(linermanager);
        mXiaoShouDingDanShangPinAdapter = new XiaoShouDingDanShangPinAdapter(R.layout.item_xiaoshoudingdanshangpin, datas2);
        //重复执行动画
        mXiaoShouDingDanShangPinAdapter.isFirstOnly(false);
        mRvRecycleview.setAdapter(mXiaoShouDingDanShangPinAdapter);
        mRvRecycleview.addOnItemTouchListener(new OnItemChildClickListener() {
            @Override
            public void onSimpleItemChildClick(BaseQuickAdapter adapter, View view, int position) {

            }

            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, final int position) {
                super.onItemChildClick(adapter, view, position);
                int itemViewId = view.getId();
                if(itemViewId==R.id.delete){
                    ExtAlertDialog.showSureDlg(XiaoShouDingDanShangPinDetailActivity.this, null, "删除该商品吗", "删除", new ExtAlertDialog.IExtDlgClick() {
                        @Override
                        public void Oclick(int result) {
                            if (result == 1) {
                                try {
                                    mXiaoShouDingDanShangPinAdapter.remove(position);
//                                mXiaoShouDingDanShangPinAdapter.notifyDataSetChanged();
                                    datas3.remove(position);
                                    if(datas3.size()==0){
                                        mLlNoData.setVisibility(View.VISIBLE);
                                    }
                                }
                                catch (Exception e){
                                    ToastUtils.showLong(e.toString());
                                }
                            }
                        }
                    });
                }
            }
        });
    }

    @Override
    public int setLayout() {
        return R.layout.activity_xiao_shou_ding_dan_shang_pin_detail;
    }

    @Override
    public void init() {

    }


    @OnClick(R.id.more_menu)
    void more() {
        startActivityForResult(new Intent(XiaoShouDingDanShangPinDetailActivity.this,XiaoShouDingDanActivity.class),REQUEST_CODE_GOODS);
    }

    @OnClick(R.id.submit)
    void submit() {
        try {
            Intent intent = new Intent();
            intent.putExtra("data", (Serializable) datas3);
            setResult(RESULT_OK, intent);
            finish();
        }
        catch (Exception e){
            ToastUtils.showLong(e.toString());
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==REQUEST_CODE_GOODS&&resultCode==RESULT_OK){
            mSalesOrderItemModel= (SalesOrderItemModel) data.getSerializableExtra("data");
            guige=PreferencesUtils.getString(XiaoShouDingDanShangPinDetailActivity.this,"guige");
            if(mSalesOrderItemModel!=null){
                datas.clear();
                datas.add(mSalesOrderItemModel);
//                datas2.add(mSalesOrderItemModel);
                datas3.add(mSalesOrderItemModel);
                mXiaoShouDingDanShangPinAdapter.addData(datas2.size(),datas);
                mXiaoShouDingDanShangPinAdapter.setguige(guige);
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
