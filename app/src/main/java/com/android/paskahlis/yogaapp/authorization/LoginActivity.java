package com.android.paskahlis.yogaapp.authorization;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.paskahlis.yogaapp.R;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        YoYo.with(Techniques.Tada)
                .duration(1400)
                .playOn(findViewById(R.id.daun_top));
    }
}
