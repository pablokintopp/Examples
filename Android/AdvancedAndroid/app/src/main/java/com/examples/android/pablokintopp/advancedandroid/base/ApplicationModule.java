package com.examples.android.pablokintopp.advancedandroid.base;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Pablo on 08/03/2018.
 */

@Module
public class ApplicationModule {

    private final Application application;

    ApplicationModule(Application application){
        this.application = application;
    }

    @Provides
    Context provideApplicationContext(){
        return application;
    }
}
