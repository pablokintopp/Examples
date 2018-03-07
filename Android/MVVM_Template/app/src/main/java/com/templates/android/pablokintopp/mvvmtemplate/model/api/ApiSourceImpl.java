package com.templates.android.pablokintopp.mvvmtemplate.model.api;

import com.templates.android.pablokintopp.mvvmtemplate.model.entity.MovieListResponse;

import rx.Observable;

import retrofit2.Retrofit;

/**
 * Created by Pablo on 06/03/2018.
 */

public class ApiSourceImpl implements ApiSource {

    RetrofitInterface retrofitInterface;

    public ApiSourceImpl(Retrofit retrofit) {
        retrofitInterface = retrofit.create(RetrofitInterface.class);
    }

    @Override
    public Observable<MovieListResponse> getUpcomingMovies(String apiKey, int page) {
        return retrofitInterface.getUpcomingMovies(apiKey, page);
    }
}
