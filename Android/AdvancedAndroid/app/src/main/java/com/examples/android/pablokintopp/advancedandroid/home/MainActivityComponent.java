package com.examples.android.pablokintopp.advancedandroid.home;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import com.examples.android.pablokintopp.advancedandroid.di.ActivityScope;
import com.examples.android.pablokintopp.advancedandroid.ui.NavigationModule;

@ActivityScope
@Subcomponent(modules = {
        MainScreenBindingModule.class,
        NavigationModule.class,
})
public interface MainActivityComponent extends AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity> {

        @Override
        public void seedInstance(MainActivity instance) {

        }
    }
}
