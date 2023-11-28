package com.example.astudio.view;

/**
 * The interface for the view of EssayDashboardFragment.
 */
public interface IUserEssaysView {

    interface Listener{
        void onBack();

        void onSubmitEssayClicked(String title, String text, String type, IUserEssaysView view);

        void onDeleteEssayClicked(int position, IUserEssaysView view);
    }

    void updateEssaysDisplay();

}
