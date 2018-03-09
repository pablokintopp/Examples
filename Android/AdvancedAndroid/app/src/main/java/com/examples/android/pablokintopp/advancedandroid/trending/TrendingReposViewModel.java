package com.examples.android.pablokintopp.advancedandroid.trending;

import com.examples.android.pablokintopp.advancedandroid.R;
import com.examples.android.pablokintopp.advancedandroid.di.ScreenScope;
import com.examples.android.pablokintopp.advancedandroid.model.Repo;
import com.jakewharton.rxrelay2.BehaviorRelay;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import timber.log.Timber;

/**
 * Created by Pablo on 09/03/2018.
 */

@ScreenScope
class TrendingReposViewModel {

    private final BehaviorRelay<List<Repo>> reposRelay = BehaviorRelay.create();
    private final BehaviorRelay<Integer> errorRelay = BehaviorRelay.create();
    private final BehaviorRelay<Boolean> loadingRelay = BehaviorRelay.create();

    @Inject
    TrendingReposViewModel() {
    }

    Observable<Boolean> loading(){
        return loadingRelay;
    }

    Observable<List<Repo>> repos(){
        return reposRelay;
    }

    Observable<Integer> error(){
        return errorRelay;
    }

    Consumer<Boolean> loadingUpdated(){
        return loadingRelay;
    }

    Consumer<List<Repo>> reposUpdated(){
        errorRelay.accept(-1);
        return reposRelay;
    }

    Consumer<Throwable> onError(){
        return throwable -> {
            Timber.e(throwable, "Error loading Repos");
            errorRelay.accept(R.string.api_error_repos);
        };
    }


}
