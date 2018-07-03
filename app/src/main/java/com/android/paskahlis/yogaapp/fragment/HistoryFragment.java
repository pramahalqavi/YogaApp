package com.android.paskahlis.yogaapp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.paskahlis.yogaapp.R;

/**
 * Created by Prama LH on 07-May-18.
 */

public class HistoryFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_history, container, false);
        return rootView;
    }
}
