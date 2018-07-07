package com.android.paskahlis.yogaapp.fragment;


import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.android.paskahlis.yogaapp.R;
import com.android.paskahlis.yogaapp.activity.MenuActivity;
import com.android.paskahlis.yogaapp.activity.SetDateActivity;
import com.android.paskahlis.yogaapp.utility.AlarmReceiver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SetAlarmFragment extends Fragment {
    private MenuActivity activity;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        activity = (MenuActivity) getActivity();
        View rootView = getView();
        
        final SharedPreferences pref = activity.getSharedPreferences("YogaApp", Context.MODE_PRIVATE);

        final TextView dateLabel = rootView.findViewById(R.id.date_label);
        final TextView timeLabel = rootView.findViewById(R.id.time_label);
        final TextView dateAlarm = rootView.findViewById(R.id.date_alarm);
        final TextView timeAlarm = rootView.findViewById(R.id.time_alarm);

        DateFormat dateFormat = new SimpleDateFormat("EEE, dd MMM");
        dateAlarm.setText(dateFormat.format(pref.getLong("date", new Date().getTime())));
        timeAlarm.setText(String.format("%02d.%02d", pref.getInt("hour", 0), pref.getInt("minute", 0)));

        final Switch sw = rootView.findViewById(R.id.alarm_switch);
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

                    Intent alarmIntent = new Intent(getActivity(), AlarmReceiver.class);
                    PendingIntent pendingIntent = PendingIntent.getBroadcast(getActivity(), 0, alarmIntent, 0);

                    Calendar cal = Calendar.getInstance();
                    long ts = pref.getLong("date", new Date().getTime());
                    ts += pref.getInt("hour", 0) * 60 * 60 * 1000;
                    ts += pref.getInt("minute", 0) * 60 * 1000;
                    cal.setTimeInMillis(ts);
//                    AlarmManager am = (AlarmManager)getActivity().getSystemService(Activity.ALARM_SERVICE);
                    AlarmManager am = (AlarmManager) getActivity().getSystemService(Context.ALARM_SERVICE);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                        am.setExact(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), pendingIntent);
                    } else {
                        am.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), pendingIntent);
                    }
                } else {
                    dateLabel.setVisibility(View.INVISIBLE);
                    dateAlarm.setVisibility(View.INVISIBLE);
                    timeLabel.setVisibility(View.INVISIBLE);
                    timeAlarm.setVisibility(View.INVISIBLE);
                }
                pref.edit().putBoolean("alarm", isChecked).apply();
                Log.d("tag", "turned to " + isChecked);
            }
        });

        SharedPreferences.OnSharedPreferenceChangeListener spChanged = new SharedPreferences.OnSharedPreferenceChangeListener() {
            @Override
            public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
                if (key.equals("alarm") && sharedPreferences.getBoolean("alarm", false) == false)
                    sw.setChecked(false);
            }
        };
        pref.registerOnSharedPreferenceChangeListener(spChanged);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_set_alarm, container, false);
    }

}
