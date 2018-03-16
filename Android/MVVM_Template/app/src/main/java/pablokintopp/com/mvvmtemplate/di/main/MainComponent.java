package pablokintopp.com.mvvmtemplate.di.main;

import dagger.Component;
import pablokintopp.com.mvvmtemplate.di.Activity;
import pablokintopp.com.mvvmtemplate.di.app.AppComponent;
import pablokintopp.com.mvvmtemplate.view.main.MainActivity;

/**
 * Created by Pablo Kintopp, Mar 2018.
 */
@Activity
@Component(dependencies = AppComponent.class, modules = MainModule.class)
public interface MainComponent {
    void inject(MainActivity mainActivity);
}
