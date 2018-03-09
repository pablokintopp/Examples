package com.templates.android.pablokintopp.mvvmtemplate.viewmodel;

import android.databinding.ObservableField;

import com.templates.android.pablokintopp.mvvmtemplate.model.entity.MovieListResponse;

import rx.subjects.PublishSubject;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Pablo on 07/03/2018.
 */

public class MovieListViewModel {


    public ObservableField<Boolean> isLoading;
    public ObservableField<Boolean> refreshEnabled;

    private PublishSubject<String> publishSubject;
    private MovieListUseCase useCase;
    private MovieListListener listener;


    public interface  MovieListListener{
        void onMovieListLoaded(MovieListResponse response);

        void onError(Throwable error);

    }

}
