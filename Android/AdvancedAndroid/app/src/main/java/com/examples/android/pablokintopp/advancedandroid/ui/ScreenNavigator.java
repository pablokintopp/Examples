package com.examples.android.pablokintopp.advancedandroid.ui;

import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.Router;

/**
 * Created by Pablo on 08/03/2018.
 */

public interface ScreenNavigator {

    void initWithRouter(Router router, Controller controller);

    boolean pop();

    void clear();

}
