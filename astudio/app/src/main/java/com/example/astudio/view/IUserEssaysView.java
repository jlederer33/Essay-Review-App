package com.example.astudio.view;

import com.example.astudio.model.Essay;

/**
 * The interface for the view of EssayDashboardFragment.
 */
public interface IUserEssaysView {

    interface Listener{
        void onBack();

        void onSubmitEssayClicked(String title, String text, String type, IUserEssaysView view);

        void onDeleteEssayClicked(int position, IUserEssaysView view);

        void onUserEssayClicked(Essay essay);
    }

    void updateEssaysDisplay();

}
