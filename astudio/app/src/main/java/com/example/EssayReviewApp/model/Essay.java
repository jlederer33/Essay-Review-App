package com.example.EssayReviewApp.model;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.example.EssayReviewApp.persistence.FirestoreFacade;
import com.example.EssayReviewApp.view.SelectedEssayFragment;

public class Essay implements java.io.Serializable {
    /**
     * This class represents the Essays created by the user. They are composed of String title, string text
     * and type. The UUID helps determine essay type
     */

    String title;
    String text;
    String type;

    public UUID id;
    public boolean inAllEssays = false; // This is to determine if an essay is in the All Essays list, allowing access to the add reviews functionality

    private static final String TITLE = "title";
    private static final String TEXT = "text";
    private static final String TYPE = "type";
    private static final String INALLESSAYS = "inAllEssays";
    private static final String ID = "id";
    private static final String REVIEWS = "reviews";



    public List<Review> reviewList = new ArrayList<>(); // this list holds the Reviews for both storage and the recyclerview

    public Essay(String title, String text, String type){
        this.title = title;
        this.text = text;
        this.type = type;
        this.id = UUID.randomUUID();
    }

    public Essay(String title, String text, String type, UUID id){
        this.title = title;
        this.text = text;
        this.type = type;
        this.id = id;
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
        reviewList.add(new Review(id, title, text));
    } //adds a review to the respective essay

    public void deleteReview(Review review){
        reviewList.remove(review);
    } //deletes a chosen review from the essay

    @NonNull
    public Map<String, Object> toMap(){
        Map<String, Object> map = new HashMap<>();

        //write essays
        map.put(TITLE, this.title);
        map.put(TEXT, this.text);
        map.put(TYPE, this.type);
        map.put(INALLESSAYS, this.inAllEssays);
        map.put(ID, this.id.toString());

        List<Map<String, Object>> reviewLinkedList = new LinkedList<>();
        for(Review review : this.reviewList)
            reviewLinkedList.add(review.toMap());
        map.put(REVIEWS, reviewLinkedList);


        return map;
    }

    @NonNull
    public static Essay fromMap(@NonNull Map<String,Object> map){
        String title = (String)map.get(TITLE);
        String text = (String)map.get(TEXT);
        String type = (String)map.get(TYPE);

        String essayIDString = (String)map.get(ID);
        UUID id = UUID.fromString(essayIDString);

        Essay essay = new Essay(title, text, type);
        essay.id = id;
        essay.inAllEssays = (Boolean)map.get(INALLESSAYS);



        List<Map<String, Object>> reviewsList = (List<Map<String, Object>>) map.get(REVIEWS);
        for(Map<String, Object> reviewMap : reviewsList)
            essay.reviewList.add(Review.fromMap(reviewMap));
        return essay;

    }

    public void launchInContainer(Class<SelectedEssayFragment> selectedEssayFragmentClass, Object o) {
    }
}
