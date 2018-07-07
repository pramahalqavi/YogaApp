package com.android.paskahlis.yogaapp.fragment;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.android.paskahlis.yogaapp.R;
import com.android.paskahlis.yogaapp.activity.MenuActivity;

/**
 * Created by Prama LH on 07-May-18.
 */

public class ArticlesFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_articles, container, false);
        final ImageView drawerButton = (ImageView) rootView.findViewById(R.id.drawer_button);

        final MenuActivity activity = (MenuActivity) getActivity();
        activity.navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);
                        activity.mDrawerLayout.closeDrawers();
                        ScrollView scrollView;
                        TextView textView;

                        switch (menuItem.getItemId()) {
                            case R.id.nav_tentang_skoliosis:
                                scrollView = (ScrollView) getView().findViewById(R.id.article_scrollview);
                                textView = getView().findViewById(R.id.title_tentang_skoliosis);
                                scrollView.smoothScrollTo(0, Math.round(textView.getY()));
                                break;
                            case R.id.nav_penyebab_skoliosis:
                                scrollView = (ScrollView) getView().findViewById(R.id.article_scrollview);
                                textView = getView().findViewById(R.id.title_penyebab_skoliosis);
                                scrollView.smoothScrollTo(0, Math.round(textView.getY()));
                                break;
                            case R.id.nav_resiko_skoliosis:
                                scrollView = (ScrollView) getView().findViewById(R.id.article_scrollview);
                                textView = getView().findViewById(R.id.title_resiko_skoliosis);
                                scrollView.smoothScrollTo(0, Math.round(textView.getY()));
                                break;
                            case R.id.nav_fakta:
                                scrollView = (ScrollView) getView().findViewById(R.id.article_scrollview);
                                textView = getView().findViewById(R.id.title_fakta);
                                scrollView.smoothScrollTo(0, Math.round(textView.getY()));
                                break;
                            case R.id.nav_tentang_yoga:
                                scrollView = (ScrollView) getView().findViewById(R.id.article_scrollview);
                                textView = getView().findViewById(R.id.title_tentang_yoga);
                                scrollView.smoothScrollTo(0, Math.round(textView.getY()));
                                break;
                            case R.id.nav_asal_usul:
                                scrollView = (ScrollView) getView().findViewById(R.id.article_scrollview);
                                textView = getView().findViewById(R.id.title_asal_usul);
                                scrollView.smoothScrollTo(0, Math.round(textView.getY()));
                                break;
                            case R.id.nav_yoga_bagi:
                                scrollView = (ScrollView) getView().findViewById(R.id.article_scrollview);
                                textView = getView().findViewById(R.id.title_yoga_bagi);
                                scrollView.smoothScrollTo(0, Math.round(textView.getY()));
                                break;
                            case R.id.nav_tips:
                                scrollView = (ScrollView) getView().findViewById(R.id.article_scrollview);
                                textView = getView().findViewById(R.id.title_tips);
                                scrollView.smoothScrollTo(0, Math.round(textView.getY()));
                                break;
                            case R.id.nav_nutrisi:
                                scrollView = (ScrollView) getView().findViewById(R.id.article_scrollview);
                                textView = getView().findViewById(R.id.title_nutrisi);
                                scrollView.smoothScrollTo(0, Math.round(textView.getY()));
                                break;
                        }
                        return true;
                    }
                });

        drawerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.mDrawerLayout.openDrawer(Gravity.START);
            }
        });
        return rootView;
    }


}
