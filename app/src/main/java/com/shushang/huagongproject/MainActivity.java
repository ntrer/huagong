package com.shushang.huagongproject;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.widget.Toast;

import com.shushang.huagongproject.base.BaseActivity;
import com.shushang.huagongproject.fragment.DaiBanFragment;
import com.shushang.huagongproject.fragment.MyFragment;
import com.shushang.huagongproject.fragment.ShouYeFragment;
import com.shushang.huagongproject.fragment.TongJiFragment;
import com.shushang.huagongproject.utils.ActivityManager.ActivityStackManager;
import com.shushang.huagongproject.utils.BottomNavigationViewHelper;

public class MainActivity extends BaseActivity {
    //退出时的时间
    private long mExitTime;
    private Handler mHandler;
    private MyFragment mMyFragment;
    private ShouYeFragment mShouYeFragment;
    private TongJiFragment mTongJiFragment;
    private DaiBanFragment mDaiBanFragment;
    private BottomNavigationView mNavigationView;
    private int lastfragment;//用于记录上个选择的Fragment
    private Fragment[] mFragments ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState!=null){
            FragmentManager manager = getSupportFragmentManager();
            manager.popBackStackImmediate(null, 1);
        }
        mNavigationView=findViewById(R.id.navigation_fragment);
        initFragment();
        mNavigationView.setItemIconTintList(null);
    }

    @Override
    public int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void init() {

    }


    //初始化fragment和fragment数组
    private void initFragment() {
        mMyFragment = new MyFragment();
        mShouYeFragment=new ShouYeFragment();
        mDaiBanFragment=new DaiBanFragment();
        mTongJiFragment=new TongJiFragment();
        mFragments = new Fragment[]{mShouYeFragment,mTongJiFragment, mDaiBanFragment,mMyFragment};
        lastfragment = 0;
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, mShouYeFragment,"tag1").show(mShouYeFragment).commit();
        BottomNavigationViewHelper.disableShiftMode(mNavigationView);
        mNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.navigation_fragment_zero:
                    {
                        if(lastfragment!=0)
                        {
                            switchFragment(lastfragment,0);
                            lastfragment=0;

                        }
                        return true;

                    }
                    case R.id.navigation_fragment_one:
                    {
                        if(lastfragment!=1)
                        {
                            switchFragment(lastfragment,1);
                            lastfragment=1;

                        }

                        return true;
                    }
                    case R.id.navigation_fragment_three:
                    {
                        if(lastfragment!=2)
                        {
                            switchFragment(lastfragment,2);
                            lastfragment=2;

                        }

                        return true;
                    }
                    case R.id.navigation_fragment_four:
                    {
                        if(lastfragment!=3)
                        {
                            switchFragment(lastfragment,3);
                            lastfragment=3;

                        }

                        return true;
                    }

                }
                return false;
            }
        });


    }


    //切换Fragment
    private void switchFragment(int lastfragment,int index)
    {
        FragmentTransaction transaction =getSupportFragmentManager().beginTransaction();
        transaction.hide(mFragments[lastfragment]);//隐藏上个Fragment
        if(mFragments[index].isAdded()==false)
        {
            transaction.add(R.id.fragment_container,mFragments[index],"tag"+index);


        }
        transaction.show(mFragments[index]).commitAllowingStateLoss();

    }


    //对返回键进行监听
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            exit();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    //退出应用
    public void exit() {
        if ((System.currentTimeMillis() - mExitTime) > 2000) {
            Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show();
            mExitTime = System.currentTimeMillis();
        } else {
            ActivityStackManager.getActivityStackManager().popAllActivity();//remove all activity.
            System.exit(0);
            finish();
        }
    }

}
