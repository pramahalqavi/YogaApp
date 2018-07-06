package com.android.paskahlis.yogaapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.paskahlis.yogaapp.authorization.LoginActivity;

public class MainActivity extends AppCompatActivity {
    private Activity activity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(activity, LoginActivity.class));
                finish();
            }
        }, 1000);
    }
}
