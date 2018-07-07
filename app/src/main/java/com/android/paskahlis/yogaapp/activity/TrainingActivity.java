package com.android.paskahlis.yogaapp.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.paskahlis.yogaapp.R;
import com.android.paskahlis.yogaapp.utility.TrainingModeListAdapter;

public class TrainingActivity extends AppCompatActivity {
    private Activity activity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);

        TrainingModeListAdapter adapter = new TrainingModeListAdapter(this);
        ListView trainingModeListView = (ListView) findViewById(R.id.training_mode_list_view);
        trainingModeListView.setAdapter(adapter);
        trainingModeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        startActivity(new Intent(activity, PoseGunungLantaiActivity.class));
                }
            }
        });
    }
}
