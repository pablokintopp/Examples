package com.examples.android.pablokintopp.advancedandroid.data;

import java.util.List;

import javax.inject.Inject;

import com.examples.android.pablokintopp.advancedandroid.model.Repo;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class RepoRequester {

    private final RepoService service;

    @Inject
    RepoRequester(RepoService service) {
        this.service = service;
    }

    public Single<List<Repo>> getTrendingRepos() {
        return service.getTrendingRepos()
                .map(TrendingReposResponse::repos)
                .subscribeOn(Schedulers.io());
    }
}
