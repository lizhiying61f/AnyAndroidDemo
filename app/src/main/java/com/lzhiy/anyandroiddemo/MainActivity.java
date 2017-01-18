package com.lzhiy.anyandroiddemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lzhiy.anyandroiddemo.about_layout.AboutLayoutActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

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

    }
}
