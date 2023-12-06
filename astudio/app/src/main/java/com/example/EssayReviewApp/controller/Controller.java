package com.example.EssayReviewApp.controller;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.EssayReviewApp.model.Dashboards;
import com.example.EssayReviewApp.model.Essay;
import com.example.EssayReviewApp.model.Review;
import com.example.EssayReviewApp.view.AddReviewsFragment;
import com.example.EssayReviewApp.view.AllEssaysFragment;
import com.example.EssayReviewApp.view.IAddReviewsView;
import com.example.EssayReviewApp.view.IAllEssaysView;
import com.example.EssayReviewApp.view.ISelectedReviewView;
import com.example.EssayReviewApp.view.ISelectedUserEssayView;
import com.example.EssayReviewApp.view.SelectedReviewFragment;
import com.example.EssayReviewApp.view.SelectedUserEssayFragment;
import com.example.EssayReviewApp.view.UserEssaysFragment;
import com.example.EssayReviewApp.view.IUserEssaysView;
import com.example.EssayReviewApp.view.IMainView;
import com.example.EssayReviewApp.view.IMenuView;
import com.example.EssayReviewApp.view.MainMenuFragment;
import com.example.EssayReviewApp.view.MainView;

public class Controller extends AppCompatActivity implements IMenuView.Listener, IUserEssaysView.Listener, IAllEssaysView.Listener, ISelectedUserEssayView.Listener, IAddReviewsView.Listener, ISelectedReviewView.Listener {
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
    public void onEssaysClicked() { //sets the view to the user essays screen
        Fragment essayView = new UserEssaysFragment(this);
        this.mainView.displayFragment(essayView, false, "user essay dashboard");
    }


    @Override
    public void onAllEssaysClicked() { // sets the view to the all essays screen
        Fragment allEssaysView = new AllEssaysFragment(this);
        this.mainView.displayFragment(allEssaysView,false, "all essays dashboard");
    }

    @Override
    public void onBack() {// sets the view to the Main Menu
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
        Dashboard.addToUserEssayList(title, text, type);
        view.updateEssaysDisplay();
    }

    @Override
    public void onDeleteEssayClicked(Essay essay, IUserEssaysView view){
        Dashboard.removeFromEssayList(essay);
        view.updateEssaysDisplay();
    }


    @Override
    public void onUserEssayClicked(Essay essay) {
        SelectedUserEssayFragment selectedEssay = new SelectedUserEssayFragment(this, essay);
        this.mainView.displayFragment(selectedEssay, false, "Selected User Essay");
    }

    @Override
    public void onAddReviewClicked(Essay essay) {
        AddReviewsFragment addReview = new AddReviewsFragment(this, essay);
        this.mainView.displayFragment(addReview, false, "Add review");
    }


    @Override
    public void onSelectedReviewClicked(Essay essay, Review review) {
        SelectedReviewFragment selectedReview = new SelectedReviewFragment(this, essay, review);
        this.mainView.displayFragment(selectedReview,false,"Selected review");
    }

    /**
     * This Method binds the submit review button to the addReview method in Essays object
     * @param essay
     * @param title
     * @param text
     */
    @Override
    public void onSubmitReviewClicked(Essay essay, String title, String text) {
        essay.addReview(title, text);
        SelectedUserEssayFragment selectedEssay = new SelectedUserEssayFragment(this, essay);
        this.mainView.displayFragment(selectedEssay, false, "Selected Essay");
    }


    @Override
    public void backToSelectedEssay(Essay essay) {
        SelectedUserEssayFragment selectedEssay = new SelectedUserEssayFragment(this, essay);
        this.mainView.displayFragment(selectedEssay, false, "Selected Essay");
    }
}

