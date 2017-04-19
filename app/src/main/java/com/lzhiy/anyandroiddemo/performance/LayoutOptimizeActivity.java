package com.lzhiy.anyandroiddemo.performance;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.lzhiy.anyandroiddemo.R;

/**
 * 布局优化
 */
public class LayoutOptimizeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_optimize);
        /*
            Activity会自带默认背景色，但是其实很多界面是不需要背景色的，或者需要的背景色与默认背景色不一致，
            这样就会导致一次重绘。
            可以在Apptheme中去掉背景色：
            <style name="appp" parent="android:Theme.Light.NoTitleBar">
                <item name="android:windowBackground">@null</item>
            </style>
         */
        //也可以通过代码设置去除背景色
        getWindow().setBackgroundDrawable(null);
    }
}
