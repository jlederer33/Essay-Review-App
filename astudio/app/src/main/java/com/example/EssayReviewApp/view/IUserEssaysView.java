package com.example.EssayReviewApp.view;

import com.example.EssayReviewApp.model.Essay;

/**
 * The interface for the view of EssayDashboardFragment.
 */
public interface IUserEssaysView {

    interface Listener{
        void onBack();

        void onSubmitEssayClicked(String title, String text, String type, IUserEssaysView view);

        void onDeleteEssayClicked(Essay essay, IUserEssaysView view);

        void onUserEssayClicked(Essay essay);
    }

    void updateEssaysDisplay();

}
