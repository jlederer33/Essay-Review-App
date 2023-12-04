package com.example.EssayReviewApp.view;

import com.example.EssayReviewApp.model.Essay;

public interface ISelectedEssayView {
    interface Listener {
        void onEssaysClicked();
        void onAddReviewClicked();
    }
}
