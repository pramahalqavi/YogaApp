package com.android.paskahlis.yogaapp.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.paskahlis.yogaapp.R;
import com.android.paskahlis.yogaapp.activity.MenuActivity;

/**
 * Created by Prama LH on 07-May-18.
 */

public class ContactsFragment extends Fragment {

    private EditText saran;
    private EditText email;
    private EditText nama;
    private Handler handler;

    private View.OnClickListener sendClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (!saran.getText().toString().equals("") && !email.getText().toString().equals("")
                    && !nama.getText().toString().equals("")) {
                Toast.makeText(getContext(), "Mengirim...", Toast.LENGTH_SHORT).show();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getContext(), "Masukan dan saran telah terkirim", Toast.LENGTH_SHORT).show();
                    }
                }, 2000);

            } else {
                Toast.makeText(getContext(), "Input kosong", Toast.LENGTH_SHORT).show();
            }
        }
    };

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final MenuActivity activity = (MenuActivity) getActivity();

        Button send = getView().findViewById(R.id.button_send);
        saran = getView().findViewById(R.id.contacts_content);
        email = getView().findViewById(R.id.contacts_email);
        nama = getView().findViewById(R.id.contacts_name);
        handler = new Handler();

        send.setOnClickListener(sendClick);
        ImageView backButton = (ImageView) getView().findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.bottomNav.setSelectedItemId(R.id.navigation_article);
            }
        });

        ImageView addButton = getView().findViewById(R.id.button_mail);
        addButton.setOnClickListener(sendClick);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_contacts, container, false);
        return rootView;
    }
}
