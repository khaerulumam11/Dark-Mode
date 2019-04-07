package com.example.kendryayu.kendryayu_1202160048_si4008_pab_modul5;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.kendryayu.kendryayu_1202160048_si4008_pab_modul5.database.DatabaseHelper;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UpdateArticle extends AppCompatActivity {

    TextInputLayout mTitle, mArticle, mAuthors;

    DatabaseHelper sqlite = new DatabaseHelper(this);

    private SQLiteDatabase tulis,read;
    private Cursor cursor;

    String al;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_article);

        mTitle = findViewById(R.id.title);
        mArticle = findViewById(R.id.article);
        mAuthors = findViewById(R.id.author);

        al = getIntent().getStringExtra("id");


        tulis       = sqlite.getWritableDatabase();
        read = sqlite.getReadableDatabase();
        cursor = read.rawQuery("SELECT * FROM Article_Table WHERE id = '" +
                al + "'",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0){
            cursor.moveToPosition(0);
            mTitle.getEditText().setText(cursor.getString(1).toString());
            mArticle.getEditText().setText(cursor.getString(3).toString());
            mAuthors.getEditText().setText(cursor.getString(2).toString());
        }
    }

    public void update(View view) {
        SimpleDateFormat mdformat = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss");
        String strDate = mdformat.format(new Date());

        String xTitle = mTitle.getEditText().getText().toString();
        String xArticle = mArticle.getEditText().getText().toString();
        String xAuthors = mAuthors.getEditText().getText().toString();



        sqlite.update(Integer.parseInt(al),xTitle.trim(),xAuthors.trim(),xArticle.trim(),strDate);

        Toast.makeText(this, "Data Berhasil Diubah", Toast.LENGTH_SHORT).show();

        Intent a = new Intent(UpdateArticle.this,ListArticle.class);
        startActivity(a);
        finish();
    }
}
