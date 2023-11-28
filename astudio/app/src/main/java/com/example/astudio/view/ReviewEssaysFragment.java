package com.example.astudio.view;

import com.example.astudio.databinding.FragmentReviewsViewBinding;

import org.jetbrains.annotations.NotNull;

public class ReviewEssaysFragment {

    private FragmentReviewsViewBinding binding;

    private final IEssaysView.Listener listener;
    public ReviewEssaysFragment(@NotNull IEssaysView.Listener listener) {
        this.listener = listener;
    }
}
