package com.examples.android.pablokintopp.advancedandroid.base;

import android.app.Activity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;
import com.examples.android.pablokintopp.advancedandroid.home.MainActivity;
import com.examples.android.pablokintopp.advancedandroid.home.MainActivityComponent;

@Module(subcomponents = {
        MainActivityComponent.class,
})
public abstract class ActivityBindingModule {

    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> provideMainActivtyInjector(MainActivityComponent.Builder builder);
}
