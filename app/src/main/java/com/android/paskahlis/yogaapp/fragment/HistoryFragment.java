package com.android.paskahlis.yogaapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.android.paskahlis.yogaapp.R;
import com.android.paskahlis.yogaapp.activity.SetDateActivity;

/**
 * Created by Prama LH on 07-May-18.
 */

public class HistoryFragment extends Fragment {
    private Button addSchedule;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        addSchedule = (Button) getView().findViewById(R.id.button_add_schedule);
        addSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SetDateActivity.class);
                startActivity(intent);
            }
        });
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_history, container, false);
        return rootView;
    }
}
