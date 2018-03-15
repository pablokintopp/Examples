package pablokintopp.com.mvvmtemplate.view.main;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

import pablokintopp.com.mvvmtemplate.MyApplication;
import pablokintopp.com.mvvmtemplate.R;
import pablokintopp.com.mvvmtemplate.databinding.ActivityMainBinding;
import pablokintopp.com.mvvmtemplate.di.main.DaggerMainComponent;
import pablokintopp.com.mvvmtemplate.di.main.MainModule;
import pablokintopp.com.mvvmtemplate.model.api.entity.Repo;
import pablokintopp.com.mvvmtemplate.view.repodetail.RepoDetailActivity;
import pablokintopp.com.mvvmtemplate.view.repodetail.RepoDetailFragment;
import pablokintopp.com.mvvmtemplate.view.repolist.RepoListFragment;
import pablokintopp.com.mvvmtemplate.viewmodel.main.MainViewModel;

public class MainActivity extends AppCompatActivity implements MainViewModel.MainListener {

    ActivityMainBinding binding;

    @Inject
    MainViewModel viewModel;

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initializeInjectors();
        initializeViews(savedInstanceState);
        binding.setViewModel(viewModel);
    }

    private void initializeViews(Bundle savedInstance) {
        if (findViewById(R.id.containerDetail) != null)
            viewModel.setTwoPane(true);

        if (savedInstance == null)
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.containerMaster, RepoListFragment.newInstance())
                    .commitAllowingStateLoss();
    }

    private void initializeInjectors() {
        DaggerMainComponent.builder()
                .appComponent(((MyApplication) getApplication()).getAppComponent())
                .mainModule(new MainModule(this))
                .build().inject(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        viewModel.stop();
    }

    @Override
    public void onItemClicked(Repo repo) {
        if (!viewModel.isTwoPane())
            startActivity(RepoDetailActivity.newIntent(this, repo));
        else {
            if (!isFinishing())
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.containerDetail, RepoDetailFragment.newInstance(repo))
                        .commitAllowingStateLoss();
        }
    }
}
