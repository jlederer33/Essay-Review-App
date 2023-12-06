package com.example.EssayReviewApp.view;

import com.example.EssayReviewApp.model.Essay;

public interface IAllEssaysView {

    interface Listener {
        void onBack();

        void onEssayClicked(Essay essay);
    }
}
