package com.examples.android.pablokintopp.advancedandroid.base;

import javax.inject.Singleton;

import dagger.Component;
import com.examples.android.pablokintopp.advancedandroid.data.RepoServiceModule;
import com.examples.android.pablokintopp.advancedandroid.networking.ServiceModule;

@Singleton
@Component(modules = {
        ApplicationModule.class,
        ActivityBindingModule.class,
        ServiceModule.class,
        RepoServiceModule.class,
})
public interface ApplicationComponent {

    void inject(MyApplication myApplication);
}
