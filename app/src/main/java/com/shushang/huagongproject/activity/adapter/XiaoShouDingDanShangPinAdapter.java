package com.shushang.huagongproject.activity.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.shushang.huagongproject.Bean.SalesOrderItemModel;
import com.shushang.huagongproject.R;

import java.util.List;

public class XiaoShouDingDanShangPinAdapter extends BaseQuickAdapter<SalesOrderItemModel,BaseViewHolder> {

    private String guige;
    public XiaoShouDingDanShangPinAdapter(int layoutResId, @Nullable List<SalesOrderItemModel> data) {
        super(layoutResId, data);
    }

    public void setguige(String guige) {
        this.guige=guige;
    }


    @Override
    protected void convert(BaseViewHolder helper, final SalesOrderItemModel item) {
        if(guige!=null){
            helper.setText(R.id.guige_text,guige);
        }
        else {
            helper.setText(R.id.guige_text,item.getSpecId());
        }
        helper.setText(R.id.danjia_text,String.valueOf(item.getUnitPrice()));
        helper.setText(R.id.shuliang_text,String.valueOf(item.getCount()));
        helper.setText(R.id.zongjia_text,String.valueOf(item.ItemTotalPrice));
        if(item.getNote()!=null){
            helper.setText(R.id.beizhu_content,item.getNote());
        }
        else {
            helper.setText(R.id.beizhu_content,"无");
        }

        helper.addOnClickListener(R.id.delete);

    }


}
