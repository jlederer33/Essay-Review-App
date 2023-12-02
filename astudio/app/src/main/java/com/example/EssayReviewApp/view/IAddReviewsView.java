package com.example.EssayReviewApp.view;

import com.example.EssayReviewApp.model.Essay;
import com.example.EssayReviewApp.model.Review;

public interface IAddReviewsView {
    interface Listener {
        void onSubmitReviewClicked(Essay essay, Review review);

        void onUserEssayClicked(Essay essay);
    }

}
