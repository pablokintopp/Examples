package com.examples.android.pablokintopp.advancedandroid.home;

import com.examples.android.pablokintopp.advancedandroid.di.ActivityScope;
import com.examples.android.pablokintopp.advancedandroid.ui.NavigationModule;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by Pablo on 08/03/2018.
 */

@ActivityScope
@Subcomponent( modules = {MainScreenBindingModule.class, NavigationModule.class})
public interface MainActivityComponent extends AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity>{

        @Override
        public void seedInstance(MainActivity instance) {

        }
    }
}
