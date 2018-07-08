package com.android.paskahlis.yogaapp.fragment.history;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.android.paskahlis.yogaapp.R;
import com.android.paskahlis.yogaapp.activity.MenuActivity;
import com.android.paskahlis.yogaapp.fragment.history.schedule.SetDateFragment;

/**
 * Created by Prama LH on 07-May-18.
 */

public class HistoryFragment extends Fragment {
    private Button addSchedule;
    private ImageView backButton;
    private MenuActivity activity;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        activity = (MenuActivity) getActivity();

        addSchedule = (Button) getView().findViewById(R.id.button_add_schedule);
        addSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.replaceFragment(new SetDateFragment(), false);
            }
        });
        backButton = (ImageView) getView().findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.bottomNav.setSelectedItemId(R.id.navigation_article);
            }
        });
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_history, container, false);
        return rootView;
    }
}
