package pablokintopp.com.mvvmtemplate.di.main;

import dagger.Module;
import dagger.Provides;
import pablokintopp.com.mvvmtemplate.di.Activity;
import pablokintopp.com.mvvmtemplate.util.RxBus;
import pablokintopp.com.mvvmtemplate.viewmodel.main.MainViewModel;

/**
 * Created by Pablo on 13/01/17.
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
