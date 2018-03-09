package com.examples.android.pablokintopp.advancedandroid.base;

import android.app.Activity;

import com.examples.android.pablokintopp.advancedandroid.home.MainActivity;
import com.examples.android.pablokintopp.advancedandroid.home.MainActivityComponent;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

/**
 * Created by Pablo on 08/03/2018.
 */
@Module(subcomponents = {MainActivityComponent.class})
public abstract class ActivityBindingModule {

    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> provideMainActivityInjector(MainActivityComponent.Builder builder);
}
