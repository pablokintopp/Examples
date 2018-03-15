package pablokintopp.com.mvvmtemplate.viewmodel.repolist;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;
import android.text.Editable;
import android.text.TextWatcher;

import java.util.List;
import java.util.concurrent.TimeUnit;

import pablokintopp.com.mvvmtemplate.R;
import pablokintopp.com.mvvmtemplate.domain.repolist.RepoListUsecase;
import pablokintopp.com.mvvmtemplate.model.api.entity.Repo;
import pablokintopp.com.mvvmtemplate.model.api.entity.RepoSearchResponse;
import pablokintopp.com.mvvmtemplate.util.SimpleTextWatcher;
import rx.subjects.PublishSubject;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Pablo on 14/03/2018.
 */

public class RepoListViewModel extends BaseObservable {

    public ObservableField<Boolean> isLoading;
    public ObservableField<Boolean> refreshEnabled;

    private CompositeSubscription subscription;
    private PublishSubject<String> publishSubject;
    private String searchText;
    private RepoListUsecase repoListUsecase;
    private RepoListListener listener;

    public RepoListViewModel(RepoListUsecase repoListUsecase, RepoListListener listener) {
        this.repoListUsecase = repoListUsecase;
        this.listener = listener;
        this.searchText = "";

        subscription = new CompositeSubscription();

        isLoading = new ObservableField<>(true);
        refreshEnabled = new ObservableField<>(true);
        publishSubject = PublishSubject.create();

        publishSubject.debounce(200, TimeUnit.MILLISECONDS)
                .doOnNext(response -> refreshEnabled.set(true))
                .doOnNext(response -> isLoading.set(true))
                .flatMap(repoListUsecase::searchRepository)
                .doOnNext(response -> isLoading.set(false))
                .doOnNext(response -> refreshEnabled.set(false))
                .subscribe(listener::onRepoSearchLoaded, listener::onError);

    }

    public void loadRepos(){
        subscription.add(repoListUsecase.getRepositories()
        .doOnNext(response -> isLoading.set(false))
        .doOnNext(response -> refreshEnabled.set(false))
        .subscribe(listener::onRepoListLoaded, listener::onError));
    }


    @Bindable
    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
        notifyPropertyChanged(R.id.searchEditText);

        if(this.searchText.trim().length() > 2)
            publishSubject.onNext(this.searchText);
    }

    public void stop() {
        if (subscription != null && !subscription.isUnsubscribed())
            subscription.unsubscribe();
    }

    public interface RepoListListener{
        void onRepoListLoaded(List<Repo> repos);

        void onRepoSearchLoaded(RepoSearchResponse repoSearchResponse);

        void onError(Throwable error);
    }


}
