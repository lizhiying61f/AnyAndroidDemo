package com.lzhiy.anyandroiddemo.about_layout.about_keyboard;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.LinearLayout;

import com.lzhiy.anyandroiddemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
/***********************************************************************
 * @website ：
 * @creator : zhiyingli
 * @create-time : 2017/1/10
 * @email : lizhiying61f@gmail.com
 * @description : 当软键盘弹出的时候，有盖在布局外面的情况，有将布局background压缩的情况，
 *                这个Demo提供了一种将布局和软键盘一起抬起的功能，同时不会导致背景压缩。
 ***********************************************************************/
public class LayoutUpActivity extends AppCompatActivity {
    @BindView(R.id.activity_layout_up)
    LinearLayout mRootview;
    @BindView(R.id.submit)
    Button mBottomView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_up);
        ButterKnife.bind(this);

        controlKeyBoardLayout(mRootview,mBottomView);
    }

    /**
     *
     * @param rootview 需要调整的最外层布局
     * @param bottomview 被键盘遮挡的最底部布局
     */
    private void controlKeyBoardLayout(final View rootview, final View bottomview) {
        rootview.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {


            @Override
            public void onGlobalLayout() {
                Rect rect = new Rect();
                //获取root在窗体的可视区域
                rootview.getWindowVisibleDisplayFrame(rect);
                //当前视图最外层的高度减去现在所看到的视图的最底部的y坐标
                int rootInvisibleHeight = rootview.getHeight() - rect.bottom;
                //若rootInvisibleHeight高度大于100，则说明当前视图上移了，说明软键盘弹出了
                if (rootInvisibleHeight > 100){
                    //软键盘弹出来的时候
                    int[] location = new int[2];
                    //获取bottomview在窗体的坐标
                    bottomview.getLocationInWindow(location);
                    //计算rootview滚动高度，使bottomview在可见区域的底部
                    int scrollHeight = (location[1] + bottomview.getHeight()) - rect.bottom;
                    rootview.scrollTo(0,scrollHeight);
                }else {
                    //软键盘没有弹出来的时候
                    rootview.scrollTo(0,0);
                }
            }
        });
    }


}
