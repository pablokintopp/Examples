package com.templates.android.pablokintopp.mvvmtemplate.di;

import com.templates.android.pablokintopp.mvvmtemplate.view.MainActivity;

import dagger.Component;

/**
 * Created by Pablo on 07/03/2018.
 */
@Activity
@Component(dependencies = AppComponent.class, modules = MainModule.class)
public interface MainComponent {
    void inject(MainActivity mainActivity);
}
