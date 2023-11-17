package com.example.astudio.View;


public interface IEssaysView {

    interface Listener{
        void onBack();

        void onSubmitEssayClicked(String title, String text, String type, IEssaysView view);
    }

    void updateEssaysDisplay();

}
