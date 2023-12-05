package com.example.EssayReviewApp.view;

import com.example.EssayReviewApp.model.Essay;
import com.example.EssayReviewApp.model.Review;

public interface ISelectedReviewView {
    interface Listener {
        void backToSelectedEssay(Essay essay);
    }
}
