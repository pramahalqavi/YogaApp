package com.android.paskahlis.yogaapp.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import com.android.paskahlis.yogaapp.R;
import com.android.paskahlis.yogaapp.activity.SetDateActivity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class SetTimeFragment extends Fragment {
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TimePicker timePicker = (TimePicker) getView().findViewById(R.id.timepicker);
        timePicker.setIs24HourView(true);
        final SharedPreferences pref = getActivity().getSharedPreferences("YogaApp", Context.MODE_PRIVATE);
        final SetDateActivity setDateActivity = (SetDateActivity) getActivity();
        setDateActivity.alarmButton.setVisibility(View.VISIBLE);

        final TextView strDate = getView().findViewById(R.id.text_date);
        final TextView infoDate = getView().findViewById(R.id.date_info);
        final TextView infoTime = getView().findViewById(R.id.time_info);

        DateFormat headerDateFormat = new SimpleDateFormat("yyyy\nEEE, dd MMM");
        strDate.setText(headerDateFormat.format(pref.getLong("date", new Date().getTime())));
        DateFormat infoDateFormat = new SimpleDateFormat("EEE, dd MMM");
        infoDate.setText(infoDateFormat.format(pref.getLong("date", new Date().getTime())));
        infoTime.setText(String.format("%02d:%02d", timePicker.getCurrentHour(), timePicker.getCurrentMinute()));

        pref.edit().putInt("hour", timePicker.getCurrentHour()).apply();
        pref.edit().putInt("minute", timePicker.getCurrentMinute()).apply();
        Calendar calendar = Calendar.getInstance();
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                infoTime.setText(String.format("%02d:%02d", hourOfDay, minute));
                pref.edit().putInt("hour", hourOfDay).apply();
                pref.edit().putInt("minute", minute).apply();
            }
        });

        LinearLayout info = getView().findViewById(R.id.info);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment alarmFragment = new SetAlarmFragment();
                getFragmentManager().beginTransaction().replace(R.id.date_container, alarmFragment).addToBackStack("AlarmFragment").commit();
            }
        });

        setDateActivity.alarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment alarmFragment = new SetAlarmFragment();
                getFragmentManager().beginTransaction().replace(R.id.date_container, alarmFragment).addToBackStack("AlarmFragment").commit();
            }
        });
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_set_time, container, false);
        return rootView;
    }
}
