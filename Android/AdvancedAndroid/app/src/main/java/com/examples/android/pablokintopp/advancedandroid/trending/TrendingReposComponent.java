package com.examples.android.pablokintopp.advancedandroid.trending;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import com.examples.android.pablokintopp.advancedandroid.di.ScreenScope;

@ScreenScope
@Subcomponent
public interface TrendingReposComponent extends AndroidInjector<TrendingReposController> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<TrendingReposController> {

    }
}
