package com.example.astudio.View;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.astudio.R;
import com.example.astudio.databinding.FragmentMainmenuBinding;
import com.google.android.material.button.MaterialButton;

import org.jetbrains.annotations.NotNull;


public class MainMenuFragment extends Fragment implements IMenuView {

    private FragmentMainmenuBinding binding;
    private final Listener listener;

    public MainMenuFragment(@NotNull Listener listener) {
        this.listener = listener;
    }

    // TODO: Rename and change types and number of parameters

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

    }
}