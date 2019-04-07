package com.example.kendryayu.kendryayu_1202160048_si4008_pab_modul5;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    SharedPreferences.Editor editor;
    SharedPreferences app_preferences;
    LinearLayout layout;

    int warna;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.layout_main);
        app_preferences = PreferenceManager.getDefaultSharedPreferences(this);

        warna = app_preferences.getInt("pref",0);

        if (warna == 0){
            layout.setBackgroundColor(getResources().getColor(R.color.default_background));
        }
    }

    public void listArticle(View view) {
        Intent ak = new Intent(MainActivity.this,ListArticle.class);
        startActivity(ak);

    }

    public void createArticle(View view) {
        Intent aj = new Intent(MainActivity.this,CreateArticle.class);
        startActivity(aj);
    }

    public void settings(View view) {
        Intent ap = new Intent(MainActivity.this,SettingActivity.class);
        startActivity(ap);
    }
}
