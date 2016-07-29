package nanodegree.udacity.com.sunshine;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.main_fragment_container);
        if (fragment == null) {
            fragment = ForecastFragment.newInstance();
            fragmentManager.beginTransaction().add(R.id.main_fragment_container, fragment)
                    .commit();
        }
    }
}
