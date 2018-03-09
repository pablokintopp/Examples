package com.examples.android.pablokintopp.advancedandroid.data;

import com.examples.android.pablokintopp.advancedandroid.model.Repo;
import com.google.auto.value.AutoValue;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.util.List;

/**
 * Created by Pablo on 09/03/2018.
 */

@AutoValue
public abstract class TrendingReposResponse {

    @Json(name = "items")
    public abstract List<Repo> repos();

    public static JsonAdapter<TrendingReposResponse> jsonAdapter(Moshi moshi){
        return new AutoValue_TrendingReposResponse.MoshiJsonAdapter(moshi);
    }
}
