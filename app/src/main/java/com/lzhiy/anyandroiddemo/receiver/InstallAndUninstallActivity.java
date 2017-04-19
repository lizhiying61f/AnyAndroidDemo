package com.lzhiy.anyandroiddemo.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/***********************************************************************
 * @website ：
 * @creator : zhiyingli
 * @create-time : 2017/2/20
 * @email : lizhiying61f@gmail.com
 * @description : 通过广播监听程序安装完成与卸载
 ***********************************************************************/

public class InstallAndUninstallActivity extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("Install",intent.getDataString());
        //接收安装广播
        if (intent.getAction().equals(Intent.ACTION_PACKAGE_ADDED)){
            String installPackageName = intent.getDataString();
            String packageName = context.getApplicationInfo().packageName;
            if (packageName.equals(installPackageName)){
                Toast.makeText(context,"安装完成了",Toast.LENGTH_SHORT);
            }
        }
        //接收卸载广播
        if (intent.getAction().equals(Intent.ACTION_PACKAGE_REMOVED)){
            String removedPackageName = intent.getDataString();
            String packageName = context.getApplicationInfo().packageName;
            if (packageName.equals(removedPackageName)){
                Toast.makeText(context,"程序卸载了",Toast.LENGTH_SHORT);
            }
        }
    }
}
