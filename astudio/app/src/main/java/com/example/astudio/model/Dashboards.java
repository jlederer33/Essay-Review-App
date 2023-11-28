package com.example.astudio.model;

import java.util.ArrayList;
import java.util.List;

/**
 * This model represents all the "dashboards" we will be using in the code. This model will handle all the
 * backend from the View classes. Currently, we only have EssayDashboard. The EssayDashboard has the
 * addToEssayList method. The essayList stores the essays. We will add the collegeList, as well
 * as the removeFromEssayList, addToCollegeList, and removeFromCollegeList in future iterations
 */
public class Dashboards {
    public static List<Essay> essayList = new ArrayList<>(); //Where essays are stored, and what the recyclerview references

    public void addToEssayList(String title, String text, String type){
        essayList.add(new Essay(title, text, type));
    }

    public void removeFromEssayList(int position){
        essayList.remove(position);

    }
}
