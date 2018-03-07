package com.templates.android.pablokintopp.mvvmtemplate.model.api;

import com.templates.android.pablokintopp.mvvmtemplate.model.entity.MovieListResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Pablo on 06/03/2018.
 */

public interface RetrofitInterface {


    @GET("movie/upcoming")
    Observable<MovieListResponse> getUpcomingMovies(@Query("api_key") String apiKey,
                                                    @Query("page") int pageNumber);
}
