package com.examples.android.pablokintopp.advancedandroid.home;

import com.bluelinelabs.conductor.Controller;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;
import com.examples.android.pablokintopp.advancedandroid.di.ControllerKey;
import com.examples.android.pablokintopp.advancedandroid.trending.TrendingReposComponent;
import com.examples.android.pablokintopp.advancedandroid.trending.TrendingReposController;

@Module(subcomponents = {
        TrendingReposComponent.class,
})
public abstract class MainScreenBindingModule {

    @Binds
    @IntoMap
    @ControllerKey(TrendingReposController.class)
    abstract AndroidInjector.Factory<? extends Controller> bindTrendingReposInjector(TrendingReposComponent.Builder builder);
}
