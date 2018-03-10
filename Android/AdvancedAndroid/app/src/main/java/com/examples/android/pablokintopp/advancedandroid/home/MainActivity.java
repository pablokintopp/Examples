package com.examples.android.pablokintopp.advancedandroid.home;

import com.bluelinelabs.conductor.Controller;

import com.examples.android.pablokintopp.advancedandroid.R;
import com.examples.android.pablokintopp.advancedandroid.base.BaseActivity;
import com.examples.android.pablokintopp.advancedandroid.trending.TrendingReposController;

public class MainActivity extends BaseActivity {

    @Override
    protected int layoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected Controller initialScreen() {
        return new TrendingReposController();
    }
}
