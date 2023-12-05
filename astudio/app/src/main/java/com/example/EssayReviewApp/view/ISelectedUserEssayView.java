package com.example.EssayReviewApp.view;

import com.example.EssayReviewApp.model.Essay;
import com.example.EssayReviewApp.model.Review;

public interface ISelectedUserEssayView {
    interface Listener {
        void onEssaysClicked();
        void onAddReviewClicked(Essay essay);

        void onSelectedReviewClicked(Essay essay, Review review);
    }
}
