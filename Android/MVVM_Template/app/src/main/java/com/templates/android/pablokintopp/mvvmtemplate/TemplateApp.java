package com.templates.android.pablokintopp.mvvmtemplate;

import android.app.Application;

import com.templates.android.pablokintopp.mvvmtemplate.di.AppComponent;
import com.templates.android.pablokintopp.mvvmtemplate.di.AppModule;
import com.templates.android.pablokintopp.mvvmtemplate.di.DaggerAppComponent;
import com.templates.android.pablokintopp.mvvmtemplate.di.NetworkModule;

/**
 * Created by Pablo on 07/03/2018.
 */

public class TemplateApp extends Application {

    AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeInjector();
    }

    private void initializeInjector() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule())
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
