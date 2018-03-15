package pablokintopp.com.mvvmtemplate.viewmodel.repolist;

import pablokintopp.com.mvvmtemplate.model.api.entity.Repo;

/**
 * Created by Pablo on 14/03/2018.
 */

public class RepoClickEvent {
    public Repo repo;

    public RepoClickEvent(Repo repo){ this.repo = repo; }
}
