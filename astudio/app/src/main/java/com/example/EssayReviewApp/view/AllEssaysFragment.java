package com.example.EssayReviewApp.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
        TextView titleView, typeView;
        public AllEssaysViewholder(@NonNull View itemView) {
            super(itemView);
            titleView = itemView.findViewById(R.id.titleTextView);
            typeView = itemView.findViewById(R.id.typeTextView);
        }
    }

    public class AllEssaysViewAdapter extends RecyclerView.Adapter<AllEssaysViewholder>{
        Context context;

        public AllEssaysViewAdapter(Context context){
            this.context = context;
        }
        @NonNull
        @Override
        public AllEssaysViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new AllEssaysViewholder(LayoutInflater.from(context).inflate(R.layout.useressayitem, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull AllEssaysViewholder holder, int position) {
            Essay essay = Dashboards.allEssaysList.get(position);
            holder.titleView.setText(essay.getTitle());
            holder.typeView.setText(essay.getType().toString());
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
