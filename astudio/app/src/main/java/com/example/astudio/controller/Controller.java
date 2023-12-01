package com.example.astudio.controller;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.astudio.model.Dashboards;
import com.example.astudio.model.Essay;
import com.example.astudio.view.AllEssaysFragment;
import com.example.astudio.view.IAllEssaysView;
import com.example.astudio.view.ISelectedEssayView;
import com.example.astudio.view.SelectedEssayFragment;
import com.example.astudio.view.UserEssaysFragment;
import com.example.astudio.view.IUserEssaysView;
import com.example.astudio.view.IMainView;
import com.example.astudio.view.IMenuView;
import com.example.astudio.view.MainMenuFragment;
import com.example.astudio.view.MainView;

public class Controller extends AppCompatActivity implements IMenuView.Listener, IUserEssaysView.Listener, IAllEssaysView.Listener, ISelectedEssayView.Listener {
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

    /**
     * These are the methods displayed in the main menu fragment
     */
    @Override
    public void onEssaysClicked() {
        Fragment essayView = new UserEssaysFragment(this);
        this.mainView.displayFragment(essayView, false, "user essay dashboard");
    }

    @Override
    public void onAllEssaysClicked() {
        Fragment allEssaysView = new AllEssaysFragment(this);
        this.mainView.displayFragment(allEssaysView,false, "all essays dashboard");
    }

    @Override
    public void onBack() {
        MainMenuFragment mainMenu = new MainMenuFragment(this);
        this.mainView.displayFragment(mainMenu,false,"main menu");
    }

    @Override
    public void onSubmitEssayClicked(String title, String text, String type, IUserEssaysView view) {
        /**
         * Registers when the submit button is essays view is clicked, and passes the information to
         * Dashboard
         * @param title
         * @param text
         * @param type
         * @param view
         */
        Dashboard.addToEssayList(title, text, type);
        view.updateEssaysDisplay();
    }

    @Override
    public void onDeleteEssayClicked(int position, IUserEssaysView view){
        Dashboard.removeFromEssayList(position);
        view.updateEssaysDisplay();
    }


    @Override
    public void onUserEssayClicked(Essay essay) {
        SelectedEssayFragment selectedEssay = new SelectedEssayFragment(this, essay);
        this.mainView.displayFragment(selectedEssay, false, "Selected Essay");
    }

}
