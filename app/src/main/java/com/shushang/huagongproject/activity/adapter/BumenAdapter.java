package com.shushang.huagongproject.activity.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.shushang.huagongproject.Bean.BuMen;
import com.shushang.huagongproject.R;

import java.util.List;

public class BumenAdapter extends BaseQuickAdapter<BuMen.DataBean,BaseViewHolder> {


    public BumenAdapter(int layoutResId, @Nullable List<BuMen.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, BuMen.DataBean item) {
        helper.setText(R.id.bumen_name,item.getDepartmentName());
    }

}
