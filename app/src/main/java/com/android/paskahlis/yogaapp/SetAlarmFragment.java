package com.android.paskahlis.yogaapp;


import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.android.paskahlis.yogaapp.activity.AlarmReceiverActivity;
import com.android.paskahlis.yogaapp.activity.SetDateActivity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SetAlarmFragment extends Fragment {

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final SetDateActivity setDateActivity = (SetDateActivity) getActivity();
        setDateActivity.alarmButton.setVisibility(View.INVISIBLE);
        final SharedPreferences pref = getContext().getSharedPreferences("YogaApp", Context.MODE_PRIVATE);

        final TextView dateLabel = getView().findViewById(R.id.date_label);
        final TextView timeLabel = getView().findViewById(R.id.time_label);
        final TextView dateAlarm = getView().findViewById(R.id.date_alarm);
        final TextView timeAlarm = getView().findViewById(R.id.time_alarm);

        DateFormat dateFormat = new SimpleDateFormat("EEE, dd MMM");
        dateAlarm.setText(dateFormat.format(getArguments().getLong("date")));
        timeAlarm.setText(String.format("%02d.%02d", getArguments().getInt("hour"), getArguments().getInt("minute")));

        Switch sw = getView().findViewById(R.id.alarm_switch);
        sw.setChecked(pref.getBoolean("alarm", false));
        if (sw.isChecked()) {
            dateLabel.setVisibility(View.VISIBLE);
            dateAlarm.setVisibility(View.VISIBLE);
            timeLabel.setVisibility(View.VISIBLE);
            timeAlarm.setVisibility(View.VISIBLE);
        } else {
            dateLabel.setVisibility(View.INVISIBLE);
            dateAlarm.setVisibility(View.INVISIBLE);
            timeLabel.setVisibility(View.INVISIBLE);
            timeAlarm.setVisibility(View.INVISIBLE);
        }
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    dateLabel.setVisibility(View.VISIBLE);
                    dateAlarm.setVisibility(View.VISIBLE);
                    timeLabel.setVisibility(View.VISIBLE);
                    timeAlarm.setVisibility(View.VISIBLE);
                    Intent intent = new Intent(getActivity(), AlarmReceiverActivity.class);
                    PendingIntent pendingIntent = PendingIntent.getActivity(getActivity(),
                            12345, intent, PendingIntent.FLAG_CANCEL_CURRENT);
                    Calendar cal = Calendar.getInstance();
                    long ts = getArguments().getLong("date");
                    ts += getArguments().getLong("hour") * 60 * 60 * 1000;
                    ts += getArguments().getLong("minute") * 60 * 1000;
                    cal.setTimeInMillis(ts);
                    AlarmManager am = (AlarmManager)getActivity().getSystemService(Activity.ALARM_SERVICE);
                    am.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),
                            pendingIntent);
                } else {
                    dateLabel.setVisibility(View.INVISIBLE);
                    dateAlarm.setVisibility(View.INVISIBLE);
                    timeLabel.setVisibility(View.INVISIBLE);
                    timeAlarm.setVisibility(View.INVISIBLE);
                }
                pref.edit().putBoolean("alarm",isChecked);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_set_alarm, container, false);
    }

}
