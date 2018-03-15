package pablokintopp.com.mvvmtemplate.domain.repolist;

import java.util.List;

import pablokintopp.com.mvvmtemplate.model.api.entity.Repo;
import pablokintopp.com.mvvmtemplate.model.api.entity.RepoSearchResponse;
import rx.Observable;

/**
 * Created by Pablo on 14/03/2018.
 */

public interface RepoListUsecase {

    Observable<List<Repo>> getRepositories();

    Observable<RepoSearchResponse> searchRepository(String query);
}
