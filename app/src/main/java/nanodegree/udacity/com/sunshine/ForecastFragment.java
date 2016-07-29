package nanodegree.udacity.com.sunshine;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import nanodegree.udacity.com.sunshine.model.ResultData;
import nanodegree.udacity.com.sunshine.network.DataDownloadFinishedCommand;
import nanodegree.udacity.com.sunshine.network.FetchWeatherDataTask;


/**
 * A simple {@link Fragment} subclass.
 */
public class ForecastFragment extends Fragment implements DataDownloadFinishedCommand {

    private ResultData mData;

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
        List<String> fakeData = new ArrayList<>(Arrays.asList("Today- Sunny", "Tomorrow Foggy"));
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(),
                R.layout.list_item_forecast, R.id.list_item_forecast_textview, fakeData);
        ListView listView = (ListView) rootView.findViewById(R.id.listview_forecast);
        listView.setAdapter(arrayAdapter);
        return rootView;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.main_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_refresh) {
            new FetchWeatherDataTask(this).execute("94043", "metric");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void transferData(ResultData data) {
        Log.v("dataishere", String.valueOf(data.getLocationData().getCityName()));
        Log.v("dataishere", String.valueOf(data.getWeatherData().get(0).getTemperature().getMaxTemperature()));
        mData = data;

    }
}