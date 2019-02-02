package com.shushang.huagongproject.activity.adapter;

import android.support.annotation.Nullable;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.shushang.huagongproject.Bean.RenYuanGuanli;
import com.shushang.huagongproject.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class RenYuanGuanliAdapter extends BaseQuickAdapter<RenYuanGuanli.DataBean, BaseViewHolder> {

    public RenYuanGuanliAdapter(int layoutResId, @Nullable List<RenYuanGuanli.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, RenYuanGuanli.DataBean item) {


        if(item.getRealName()!=null){
            helper.setText(R.id.name, item.getRealName());
        }
        else {
            helper.setText(R.id.name, "无");
        }

        if(item.getDepartmentName()!=null){
            if(item.getDutyName()!=null){
                helper.setText(R.id.xingming_text, item.getDepartmentName()+""+item.getDutyName());
            }else {
                helper.setText(R.id.xingming_text, item.getDepartmentName()+"");
            }
        }
        else {
            helper.setText(R.id.xingming_text, "");
        }


        if(item.getManagerAccount()!=null){
            helper.setText(R.id.dengluzhanghao_text,item.getManagerAccount());
        }
        else {
            helper.setText(R.id.dengluzhanghao_text,"");
        }


        if(item.getNickName()!=null){
            helper.setText(R.id.dengluming_text,item.getNickName());
        }
        else {
            helper.setText(R.id.dengluming_text,"");
        }

        if(item.getCreateTime()!=null){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date=new Date(Long.parseLong(item.getCreateTime().substring(6,19)));
            String time=simpleDateFormat.format(date);
            helper.setText(R.id.chuangjianshijian_text,time);
        }

        if(item.isActive()){
            helper.getView(R.id.quanxian1).setVisibility(View.VISIBLE);
            helper.getView(R.id.quanxian2).setVisibility(View.GONE);
        }
        else {
            helper.getView(R.id.quanxian1).setVisibility(View.GONE);
            helper.getView(R.id.quanxian2).setVisibility(View.VISIBLE);
        }

    }
}
