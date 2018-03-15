package pablokintopp.com.mvvmtemplate.di.repolist;

import android.content.SharedPreferences;

import com.google.gson.Gson;

import dagger.Module;
import dagger.Provides;
import pablokintopp.com.mvvmtemplate.di.Fragment;
import pablokintopp.com.mvvmtemplate.domain.repolist.RepoListUsecase;
import pablokintopp.com.mvvmtemplate.domain.repolist.RepoListUsecaseImpl;
import pablokintopp.com.mvvmtemplate.model.api.ApiSource;
import pablokintopp.com.mvvmtemplate.model.preferences.PreferencesHelper;
import pablokintopp.com.mvvmtemplate.model.preferences.PreferencesHelperImpl;
// import pablokintopp.com.mvvmtemplate.view.repolist.RepoListAdapter;
import pablokintopp.com.mvvmtemplate.util.RxBus;
import pablokintopp.com.mvvmtemplate.view.repolist.RepoListAdapter;
import pablokintopp.com.mvvmtemplate.viewmodel.repolist.RepoListViewModel;

/**
 * Created by Pablo on 14/03/2018.
 */
@Module
public class RepoListModule {
    RepoListViewModel.RepoListListener listener;

    public RepoListModule(RepoListViewModel.RepoListListener listener) {
        this.listener = listener;
    }

    @Provides
    @Fragment
    PreferencesHelper<String> provideTokenPreferencesHelper(SharedPreferences preferences, Gson gson){
        return new PreferencesHelperImpl<>(preferences, gson);

    }

    @Provides
    @Fragment
    RepoListUsecase provideRepoListUsecase(ApiSource apiSource, PreferencesHelper<String> tokenPreferencesHelper){
        return new RepoListUsecaseImpl(apiSource,tokenPreferencesHelper);
    }

    @Provides
    @Fragment
    RepoListViewModel provideRepoListViewModel(RepoListUsecase repoListUsecase){
        return new RepoListViewModel(repoListUsecase, listener);
    }

    @Provides
    @Fragment
    RepoListAdapter provideRepoListAdapter(RxBus rxBus){
        return  new RepoListAdapter(rxBus);
    }
}
