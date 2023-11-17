package com.example.astudio.Controller;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.astudio.Model.Dashboards;
import com.example.astudio.View.EssayDashAdapter;
import com.example.astudio.View.EssayDashboardFragment;
import com.example.astudio.View.IEssaysView;
import com.example.astudio.View.IMainView;
import com.example.astudio.View.IMenuView;
import com.example.astudio.View.MainMenuFragment;
import com.example.astudio.View.MainView;

public class Controller extends AppCompatActivity implements IMenuView.Listener, IEssaysView.Listener {
    IMainView mainView;
    Dashboards Dashboard = new Dashboards();

    EssayDashAdapter essayDashAdapter = new EssayDashAdapter(this );//Dashboards.essayList);


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
    public void onBack() {
        MainMenuFragment mainMenu = new MainMenuFragment(this);
        this.mainView.displayFragment(mainMenu,false,"main menu");
    }

    @Override
    public void onSubmitEssayClicked(String title, String text, String type) {
        Dashboard.addToEssayList(title, text, type);
        essayDashAdapter.notifyItemChanged(Dashboards.essayList.size() - 1);
    }


}
