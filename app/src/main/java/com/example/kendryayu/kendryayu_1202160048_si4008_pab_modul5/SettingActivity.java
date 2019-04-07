package com.example.kendryayu.kendryayu_1202160048_si4008_pab_modul5;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

public class SettingActivity extends AppCompatActivity {

    int mColor,mAA;

    int warna,warna1;

    // Key for current color
    private final String COLOR_KEY = "color";

    // Shared preferences object
    private SharedPreferences mPreferences;
    // Name of shared preferences file
    private static final String mSharedPrefFile = "com.example.kendryayu.kendryayu_1202160048_pab_modul5";

    SharedPreferences.Editor preferencesEditor;
    TextView txttema,txtsize,jdul;
    Switch swtema,swsize;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        txttema = findViewById(R.id.modetema);
        txtsize = findViewById(R.id.modesize);
        jdul = findViewById(R.id.set);
        swtema = findViewById(R.id.switchtema);
        swsize = findViewById(R.id.switchsize);

        linearLayout = findViewById(R.id.layout_setting);
        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mColor = mPreferences.getInt("pref", 0);
        mAA = mColor;

        if (mAA != 0){
            linearLayout.setBackgroundColor(getResources().getColor(R.color.black));
            txttema.setTextColor(getResources().getColor(R.color.default_background));
            txtsize.setTextColor(getResources().getColor(R.color.default_background));
            jdul.setTextColor(getResources().getColor(R.color.default_background));

        } else {
            txttema.setTextColor(getResources().getColor(R.color.black));
            txtsize.setTextColor(getResources().getColor(R.color.black));
            jdul.setTextColor(getResources().getColor(R.color.black));

            linearLayout.setBackgroundColor(getResources().getColor(R.color.default_background));


        }

        SharedPreferences pref = getApplicationContext().getSharedPreferences("pref", 0);

        preferencesEditor = pref.edit();

        warna = pref.getInt("background",R.color.black);
        warna1 = pref.getInt("background",R.color.default_background);



    }

    public void save(View view) {

        if (swtema.isChecked()==true){
            SharedPreferences pref = getApplicationContext().getSharedPreferences("pref", 0);

            preferencesEditor = pref.edit();

            warna = pref.getInt("background",R.color.black);
            preferencesEditor.putInt("background", warna);
            preferencesEditor.commit();

//
//            txttema.setTextColor(getResources().getColor(R.color.default_background));
//            txtsize.setTextColor(getResources().getColor(R.color.default_background));
//            jdul.setTextColor(getResources().getColor(R.color.default_background));
//
//            linearLayout.setBackgroundColor(getResources().getColor(R.color.black));

//            Intent pindah = new Intent(SettingActivity.this,MainActivity.class);
//            startActivity(pindah);
        } else {
            SharedPreferences pref = getApplicationContext().getSharedPreferences("pref", 0);

            preferencesEditor = pref.edit();

            warna = pref.getInt("background",R.color.default_background);
            preferencesEditor.putInt("background",warna);
            preferencesEditor.commit();


//            txttema.setTextColor(getResources().getColor(R.color.black));
//            txtsize.setTextColor(getResources().getColor(R.color.black));
//            jdul.setTextColor(getResources().getColor(R.color.black));
//
//            linearLayout.setBackgroundColor(getResources().getColor(R.color.default_background));


//            Intent pindah1 = new Intent(SettingActivity.this,MainActivity.class);
//            startActivity(pindah1);
        }
    }

}
