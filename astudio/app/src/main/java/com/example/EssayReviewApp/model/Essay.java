package com.example.EssayReviewApp.model;

import java.util.ArrayList;
import java.util.List;

public class Essay {

    String title;
    String text;
    String type;

    public List<Review> reviewList = new ArrayList<>();

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

    public String getType() {return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int numOfReviews(){
        return reviewList.size();
    }

    public void addReview(String title, String text){ //adds a review to the Essay
        reviewList.add(new Review(title, text));
    }
}
