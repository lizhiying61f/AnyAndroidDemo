package com.lzhiy.anyandroiddemo;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.lzhiy.anyandroiddemo.about_layout.AboutLayoutActivity;
import com.lzhiy.anyandroiddemo.animator.AnimatorActivity;
import com.lzhiy.anyandroiddemo.performance.PerformanceActivity;
import com.lzhiy.anyandroiddemo.receiver.InstallAndUninstallActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    private InstallAndUninstallActivity installAndUninstall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.aboutLayout)
    void toAboutLayoutActivity(){
        startActivity(new Intent(MainActivity.this, AboutLayoutActivity.class));
    }

    @OnClick(R.id.performance)
    void toPerformanceActivity(){
        startActivity(new Intent(MainActivity.this, PerformanceActivity.class));
    }

    @OnClick(R.id.animator)
    void toAnimator(){
        startActivity(new Intent(MainActivity.this,AnimatorActivity.class));
    }


    @Override
    protected void onStart() {
        super.onStart();
        installAndUninstall = new InstallAndUninstallActivity();
        IntentFilter filter = new IntentFilter();

        filter.addAction(Intent.ACTION_PACKAGE_ADDED);
        filter.addAction(Intent.ACTION_PACKAGE_REMOVED);
        filter.addDataScheme("package");

        registerReceiver(installAndUninstall,filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(installAndUninstall);
    }
}
