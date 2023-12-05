package com.example.EssayReviewApp.view;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.View;

import com.example.EssayReviewApp.databinding.MainBinding;

/**
 * This is the main view of the app. The view has a fragment container. Using MainMenuFragment,
 * the fragments are displayed on this screen
 */
public class MainView implements IMainView {

    FragmentManager fragManager;

    MainBinding binding;

    public MainView(FragmentActivity activity){
        this.fragManager = activity.getSupportFragmentManager();
        this.binding = MainBinding.inflate(activity.getLayoutInflater());
    }

    @Override
    public View getRootView() {

        return this.binding.getRoot();
    }

    @Override
    public void displayFragment(Fragment fragment, boolean reversible, String name) {
        FragmentTransaction ft = fragManager.beginTransaction();
        ft.replace(this.binding.fragmentContainer.getId(), fragment);
        if (reversible)  ft.addToBackStack(name);
        ft.commit();

    }
}