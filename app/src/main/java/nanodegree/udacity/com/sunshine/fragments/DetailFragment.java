package nanodegree.udacity.com.sunshine.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.ButterKnife;
import nanodegree.udacity.com.sunshine.R;
import nanodegree.udacity.com.sunshine.activities.SettingsActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {


    private static final String DATA = "data";

    public DetailFragment() {
        // Required empty public constructor
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
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
        TextView textView = ButterKnife.findById(rootView, R.id.text_data);
        textView.setText(getArguments().getString(DATA));
        return rootView;
    }

    public static Fragment newInstance(String stringExtra) {
        Bundle args = new Bundle();
        args.putString(DATA, stringExtra);
        DetailFragment fragment = new DetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.detail_activity_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_settings) {
            Intent intent = SettingsActivity.newIntent(getActivity());
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
