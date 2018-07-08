package com.android.paskahlis.yogaapp.fragment.history.training;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.android.paskahlis.yogaapp.R;
import com.android.paskahlis.yogaapp.activity.MenuActivity;
import com.android.paskahlis.yogaapp.utility.OrderedListHelper;
import com.android.paskahlis.yogaapp.utility.TrainingFragmentContollerManager;

public class PoseWajahAnjingTerlungkupFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_pose_wajah_anjing_terlungkup, container, false);
        LinearLayout stepContainer = (LinearLayout) rootView.findViewById(R.id.step_container);

        String[] steps = getResources().getStringArray(R.array.pose_wajah_anjing_terlungkup);

        final MenuActivity activity = (MenuActivity) getActivity();

        OrderedListHelper helper = new OrderedListHelper(activity);
        for (int idx = 0; idx < steps.length; idx++) {
            stepContainer.addView(helper.buildRow(idx + 1, steps[idx]));
        }
        TrainingFragmentContollerManager contollerManager = new TrainingFragmentContollerManager(activity, rootView, this);
        rootView = contollerManager.initController();
        return rootView;
    }
}
