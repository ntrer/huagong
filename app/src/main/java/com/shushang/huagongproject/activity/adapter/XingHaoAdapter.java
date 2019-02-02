package com.shushang.huagongproject.activity.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.shushang.huagongproject.Bean.GuiGe;
import com.shushang.huagongproject.R;

import java.util.List;

public class XingHaoAdapter extends BaseQuickAdapter<GuiGe.DataBean,BaseViewHolder> {


    public XingHaoAdapter(int layoutResId, @Nullable List<GuiGe.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, GuiGe.DataBean item) {
       helper.setText(R.id.xinghao_name,item.getSeries());
    }

}
