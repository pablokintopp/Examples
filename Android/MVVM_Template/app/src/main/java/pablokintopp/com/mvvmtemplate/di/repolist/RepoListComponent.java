package pablokintopp.com.mvvmtemplate.di.repolist;

import android.databinding.ObservableField;

import dagger.Component;
import pablokintopp.com.mvvmtemplate.di.Fragment;
import pablokintopp.com.mvvmtemplate.di.app.AppComponent;
import pablokintopp.com.mvvmtemplate.view.repolist.RepoListFragment;
import rx.subjects.PublishSubject;

/**
 * Created by Pablo on 14/03/2018.
 */

@Fragment
@Component(dependencies = AppComponent.class, modules = RepoListModule.class)
public interface RepoListComponent {
   void inject(RepoListFragment fragment);

}
