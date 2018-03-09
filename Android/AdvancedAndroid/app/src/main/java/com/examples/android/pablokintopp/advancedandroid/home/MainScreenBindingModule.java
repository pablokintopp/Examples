package com.examples.android.pablokintopp.advancedandroid.home;

import com.bluelinelabs.conductor.Controller;
import com.examples.android.pablokintopp.advancedandroid.di.ControllerKey;
import com.examples.android.pablokintopp.advancedandroid.trending.TrendingReposComponent;
import com.examples.android.pablokintopp.advancedandroid.trending.TrendingReposController;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

/**
 * Created by Pablo on 08/03/2018.
 */
@Module(subcomponents = {TrendingReposComponent.class})
public abstract class MainScreenBindingModule {
    @Binds
    @IntoMap
    @ControllerKey(TrendingReposController.class)
    abstract AndroidInjector.Factory<? extends Controller> bindingTrendingReposInjector( TrendingReposComponent.Builder builder);
}
