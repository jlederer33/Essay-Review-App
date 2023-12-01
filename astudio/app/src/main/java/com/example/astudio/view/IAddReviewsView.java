package com.example.astudio.view;

import com.example.astudio.model.Essay;
import com.example.astudio.model.Review;

public interface IAddReviewsView {
    interface Listener {
        void onSubmitReviewClicked(Essay essay, Review review, ISelectedEssayView view);
    }

}
