package com.shushang.huagongproject.activity.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.shushang.huagongproject.base.BaseViewPagerAdapter;

public class CaiGouDingDanTongJIAdapter extends BaseViewPagerAdapter {

    public CaiGouDingDanTongJIAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public void addFragment(Fragment fragment, String title) {
        mFragments.add(fragment);
        mFragmentTitles.add(title);
    }
}
