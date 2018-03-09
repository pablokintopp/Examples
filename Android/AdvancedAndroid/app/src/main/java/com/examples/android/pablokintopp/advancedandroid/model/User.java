package com.examples.android.pablokintopp.advancedandroid.model;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

/**
 * Created by Pablo on 08/03/2018.
 */
@AutoValue
public abstract class User {

    public abstract long id();

    public abstract String login();

    public static JsonAdapter<User> jsonAdapter(Moshi moshi){
        return new AutoValue_User.MoshiJsonAdapter(moshi);
    }
}
