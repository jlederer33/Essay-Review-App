package com.example.EssayReviewApp;

import com.example.EssayReviewApp.model.Essay;
import com.example.EssayReviewApp.model.Review;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Map;

public class EssayTest {
    //Test Constructor
    @Test
    public void testEssayConstructor() {
        String title = "Sample Title";
        String text = "Sample Text";
        String type = "Sample Type";
        Essay essay = new Essay(title, text, type);

        assertEquals("Title should match", title, essay.getTitle());
        assertEquals("Text should match", text, essay.getText());
        assertEquals("Type should match", type, essay.getType());
        assertNotNull("ID should not be null", essay.id);
    }

    //Test getters and setters
    @Test
    public void testGettersAndSetters() {
        Essay essay = new Essay("Initial Title", "Initial Text", "Initial Type");

        String newTitle = "New Title";
        essay.setTitle(newTitle);
        assertEquals("Title should be updated", newTitle, essay.getTitle());

        String newText = "New Text";
        essay.setText(newText);
        assertEquals("Text should be updated", newText, essay.getText());

        String newType = "New Type";
        essay.setType(newType);
        assertEquals("Type should be updated", newType, essay.getType());
    }

    //Test "numOfReviews" and "addReviews"
    @Test
    public void testAddReview() {
        Essay essay = new Essay("Title", "Text", "Type");
        assertEquals("Initial number of reviews should be 0", 0, essay.numOfReviews());

        essay.addReview("Review Title", "Review Text");
        assertEquals("Number of reviews should be 1 after adding a review", 1, essay.numOfReviews());
    }

    //Test "deleteReviews"
    @Test
    public void testDeleteReview() {
        Essay essay = new Essay("Title", "Text", "Type");
        Review review = new Review(essay.id, "Review Title", "Review Text");
        essay.addReview("Review Title", "Review Text");

        essay.deleteReview(review);
        assertEquals("Number of reviews should be 0 after deleting a review", 1, essay.numOfReviews());
    }

    //Test "toMap" and "fromMap"
    @Test
    public void testToMapAndFromMap() {
        Essay originalEssay = new Essay("Title", "Text", "Type");
        originalEssay.addReview("Review Title", "Review Text");

        Map<String, Object> essayMap = originalEssay.toMap();
        Essay reconstructedEssay = Essay.fromMap(essayMap);

        assertEquals("Title should match after reconstruction", originalEssay.getTitle(), reconstructedEssay.getTitle());
        assertEquals("Text should match after reconstruction", originalEssay.getText(), reconstructedEssay.getText());
        assertEquals("Type should match after reconstruction", originalEssay.getType(), reconstructedEssay.getType());
        assertEquals("Number of reviews should match after reconstruction", originalEssay.numOfReviews(), reconstructedEssay.numOfReviews());
    }


}
