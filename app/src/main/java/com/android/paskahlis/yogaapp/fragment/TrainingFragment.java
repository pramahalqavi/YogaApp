package com.android.paskahlis.yogaapp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.paskahlis.yogaapp.R;
import com.android.paskahlis.yogaapp.utility.TrainingModeListAdapter;

public class TrainingFragment extends Fragment {
    private final String[] TRAINING_MODES = {
            "POSE GUNUNG DI LANTAI",
            "POSE GUNUNG TERLENTANG",
            "POSE POHON TERLENTANG",
            "POSE KURSI TERLENTANG",
            "POSE WAJAH TELUNGKUP",
            "POSE BENTANGAN TANGAN DAN KAKI",
            "POSE SEGITIGA MEMUTAR",
            "POSE WAJAH ANJING TELUNGKUP",
            "POSE TONGKAT",
            "POSE DUDUK CONDONG KE DEPAN"
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_training, container, false);

        TrainingModeListAdapter adapter = new TrainingModeListAdapter(this.getActivity(), TRAINING_MODES);
        ListView trainingModeListView = (ListView) rootView.findViewById(R.id.training_mode_list_view);
        trainingModeListView.setAdapter(adapter);

        return rootView;
    }
}
