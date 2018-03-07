package com.templates.android.pablokintopp.mvvmtemplate.model.entity;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.List;

/**
 * Created by Pablo on 06/03/2018.
 */
@Parcel
public class MovieListResponse {

    @SerializedName("results")
    public List<Movie> data;
}
