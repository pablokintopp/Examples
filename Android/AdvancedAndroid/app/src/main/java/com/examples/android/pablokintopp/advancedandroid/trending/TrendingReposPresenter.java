package com.examples.android.pablokintopp.advancedandroid.trending;

import com.examples.android.pablokintopp.advancedandroid.data.RepoRequester;
import com.examples.android.pablokintopp.advancedandroid.di.ScreenScope;
import com.examples.android.pablokintopp.advancedandroid.model.Repo;

import javax.inject.Inject;

/**
 * Created by Pablo on 09/03/2018.
 */
@ScreenScope
class TrendingReposPresenter implements RepoAdapter.RepoClickedListener {

    private final TrendingReposViewModel viewModel;
    private final RepoRequester repoRequester;

    @Inject
    public TrendingReposPresenter(TrendingReposViewModel viewModel, RepoRequester repoRequester) {
        this.viewModel = viewModel;
        this.repoRequester = repoRequester;
        loadRepos();
    }

    private void loadRepos(){
        repoRequester.getTrendindRepos()
                .doOnSubscribe(__ -> viewModel.loadingUpdated().accept(true))
                .doOnEvent((data, thrwoable) -> viewModel.loadingUpdated().accept(false))
                .subscribe(viewModel.reposUpdated(), viewModel.onError());
    }

    @Override
    public void onRepoClicked(Repo repo) {

    }
}
