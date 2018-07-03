package com.android.paskahlis.yogaapp.activity;

import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.android.paskahlis.yogaapp.R;
import com.android.paskahlis.yogaapp.fragment.ArticlesFragment;
import com.android.paskahlis.yogaapp.fragment.ContactsFragment;
import com.android.paskahlis.yogaapp.fragment.HistoryFragment;
import com.android.paskahlis.yogaapp.utility.BottomNavigationViewHelper;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        BottomNavigationView bottomNav = findViewById(R.id.navigation);
        BottomNavigationViewHelper.removeShiftMode(bottomNav);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new ArticlesFragment()).commit();
        bottomNav.setOnNavigationItemSelectedListener(navListener);
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedfragment = null;
                    switch (item.getItemId()) {
                        case R.id.navigation_article:
                            selectedfragment = new ArticlesFragment();
                            break;
                        case R.id.navigation_history:
                            selectedfragment = new HistoryFragment();
                            break;
                        case R.id.navigation_contact:
                            selectedfragment = new ContactsFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment, selectedfragment).commit();
                    return true;
                }
            };
}
