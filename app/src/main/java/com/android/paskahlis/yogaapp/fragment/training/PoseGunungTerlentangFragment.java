package com.android.paskahlis.yogaapp.fragment.training;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.android.paskahlis.yogaapp.R;
import com.android.paskahlis.yogaapp.utility.OrderedListHelper;

public class PoseGunungTerlentangFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_pose_gunung_terlentang, container, false);
        LinearLayout stepContainer = (LinearLayout) rootView.findViewById(R.id.step_container);

        String[] steps = getResources().getStringArray(R.array.pose_gunung_terlentang);

        OrderedListHelper helper = new OrderedListHelper(getActivity());
        for (int idx = 0; idx < steps.length; idx++) {
            stepContainer.addView(helper.buildRow(idx + 1, steps[idx]));
        }

        return rootView;

    }

}
