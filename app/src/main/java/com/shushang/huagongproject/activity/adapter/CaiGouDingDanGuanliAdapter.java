package com.shushang.huagongproject.activity.adapter;

import android.support.annotation.Nullable;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.shushang.huagongproject.Bean.CaiGouDingDan;
import com.shushang.huagongproject.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CaiGouDingDanGuanliAdapter extends BaseQuickAdapter<CaiGouDingDan.DataBean,BaseViewHolder> {


    public CaiGouDingDanGuanliAdapter(int layoutResId, @Nullable List<CaiGouDingDan.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CaiGouDingDan.DataBean item) {

        try {
            helper.setText(R.id.caigoudingdan,"订单号："+item.getPurchaseOrderId());
            if(item.getCreaterTime()!=null){
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date=new Date(Long.parseLong(item.getCreaterTime().substring(6,19)));
                String time=simpleDateFormat.format(date);
                helper.setText(R.id.xiadanriqi_text,time);
            }
            else {
                helper.setText(R.id.xiadanriqi_text,"");
            }

            helper.setText(R.id.chuangjianren_text,item.getCreaterName());

        }
        catch (Exception e){
            Toast.makeText(mContext, e.toString(), Toast.LENGTH_SHORT).show();
        }

    }


}
