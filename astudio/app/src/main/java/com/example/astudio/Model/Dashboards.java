package com.example.astudio.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * This model represents all the "dashboards" we will be using in the code. Currently, we only
 * have EssayDashboard. The EssayDashboard has the addToEssayList and removeFromEssayList methods,
 * which are self explanatory.
 */
public class Dashboards {
    public List essayList = new ArrayList<>();

    public void addToEssayList(String title, String text, String type){
        essayList.add(new Essay(title, text, type));
    }
}
