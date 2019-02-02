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

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.shushang.huagongproject.Bean.SalesOrderItemModel;
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

public class XinZengXiaoShouDingDanShangPinActivity extends BaseActivity {
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
    private List<SalesOrderItemModel> datas=new ArrayList<>();
    private List<SalesOrderItemModel> datas2=new ArrayList<>();
    private List<SalesOrderItemModel> datas3=new ArrayList<>();
    private SalesOrderItemModel mSalesOrderItemModel;
    private static final int REQUEST_CODE_GOODS = 1004;
    private Dialog mRequestDialog;
    private String Note,Items,guige;
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
        mXiaoShouDingDanShangPinAdapter = new XiaoShouDingDanShangPinAdapter(R.layout.item_xiaoshoudingdanshangpin,datas);
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
                   ExtAlertDialog.showSureDlg(XinZengXiaoShouDingDanShangPinActivity.this, null, "删除该商品吗", "删除", new ExtAlertDialog.IExtDlgClick() {
                       @Override
                       public void Oclick(int result) {
                           if (result == 1) {
                               mXiaoShouDingDanShangPinAdapter.remove(position);
                               mXiaoShouDingDanShangPinAdapter.notifyDataSetChanged();
                               datas3.remove(position);
                           }
                       }
                   });
               }
           }
       });
    }

    @Override
    public int setLayout() {
        return R.layout.activity_xin_zeng_xiao_shou_shangpin;
    }

    @Override
    public void init() {

    }


    @OnClick(R.id.more_menu)
    void more() {
      startActivityForResult(new Intent(XinZengXiaoShouDingDanShangPinActivity.this,XiaoShouDingDanActivity.class),REQUEST_CODE_GOODS);
    }

    @OnClick(R.id.submit)
    void submit() {
        Intent intent = new Intent();
        intent.putExtra("data", (Serializable) datas3);
        setResult(RESULT_OK, intent);
        finish();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==REQUEST_CODE_GOODS&&resultCode==RESULT_OK){
             mSalesOrderItemModel= (SalesOrderItemModel) data.getSerializableExtra("data");
            guige=PreferencesUtils.getString(XinZengXiaoShouDingDanShangPinActivity.this,"guige");
            if(mSalesOrderItemModel!=null){
                datas2.clear();
                datas2.add(mSalesOrderItemModel);
                datas3.add(mSalesOrderItemModel);
                mXiaoShouDingDanShangPinAdapter.addData(datas2);
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
