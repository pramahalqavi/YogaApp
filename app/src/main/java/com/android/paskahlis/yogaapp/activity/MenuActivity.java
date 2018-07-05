package com.android.paskahlis.yogaapp.activity;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Toolbar;

import com.android.paskahlis.yogaapp.R;
import com.android.paskahlis.yogaapp.fragment.ArticlesFragment;
import com.android.paskahlis.yogaapp.fragment.ContactsFragment;
import com.android.paskahlis.yogaapp.fragment.HistoryFragment;
import com.android.paskahlis.yogaapp.fragment.TentangSkoliosisFragment;
import com.android.paskahlis.yogaapp.utility.BottomNavigationViewHelper;

public class MenuActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

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
                        break;
                    case R.id.navigation_history:
                        selectedfragment = new HistoryFragment();
                        break;
                    case R.id.navigation_contact:
                        selectedfragment = new ContactsFragment();
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

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ImageView drawerButton = findViewById(R.id.drawer_button);

        drawerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(Gravity.START);
            }
        });

        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();

                        Fragment selectedfragment = null;
                        switch (menuItem.getItemId()) {
                            case R.id.nav_tentang_skoliosis:
//                                ScrollView scrollView = (ScrollView) findViewById(R.id.title_tentang_skoliosis);
//                                scrollView.smoothScrollTo(0, 500);
                                break;
                            case R.id.nav_penyebab_skoliosis:

                                break;
                            case R.id.nav_resiko_skoliosis:

                                break;
//                            case R.id.nav_fakta:
//
//                                break;
//                            case R.id.nav_tentang_yoga:
//
//                                break;
//                            case R.id.nav_asal_usul:
//
//                                break;
//                            case R.id.nav_yoga_bagi:
//
//                                break;
//                            case R.id.nav_tips:
//
//                                break;
//                            case R.id.nav_nutrisi:
//
//                                break;
                        }
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, selectedfragment).commit();


                        return true;
                    }
                });
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(Gravity.START)) {
            mDrawerLayout.closeDrawers();
            return;
        }
    }
}
