package com.example.EssayReviewApp.controller;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.EssayReviewApp.model.Dashboards;
import com.example.EssayReviewApp.model.Essay;
import com.example.EssayReviewApp.model.Review;
import com.example.EssayReviewApp.persistence.FirestoreFacade;
import com.example.EssayReviewApp.persistence.IPersistenceFacade;
import com.example.EssayReviewApp.view.AddReviewsFragment;
import com.example.EssayReviewApp.view.AllEssaysFragment;
import com.example.EssayReviewApp.view.IAddReviewsView;
import com.example.EssayReviewApp.view.IAllEssaysView;
import com.example.EssayReviewApp.view.ISelectedReviewView;
import com.example.EssayReviewApp.view.ISelectedEssayView;
import com.example.EssayReviewApp.view.SelectedReviewFragment;
import com.example.EssayReviewApp.view.SelectedEssayFragment;
import com.example.EssayReviewApp.view.UserEssaysFragment;
import com.example.EssayReviewApp.view.IUserEssaysView;
import com.example.EssayReviewApp.view.IMainView;
import com.example.EssayReviewApp.view.IMenuView;
import com.example.EssayReviewApp.view.MainMenuFragment;
import com.example.EssayReviewApp.view.MainView;

public class Controller extends AppCompatActivity
        implements IMenuView.Listener, IUserEssaysView.Listener, IAllEssaysView.Listener,
        ISelectedEssayView.Listener, IAddReviewsView.Listener, ISelectedReviewView.Listener,
        IPersistenceFacade.Listener{
    IMainView mainView;
    Dashboards dashboard = new Dashboards();

    IPersistenceFacade persFacade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mainView = new MainView(this);

        this.persFacade = new FirestoreFacade();

        this.persFacade.retrieveEssays(new IPersistenceFacade.Listener() {
            @Override
            public void onEssaysRecieved(@NonNull Dashboards dashboard) {
                Controller.this.dashboard = dashboard;
            }
        });

        MainMenuFragment mainMenuFragment = new MainMenuFragment(this);
        this.mainView.displayFragment(mainMenuFragment, false, "main menu");

        setContentView(this.mainView.getRootView());
    }

    /**
     * These are the methods displayed in the main menu fragment
     */
    @Override
    public void onUserEssaysClicked() { //sets the view to the user essays screen
        Fragment essayView = new UserEssaysFragment(this);
        this.mainView.displayFragment(essayView, false, "user essay dashboard");
    }


    @Override
    public void onAllEssaysClicked() { // sets the view to the all essays screen
        Fragment allEssaysView = new AllEssaysFragment(this);
        this.mainView.displayFragment(allEssaysView,false, "all essays dashboard");
    }

    @Override
    public void onBack() {//Switches the fragment to the Main menu
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

        Essay essay = new Essay(title, text, type);
        dashboard.addToUserEssayList(essay);
        view.updateEssaysDisplay();
        this.persFacade.saveUserEssay(essay);
    }

    @Override
    public void onDeleteEssayClicked(Essay essay, IUserEssaysView view){ //Connects the delete essay button
        dashboard.removeFromEssayList(essay);
        view.updateEssaysDisplay();
        this.persFacade.removeUserEssay(essay);

    }


    @Override
    public void onEssayClicked(Essay essay) {//method that displays the specific Essay
        SelectedEssayFragment selectedEssay = new SelectedEssayFragment(this, essay);
        this.mainView.displayFragment(selectedEssay, false, "Selected User Essay");
    }

    @Override
    public void onAddReviewClicked(Essay essay) {//switches the view to display the Add Review
        AddReviewsFragment addReview = new AddReviewsFragment(this, essay);
        this.mainView.displayFragment(addReview, false, "Add review");
    }

    @Override
    public void onSubmitToAllEssaysClicked(Essay essay) {//Calls on the submitToAllEssays method in the dashboards, allows user to submit an essay from the User screen to the All essays screen
        dashboard.submitToAllEssays(essay);
        UserEssaysFragment userEssays= new UserEssaysFragment(this);
        this.mainView.displayFragment(userEssays, false, "User Essays");
        this.persFacade.saveAllEssay(essay);
    }


    @Override
    public void onSelectedReviewClicked(Essay essay, Review review) {//Switches the view to display the selected review fragment
        SelectedReviewFragment selectedReview = new SelectedReviewFragment(this, essay, review);
        this.mainView.displayFragment(selectedReview,false,"Selected review");
    }

    @Override
    public void onDeleteReviewClicked(Essay essay, Review review, ISelectedEssayView view) {
        essay.deleteReview(review);
        view.updateReviewsDisplay();
        this.persFacade.saveAllEssay(essay);
    }


    @Override
    public void onSubmitReviewClicked(Essay essay, String title, String text) {//This Method binds the submit review button to the addReview method in Essays object
        essay.addReview(title, text);
        SelectedEssayFragment selectedEssay = new SelectedEssayFragment(this, essay);
        this.mainView.displayFragment(selectedEssay, false, "Selected Essay");
        this.persFacade.saveAllEssay(essay);
    }


    @Override
    public void backToSelectedEssay(Essay essay) {//This method allows the user to go back to the selected essay fragment from the selected reviews fragment
        SelectedEssayFragment selectedEssay = new SelectedEssayFragment(this, essay);
        this.mainView.displayFragment(selectedEssay, false, "Selected Essay");
    }

    @Override
    public void onEssaysRecieved(@NonNull Dashboards dashboard) {

    }
}

