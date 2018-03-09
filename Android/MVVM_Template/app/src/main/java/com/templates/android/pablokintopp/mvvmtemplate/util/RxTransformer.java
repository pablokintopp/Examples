package com.templates.android.pablokintopp.mvvmtemplate.util;




import io.reactivex.android.schedulers.AndroidSchedulers;
import rx.Observable;

import rx.schedulers.Schedulers;


/**
 * Created by Pablo on 08/03/2018.
 */

public class RxTransformer {

    public static <T> Observable.Transformer<T, T> applyIOSchedulers() {
        return observable -> observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public static <T> Observable.Transformer<T, T> applyComputationSchedulers() {
        return observable -> observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
