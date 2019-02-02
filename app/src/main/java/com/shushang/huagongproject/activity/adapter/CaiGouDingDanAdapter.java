package com.shushang.huagongproject.activity.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.shushang.huagongproject.Bean.PurchaseOrderItemModel;
import com.shushang.huagongproject.R;

import java.util.List;

public class CaiGouDingDanAdapter extends BaseQuickAdapter<PurchaseOrderItemModel,BaseViewHolder> {


    public CaiGouDingDanAdapter(int layoutResId, @Nullable List<PurchaseOrderItemModel> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, PurchaseOrderItemModel item) {
        helper.setText(R.id.wuliao_text,item.getMaterielName());
        helper.setText(R.id.guige_text,item.getSpecificationName());
        helper.setText(R.id.gongyingshang_text,item.getSupplierName());
        helper.setText(R.id.danjia_text,String.valueOf(item.getUnitPrice()));
        helper.setText(R.id.shuliang_text,String.valueOf(item.getCount()));
        helper.setText(R.id.fukuantiaojiantext,item.getPaymentTerm());
    }


}
