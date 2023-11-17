package com.example.astudio.View;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.astudio.Model.Dashboards;
import com.example.astudio.Model.Essay;
import com.example.astudio.R;
import com.example.astudio.databinding.FragmentEssayViewBinding;
import com.example.astudio.databinding.FragmentMainmenuBinding;
import com.google.android.material.snackbar.Snackbar;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


public class EssayDashboardFragment extends Fragment implements IEssaysView{
    private FragmentEssayViewBinding binding;

    private final Listener listener;

    //List<Essay> essaysList = Dashboards.essayList;
    RecyclerView recyclerView;

    Context context;

    public EssayDashboardFragment(@NotNull Listener listener) {
        this.listener = listener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.binding = FragmentEssayViewBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerViewEssays);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.binding.getRoot().getContext()));
        recyclerView.setAdapter(new EssayDashAdapter(this.binding.getRoot().getContext() ));//, Dashboards.essayList));

        final String[] type = new String[1];

        //Helps connect the spinner to the listener
        binding.typeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i){
                    case 0:
                        type[0] = "Personal";
                        break;
                    case 1:
                        type[0] = "Supplement";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //Register back button
        this.binding.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EssayDashboardFragment.this.listener.onBack();
            }
        });

        //Register Submit Essay click listener
        this.binding.submitButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                final Editable essayTitleEditable = EssayDashboardFragment.this.binding.titleEditText.getText();
                final String essayTitleString = essayTitleEditable.toString();

                final Editable essayTextEditable = EssayDashboardFragment.this.binding.textEditText.getText();
                final String essayTextString = essayTextEditable.toString();

                if(essayTextString.isEmpty() || essayTextString.isEmpty()){
                    String errMsgStr = "Both fields must be filled out!";
                    Snackbar.make(view, errMsgStr, Snackbar.LENGTH_LONG).show();
                    return;
                }

                essayTitleEditable.clear();
                essayTextEditable.clear();

                EssayDashboardFragment.this.listener.onSubmitEssayClicked(essayTitleString, essayTextString, type[0], EssayDashboardFragment.this);


            }
        });



    }

    @Override
    public void updateEssaysDisplay() {
        this.binding.recyclerViewEssays.getAdapter().notifyDataSetChanged();
    }
}