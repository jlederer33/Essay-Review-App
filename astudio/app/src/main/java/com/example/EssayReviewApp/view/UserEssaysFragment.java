package com.example.EssayReviewApp.view;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.EssayReviewApp.databinding.FragmentUseressaysViewBinding;
import com.example.EssayReviewApp.model.Dashboards;
import com.example.EssayReviewApp.model.Essay;
import com.example.EssayReviewApp.R;
import com.google.android.material.snackbar.Snackbar;

import org.jetbrains.annotations.NotNull;


/**
 * This is the Essay dashboard fragment, which represents the view of the Essay dashboard. The essays
 * are displayed in a recyclerview. The user will have options to add and remove essays from this
 * dashboard.
 */

public class UserEssaysFragment extends Fragment implements IUserEssaysView {
    public class EssayDashViewHolder extends RecyclerView.ViewHolder {
        /**
         * The viewholder for the essay_view recyclerview. The items it uses are Essays, and displays the
         * type, title and text
         */
        TextView titleView, typeView, numOfReviews;
        private ImageButton deleteButton;
        public LinearLayout essayItem;

        public EssayDashViewHolder(@NonNull View itemView){
            super(itemView);
            titleView = itemView.findViewById(R.id.titleTextView);
            typeView = itemView.findViewById(R.id.typeTextView);


            essayItem = itemView.findViewById(R.id.userEssayItem);

            deleteButton = itemView.findViewById(R.id.essayItemDeleteButton);

        }
    }

    public class EssayDashAdapter extends RecyclerView.Adapter<EssayDashViewHolder>{

        /**
         * The adapter for the recyclerview. Uses the essayList from Dashboard
         */

        Context context;


        public EssayDashAdapter(Context context){
            this.context = context;
        }
        @NonNull
        @Override
        public EssayDashViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new EssayDashViewHolder(LayoutInflater.from(context).inflate(R.layout.useressayitem, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull EssayDashViewHolder holder, int position) {
            Essay essay = Dashboards.userEssayList.get(position);
            holder.titleView.setText(essay.getTitle());
            holder.typeView.setText(essay.getType().toString());

            holder.essayItem.setOnClickListener(new View.OnClickListener() {//Allows the essay to be clicked on, accessing the selected essay
                @Override
                public void onClick(View view) {
                    UserEssaysFragment.this.listener.onEssayClicked(essay);
                }
            });

            holder.deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    UserEssaysFragment.this.listener.onDeleteEssayClicked(essay, UserEssaysFragment.this);
                }

            });



        }



        @Override
        public int getItemCount() {
            return Dashboards.userEssayList.size();
        }


    }


    private FragmentUseressaysViewBinding binding;

    private final Listener listener;

    RecyclerView recyclerView;

    public UserEssaysFragment(@NotNull Listener listener) {
        this.listener = listener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.binding = FragmentUseressaysViewBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerViewEssays);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.binding.getRoot().getContext()));
        recyclerView.setAdapter(new EssayDashAdapter(this.binding.getRoot().getContext() ));

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

        //Register back button (Switches back to main menu)
        this.binding.mainmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserEssaysFragment.this.listener.onBack();
            }
        });

        //Register Submit Essay click listener
        this.binding.submitButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                final Editable essayTitleEditable = UserEssaysFragment.this.binding.titleEditText.getText();
                final String essayTitleString = essayTitleEditable.toString();

                final Editable essayTextEditable = UserEssaysFragment.this.binding.textEditText.getText();
                final String essayTextString = essayTextEditable.toString();

                if(essayTextString.isEmpty() || essayTextString.isEmpty()){
                    String errMsgStr = "Both fields must be filled out!";
                    Snackbar.make(view, errMsgStr, Snackbar.LENGTH_LONG).show();
                    return;
                }

                essayTitleEditable.clear();
                essayTextEditable.clear();

                UserEssaysFragment.this.listener.onSubmitEssayClicked(essayTitleString, essayTextString, type[0], UserEssaysFragment.this);


            }


        });


    }

    @Override
    public void updateEssaysDisplay() {
        this.binding.recyclerViewEssays.getAdapter().notifyDataSetChanged();
    }
}
