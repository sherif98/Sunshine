package nanodegree.udacity.com.sunshine.fragments;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import nanodegree.udacity.com.sunshine.R;
import nanodegree.udacity.com.sunshine.activities.DetailActivity;
import nanodegree.udacity.com.sunshine.activities.SettingsActivity;
import nanodegree.udacity.com.sunshine.model.ResultData;
import nanodegree.udacity.com.sunshine.network.DataDownloadFinishedCommand;
import nanodegree.udacity.com.sunshine.network.FetchWeatherDataTask;


/**
 * A simple {@link Fragment} subclass.
 */
public class ForecastFragment extends Fragment implements DataDownloadFinishedCommand {

    private ResultData mData;
    private ArrayAdapter<String> mArrayAdapter;
    private ListView mListView;


    public ForecastFragment() {
        // Required empty public constructor
    }

    public static ForecastFragment newInstance() {
        return new ForecastFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        mListView = ButterKnife.findById(rootView, R.id.listview_forecast);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String text = mArrayAdapter.getItem(i);
                Intent intent = DetailActivity.newIntent(getActivity(), text);
                startActivity(intent);
            }
        });
        return rootView;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.main_menu, menu);
    }

    @Override
    public void onStart() {
        super.onStart();
        updateWeather();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_refresh) {
            updateWeather();
            return true;
        } else if (id == R.id.action_settings) {
            Intent intent = SettingsActivity.newIntent(getActivity());
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void updateWeather() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String location = sharedPreferences.getString(getString(R.string.pref_location_key),
                getString(R.string.pref_location_default));
        String unitType = sharedPreferences.getString(getString(R.string.pref_units_key),
                getString(R.string.pref_units_metric));
        new FetchWeatherDataTask(this).execute(location, unitType, "7");
    }

    @Override
    public void transferData(ResultData data) {
        Log.v("dataishere", String.valueOf(data.getLocationData().getCityName()));
        Log.v("dataishere", String.valueOf(data.getWeatherData().get(0).getTemperature().getMaxTemperature()));
        mData = data;
        List<String> realData = new ArrayList<>();
        for (int i = 0; i < data.getWeatherData().size(); i++) {
            String s = "min : " + data.getWeatherData().get(i).getTemperature().getMinTemperature();
            s += " max : " + data.getWeatherData().get(i).getTemperature().getMaxTemperature();
            s += " main : " + data.getWeatherData().get(i).getWeather().get(0).getWeatherType();
            realData.add(s);
        }
        updateAdapter(realData);
    }

    private void updateAdapter(List<String> data) {
        if (mArrayAdapter == null) {
            mArrayAdapter = new ArrayAdapter<>(getActivity(),
                    R.layout.list_item_forecast, R.id.list_item_forecast_textview, data);
            mListView.setAdapter(mArrayAdapter);
        } else {
            mArrayAdapter.clear();
            mArrayAdapter.addAll(data);
        }
    }
}