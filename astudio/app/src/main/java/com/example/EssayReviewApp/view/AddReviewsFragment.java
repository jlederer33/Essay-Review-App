package com.example.EssayReviewApp.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.EssayReviewApp.R;
import com.example.EssayReviewApp.databinding.FragmentAddReviewsBinding;
import com.example.EssayReviewApp.databinding.FragmentSelectedessayViewBinding;
import com.example.EssayReviewApp.model.Essay;
import com.example.EssayReviewApp.model.Review;
import com.google.android.material.snackbar.Snackbar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddReviewsFragment} factory method to
 * create an instance of this fragment.
 */
public class AddReviewsFragment extends Fragment implements IAddReviewsView {
    private Essay essay;
    private Review review;

    Listener listener;
    private FragmentAddReviewsBinding binding;

    public AddReviewsFragment(Essay essay, Review review) {
        this.essay = essay;
        this.review = review;
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.binding = FragmentAddReviewsBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        this.binding.addReviewEssayText.setText(essay.getText());

        this.binding.submitReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Editable reviewTextEditable= AddReviewsFragment.this.binding.enterReview.getText();
                final String reviewTextString = reviewTextEditable.toString();

                if(reviewTextString.isEmpty()){
                    String errMsgStr = "Must fill in review!";
                    Snackbar.make(view, errMsgStr, Snackbar.LENGTH_LONG).show();
                    return;
                }

                review.setText(reviewTextString);

                reviewTextEditable.clear();

                //AddReviewsFragment.this.listener.onSubmitReviewClicked(essay, review, SelectedEssayFragment.this);

                //AddReviewsFragment.this.listener.onUserEssayClicked();
            }
        });
    }
}