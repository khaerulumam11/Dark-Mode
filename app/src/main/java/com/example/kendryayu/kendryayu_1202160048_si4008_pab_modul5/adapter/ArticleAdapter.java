package com.example.kendryayu.kendryayu_1202160048_si4008_pab_modul5.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kendryayu.kendryayu_1202160048_si4008_pab_modul5.DetailArticle;
import com.example.kendryayu.kendryayu_1202160048_si4008_pab_modul5.R;
import com.example.kendryayu.kendryayu_1202160048_si4008_pab_modul5.model.Article;

import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {
    private List<Article> articleList;
    private Context con;
    int id;
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvTitle, tvAuthor,tvDesc;
        public CardView a;
        public ViewHolder(View itemView) {
            super(itemView);
            tvTitle  = itemView.findViewById(R.id.txt_title);
            tvAuthor   = itemView.findViewById(R.id.txt_author);
            tvDesc   = itemView.findViewById(R.id.txt_description);
            a = itemView.findViewById(R.id.card);
        }
    }
    public ArticleAdapter (Context con, List<Article> listUser){
        this.articleList = listUser;
        this.con = con;
    }

    @Override
    public ArticleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row, parent, false);
        return new ViewHolder(view);
    }

    public void add(Article user){
        articleList.add(user);
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(ArticleAdapter.ViewHolder holder, int position) {
        final Article user = articleList.get(position);
        holder.tvTitle.setText(user.getTitle());
        holder.tvAuthor.setText(user.getAuthor());
        holder.tvDesc.setText(user.getDescription().substring(0,10));
        holder.a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ay = new Intent(con, DetailArticle.class);
                ay.putExtra("id",user.getId());
                con.startActivity(ay);
            }
        });
    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }
}
