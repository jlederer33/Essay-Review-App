package com.example.astudio.View;

import com.example.astudio.Model.Essay;

public interface IEssaysView {

    interface Listener{
        void onBack();

        void onSubmitEssayClicked(String title, String text, String type);
    }

}
