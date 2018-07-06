package com.android.paskahlis.yogaapp.authorization;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.android.paskahlis.yogaapp.R;

public class RegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
    }

    public void exitPendaftaranButtonOnClick(View view) {
        onBackPressed();
    }
}
