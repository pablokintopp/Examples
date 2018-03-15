package pablokintopp.com.mvvmtemplate.view.repodetail;

import android.support.v4.app.Fragment;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.parceler.Parcels;

import javax.inject.Inject;

import pablokintopp.com.mvvmtemplate.MyApplication;
import pablokintopp.com.mvvmtemplate.R;
import pablokintopp.com.mvvmtemplate.databinding.FragmentRepoDetailBinding;
import pablokintopp.com.mvvmtemplate.di.repodetail.DaggerRepoDetailComponent;
import pablokintopp.com.mvvmtemplate.di.repodetail.RepoDetailModule;
import pablokintopp.com.mvvmtemplate.model.api.entity.Repo;
import pablokintopp.com.mvvmtemplate.viewmodel.repodetail.RepoDetailViewModel;

/**
 * Created by Pablo on 15/03/2018.
 */

public class RepoDetailFragment  extends Fragment{
    public static final String KEY_REPO = "key_repo";
    public static final String KEY_STATE = "key_state";

    FragmentRepoDetailBinding binding;

    @Inject
    RepoDetailViewModel viewModel;



    public static RepoDetailFragment newInstance(Repo repo) {
        Bundle args = new Bundle();
        args.putParcelable(KEY_REPO, Parcels.wrap(repo));
        RepoDetailFragment fragment = new RepoDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_repo_detail, container, false);
        initializeInjectors();
        binding.setViewModel(viewModel);


        return binding.getRoot();
    }



    private void initializeInjectors() {
        Repo repo = Parcels.unwrap(getArguments().getParcelable(KEY_REPO));
        DaggerRepoDetailComponent.builder()
                .appComponent(((MyApplication) getActivity().getApplication()).getAppComponent())
        .repoDetailModule(new RepoDetailModule(repo))
                .build().inject(this);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

    }


}
