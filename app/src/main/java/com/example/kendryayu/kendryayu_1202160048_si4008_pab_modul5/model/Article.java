package com.example.kendryayu.kendryayu_1202160048_si4008_pab_modul5.model;

public class Article {

    private String id,title,author,description,created;

    public Article(){}

    public Article(String id, String title, String author, String description, String created){

        this.id = id;
        this.title = title;
        this.author = author;
        this.description = description;
        this.created = created;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }
}
