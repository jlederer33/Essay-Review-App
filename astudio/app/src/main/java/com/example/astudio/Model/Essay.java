package com.example.astudio.Model;

public class Essay {

    String title;
    String text;

    EssayTypes type;

    public Essay(String title, String text, EssayTypes type){
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

    public EssayTypes getType() {
        return type;
    }

    public void setType(EssayTypes type) {
        this.type = type;
    }
}
