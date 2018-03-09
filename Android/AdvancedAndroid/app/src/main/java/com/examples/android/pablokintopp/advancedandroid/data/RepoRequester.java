package com.examples.android.pablokintopp.advancedandroid.data;

import com.examples.android.pablokintopp.advancedandroid.model.Repo;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Pablo on 09/03/2018.
 */

public class RepoRequester {

    private final RepoService service;

    @Inject
    public RepoRequester(RepoService service) {
        this.service = service;
    }

    public Single<List<Repo>> getTrendindRepos(){
        return service.getTrendingRepos()
                .map(TrendingReposResponse::repos)
                .subscribeOn(Schedulers.io());
    }
}
