package pablokintopp.com.mvvmtemplate.viewmodel.repolist;

import android.content.Context;
import android.databinding.ObservableField;
import android.view.View;

import pablokintopp.com.mvvmtemplate.model.api.entity.Repo;
import pablokintopp.com.mvvmtemplate.util.RxBus;

/**
 * Created by Pablo on 14/03/2018.
 */

public class RepoListItemViewModel {
    public ObservableField<String> name;
    public ObservableField<String> url;
    public ObservableField<String> description;
    public ObservableField<String> userName;



    private Repo repo;
    private RxBus rxBus;

    public RepoListItemViewModel(Context context, RxBus rxBus, Repo repo) {
        this.repo = repo;
        this.rxBus = rxBus;

        name = new ObservableField<>(repo.name);
        url = new ObservableField<>(repo.url);
        description = new ObservableField<>(repo.description);
        userName = new ObservableField<>(repo.owner.username);

    }

    public void onItemClicked(View view){
        rxBus.send(new RepoClickEvent(repo));
    }
}
