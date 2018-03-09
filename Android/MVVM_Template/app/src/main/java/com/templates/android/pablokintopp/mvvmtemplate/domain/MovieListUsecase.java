package com.templates.android.pablokintopp.mvvmtemplate.domain;

import com.templates.android.pablokintopp.mvvmtemplate.model.entity.MovieListResponse;

import rx.Observable;

/**
 * Created by Pablo on 07/03/2018.
 */

public interface MovieListUsecase {
    Observable<MovieListResponse> getMovieList(String query);

}
