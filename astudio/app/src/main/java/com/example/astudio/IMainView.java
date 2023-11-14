package com.example.astudio;

import android.view.View;

import androidx.fragment.app.Fragment;


public interface IMainView {
    /**
     * Interface for the backend of Main Menu. Retrieves the android view at root of screen hierarchy
     * @return the screen's root android view
     */

    View getRootView();

    void displayFragment(Fragment fragment, boolean reversible, String name);




}
