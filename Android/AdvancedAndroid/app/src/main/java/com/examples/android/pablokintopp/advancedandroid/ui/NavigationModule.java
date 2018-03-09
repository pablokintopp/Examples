package com.examples.android.pablokintopp.advancedandroid.ui;

import dagger.Binds;
import dagger.Module;

/**
 * Created by Pablo on 08/03/2018.
 */
@Module
public abstract class NavigationModule {

    @Binds
    abstract ScreenNavigator provideScreenNavigator(DefaultScreenNavigator screenNavigator);
}
