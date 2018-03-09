package com.examples.android.pablokintopp.advancedandroid.ui;

import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.Router;
import com.bluelinelabs.conductor.RouterTransaction;
import com.examples.android.pablokintopp.advancedandroid.di.ActivityScope;

import javax.inject.Inject;

/**
 * Created by Pablo on 08/03/2018.
 */

@ActivityScope
public class DefaultScreenNavigator  implements ScreenNavigator{

    private Router router;

    @Inject
    public DefaultScreenNavigator() {
    }

    @Override
    public void initWithRouter(Router router, Controller rootScreen) {
        this.router = router;
        if(!router.hasRootController()){
            router.setRoot(RouterTransaction.with(rootScreen));
        }

    }

    @Override
    public boolean pop() {
        return router != null && router.handleBack();
    }

    @Override
    public void clear() {
        router = null;

    }
}
