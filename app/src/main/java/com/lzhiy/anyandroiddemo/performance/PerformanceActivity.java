package com.lzhiy.anyandroiddemo.performance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lzhiy.anyandroiddemo.R;
import com.lzhiy.anyandroiddemo.performance.fragment_performance.FragmentPerformanceActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 性能优化
 */
public class PerformanceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_performance);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.layout_optimize)
    public void toLayoutOptimizeActivity(){
        startActivity(new Intent(PerformanceActivity.this,LayoutOptimizeActivity.class));
    }

    @OnClick(R.id.fragment_performance)
    public void toFragmentPerformanceActivity(){
        startActivity(new Intent(PerformanceActivity.this, FragmentPerformanceActivity.class));
    }

}
