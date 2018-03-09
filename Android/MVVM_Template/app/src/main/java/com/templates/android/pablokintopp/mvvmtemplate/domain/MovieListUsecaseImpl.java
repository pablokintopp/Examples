package com.templates.android.pablokintopp.mvvmtemplate.domain;

import com.templates.android.pablokintopp.mvvmtemplate.model.api.ApiSource;
import com.templates.android.pablokintopp.mvvmtemplate.model.entity.MovieListResponse;
import com.templates.android.pablokintopp.mvvmtemplate.util.Constants;
import com.templates.android.pablokintopp.mvvmtemplate.util.PreferencesHelper;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by Pablo on 07/03/2018.
 */

public class MovieListUsecaseImpl implements MovieListUsecase {

    private PreferencesHelper<String> tokenHelper;
    private ApiSource apiSource;

    @Inject
    public MovieListUsecaseImpl(PreferencesHelper<String> tokenHelper, ApiSource apiSource) {
        this.apiSource = apiSource;
        this.tokenHelper = tokenHelper;
    }

    @Override
    public Observable<MovieListResponse> searchMovie(String query) {
        return tokenHelper.get(Constants.SHARED_KEY_TOKEN, String.class)
                .flatMap(s -> apiSource.searchMovie(query, s))
                .compose(RxTransformer.applyIOSchedulers());
    }
}
