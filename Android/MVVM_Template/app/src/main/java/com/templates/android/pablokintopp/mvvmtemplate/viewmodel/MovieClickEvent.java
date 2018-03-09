package com.templates.android.pablokintopp.mvvmtemplate.viewmodel;

import com.templates.android.pablokintopp.mvvmtemplate.model.entity.Movie;

/**
 * Created by Pablo on 07/03/2018.
 */

public class MovieClickEvent {
    public Movie movie;

    public MovieClickEvent(Movie movie) {
        this.movie = movie;
    }
}
