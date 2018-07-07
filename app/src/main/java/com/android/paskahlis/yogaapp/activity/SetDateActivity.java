package com.android.paskahlis.yogaapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.android.paskahlis.yogaapp.R;
import com.android.paskahlis.yogaapp.fragment.history.schedule.SetDateFragment;

public class SetDateActivity extends AppCompatActivity {

    public ImageView alarmButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_date);

        alarmButton = findViewById(R.id.alarm_button);
        alarmButton.setVisibility(View.INVISIBLE);

        getSupportFragmentManager().beginTransaction().replace(R.id.date_container, new SetDateFragment()).commit();
    }

    @Override
    public void onBackPressed() {
        alarmButton.setVisibility(View.INVISIBLE);
        super.onBackPressed();
    }
}
