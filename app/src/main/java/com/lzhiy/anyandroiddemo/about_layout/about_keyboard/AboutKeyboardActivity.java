package com.lzhiy.anyandroiddemo.about_layout.about_keyboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lzhiy.anyandroiddemo.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class AboutKeyboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_keyboard);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.layout_up)
    void toLayoutUpActivity(){
        startActivity(new Intent(AboutKeyboardActivity.this, LayoutUpActivity.class));
    }
}
