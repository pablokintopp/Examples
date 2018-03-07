package com.templates.android.pablokintopp.mvvmtemplate.model.api;

import com.templates.android.pablokintopp.mvvmtemplate.model.entity.MovieListResponse;

import rx.Observable;

/**
 * Created by Pablo on 06/03/2018.
 */

public interface ApiSource {
    Observable<MovieListResponse> getUpcomingMovies(String apiKey, int page);
}
