package com.example.EssayReviewApp.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.EssayReviewApp.databinding.FragmentMainmenuBinding;

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
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.binding = FragmentMainmenuBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        //Registers the user essays button so that when clicked it switches to the User Essays Fragment
        this.binding.essaysButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                MainMenuFragment.this.listener.onUserEssaysClicked();
            }
        });

        //Registers the all essays button so that when clicked it switches to the All Essays Fragment
        this.binding.allEssaysButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainMenuFragment.this.listener.onAllEssaysClicked();
            }
        });

    }
}