package com.classy.class_2021a_and_4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.donkey.dolly.Dolly;
import com.google.gson.Gson;

import java.util.Random;

import static com.classy.class_2021a_and_4.Constants.SP_FILE;

public class Activity_Main extends Activity_Base {

    private MainViewController mainViewController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        isDoubleBackPressToClose = true;


        mainViewController = new MainViewController(this);
        mainViewController.updateTitle("Guy");
        mainViewController.updateBackground(R.drawable.img_poker_table);

        /*
        SharedPreferences prefs = getSharedPreferences(SP_FILE, MODE_PRIVATE);

        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("name", "Elena");
        editor.putInt("idName", 12);
        editor.apply();

        String name = prefs.getString("name", "No name defined");//"No name defined" is the default value.
        int idName = prefs.getInt("idName", -1); //0 is the default value.
        String car = prefs.getString("car", "NA"); //0 is the default value.


        Log.d("pttt", "name= " + name);
        Log.d("pttt", "idName= " + idName);
        Log.d("pttt", "car= " + car);
         */


        SharedPreferences prefs = getSharedPreferences(SP_FILE, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();

        TopTen topTen = generateData();
        String json = gson.toJson(topTen);
        editor.putString("TopTen", json);


        String jsonFromMemory = prefs.getString("TopTen", "");
        TopTen topTenFromMemory = gson.fromJson(jsonFromMemory, TopTen.class);

    }

    private TopTen generateData() {
        TopTen topTen = new TopTen();
        for (int i = 0; i < 10; i++) {
            Record r = new Record()
                    .setDate(System.currentTimeMillis() - (i * 1000l * 60 * 60 *24))
                    .setName("Or"+i)
                    .setScore(new Random().nextInt(100));

            topTen.getRecords().add(r);
        }
        return topTen;
    }

}