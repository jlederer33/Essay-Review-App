package com.example.EssayReviewApp.model;

import java.util.ArrayList;
import java.util.List;

public class Essay {
    /**
     * This class represents the Essays created by the user. They are composed of String title, string text
     * and type.
     */

    String title;
    String text;
    String type;

    public List<Review> reviewList = new ArrayList<>(); // this list holds the Reviews for both storage and the recyclerview

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
    } //returns the number of reviews based on the size

    public void addReview(String title, String text){ //adds a review to the Essay's reviewList
        reviewList.add(new Review(title, text));
    }
}
