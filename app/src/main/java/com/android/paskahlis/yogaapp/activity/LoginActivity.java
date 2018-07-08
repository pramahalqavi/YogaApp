package com.android.paskahlis.yogaapp.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.android.paskahlis.yogaapp.R;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    public void registerLabelOnClick(View view) {
        startActivity(new Intent(this, RegistrationActivity.class));
    }

    public void masukButtonOnClick(View view) {
        startActivity(new Intent(this, MenuActivity.class));
        finish();
    }
}
