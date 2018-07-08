package com.android.paskahlis.yogaapp.activity;

import android.content.DialogInterface;
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
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.paskahlis.yogaapp.R;
import com.android.paskahlis.yogaapp.fragment.ArticlesFragment;
import com.android.paskahlis.yogaapp.fragment.ContactsFragment;
import com.android.paskahlis.yogaapp.fragment.history.HistoryFragment;
import com.android.paskahlis.yogaapp.utility.BottomNavigationViewHelper;

public class MenuActivity extends AppCompatActivity {
    public DrawerLayout mDrawerLayout;
    public NavigationView navigationView;
    private BottomNavigationView bottomNav;
    private Boolean isBackPressedTwice = false;

    private BottomNavigationView.OnNavigationItemSelectedListener bottomNavListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedfragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_article:
                    selectedfragment = new ArticlesFragment();
                    mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
                    if (bottomNav.getSelectedItemId() == R.id.navigation_history
                            && getSupportFragmentManager().getBackStackEntryCount() > 0) {
                        showDialogSwitchTab(selectedfragment);
                    } else {
                        replaceFragment(selectedfragment, true);
                    }
                    break;
                case R.id.navigation_history:
                    selectedfragment = new HistoryFragment();
                    mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
                    if (bottomNav.getSelectedItemId() != R.id.navigation_history) {
                        replaceFragment(selectedfragment, true);
                    }
                    break;
                case R.id.navigation_contact:
                    selectedfragment = new ContactsFragment();
                    mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
                    if (bottomNav.getSelectedItemId() == R.id.navigation_history
                            && getSupportFragmentManager().getBackStackEntryCount() > 0) {
                        showDialogSwitchTab(selectedfragment);
                    } else {
                        replaceFragment(selectedfragment, true);
                    }
                    break;
                case R.id.navigation_exit:
                    finish();
                    System.exit(0);
                    break;
            }
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);


        bottomNav = findViewById(R.id.navigation);
        BottomNavigationViewHelper.removeShiftMode(bottomNav);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new ArticlesFragment()).commit();
        bottomNav.setOnNavigationItemSelectedListener(bottomNavListener);
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
        if (mDrawerLayout.isDrawerOpen(Gravity.START)) {
            mDrawerLayout.closeDrawers();
            return;
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        int count = fragmentManager.getBackStackEntryCount();
        if (count == 0) {
            if (!isBackPressedTwice) {
                Toast.makeText(this, "Tekan sekali lagi untuk keluar.", Toast.LENGTH_SHORT).show();
                isBackPressedTwice = true;
                return;
            }
            super.onBackPressed();
        } else {
            fragmentManager.popBackStack();
        }
    }

    public void showDialogSwitchTab(final Fragment fragment) {
        AlertDialog.Builder builder;
        builder = new AlertDialog.Builder(this);
        builder.setMessage("Apakah Anda ingin menyelesaikan agenda ini?")
                .setPositiveButton("Oke", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        if (fragment.getClass().getSimpleName() == "ArticlesFragment") {
                            replaceFragment(fragment, true);
                        } else {
                            replaceFragment(fragment, true);
                        }
                    }
                })
                .setNegativeButton("Batal", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        bottomNav.setOnNavigationItemSelectedListener(null);
                        bottomNav.setSelectedItemId(R.id.navigation_history);
                        bottomNav.setOnNavigationItemSelectedListener(bottomNavListener);
                    }
                }).setCancelable(false).show();
    }
}
