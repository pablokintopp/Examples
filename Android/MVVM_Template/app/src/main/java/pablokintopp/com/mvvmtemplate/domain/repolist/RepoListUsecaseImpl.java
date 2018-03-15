package pablokintopp.com.mvvmtemplate.domain.repolist;

import java.util.List;

import javax.inject.Inject;

import pablokintopp.com.mvvmtemplate.model.api.ApiSource;
import pablokintopp.com.mvvmtemplate.model.api.entity.Repo;
import pablokintopp.com.mvvmtemplate.model.api.entity.RepoSearchResponse;
import pablokintopp.com.mvvmtemplate.model.preferences.PreferencesHelper;
import pablokintopp.com.mvvmtemplate.util.Constants;
import pablokintopp.com.mvvmtemplate.util.RxTransformer;
import rx.Observable;

/**
 * Created by Pablo on 14/03/2018.
 */

public class RepoListUsecaseImpl implements RepoListUsecase {
    private ApiSource apiSource;
    private PreferencesHelper<String> tokenPreferencesHelper;

    @Inject
    public RepoListUsecaseImpl(ApiSource apiSource, PreferencesHelper<String> tokenPreferencesHelper) {
        this.apiSource = apiSource;
        this.tokenPreferencesHelper = tokenPreferencesHelper;
    }

    @Override
    public Observable<List<Repo>> getRepositories() {
        return tokenPreferencesHelper.get(Constants.SHARED_KEY_TOKEN,String.class)
                .flatMap(s -> apiSource.getRepositories())
                .compose(RxTransformer.applyIOSchedulers());
    }

    @Override
    public Observable<RepoSearchResponse> searchRepository(String query) {
        return tokenPreferencesHelper.get(Constants.SHARED_KEY_TOKEN,String.class)
                .flatMap(s -> apiSource.searchRepository(query))
                .compose(RxTransformer.applyIOSchedulers());
    }
}
