package com.shushang.huagongproject.activity.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.shushang.huagongproject.Bean.GuiGe;
import com.shushang.huagongproject.R;

import java.util.List;

public class GuiGeGuanliAdapter extends BaseQuickAdapter<GuiGe.DataBean, BaseViewHolder> {

    public GuiGeGuanliAdapter(int layoutResId, @Nullable List<GuiGe.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, GuiGe.DataBean item) {

        if(item.getSeries()!=null){
            helper.setText(R.id.xielie, item.getSeries());
        }
        else {
            helper.setText(R.id.xielie, "无");
        }

        if(item.getSpecId()!=null){
            helper.setText(R.id.xinghao_text, item.getSpecId());
        }
        else {
            helper.setText(R.id.xinghao_text, "无");
        }


        if(String.valueOf(item.getPeelStrengthMin())!=null&&String.valueOf(item.getPeelStrengthMax())!=null){
            helper.setText(R.id.bolili_text,item.getPeelStrengthMin()+"-"+item.getPeelStrengthMax());
        }
        else {
            helper.setText(R.id.bolili_text,"0");
        }


        if(String.valueOf(item.getPeelStrengthMin())!=null&&String.valueOf(item.getPeelStrengthMax())!=null){
            helper.setText(R.id.naiwenxing_text,item.getPeelStrengthMin()+"-"+item.getPeelStrengthMax());
        }
        else {
            helper.setText(R.id.naiwenxing_text,"0");
        }


        if(String.valueOf(item.getMolecularWeightMin())!=null&&String.valueOf(item.getMolecularWeightMax())!=null){
            helper.setText(R.id.fenziliang_text,item.getMolecularWeightMin()+"-"+item.getMolecularWeightMax());
        }
        else {
            helper.setText(R.id.fenziliang_text,"0");
        }

        if(String.valueOf(item.getSolidContentMin())!=null&&String.valueOf(item.getMolecularWeightMax())!=null){
            helper.setText(R.id.guhanliang_text,item.getSolidContentMin()+"-"+item.getMolecularWeightMax());
        }
        else {
            helper.setText(R.id.guhanliang_text,"0");
        }

        if(String.valueOf(item.getLowBoilingContentMin())!=null&&String.valueOf(item.getLowBoilingContentMax())!=null){
            helper.setText(R.id.difei_text,item.getLowBoilingContentMin()+"-"+item.getLowBoilingContentMax());
        }
        else {
            helper.setText(R.id.difei_text,"0");
        }


    }
}
