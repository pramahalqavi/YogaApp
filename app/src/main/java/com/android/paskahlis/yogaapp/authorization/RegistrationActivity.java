package com.android.paskahlis.yogaapp.authorization;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.paskahlis.yogaapp.R;

public class RegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        getSupportActionBar().hide();
    }
}
