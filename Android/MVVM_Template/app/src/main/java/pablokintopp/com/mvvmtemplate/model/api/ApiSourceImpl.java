package pablokintopp.com.mvvmtemplate.model.api;

import java.util.List;

import pablokintopp.com.mvvmtemplate.model.api.entity.Repo;
import pablokintopp.com.mvvmtemplate.model.api.entity.RepoSearchResponse;

import retrofit2.Retrofit;
import rx.Observable;

/**
 * Created by mertsimsek on 13/01/17.
 */

public class ApiSourceImpl implements ApiSource{

    RetrofitInterface retrofitInterface;

    public ApiSourceImpl(Retrofit retrofit) {
        retrofitInterface = retrofit.create(RetrofitInterface.class);
    }


    @Override
    public Observable<List<Repo>> getRepositories() {
        return retrofitInterface.getRepositories();
    }

    @Override
    public Observable<RepoSearchResponse> searchRepository(String query) {
        return retrofitInterface.searchRepository(query);
    }


}
