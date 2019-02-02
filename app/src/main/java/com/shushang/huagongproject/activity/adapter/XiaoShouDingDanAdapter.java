package com.shushang.huagongproject.activity.adapter;

import android.support.annotation.Nullable;
import android.view.View;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.shushang.huagongproject.Bean.XiaoShouDingDan;
import com.shushang.huagongproject.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class XiaoShouDingDanAdapter extends BaseQuickAdapter<XiaoShouDingDan.DataBean,BaseViewHolder> {


    public XiaoShouDingDanAdapter(int layoutResId, @Nullable List<XiaoShouDingDan.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, XiaoShouDingDan.DataBean item) {
     try {
         helper.setText(R.id.xiaoshoudingdan,item.getSalesOrderId());
         helper.setText(R.id.maijia_text,item.getBuyerTitle());
         SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
         Date date=new Date(Long.parseLong(item.getCreaterTime().substring(6,19)));
         Date date2=new Date(Long.parseLong(item.getEstimatedDeliveryTime().substring(6,19)));
         String time=simpleDateFormat.format(date);
         String time2=simpleDateFormat.format(date2);
         helper.setText(R.id.chuangjianshijiantext,time);
         helper.setText(R.id.fahuoshijian_text,time2);
         helper.setText(R.id.fukauntiaojian_text,"支付宝");
         helper.setText(R.id.shangpinjianshu_text,item.getItems().size()+"件");

         if(item.getStatus()==0){
             helper.getView(R.id.daishenhe).setVisibility(View.VISIBLE);
         }
         else if(item.getStatus()==10){
             helper.getView(R.id.shenhetongguo).setVisibility(View.VISIBLE);
         }
         else if(item.getStatus()==-10){
             helper.getView(R.id.shenhebutongguo).setVisibility(View.VISIBLE);
         }
         else if(item.getStatus()==100){
             helper.getView(R.id.yiwancheng).setVisibility(View.VISIBLE);
         }
         else if(item.getStatus()==-100){
             helper.getView(R.id.yiquxiao).setVisibility(View.VISIBLE);
         }


     }
     catch (Exception e){
         ToastUtils.showLong(e.toString());
     }
    }

}
