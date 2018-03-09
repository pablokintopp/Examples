package com.templates.android.pablokintopp.mvvmtemplate.util;

import rx.Observable;

/**
 * Created by Pablo on 08/03/2018.
 */

public interface PreferencesHelper<T> {

    Observable<T> save(String key, T value);

    Observable<T> get(String key, Class<T> generic);

    Observable<Boolean> clear();
}
