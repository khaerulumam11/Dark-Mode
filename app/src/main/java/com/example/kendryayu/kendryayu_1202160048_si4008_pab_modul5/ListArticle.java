package com.example.kendryayu.kendryayu_1202160048_si4008_pab_modul5;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.example.kendryayu.kendryayu_1202160048_si4008_pab_modul5.adapter.ArticleAdapter;
import com.example.kendryayu.kendryayu_1202160048_si4008_pab_modul5.database.DatabaseHelper;
import com.example.kendryayu.kendryayu_1202160048_si4008_pab_modul5.model.Article;
import com.example.kendryayu.kendryayu_1202160048_si4008_pab_modul5.util.SwipeUtilDelete;
import com.example.kendryayu.kendryayu_1202160048_si4008_pab_modul5.util.SwipeUtilEdit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ListArticle extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SQLiteDatabase tampil;
    private DatabaseHelper dataHelper;
    private List<Article> userList;
    ArticleAdapter userAdapter;
    protected Cursor cursor;
    String id;
    protected RecyclerView.LayoutManager mLayoutManager;


    public static final String TAG_ID = "id";
    public static final String TAG_TITLE = "title";
    public static final String TAG_AUTHOR = "author";
    public static final String TAG_DESC = "description";
    public static final String TAG_CREATED = "description";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_article);

        dataHelper  =  new DatabaseHelper(getApplicationContext());
        tampil      = dataHelper.getReadableDatabase();

        recyclerView                = (RecyclerView) findViewById(R.id.rv);
        userList                    = new ArrayList<>();


        mLayoutManager              = new LinearLayoutManager(this);

        userAdapter                 = new ArticleAdapter(this,userList);
        recyclerView.setLayoutManager(mLayoutManager);

        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(userAdapter);

        dataUser();

        setSwipeForRecyclerView();


    }

    private void dataUser() {
        ArrayList<HashMap<String, String>> row = dataHelper.getAllData();
        for (int i = 0; i < row.size(); i++) {
            id = row.get(i).get(TAG_ID);
            String title = row.get(i).get(TAG_TITLE);
            String author = row.get(i).get(TAG_AUTHOR);
            String desk = row.get(i).get(TAG_DESC);
//            String create = row.get(i).get(TAG_CREATED);

            Article data = new Article();

            data.setId(id);
            data.setTitle(title);
            data.setAuthor(author);
            data.setDescription(desk);

            userList.add(data);
        }

        userAdapter.notifyDataSetChanged();
    }

    private void setSwipeForRecyclerView() {
        SwipeUtilDelete swipeHelper = new SwipeUtilDelete(0, ItemTouchHelper.LEFT, this) {
            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                final int position = viewHolder.getAdapterPosition();
                ArticleAdapter adapter = (ArticleAdapter) recyclerView.getAdapter();

                dataHelper.delete(Integer.parseInt(userList.get(position).getId()));

                userList.clear();
                dataUser();
                userAdapter.notifyDataSetChanged();
            }
        };

        ItemTouchHelper mItemTouchHelper = new ItemTouchHelper(swipeHelper);
        mItemTouchHelper.attachToRecyclerView(recyclerView);
        swipeHelper.setLeftcolorCode(ContextCompat.getColor(this, R.color.colorRed));

        SwipeUtilEdit swipeHelper1 = new SwipeUtilEdit(0, ItemTouchHelper.RIGHT, this) {
            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                final int position = viewHolder.getAdapterPosition();

                ArticleAdapter adapter = (ArticleAdapter) recyclerView.getAdapter();

                Intent pindah = new Intent(ListArticle.this,UpdateArticle.class);
                pindah.putExtra("id",id);
                startActivity(pindah);
                finish();

                adapter.notifyDataSetChanged();

            }
        };

        ItemTouchHelper mItemTouchHelper1 = new ItemTouchHelper(swipeHelper1);
        mItemTouchHelper1.attachToRecyclerView(recyclerView);
        swipeHelper1.setLeftcolorCode(ContextCompat.getColor(this, R.color.hijau));
    }


    }

