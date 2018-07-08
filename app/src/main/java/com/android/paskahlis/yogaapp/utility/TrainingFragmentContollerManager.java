package com.android.paskahlis.yogaapp.utility;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.paskahlis.yogaapp.R;
import com.android.paskahlis.yogaapp.activity.MenuActivity;
import com.android.paskahlis.yogaapp.fragment.history.training.PoseBentanganTanganKakiFragment;
import com.android.paskahlis.yogaapp.fragment.history.training.PoseDudukCondongDepanFragment;
import com.android.paskahlis.yogaapp.fragment.history.training.PoseGunungLantaiFragment;
import com.android.paskahlis.yogaapp.fragment.history.training.PoseGunungTerlentangFragment;
import com.android.paskahlis.yogaapp.fragment.history.training.PoseKursiTerlentangFragment;
import com.android.paskahlis.yogaapp.fragment.history.training.PosePohonTerlentangFragment;
import com.android.paskahlis.yogaapp.fragment.history.training.PoseSegitigaMemutarFragment;
import com.android.paskahlis.yogaapp.fragment.history.training.PoseTongkatFragment;
import com.android.paskahlis.yogaapp.fragment.history.training.PoseWajahAnjingTerlungkupFragment;
import com.android.paskahlis.yogaapp.fragment.history.training.PoseWajahTerlungkupFragment;

import java.util.ArrayList;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

public class TrainingFragmentContollerManager {
    private final Fragment[] FRAGMENTS = {
            new PoseGunungLantaiFragment(),
            new PoseGunungTerlentangFragment(),
            new PosePohonTerlentangFragment(),
            new PoseKursiTerlentangFragment(),
            new PoseWajahTerlungkupFragment(),
            new PoseBentanganTanganKakiFragment(),
            new PoseSegitigaMemutarFragment(),
            new PoseWajahAnjingTerlungkupFragment(),
            new PoseTongkatFragment(),
            new PoseDudukCondongDepanFragment()
    };

    private ArrayList<String> fragmentsClassName = new ArrayList<>();
    private int position;
    private Fragment currentFragment;
    private MenuActivity activity;
    private View view;
    private ImageView backButton;
    private ImageView previousButton;
    private ImageView nextButton;
    private ImageView playPauseButton;
    private GifImageView gifTutorial;

    private View.OnClickListener playPauseButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            GifDrawable gifDrawable = (GifDrawable) gifTutorial.getDrawable();
            Resources res = activity.getResources();
            if (gifDrawable.isPlaying()) {
                gifDrawable.pause();
                playPauseButton.setImageDrawable(res.getDrawable(R.drawable.ic_play_circle_outline));
                return;
            }
            playPauseButton.setImageDrawable(res.getDrawable(R.drawable.ic_pause_circle_outline));
            gifDrawable.start();
        }
    };

    private View.OnClickListener previousButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (position == 0) {
                Toast.makeText(activity, "Tidak ada panduan lain sebelum ini", Toast.LENGTH_SHORT).show();
                return;
            }
            activity.replaceFragment(FRAGMENTS[position - 1]);
        }
    };

    private View.OnClickListener nextButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (position == fragmentsClassName.size() - 1) {
                Toast.makeText(activity, "Tidak ada panduan lain setelah ini", Toast.LENGTH_SHORT).show();
                return;
            }
            activity.replaceFragment(FRAGMENTS[position + 1]);
        }
    };

    public TrainingFragmentContollerManager(Context context, View view, Fragment currentFragment) {
        this.activity = (MenuActivity) context;
        this.currentFragment = currentFragment;
        this.view = view;

        for (Fragment fragment : FRAGMENTS) {
            fragmentsClassName.add(fragment.getClass().getSimpleName());
        }

        position = fragmentsClassName.indexOf(currentFragment.getClass().getSimpleName());

        previousButton = (ImageView) view.findViewById(R.id.previous_button);
        nextButton = (ImageView) view.findViewById(R.id.next_button);
        playPauseButton = (ImageView) view.findViewById(R.id.play_pause_button);
        gifTutorial = (GifImageView) view.findViewById(R.id.gif_tutorial);
        backButton = (ImageView) view.findViewById(R.id.back_button);
    }

    public View initController() {
        playPauseButton.setOnClickListener(playPauseButtonListener);
        previousButton.setOnClickListener(previousButtonListener);
        nextButton.setOnClickListener(nextButtonListener);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.onBackPressed();
            }
        });
        return view;
    }
}
