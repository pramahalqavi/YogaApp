package com.android.paskahlis.yogaapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.android.paskahlis.yogaapp.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void registerLabelOnClick(View view) {
        startActivity(new Intent(this, RegistrationActivity.class));
    }

    public void masukButtonOnClick(View view) {
        startActivity(new Intent(this, AuthenticationActivity.class));
    }
}
