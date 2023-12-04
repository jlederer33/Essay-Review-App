package com.example.EssayReviewApp.view;

import com.example.EssayReviewApp.model.Essay;
import com.example.EssayReviewApp.model.Review;

public interface IAddReviewsView {
    interface Listener {
        void onSubmitReviewClicked(Essay essay, String title, String text);

        void onUserEssayClicked(Essay essay);
    }

}
