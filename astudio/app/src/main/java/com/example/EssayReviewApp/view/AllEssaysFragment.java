package com.example.EssayReviewApp.view;

import android.content.Context;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.EssayReviewApp.R;
import com.example.EssayReviewApp.databinding.FragmentAllessaysViewBinding;
import com.example.EssayReviewApp.model.Dashboards;
import com.example.EssayReviewApp.model.Essay;

import org.jetbrains.annotations.NotNull;

public class AllEssaysFragment extends Fragment implements IAllEssaysView{
    public class AllEssaysViewholder extends RecyclerView.ViewHolder{
        TextView titleView, typeView, numOfReviews;
        public LinearLayout essayItem;
        public AllEssaysViewholder(@NonNull View itemView) {
            super(itemView);
            titleView = itemView.findViewById(R.id.titleTextView);
            typeView = itemView.findViewById(R.id.typeTextView);

            essayItem = itemView.findViewById(R.id.allEssayItem);

            numOfReviews = itemView.findViewById(R.id.numOfReviews);
        }
    }

   /** public class AllEssaysFragment extends Fragment implements IAllEssaysView{
    private EditText searchEditText;
    private RecyclerView essaysRecyclerView;
    private EssaysAdapter essaysAdapter; //(adapter for recycler view)

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_all_essays, container, false);

        searchEditText = view.findViewById(R.id.searchEditText);
        essaysRecyclerView = view.findViewById(R.id.essaysRecyclerView);

        // Set up RecyclerView, adapter, etc.

        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                essaysAdapter.getFilter().filter(s); // Filter as the user types
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        return view;
    }
}
    public class EssaysAdapter extends RecyclerView.Adapter<EssaysAdapter.ViewHolder> implements Filterable {

        private List<Essay> originalEssays; // The full list of essays
        private List<Essay> filteredEssays; // The filtered list of essays

        // Constructor, ViewHolder, and other required methods...

        @Override
        public Filter getFilter() {
            return new Filter() {
                @Override
                protected FilterResults performFiltering(CharSequence constraint) {
                    List<Essay> filteredList = new ArrayList<>();
                    if (constraint == null || constraint.length() == 0) {
                        filteredList.addAll(originalEssays);
                    } else {
                        String filterPattern = constraint.toString().toLowerCase().trim();
                        for (Essay essay : originalEssays) {
                            if (essay.getTitle().toLowerCase().contains(filterPattern)) { // Assuming Essay has a getTitle method
                                filteredList.add(essay);
                            }
                        }
                    }
                    FilterResults results = new FilterResults();
                    results.values = filteredList;
                    return results;
                }

                @Override
                protected void publishResults(CharSequence constraint, FilterResults results) {
                    filteredEssays.clear();
                    filteredEssays.addAll((List) results.values);
                    notifyDataSetChanged();
                }
            };
        }
    }
    */


public class AllEssaysViewAdapter extends RecyclerView.Adapter<AllEssaysViewholder>{
        Context context;

        public AllEssaysViewAdapter(Context context){
            this.context = context;
        }
        @NonNull
        @Override
        public AllEssaysViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new AllEssaysViewholder(LayoutInflater.from(context).inflate(R.layout.allessayitem, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull AllEssaysViewholder holder, int position) {
            Essay essay = Dashboards.allEssaysList.get(position);
            holder.titleView.setText(essay.getTitle());
            holder.typeView.setText(essay.getType().toString());

            holder.numOfReviews.setText(String.valueOf(essay.numOfReviews()));

            holder.essayItem.setOnClickListener(new View.OnClickListener() {//Allows the essay to be clicked on, accessing the selected essay
                @Override
                public void onClick(View view) {
                    AllEssaysFragment.this.listener.onEssayClicked(essay);
                }
            });
        }

        @Override
        public int getItemCount() {
            return Dashboards.allEssaysList.size();
        }

    }


    private FragmentAllessaysViewBinding binding;

    private final Listener listener;

    RecyclerView recyclerView;

    public AllEssaysFragment(@NotNull IAllEssaysView.Listener listener) {
        this.listener = listener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.binding = FragmentAllessaysViewBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.allEssaysRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.binding.getRoot().getContext()));
        recyclerView.setAdapter(new AllEssaysViewAdapter(this.binding.getRoot().getContext()));

        this.binding.aeBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {AllEssaysFragment.this.listener.onBack();
            }
        });
    }
}
