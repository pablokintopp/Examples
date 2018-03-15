package pablokintopp.com.mvvmtemplate.model.api;

import java.util.List;

import pablokintopp.com.mvvmtemplate.model.api.entity.Repo;
import pablokintopp.com.mvvmtemplate.model.api.entity.RepoSearchResponse;

import rx.Observable;

/**
 * Created by mertsimsek on 13/01/17.
 */

public interface ApiSource {


    Observable<List<Repo>> getRepositories();

    Observable<RepoSearchResponse> searchRepository(String query);
}
