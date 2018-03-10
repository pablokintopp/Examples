package com.examples.android.pablokintopp.advancedandroid.trending;

import javax.inject.Inject;

import com.examples.android.pablokintopp.advancedandroid.data.RepoRequester;
import com.examples.android.pablokintopp.advancedandroid.di.ScreenScope;
import com.examples.android.pablokintopp.advancedandroid.model.Repo;

@ScreenScope
class TrendingReposPresenter implements RepoAdapter.RepoClickedListener {

    private final TrendingReposViewModel viewModel;
    private final RepoRequester repoRequester;

    @Inject
    TrendingReposPresenter(TrendingReposViewModel viewModel, RepoRequester repoRequester) {
        this.viewModel = viewModel;
        this.repoRequester = repoRequester;
        loadRepos();
    }

    private void loadRepos() {
        repoRequester.getTrendingRepos()
                .doOnSubscribe(__ -> viewModel.loadingUpdated().accept(true))
                .doOnEvent((d, t) -> viewModel.loadingUpdated().accept(false))
                .subscribe(viewModel.reposUpdated(), viewModel.onError());
    }

    @Override
    public void onRepoClicked(Repo repo) {

    }
}
