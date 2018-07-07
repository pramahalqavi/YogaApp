package com.android.paskahlis.yogaapp.utility;;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.android.paskahlis.yogaapp.activity.AlarmReceiverActivity;

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context arg0, Intent arg1) {
//        Toast.makeText(arg0, "I'm running", Toast.LENGTH_SHORT).show();
        final SharedPreferences pref = arg0.getSharedPreferences("YogaApp", Context.MODE_PRIVATE);
        if (pref.getBoolean("alarm", true)) {
            pref.edit().putBoolean("alarm", false).apply();
            Intent in = new Intent(arg0, AlarmReceiverActivity.class);
            in.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            arg0.startActivity(in);
        }
    }

}