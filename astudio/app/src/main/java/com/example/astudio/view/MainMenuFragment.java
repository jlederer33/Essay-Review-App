package com.example.astudio.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.astudio.databinding.FragmentMainmenuBinding;

import org.jetbrains.annotations.NotNull;

/**
 * This fragment represents the default main menu screen. Users will be able to access
 * the different functions of the app from this fragment
 */
public class MainMenuFragment extends Fragment implements IMenuView {

    private FragmentMainmenuBinding binding;
    private final Listener listener;

    public MainMenuFragment(@NotNull Listener listener) {
        this.listener = listener;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.binding = FragmentMainmenuBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        //register essay button on click listener
        this.binding.essaysButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                MainMenuFragment.this.listener.onEssaysClicked();
            }
        });

        this.binding.allEssaysButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainMenuFragment.this.listener.onAllEssaysClicked();
            }
        });

    }
}