package com.example.astudio;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;


import android.view.View;

public class MainView implements IMainView {

    FragmentManager fragManager;

    @Override
    public View getRootView() {
        return null;
    }

    @Override
    public void displayFragment(Fragment fragment, boolean reversible, String name) {

    }
}