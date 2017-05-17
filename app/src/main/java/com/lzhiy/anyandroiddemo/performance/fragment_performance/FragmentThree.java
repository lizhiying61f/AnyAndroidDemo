package com.lzhiy.anyandroiddemo.performance.fragment_performance;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/***********************************************************************
 * @website ：
 * @creator : zhiyingli
 * @create-time : 2017/4/19
 * @email : lizhiying61f@gmail.com
 * @description :
 ***********************************************************************/

public class FragmentThree extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity());
        textView.setGravity(Gravity.CENTER);
        textView.setText("第三页");
        return textView;
    }
}
