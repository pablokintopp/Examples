package pablokintopp.com.mvvmtemplate.di.app;

import android.content.SharedPreferences;

import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Component;
import pablokintopp.com.mvvmtemplate.model.api.ApiSource;
import pablokintopp.com.mvvmtemplate.util.RxBus;

/**
 * Created by Pablo Kintopp, Mar 2018.
 */

@Singleton
@Component(modules = {AppModule.class, NetworkModule.class})
public interface AppComponent {
    ApiSource apiSource();
    SharedPreferences sharedPreferences();
    Gson gson();
    RxBus bus();
}
