package pablokintopp.com.mvvmtemplate.di.repodetail;

import dagger.Component;
import pablokintopp.com.mvvmtemplate.di.Fragment;
import pablokintopp.com.mvvmtemplate.di.app.AppComponent;
import pablokintopp.com.mvvmtemplate.view.repodetail.RepoDetailFragment;

/**
 * Created by Pablo on 15/03/2018.
 */
@Fragment
@Component(dependencies = AppComponent.class, modules = RepoDetailModule.class)
public interface RepoDetailComponent {
    void inject(RepoDetailFragment fragment);
}
