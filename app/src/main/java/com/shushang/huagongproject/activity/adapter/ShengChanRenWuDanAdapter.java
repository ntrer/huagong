package com.shushang.huagongproject.activity.adapter;

import android.support.annotation.Nullable;
import android.view.View;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.shushang.huagongproject.Bean.ShengChanRenWuDan;
import com.shushang.huagongproject.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ShengChanRenWuDanAdapter extends BaseQuickAdapter<ShengChanRenWuDan.DataBean,BaseViewHolder> {


    public ShengChanRenWuDanAdapter(int layoutResId, @Nullable List<ShengChanRenWuDan.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ShengChanRenWuDan.DataBean item) {
        try {
            helper.setText(R.id.caigoudingdan,"单号:"+item.getId());
            helper.setText(R.id.chuangjianren_text,item.getCreaterName());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date=new Date(Long.parseLong(item.getCreaterTime().substring(6,19)));
            String time=simpleDateFormat.format(date);
            helper.setText(R.id.chuangjianshijian_text,time);
            helper.setText(R.id.kehu_text,item.getBuyerTitle());
            helper.setText(R.id.guige_text,item.getSpecId());
            if(item.getStatus()==0){
               helper.getView(R.id.daishenhe).setVisibility(View.VISIBLE);
            }
            else if(item.getStatus()==10){
                helper.getView(R.id.daishengchan).setVisibility(View.VISIBLE);
            }
            else if(item.getStatus()==-10){
                helper.getView(R.id.shenhebutongguo).setVisibility(View.VISIBLE);
            }
            else if(item.getStatus()==30){
                helper.getView(R.id.zhengzaishengchan).setVisibility(View.VISIBLE);
            }
            else if(item.getStatus()==40){
                helper.getView(R.id.bufenwancheng).setVisibility(View.VISIBLE);
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
