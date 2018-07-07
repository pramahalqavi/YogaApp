package com.android.paskahlis.yogaapp.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;

import com.android.paskahlis.yogaapp.R;
import com.android.paskahlis.yogaapp.fragment.ArticlesFragment;
import com.android.paskahlis.yogaapp.fragment.ContactsFragment;
import com.android.paskahlis.yogaapp.fragment.HistoryFragment;
import com.android.paskahlis.yogaapp.fragment.TrainingFragment;
import com.android.paskahlis.yogaapp.utility.BottomNavigationViewHelper;

public class MenuActivity extends AppCompatActivity {
    public DrawerLayout mDrawerLayout;
    public NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);


        BottomNavigationView bottomNav = findViewById(R.id.navigation);
        BottomNavigationViewHelper.removeShiftMode(bottomNav);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new ArticlesFragment()).commit();
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedfragment = null;
                switch (item.getItemId()) {
                    case R.id.navigation_article:
                        selectedfragment = new ArticlesFragment();
                        mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
                        break;
                    case R.id.navigation_history:
//                        selectedfragment = new HistoryFragment();
                        selectedfragment = new TrainingFragment();
                        mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
                        break;
                    case R.id.navigation_contact:
                        selectedfragment = new ContactsFragment();
                        mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
                        break;
                    case R.id.navigation_exit:
                        finish();
                        System.exit(0);
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment, selectedfragment).commit();
                return true;
            }
        });

        navigationView = findViewById(R.id.nav_view);

    }
    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(Gravity.START)) {
            mDrawerLayout.closeDrawers();
            return;
        } else {
            super.onBackPressed();
        }
    }

}
