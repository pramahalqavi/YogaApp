package com.android.paskahlis.yogaapp.authorization;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

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
                .duration(700)
                .playOn(findViewById(R.id.daun_top));
        YoYo.with(Techniques.Tada)
                .duration(700)
                .playOn(findViewById(R.id.daun_bottom));
    }

    public void registerLabelOnClick(View view) {
        startActivity(new Intent(this, RegistrationActivity.class));
    }

    public void masukButtonOnClick(View view) {
        startActivity(new Intent(this, AuthenticationActivity.class));
    }
}
