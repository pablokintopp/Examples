package com.templates.android.pablokintopp.mvvmtemplate.di;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.templates.android.pablokintopp.mvvmtemplate.util.RxBus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Pablo on 06/03/2018.
 */

@Module
public class AppModule {
    Application app;

    public AppModule(Application app) {
        this.app = app;
    }

    @Provides
    @Singleton
    Context provideContext(){
        return app.getApplicationContext();
    }

    @Provides
    @Singleton
    Gson provideGson(){
        return new Gson();
    }

    @Provides
    @Singleton
    RxBus provideBus(){
        return  RxBus.getInstance();
    }

    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences(Application application){
        return PreferenceManager.getDefaultSharedPreferences(application);
    }
}
