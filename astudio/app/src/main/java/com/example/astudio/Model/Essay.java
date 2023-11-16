package com.example.astudio.Model;

public class Essay {

    String title;
    String text;

    String type;

    public Essay(String title, String text, String type){
        this.title = title;
        this.text = text;
        this.type = type;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
