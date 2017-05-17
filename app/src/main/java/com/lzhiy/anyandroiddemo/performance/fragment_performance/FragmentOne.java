package com.lzhiy.anyandroiddemo.performance.fragment_performance;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lzhiy.anyandroiddemo.R;

import butterknife.ButterKnife;

/***********************************************************************
 * @website ：
 * @creator : zhiyingli
 * @create-time : 2017/4/19
 * @email : lizhiying61f@gmail.com
 * @description :
 ***********************************************************************/

public class FragmentOne extends Fragment {
    private Context context;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.activity_layout_up,null);
        ButterKnife.bind(this,rootview);
        return rootview;
    }
}
