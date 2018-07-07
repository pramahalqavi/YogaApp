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
import com.android.paskahlis.yogaapp.fragment.training.PoseBentanganTanganKakiFragment;
import com.android.paskahlis.yogaapp.fragment.training.PoseGunungLantaiFragment;
import com.android.paskahlis.yogaapp.fragment.training.PoseGunungTerlentangFragment;
import com.android.paskahlis.yogaapp.fragment.training.PoseKursiTerlentangFragment;
import com.android.paskahlis.yogaapp.fragment.training.PosePohonTerlentangFragment;
import com.android.paskahlis.yogaapp.fragment.training.PoseWajahTerlungkupFragment;
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
                Fragment fragment = null;
                switch (i) {
                    case 0:
                        fragment = new PoseGunungLantaiFragment();
                        break;
                    case 1:
                        fragment = new PoseGunungTerlentangFragment();
                        break;
                    case 2:
                        fragment = new PosePohonTerlentangFragment();
                        break;
                    case 3:
                        fragment = new PoseKursiTerlentangFragment();
                        break;
                    case 4:
                        fragment = new PoseWajahTerlungkupFragment();
                        break;
                    case 5:
                        fragment = new PoseBentanganTanganKakiFragment();
                        break;

                }
                if (fragment != null)
                    activity.replaceFragment(fragment, false);
            }
        });

        return rootView;
    }
}
