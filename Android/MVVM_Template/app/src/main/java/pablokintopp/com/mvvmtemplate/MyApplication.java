package pablokintopp.com.mvvmtemplate;

import android.app.Application;

import pablokintopp.com.mvvmtemplate.di.app.AppComponent;
import pablokintopp.com.mvvmtemplate.di.app.AppModule;
import pablokintopp.com.mvvmtemplate.di.app.DaggerAppComponent;
import pablokintopp.com.mvvmtemplate.di.app.NetworkModule;

/**
 * Created by mertsimsek on 13/01/17.
 */

public class MyApplication extends Application {

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
