package pablokintopp.com.mvvmtemplate.viewmodel.repodetail;

import android.databinding.ObservableField;

import pablokintopp.com.mvvmtemplate.model.api.entity.Repo;

/**
 * Created by Pablo on 15/03/2018.
 */

public class RepoDetailViewModel {

    public ObservableField<String> repoName;
    public ObservableField<String> repoDesc;
    public ObservableField<String> repoUrl;
    public ObservableField<String> userName;
    public ObservableField<String> userUrl;

    private Repo repo;

    public RepoDetailViewModel(Repo repo) {
        this.repo = repo;
        repoName = new ObservableField<>(repo.name);
        repoDesc = new ObservableField<>(repo.description);
        userName = new ObservableField<>(repo.owner.username);
        userUrl = new ObservableField<>(repo.owner.url);
        repoUrl = new ObservableField<>(repo.url);
    }
}
