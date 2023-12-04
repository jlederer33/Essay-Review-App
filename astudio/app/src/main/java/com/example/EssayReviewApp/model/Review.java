package com.example.EssayReviewApp.model;

public class Review{
    /**
     * This class represents the reviews given to the essay. They are composed of String title and
     * String text
     */
    String title;
    String text;

    public Review(String text, String title){
        this.title = title;
        this.text = text;
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


}

