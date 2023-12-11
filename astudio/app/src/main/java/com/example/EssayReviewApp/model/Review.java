package com.example.EssayReviewApp.model;

import androidx.annotation.NonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Review implements java.io.Serializable{
    /**
     * This class represents the reviews given to the essay. They are composed of String title and
     * String text
     */
    String title;
    String text;

    private UUID essayID;


    private static final String TITLE = "title";
    private static final String TEXT = "text";
    private static final String ESSAYID = "essayID";

    public Review(UUID essayID, String text, String title){
        this.essayID = essayID;
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

    public Map<String, Object> toMap(){
        Map<String, Object> map = new HashMap<>();
        map.put(ESSAYID, this.essayID.toString());
        map.put(TITLE, this.title);
        map.put(TEXT, this.text);

        return map;
    }

    public static Review fromMap(@NonNull Map<String,Object> map){
        String essayIDString = (String) map.get("essayID");
        UUID essayID = UUID.fromString(essayIDString);
        // bug where retrieving from map switches the title and text
        String title = (String)map.get(TITLE);
        String text = (String)map.get(TEXT);

        return new Review(essayID, title, text);
    }

}

