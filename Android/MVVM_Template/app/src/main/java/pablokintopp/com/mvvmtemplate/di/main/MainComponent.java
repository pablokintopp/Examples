package pablokintopp.com.mvvmtemplate.di.main;

import dagger.Component;
import pablokintopp.com.mvvmtemplate.di.Activity;
import pablokintopp.com.mvvmtemplate.di.app.AppComponent;
import pablokintopp.com.mvvmtemplate.view.main.MainActivity;

/**
 * Created by mertsimsek on 13/01/17.
 */
@Activity
@Component(dependencies = AppComponent.class, modules = MainModule.class)
public interface MainComponent {
    void inject(MainActivity mainActivity);
}
