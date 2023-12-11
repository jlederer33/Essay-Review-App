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
import com.example.EssayReviewApp.model.Essay;
import com.example.EssayReviewApp.model.Review;
import com.google.android.material.snackbar.Snackbar;

/**
 * Once users click add review, they will be taken to this fragment. This class will allow users to
 * input title and text, and submit is clicked the review will be added to the respective essay
 */
public class AddReviewsFragment extends Fragment implements IAddReviewsView {
    private Essay essay;

    Listener listener;
    private FragmentAddReviewsBinding binding;

    public AddReviewsFragment(Listener listener, Essay essay) {
        this.essay = essay;
        this.listener = listener;
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

                //Title editable, lets user enter the title of their review then converts to a string
                final Editable reviewTitleEditable = AddReviewsFragment.this.binding.enterReviewTitle.getText();
                final String reviewTitleString = reviewTitleEditable.toString();

                //Text editable, lets user enter the text of their review then converts to a string
                final Editable reviewTextEditable = AddReviewsFragment.this.binding.enterReviewText.getText();
                final String reviewTextString = reviewTextEditable.toString();

                //To make sure that the title and text are both filled out, dont want to pass blank inputs
                if(reviewTitleString.isEmpty() || reviewTextString.isEmpty()){
                    String errMsgStr = "Must fill in review!";
                    Snackbar.make(view, errMsgStr, Snackbar.LENGTH_LONG).show();
                    return;
                }

                reviewTitleEditable.clear();
                reviewTextEditable.clear();
                AddReviewsFragment.this.listener.onSubmitReviewClicked(essay, reviewTitleString, reviewTextString);


            }
        });
    }
}