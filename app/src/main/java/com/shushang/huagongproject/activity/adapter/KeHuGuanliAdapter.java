package com.shushang.huagongproject.activity.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.shushang.huagongproject.Bean.KeHu;
import com.shushang.huagongproject.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class KeHuGuanliAdapter extends BaseQuickAdapter<KeHu.DataBean, BaseViewHolder> {

    public KeHuGuanliAdapter(int layoutResId, @Nullable List<KeHu.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, KeHu.DataBean item) {


        if(item.getBuyerTitle()!=null){
            helper.setText(R.id.gongyingshangmingcheng_text, item.getBuyerTitle());
        }
        else {
            helper.setText(R.id.gongyingshangmingcheng_text, "无");
        }

        if(item.getAddress()!=null){
            helper.setText(R.id.shouhuodizhi_text, item.getAddress()+"");
        }
        else {
            helper.setText(R.id.xingming_text, "");
        }


        if(item.getAddressRealName()!=null){
            helper.setText(R.id.lianxiren_text,item.getAddressRealName());
        }
        else {
            helper.setText(R.id.lianxiren_text,"");
        }


        if(item.getAddressMobile()!=null){
            helper.setText(R.id.shoujihao_text,item.getAddressMobile());
        }
        else {
            helper.setText(R.id.shoujihao_text,"");
        }

        if(item.getCreateTime()!=null){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date=new Date(Long.parseLong(item.getCreateTime().substring(6,19)));
            String time=simpleDateFormat.format(date);
            helper.setText(R.id.chuangjianshijian,time);
        }


    }
}
