package com.templates.android.pablokintopp.mvvmtemplate.model.entity;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.Date;
import java.util.List;

/**
 * Created by Pablo on 06/03/2018.
 */
@Parcel
public class Movie {

    public double voteAverage;
    public String title;
    public Image posterPath;
    public Image backdropPath;
    public Date releaseDate;
    public String overview;
    List<String> genres ;
}
