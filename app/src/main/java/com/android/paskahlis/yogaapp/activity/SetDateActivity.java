package com.android.paskahlis.yogaapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.android.paskahlis.yogaapp.R;
import com.android.paskahlis.yogaapp.fragment.SetDateFragment;

public class SetDateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_date);
        getSupportFragmentManager().beginTransaction().replace(R.id.date_container, new SetDateFragment()).commit();
    }
}
