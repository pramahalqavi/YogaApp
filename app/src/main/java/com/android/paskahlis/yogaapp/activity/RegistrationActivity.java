package com.android.paskahlis.yogaapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.android.paskahlis.yogaapp.R;

public class RegistrationActivity extends AppCompatActivity {
    private EditText nameInput;
    private EditText emailInput;
    private EditText passwordInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        nameInput = (EditText) findViewById(R.id.name_input);
        emailInput = (EditText) findViewById(R.id.email_input);
        passwordInput = (EditText) findViewById(R.id.password_input);
    }

    public void exitPendaftaranButtonOnClick(View view) {
        onBackPressed();
    }

    public void registerButtonOnClick(View view) {
        if (isFieldIncomplete()) return;
        Intent intent = new Intent(this, MenuActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    private boolean isFieldIncomplete() {
        boolean fieldIncomplete = setWarningOnInput(nameInput, "Nama tidak boleh kosong");
        fieldIncomplete = fieldIncomplete || setWarningOnInput(emailInput, "Email tidak boleh kosong");
        fieldIncomplete = fieldIncomplete || setWarningOnInput(passwordInput, "Password tidak boleh kosong");
        return fieldIncomplete;
    }

    private Boolean setWarningOnInput(EditText input, String errorMsg) {
        Boolean isBlank = input.getText().toString().isEmpty();
        if (isBlank) input.setError(errorMsg);
        return isBlank;
    }
}
