package com.lzhiy.anyandroiddemo.about_layout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lzhiy.anyandroiddemo.R;
import com.lzhiy.anyandroiddemo.about_layout.about_keyboard.LayoutUpActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/***********************************************************************
 * @website ：
 * @creator : zhiyingli
 * @create-time : 2017/1/10
 * @email : lizhiying61f@gmail.com
 * @description :
 ***********************************************************************/
public class AboutLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_layout);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.aboutkeyboard)
    void toAboutKeyboardActivity(){
        startActivity(new Intent(AboutLayoutActivity.this, LayoutUpActivity.class));
    }
}
