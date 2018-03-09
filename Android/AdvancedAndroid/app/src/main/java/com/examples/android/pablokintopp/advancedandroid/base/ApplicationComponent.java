package com.examples.android.pablokintopp.advancedandroid.base;

import com.examples.android.pablokintopp.advancedandroid.data.RepoServiceModule;
import com.examples.android.pablokintopp.advancedandroid.networking.ServiceModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Pablo on 08/03/2018.
 */
@Singleton
@Component(modules = {ApplicationModule.class,
        ActivityBindingModule.class,
        ServiceModule.class,
        RepoServiceModule.class
           })
public interface ApplicationComponent {
    void inject(MyApplication myApplication);
}
