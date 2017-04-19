package com.lzhiy.anyandroiddemo.animator;

import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lzhiy.anyandroiddemo.R;

/**
 * 动画
 */
public class AnimatorActivity extends AppCompatActivity {
    private TextView animatorTV;
    private LinearLayout tv_container;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator);
        animatorTV = (TextView) findViewById(R.id.animator_simple);
        tv_container = (LinearLayout) findViewById(R.id.tv_container);
    }

    public void alphademo(View view){
        ObjectAnimator animator = ObjectAnimator.ofFloat(animatorTV,"alpha",1f,0f,1f);
        animator.setDuration(3000);
        animator.start();
    }

    public void rotation(View v){
        ObjectAnimator animator = ObjectAnimator.ofFloat(animatorTV, "rotation", 0f, 360f);
        animator.setDuration(5000);
        animator.start();
    }

    public void translation(View v){
        final int height = tv_container.getHeight();
        int height1 = animatorTV.getHeight();
        animatorTV.setVisibility(View.VISIBLE);
//        ValueAnimator animator = ValueAnimator.ofFloat(-height1,(height - height1));
//        animator.setTarget(animatorTV);
//        animator.setDuration(3000).start();
//        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
//        {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation)
//            {
//                animatorTV.setTranslationY((Float) animation.getAnimatedValue());
//            }
//        });
        ValueAnimator animator = new ValueAnimator();
        animator.setObjectValues(new YAndAlpha(-height1,1f));
        animator.setDuration(2000);
        animator.setRepeatCount(Animation.INFINITE);
        animator.setRepeatMode(ValueAnimator.RESTART);
        animator.setInterpolator(new LinearInterpolator());
        animator.setEvaluator(new TypeEvaluator() {
            @Override
            public Object evaluate(float fraction, Object startValue, Object endValue) {
                YAndAlpha alpha = new YAndAlpha();
                alpha.Y = height * fraction;
                alpha.alpha = (1 - fraction);
                return alpha;
            }
        });
        animator.start();
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                YAndAlpha value = (YAndAlpha) animation.getAnimatedValue();
                animatorTV.setAlpha(value.alpha);
                animatorTV.setTranslationY(value.Y);
            }
        });
    }

    private class YAndAlpha{
        public YAndAlpha() {
        }

        public YAndAlpha(float y, float alpha) {
            Y = y;
            this.alpha = alpha;
        }

        float Y;
        float alpha;
    }
}
