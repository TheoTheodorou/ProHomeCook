package com.example.phc.models;

public class Recipe {
    public String rid;
    public String title;

    public Recipe(String rid, String title) {
        this.rid = rid;
        this.title = title;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
