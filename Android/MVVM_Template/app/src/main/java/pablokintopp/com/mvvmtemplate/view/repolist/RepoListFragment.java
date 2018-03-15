package pablokintopp.com.mvvmtemplate.view.repolist;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.parceler.Parcels;

import java.util.List;

import javax.inject.Inject;

import pablokintopp.com.mvvmtemplate.MyApplication;
import pablokintopp.com.mvvmtemplate.R;
import pablokintopp.com.mvvmtemplate.databinding.FragmentRepoListBinding;
import pablokintopp.com.mvvmtemplate.di.repolist.DaggerRepoListComponent;
import pablokintopp.com.mvvmtemplate.di.repolist.RepoListModule;
import pablokintopp.com.mvvmtemplate.model.api.entity.Repo;
import pablokintopp.com.mvvmtemplate.model.api.entity.RepoSearchResponse;
import pablokintopp.com.mvvmtemplate.util.DialogBuilder;
import pablokintopp.com.mvvmtemplate.viewmodel.repolist.RepoListViewModel;


/**
 * A simple {@link Fragment} subclass.
 */
public class RepoListFragment extends Fragment implements RepoListViewModel.RepoListListener{

    FragmentRepoListBinding binding;
    public static final String KEY_STATE_LIST = "key_state_list";

    @Inject
    RepoListViewModel viewModel;

    @Inject
    RepoListAdapter adapter;

    public static RepoListFragment newInstance() {
        Bundle args = new Bundle();
        RepoListFragment fragment = new RepoListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_repo_list, container, false);
        initializeInjectors();
        binding.setViewModel(viewModel);
        binding.recyclerView.setAdapter(adapter);

        if (savedInstanceState == null)
            viewModel.loadRepos();


        return binding.getRoot();
    }



    private void initializeInjectors() {

        DaggerRepoListComponent.builder()
                .appComponent(((MyApplication) getActivity().getApplication()).getAppComponent())
                .repoListModule(new RepoListModule(this))
                .build().inject(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        viewModel.stop();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (adapter != null && adapter.getRepos() != null)
            outState.putParcelable(KEY_STATE_LIST, Parcels.wrap(adapter.getRepos()));
    }



    @Override
    public void onRepoListLoaded(List<Repo> response) {
        adapter.setRepos(response);

    }

    @Override
    public void onRepoSearchLoaded(RepoSearchResponse response) {
        adapter.setRepos(response.items);
    }

    @Override
    public void onError(Throwable error) {

        Log.e(this.getClass().getSimpleName(), error.getMessage());
        DialogBuilder
                .infoDialog(getActivity(),
                        R.string.dialog_error_title,
                        R.string.dialog_error_content)
                .show();
    }
}
