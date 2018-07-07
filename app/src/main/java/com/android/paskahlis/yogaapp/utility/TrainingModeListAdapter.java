package com.android.paskahlis.yogaapp.utility;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.paskahlis.yogaapp.R;

public class TrainingModeListAdapter extends BaseAdapter {
    private Context context;
    private String[] trainingModes;

    public TrainingModeListAdapter(Context context, String[] trainingModes) {
        this.context = context;
        this.trainingModes = trainingModes;
    }

    @Override
    public int getCount() {
        return trainingModes.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(R.layout.training_mode_list_item, viewGroup, false);
        TextView trainingTitle = (TextView) row.findViewById(R.id.training_title_text_view);
        trainingTitle.setText(trainingModes[i]);
        return row;
    }
}
