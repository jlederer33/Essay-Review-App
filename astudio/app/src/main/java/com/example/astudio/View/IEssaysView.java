package com.example.astudio.View;

import com.example.astudio.Model.Essay;
import com.example.astudio.Model.EssayTypes;

public interface IEssaysView {

    interface Listener{

        void onSubmitEssay(String title, String text, EssayTypes type);
    }
    //void onSubmitEssayClicked(IEssaysView view);
}
