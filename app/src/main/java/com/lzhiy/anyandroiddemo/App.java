package com.lzhiy.anyandroiddemo;

import android.app.Application;

/***********************************************************************
 * @website ：
 * @creator : zhiyingli
 * @create-time : 2017/2/20
 * @email : lizhiying61f@gmail.com
 * @description :
 ***********************************************************************/

public class App extends Application {
    private static App instance;
    public static synchronized App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
