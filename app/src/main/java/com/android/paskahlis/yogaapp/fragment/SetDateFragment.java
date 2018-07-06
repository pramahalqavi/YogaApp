package com.android.paskahlis.yogaapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.android.paskahlis.yogaapp.R;
import com.android.paskahlis.yogaapp.activity.SetDateActivity;


public class SetDateFragment extends Fragment {
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final SetDateActivity setDateActivity = (SetDateActivity) getActivity();
        ImageView backButton = setDateActivity.findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDateActivity.onBackPressed();
            }
        });

        Button setSchedule = getView().findViewById(R.id.button_set_schedule);
        setSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.date_container, new SetTimeFragment()).addToBackStack("TimeFragment").commit();
            }
        });
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_set_date, container, false);

        return rootView;
    }
}
