package nanodegree.udacity.com.sunshine.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import nanodegree.udacity.com.sunshine.R;
import nanodegree.udacity.com.sunshine.fragments.DetailFragment;

public class DetailActivity extends AppCompatActivity {

    private static final String DATA = "data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.detail_fragment_container);
        if (fragment == null) {
            fragment = DetailFragment.newInstance(getIntent().getStringExtra(DATA));
            fragmentManager.beginTransaction().add(R.id.detail_fragment_container, fragment)
                    .commit();
        }
    }

    public static Intent newIntent(Context context, String text) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(DATA, text);
        return intent;
    }
}
