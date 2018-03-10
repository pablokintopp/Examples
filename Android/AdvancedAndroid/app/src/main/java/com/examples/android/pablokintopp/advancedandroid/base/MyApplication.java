package com.examples.android.pablokintopp.advancedandroid.base;

import android.app.Application;

import javax.inject.Inject;

import com.examples.android.pablokintopp.advancedandroid.BuildConfig;

import com.examples.android.pablokintopp.advancedandroid.di.ActivityInjector;
import timber.log.Timber;

public class MyApplication extends Application {

    @Inject ActivityInjector activityInjector;

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        component.inject(this);

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    public ActivityInjector getActivityInjector() {
        return activityInjector;
    }
}
