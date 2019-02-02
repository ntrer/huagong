package com.shushang.huagongproject.application;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.blankj.utilcode.util.Utils;
import com.shushang.AppContext;
import com.shushang.huagongproject.utils.MediaLoader;
import com.yanzhenjie.album.Album;
import com.yanzhenjie.album.AlbumConfig;

import java.util.Locale;
import java.util.Set;

/**
 * Created by YD on 2018/7/10.
 */

public class MyApplication extends Application {
    private static MyApplication myApplication=null;
    private Set<Activity> allActivities;
    private int	mScreenWidth, mScreenHeight;// 屏幕尺寸
    private String token_id;
    @Override
    public void onCreate() {
        super.onCreate();
        myApplication=this;
        //工具类初始化
        Utils.init(myApplication);
        AppContext.getInstance().init(myApplication);
        Album.initialize(AlbumConfig.newBuilder(this)
                .setAlbumLoader(new MediaLoader())
                .setLocale(Locale.getDefault())
                .build()
        );
    }


    public static MyApplication getInstance(){
        return myApplication;
    }



    /**
     * 退出app
     */
    public void exitApp() {
        if (allActivities != null) {
            synchronized (allActivities) {
                for (Activity act : allActivities) {
                    act.finish();
                }
            }
        }
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }


}
