package com.templates.android.pablokintopp.mvvmtemplate.di;

import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.templates.android.pablokintopp.mvvmtemplate.model.api.ApiSource;
import com.templates.android.pablokintopp.mvvmtemplate.util.RxBus;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Pablo on 06/03/2018.
 */

@Singleton
@Component(modules = {AppModule.class, NetworkModule.class})
public interface AppComponent {

    ApiSource apiSource();
    SharedPreferences sharedPreferences();
    Gson gson();
    RxBus bus();

}
