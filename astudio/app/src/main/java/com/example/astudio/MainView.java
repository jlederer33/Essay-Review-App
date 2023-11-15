package com.example.astudio;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import com.example.astudio.databinding.MainBinding;
import android.view.View;

public class MainView implements IMainView {

    FragmentManager fragManager;

    MainBinding binding;

    public MainView(FragmentActivity activity){
        this.fragManager = activity.getSupportFragmentManager();
        this.binding = MainBinding.inflate(activity.getLayoutInflater());
    }

    @Override
    public View getRootView() {
        return null;
    }

    @Override
    public void displayFragment(Fragment fragment, boolean reversible, String name) {

    }
}