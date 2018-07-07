package com.android.paskahlis.yogaapp.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MenuItem;

import com.android.paskahlis.yogaapp.R;
import com.android.paskahlis.yogaapp.fragment.ArticlesFragment;
import com.android.paskahlis.yogaapp.fragment.ContactsFragment;
import com.android.paskahlis.yogaapp.fragment.history.HistoryFragment;
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
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedfragment = null;
                switch (item.getItemId()) {
                    case R.id.navigation_article:
                        selectedfragment = new ArticlesFragment();
                        mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
                        break;
                    case R.id.navigation_history:
                        selectedfragment = new HistoryFragment();
                        mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
                        break;
                    case R.id.navigation_contact:
                        selectedfragment = new ContactsFragment();
                        mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
                        break;
                    case R.id.navigation_exit:
                        finish();
                        break;
                }
                replaceFragment(selectedfragment, true);
                return true;
            }
        });

        navigationView = findViewById(R.id.nav_view);

    }

    public void replaceFragment(Fragment fragment, boolean clearStack) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (clearStack) {
            int count = fragmentManager.getBackStackEntryCount();
            for (int i = 0; i < count; ++i)
                fragmentManager.popBackStack();
        }
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out, R.anim.fade_in, R.anim.fade_out);
        fragmentTransaction.replace(R.id.fragment, fragment);
        if (!clearStack) fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        int count = fragmentManager.getBackStackEntryCount();

        if (mDrawerLayout.isDrawerOpen(Gravity.START)) {
            mDrawerLayout.closeDrawers();
            return;
        }

        if (count == 0) {
            super.onBackPressed();
        } else {
            fragmentManager.popBackStack();
        }
    }

}
