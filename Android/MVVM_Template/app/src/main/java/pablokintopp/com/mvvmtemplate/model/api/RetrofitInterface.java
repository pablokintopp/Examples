package pablokintopp.com.mvvmtemplate.model.api;

import java.util.List;

import pablokintopp.com.mvvmtemplate.model.api.entity.Repo;
import pablokintopp.com.mvvmtemplate.model.api.entity.RepoSearchResponse;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Pablo Kintopp, Mar 2018.
 */

public interface RetrofitInterface {


    @GET("repositories")
    Observable<List<Repo>> getRepositories();

    @GET("search/repositories")
    Observable<RepoSearchResponse> searchRepository(@Query("q") String query);
}
