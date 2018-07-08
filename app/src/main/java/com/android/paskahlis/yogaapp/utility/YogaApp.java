package com.android.paskahlis.yogaapp.utility;

import android.app.Application;
import android.content.Context;

import com.android.paskahlis.yogaapp.R;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class YogaApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/comfortaa-regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }
}
