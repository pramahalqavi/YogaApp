package com.android.paskahlis.yogaapp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.android.paskahlis.yogaapp.R;
import com.android.paskahlis.yogaapp.utility.TrainingModeListAdapter;

public class TrainingActivity extends AppCompatActivity {
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

    private ListView trainingModeListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);


        TrainingModeListAdapter adapter = new TrainingModeListAdapter(this, TRAINING_MODES);
        trainingModeListView = (ListView) findViewById(R.id.training_mode_list_view);
        trainingModeListView.setAdapter(adapter);
    }
}
