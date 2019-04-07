package com.example.kendryayu.kendryayu_1202160048_si4008_pab_modul5;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.kendryayu.kendryayu_1202160048_si4008_pab_modul5.database.DatabaseHelper;

public class DetailArticle extends AppCompatActivity {

    TextView a,b,c;
    String ak;
    private Cursor cursor;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_article);

        databaseHelper = new DatabaseHelper(this);
        ak = getIntent().getStringExtra("id");

        a = findViewById(R.id.judul);
        b = findViewById(R.id.pengarang);
        c = findViewById(R.id.deskripsi);
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM Article_Table WHERE id = '" +
                ak + "'",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0){
            cursor.moveToPosition(0);
            a.setText(cursor.getString(1).toString());
            b.setText(cursor.getString(2).toString()+" "+cursor.getString(4).toString());
            c.setText(cursor.getString(3).toString());
        }
    }
}
