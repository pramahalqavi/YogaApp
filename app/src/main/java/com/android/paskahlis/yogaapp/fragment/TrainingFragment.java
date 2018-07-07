package com.android.paskahlis.yogaapp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.paskahlis.yogaapp.R;
import com.android.paskahlis.yogaapp.activity.MenuActivity;
import com.android.paskahlis.yogaapp.utility.TrainingModeListAdapter;

public class TrainingFragment extends Fragment {
    private MenuActivity activity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_training, container, false);

        activity = (MenuActivity) getActivity();

        TrainingModeListAdapter adapter = new TrainingModeListAdapter(activity);
        ListView trainingModeListView = (ListView) rootView.findViewById(R.id.training_mode_list_view);
        trainingModeListView.setAdapter(adapter);
        trainingModeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        Fragment fragment = new PoseGunungLantaiFragment();
                        activity.replaceFragment(fragment, false);
                }
            }
        });

        return rootView;
    }
}
