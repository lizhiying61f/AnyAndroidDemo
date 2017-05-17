package com.lzhiy.anyandroiddemo.performance.fragment_performance;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;

import com.lzhiy.anyandroiddemo.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class FragmentPerformanceActivity extends AppCompatActivity {

    private FragmentOne fgOne;
    private FragmentTwo fgTwo;
    private FragmentThree fgThree;
    private Fragment currentFragment = new Fragment();
    private static final String CURRENT_FRAGMENT = "current_fragment";

    private FragmentManager supportFragmentManager;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(CURRENT_FRAGMENT,currentFragment.getClass().getName());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_performance);
        ButterKnife.bind(this);
        supportFragmentManager = getSupportFragmentManager();
        if (savedInstanceState!=null){
            String saveFragment = savedInstanceState.getString(CURRENT_FRAGMENT);
            fgOne = (FragmentOne) supportFragmentManager.findFragmentByTag(FragmentOne.class.getName());
            fgTwo = (FragmentTwo) supportFragmentManager.findFragmentByTag(FragmentTwo.class.getName());
            fgThree = (FragmentThree) supportFragmentManager.findFragmentByTag(FragmentThree.class.getName());

            if (TextUtils.isEmpty(saveFragment)){
                supportFragmentManager.beginTransaction()
                        .show(fgOne)
                        .hide(fgTwo)
                        .hide(fgThree)
                        .commit();

                currentFragment = fgOne;
            }else {
                switchCUrrentPage(saveFragment);
            }
        }else {
            /**
             * Fragment的onAttach onCreateView方法,是在add之后调用的。
             * 在这里建立Fragment的对象，对性能对影响不是很大。
             */
            fgOne = new FragmentOne();
            fgTwo = new FragmentTwo();
            fgThree = new FragmentThree();

            showFragment(fgOne);
        }
    }

    private void showFragment(Fragment fg) {
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        if (!fg.isAdded()){
            fragmentTransaction
                    .hide(currentFragment)
                    .add(R.id.content,fg,fg.getClass().getName());
        }else {
            fragmentTransaction
                    .hide(currentFragment)
                    .show(fg);
        }

        currentFragment = fg;
        fragmentTransaction.commit();
    }

    private void switchCUrrentPage(String saveFragment) {
        if (saveFragment.equals(fgOne.getClass().getName())){
            supportFragmentManager.beginTransaction()
                    .show(fgOne)
                    .hide(fgTwo)
                    .hide(fgThree)
                    .commit();

            currentFragment = fgOne;
        }else if (saveFragment.equals(fgTwo.getClass().getName())){
            supportFragmentManager.beginTransaction()
                    .show(fgTwo)
                    .hide(fgOne)
                    .hide(fgThree)
                    .commit();

            currentFragment = fgTwo;
        }else {
            supportFragmentManager.beginTransaction()
                    .show(fgThree)
                    .hide(fgOne)
                    .hide(fgTwo)
                    .commit();

            currentFragment = fgThree;
        }
    }

    @OnClick(R.id.page1)
    void switchPage1(){
        showFragment(fgOne);
    }

    @OnClick(R.id.page2)
    void switchPage2(){
        showFragment(fgTwo);
    }

    @OnClick(R.id.page3)
    void switchPage3(){
        showFragment(fgThree);
    }
}
