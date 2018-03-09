package com.templates.android.pablokintopp.mvvmtemplate.view;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;


import com.templates.android.pablokintopp.mvvmtemplate.R;
import com.templates.android.pablokintopp.mvvmtemplate.TemplateApp;
import com.templates.android.pablokintopp.mvvmtemplate.databinding.ActivityMainBinding;

import com.templates.android.pablokintopp.mvvmtemplate.di.DaggerMainComponent;
import com.templates.android.pablokintopp.mvvmtemplate.di.MainModule;
import com.templates.android.pablokintopp.mvvmtemplate.model.entity.Movie;
import com.templates.android.pablokintopp.mvvmtemplate.viewmodel.MainViewModel;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainViewModel.MainListener {

    ActivityMainBinding binding;

    @Inject
    MainViewModel viewModel;

    public static Intent newIntent(Context context){
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

    private void initializeViews(Bundle savedInstanceState) {
        if(findViewById(R.id.containerMain) != null)
            viewModel.setTwoPane(true);

        if(savedInstanceState == null) {
            //ToDo getSupportFragmentManager().beginTransaction().add(R.id.containerMain, MovieListFragment.newInstance()).commitAllowingStateLoss();
        }
    }

    private void initializeInjectors() {

        DaggerMainComponent.builder()
                .appComponent(((TemplateApp) getApplication()).getAppComponent())
                .mainModule(new MainModule(this))
                .build();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        viewModel.stop();
    }

    @Override
    public void onMovieItemClicked(Movie movie) {
        if(!viewModel.isTwoPane()) {
            //ToDo startActivity(MovieDetailActivity.newIntent(this, movie));
            Log.d(this.getLocalClassName(), "Movie item clicked! Should open detail activity");
        }else{
            if(!isFinishing()){
                Log.d(this.getLocalClassName(), "Movie item clicked! Should show detail pane!");
                //ToDo getSupportFragmentManager().beginTransaction().replace(R.id.containerDetail, MovieDetailFragment.newInstance(movie)).commitAllowingStateLoss();
            }
        }



    }
}
