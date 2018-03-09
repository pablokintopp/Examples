package com.templates.android.pablokintopp.mvvmtemplate.di;

import com.templates.android.pablokintopp.mvvmtemplate.util.RxBus;
import com.templates.android.pablokintopp.mvvmtemplate.viewmodel.MainViewModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Pablo on 07/03/2018.
 */
@Module
public class MainModule {

    MainViewModel.MainListener mainListener;

    public MainModule(MainViewModel.MainListener mainListener) {
        this.mainListener = mainListener;
    }

    @Provides
    @Activity
    MainViewModel provideMainViewModel(RxBus rxBus){
        return new MainViewModel(rxBus, mainListener);
    }
}
