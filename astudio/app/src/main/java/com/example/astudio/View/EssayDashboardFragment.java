package com.example.astudio.View;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.astudio.Model.Essay;
import com.example.astudio.R;
import com.example.astudio.databinding.FragmentEssayViewBinding;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


public class EssayDashboardFragment extends Fragment implements IEssaysView{
    private FragmentEssayViewBinding binding;

    private final Listener listener;

    private List<Essay> essaysList;

    private RecyclerView recyclerView;

    public EssayDashboardFragment(@NotNull Listener listener) {
        this.listener = listener;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_essay_view, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        //Register Submit Essay click listener
        this.binding.submitButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                final Editable essayTitleEditable = EssayDashboardFragment.this.binding.titleEditText.getText();
                final String essayTitleString = essayTitleEditable.toString();


            }
        });
    }
}