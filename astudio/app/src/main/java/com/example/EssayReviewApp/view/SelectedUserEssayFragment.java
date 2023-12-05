package com.example.EssayReviewApp.view;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.EssayReviewApp.R;
import com.example.EssayReviewApp.databinding.FragmentSelecteduseressayViewBinding;
import com.example.EssayReviewApp.model.Essay;
import com.example.EssayReviewApp.model.Review;

public class SelectedUserEssayFragment extends Fragment implements ISelectedUserEssayView {

    public class ReviewViewholder extends RecyclerView.ViewHolder{
        TextView reviewTitle, reviewText;

        public LinearLayout reviewItem;

        public ReviewViewholder(@NonNull View itemView) {
            super(itemView);
            reviewTitle = itemView.findViewById(R.id.reviewTitle);
            reviewText = itemView.findViewById(R.id.reviewText);

            reviewItem = itemView.findViewById(R.id.reviewItem);

        }
    }

    public class ReviewAdapter extends RecyclerView.Adapter<ReviewViewholder>{
        Context context;

        public ReviewAdapter(Context context) {
            this.context = context;
        }

        @NonNull
        @Override
        public ReviewViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new SelectedUserEssayFragment.ReviewViewholder(LayoutInflater.from(context).inflate(R.layout.reviewitem, parent, false));

        }

        @Override
        public void onBindViewHolder(@NonNull ReviewViewholder holder, int position) {

            Review review = essay.reviewList.get(position);
            holder.reviewTitle.setText(review.getTitle());
            holder.reviewTitle.setText(review.getText());

            holder.reviewItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SelectedUserEssayFragment.this.listener.onSelectedReviewClicked(essay, review);
                }
            });
        }

        @Override
        public int getItemCount() {
            return essay.numOfReviews();
        }
    }

    private final Listener listener;
    private FragmentSelecteduseressayViewBinding binding;

    private Essay essay;

    RecyclerView recyclerView;


    public SelectedUserEssayFragment(Listener listener, Essay essay) {
        this.essay = essay;
        this.listener = listener;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.binding = FragmentSelecteduseressayViewBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        this.binding.selectedEssayTitle.setText(essay.getTitle());
        this.binding.selectedEssayText.setText(essay.getText());


        recyclerView = view.findViewById(R.id.recyclerViewReviews);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.binding.getRoot().getContext()));
        recyclerView.setAdapter(new ReviewAdapter(this.binding.getRoot().getContext() ));

        this.binding.backToUserEssays.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               SelectedUserEssayFragment.this.listener.onEssaysClicked();
            }
        });

        this.binding.addReviewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SelectedUserEssayFragment.this.listener.onAddReviewClicked(essay);
            }
        });
    }

    public void updateReviewsDisplay(){
        this.binding.recyclerViewReviews.getAdapter().notifyDataSetChanged();
    }




}