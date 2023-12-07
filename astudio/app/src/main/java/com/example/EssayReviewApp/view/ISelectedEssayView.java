package com.example.EssayReviewApp.view;

import com.example.EssayReviewApp.model.Essay;
import com.example.EssayReviewApp.model.Review;

public interface ISelectedEssayView {
        interface Listener {
            void onUserEssaysClicked();
            void onAllEssaysClicked();
            void onAddReviewClicked(Essay essay);

            void onSubmitToAllEssaysClicked(Essay essay);
            void onSelectedReviewClicked(Essay essay, Review review);
        }
}
