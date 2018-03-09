package com.examples.android.pablokintopp.advancedandroid.model;

import android.support.annotation.Nullable;

import com.squareup.moshi.FromJson;
import com.squareup.moshi.ToJson;

import org.threeten.bp.ZonedDateTime;

/**
 * Created by Pablo on 08/03/2018.
 */

public class ZonedDateTimeAdapter {

    @FromJson
    ZonedDateTime fromJson(String json){
        return ZonedDateTime.parse(json);
    }

    @ToJson
    String toJson(@Nullable ZonedDateTime value){
        return value != null ? value.toString() : null;
    }
}
