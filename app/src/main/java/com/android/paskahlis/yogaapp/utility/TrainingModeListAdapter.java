package com.android.paskahlis.yogaapp.utility;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.paskahlis.yogaapp.R;

public class TrainingModeListAdapter extends BaseAdapter {
    private final String[] TRAINING_MODES = {
            "POSE GUNUNG DI LANTAI",
            "POSE GUNUNG TERLENTANG",
            "POSE POHON TERLENTANG",
            "POSE KURSI TERLENTANG",
            "POSE WAJAH TELUNGKUP",
            "POSE BENTANGAN TANGAN DAN KAKI",
            "POSE SEGITIGA MEMUTAR",
            "POSE WAJAH ANJING TELUNGKUP",
            "POSE TONGKAT",
            "POSE DUDUK CONDONG KE DEPAN"
    };

    private Context context;

    public TrainingModeListAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return TRAINING_MODES.length;
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
        trainingTitle.setText(TRAINING_MODES[i]);
        return row;
    }
}
