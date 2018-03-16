package pablokintopp.com.mvvmtemplate.model.preferences;

import rx.Observable;

/**
 * Created by Pablo Kintopp, Mar 2018.
 */

public interface PreferencesHelper<T> {

    Observable<T> save(String key, T value);

    Observable<T> get(String key, Class<T> generic);

    Observable<Boolean> clear();
}
