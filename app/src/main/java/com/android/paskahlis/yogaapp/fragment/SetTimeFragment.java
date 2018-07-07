package com.android.paskahlis.yogaapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.TimePicker;

import com.android.paskahlis.yogaapp.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class SetTimeFragment extends Fragment {
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TimePicker timePicker = (TimePicker) getView().findViewById(R.id.timepicker);
        timePicker.setIs24HourView(true);

        final TextView strDate = getView().findViewById(R.id.text_date);
        final TextView infoDate = getView().findViewById(R.id.date_info);
        final TextView infoTime = getView().findViewById(R.id.time_info);

        DateFormat headerDateFormat = new SimpleDateFormat("yyyy\nEEE, dd MMM");
        strDate.setText(headerDateFormat.format(getArguments().getLong("date")));
        DateFormat infoDateFormat = new SimpleDateFormat("EEE, dd MMM");
        infoDate.setText(infoDateFormat.format(getArguments().getLong("date")));
        infoTime.setText(String.format("%02d:%02d", timePicker.getCurrentHour(), timePicker.getCurrentMinute()));

        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                infoTime.setText(String.format("%02d:%02d", hourOfDay, minute));
            }
        });
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_set_time, container, false);
        return rootView;
    }
}
