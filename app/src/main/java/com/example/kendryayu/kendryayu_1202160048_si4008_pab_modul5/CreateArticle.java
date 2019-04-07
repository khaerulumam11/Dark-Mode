package com.example.kendryayu.kendryayu_1202160048_si4008_pab_modul5;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.kendryayu.kendryayu_1202160048_si4008_pab_modul5.database.DatabaseHelper;
import com.example.kendryayu.kendryayu_1202160048_si4008_pab_modul5.model.Article;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CreateArticle extends AppCompatActivity {

    TextInputLayout mTitle, mArticle, mAuthors;

    DatabaseHelper sqlite = new DatabaseHelper(this);

    private SQLiteDatabase tulis;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_article);

        mTitle = findViewById(R.id.title);
        mArticle = findViewById(R.id.article);
        mAuthors = findViewById(R.id.author);

        tulis       = sqlite.getWritableDatabase();
    }

    public void post(View view) {

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat mdformat = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss");
        String strDate = mdformat.format(new Date());

        String xTitle = mTitle.getEditText().getText().toString();
        String xArticle = mArticle.getEditText().getText().toString();
        String xAuthors = mAuthors.getEditText().getText().toString();



        sqlite.insert(xTitle.trim(),xAuthors.trim(),xArticle.trim(),strDate);

        Toast.makeText(this, "Data Berhasil Masuk", Toast.LENGTH_SHORT).show();

        Intent a = new Intent(CreateArticle.this,MainActivity.class);
        startActivity(a);

    }
}
