package com.classy.class_2021a_and_4;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class MainViewController {

    private AppCompatActivity activity;

    private TextView main_LBL_title;
    private Button main_BTN_update;
    private ImageView main_IMG_background;

    public MainViewController(AppCompatActivity activity) {
        this.activity = activity;
        findViews(activity);
    }

    private void findViews(AppCompatActivity activity) {
        main_LBL_title = activity.findViewById(R.id.main_LBL_title);
        main_BTN_update = activity.findViewById(R.id.main_BTN_update);
        main_IMG_background = activity.findViewById(R.id.main_IMG_background);
    }

    public void updateTitle(String str) {
        main_LBL_title.setText(str);
    }

    public void updateBackground(int id) {
        Glide
                .with(activity)
                .load(id)
                .into(main_IMG_background);
    }
}
