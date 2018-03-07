package com.templates.android.pablokintopp.mvvmtemplate.di;

import com.templates.android.pablokintopp.mvvmtemplate.model.api.ApiSource;
import com.templates.android.pablokintopp.mvvmtemplate.model.api.ApiSourceImpl;
import com.templates.android.pablokintopp.mvvmtemplate.util.Constants;

import javax.inject.Singleton;

import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Pablo on 06/03/2018.
 */

public class NetworkModule {

    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient okHttpClient){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient)
                .build();

        return retrofit;

    }

    @Provides
    @Singleton
    ApiSource provideApiSource(Retrofit retrofit) {
        return new ApiSourceImpl(retrofit);
    }


}
