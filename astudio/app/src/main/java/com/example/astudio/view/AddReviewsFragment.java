package com.example.astudio.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.astudio.R;
import com.example.astudio.databinding.FragmentAddReviewsBinding;
import com.example.astudio.databinding.FragmentSelectedessayViewBinding;
import com.example.astudio.model.Essay;
import com.example.astudio.model.Review;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddReviewsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddReviewsFragment extends Fragment implements IAddReviewsView {
    private Essay essay;
    private Review review;
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
            }
        });
    }
}