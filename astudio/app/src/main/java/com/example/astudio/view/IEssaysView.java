package com.example.astudio.view;

/**
 * The interface for the view of EssayDashboardFragment.
 */
public interface IEssaysView {

    interface Listener{
        void onBack();

        void onSubmitEssayClicked(String title, String text, String type, IEssaysView view);
    }

    void updateEssaysDisplay();

}
