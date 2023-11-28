package com.example.astudio.controller;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.astudio.model.Dashboards;
import com.example.astudio.view.EssayDashboardFragment;
import com.example.astudio.view.IEssaysView;
import com.example.astudio.view.IMainView;
import com.example.astudio.view.IMenuView;
import com.example.astudio.view.MainMenuFragment;
import com.example.astudio.view.MainView;

public class Controller extends AppCompatActivity implements IMenuView.Listener, IEssaysView.Listener {
    IMainView mainView;
    Dashboards Dashboard = new Dashboards();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mainView = new MainView(this);

        MainMenuFragment mainMenuFragment = new MainMenuFragment(this);
        this.mainView.displayFragment(mainMenuFragment, false, "main menu");

        setContentView(this.mainView.getRootView());
    }

    @Override
    public void onEssaysClicked() {
        Fragment essayView = new EssayDashboardFragment(this);
        this.mainView.displayFragment(essayView, false, "essay dashboard");
    }

    @Override
    public void onReviewsClicked(){
        //Fragment reviewerView = new ReviewEssaysFragment(this);
    }

    @Override
    public void onBack() {
        MainMenuFragment mainMenu = new MainMenuFragment(this);
        this.mainView.displayFragment(mainMenu,false,"main menu");
    }

    /**
     * Registers when the submit button is essays view is clicked, and passes the information to
     * Dashboard
     * @param title
     * @param text
     * @param type
     * @param view
     */

    @Override
    public void onSubmitEssayClicked(String title, String text, String type, IEssaysView view) {
        Dashboard.addToEssayList(title, text, type);
        view.updateEssaysDisplay();
    }


}
