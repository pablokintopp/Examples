package pablokintopp.com.mvvmtemplate.view.repodetail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import org.parceler.Parcels;

import pablokintopp.com.mvvmtemplate.R;
import pablokintopp.com.mvvmtemplate.model.api.entity.Repo;

/**
 * Created by mertsimsek on 13/01/17.
 */
public class RepoDetailActivity extends AppCompatActivity {

    public static final String KEY_REPO = "key_repo";

    public static Intent newIntent(Context context, Repo repo) {
        Intent intent = new Intent(context, RepoDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(KEY_REPO, Parcels.wrap(repo));
        intent.putExtras(bundle);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repo_detail);

        Repo repo = Parcels.unwrap(getIntent().getExtras().getParcelable(KEY_REPO));
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle(repo.name);

        if (savedInstanceState == null)
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.containerDetail, RepoDetailFragment.newInstance(repo))
                    .commitAllowingStateLoss();
    }
}
