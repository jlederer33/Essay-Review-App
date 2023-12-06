package com.example.EssayReviewApp.model;

import java.util.ArrayList;
import java.util.List;

/**
 * This model represents all the "dashboards" we will be using in the code. This model will handle all the
 * backend from the View classes. Currently, we only have EssayDashboard. The EssayDashboard has the
 * addToEssayList method. The essayList stores the essays. We will add the collegeList, as well
 * as the removeFromEssayList, addToCollegeList, and removeFromCollegeList in future iterations
 */
public class Dashboards {
    public static List<Essay> userEssayList = new ArrayList<>(); //Where User essays are stored, and what the User recyclerview references

    public static List<Essay> allEssaysList = new ArrayList<>(); //This is the "All Essays" screen, where users can add reviews and the like

    public void addToUserEssayList(String title, String text, String type){
        userEssayList.add(new Essay(title, text, type));
    }

    //public void removeFromEssayList(int position){userEssayList.remove(position);}

    public void removeFromEssayList(Essay essay){
        userEssayList.remove(essay);
    }

    public void submitToAllEssays(Essay essay, int position){
        essay = userEssayList.get(position);
        allEssaysList.add(essay);
        userEssayList.remove(position);
    }


}
