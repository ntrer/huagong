package com.shushang.huagongproject.activity.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.shushang.huagongproject.Bean.Zhiwu;
import com.shushang.huagongproject.R;

import java.util.List;

public class ZhiWuAdapter extends BaseQuickAdapter<Zhiwu.DataBean,BaseViewHolder> {


    public ZhiWuAdapter(int layoutResId, @Nullable List<Zhiwu.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Zhiwu.DataBean item) {
        helper.setText(R.id.bumen_name,item.getDutyName());
    }

}
