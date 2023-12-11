package com.example.EssayReviewApp.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.EssayReviewApp.databinding.FragmentSelectedreviewViewBinding;
import com.example.EssayReviewApp.model.Essay;
import com.example.EssayReviewApp.model.Review;
import com.google.firebase.firestore.util.Listener;

/**
 * This class represents when a User wants to see a full review. In this fragment, users are able to view the text and title of the review
 */
public class SelectedReviewFragment extends Fragment implements ISelectedReviewView {
    private final Listener listener;
    private FragmentSelectedreviewViewBinding binding;

    private Essay essay;
    private Review review;

    public SelectedReviewFragment(Listener listener, Essay essay, Review review) {
        this.listener = listener;
        this.essay = essay;
        this.review = review;
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.binding = FragmentSelectedreviewViewBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        this.binding.selectedReviewTitle.setText(review.getTitle());
        this.binding.selectedReviewText.setText(review.getText());

        this.binding.backToSelectedEssay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SelectedReviewFragment.this.listener.backToSelectedEssay(essay);
            }
        });
    }
}