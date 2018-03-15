package pablokintopp.com.mvvmtemplate.di.repodetail;

import dagger.Module;
import dagger.Provides;
import pablokintopp.com.mvvmtemplate.di.Fragment;
import pablokintopp.com.mvvmtemplate.model.api.entity.Repo;
import pablokintopp.com.mvvmtemplate.viewmodel.repodetail.RepoDetailViewModel;

/**
 * Created by Pablo on 15/03/2018.
 */
@Module
public class RepoDetailModule {

    Repo repo;

    public RepoDetailModule(Repo repo) {
        this.repo = repo;
    }

    @Provides
   @Fragment
    RepoDetailViewModel provideRepoDetailViewModel(){
       return new RepoDetailViewModel(repo);
   }

}
