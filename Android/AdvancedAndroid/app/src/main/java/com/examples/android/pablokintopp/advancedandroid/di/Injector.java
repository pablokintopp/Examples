package com.examples.android.pablokintopp.advancedandroid.di;

import android.app.Activity;

import com.bluelinelabs.conductor.Controller;
import com.examples.android.pablokintopp.advancedandroid.base.BaseActivity;

import dagger.Component;

/**
 * Created by Pablo on 08/03/2018.
 */

public class Injector {

    public Injector() {
    }

    public static void inject(Activity activity){

        ActivityInjector.get(activity).inject(activity);

    }

    public static void clearComponent(Activity activity) {
        ActivityInjector.get(activity).clear(activity);
    }

    public static void inject(Controller controller){
        ScreenInjector.get(controller.getActivity()).inject(controller);

    }

    public static void clearComponent(Controller controller){
        ScreenInjector.get(controller.getActivity()).clear(controller);

    }
}
