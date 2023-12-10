package com.example.EssayReviewApp.persistence;

import androidx.annotation.NonNull;

import com.example.EssayReviewApp.model.Dashboards;
import com.example.EssayReviewApp.model.Essay;


public interface IPersistenceFacade {

    interface Listener{
        void onEssaysRecieved(@NonNull Dashboards dashboard);
    }

    void saveUserEssay(@NonNull Essay Essay);
    void saveAllEssay(@NonNull Essay essay);

    public void removeUserEssay(Essay essay);

    void retrieveEssays(@NonNull Listener listener);
}


