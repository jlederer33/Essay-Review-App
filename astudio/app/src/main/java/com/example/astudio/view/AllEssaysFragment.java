package com.example.astudio.view;

import com.example.astudio.databinding.FragmentUseressaysViewBinding;

import org.jetbrains.annotations.NotNull;

public class AllEssaysFragment {

    private FragmentUseressaysViewBinding binding;

    private final IAllEssaysView.Listener listener;
    public AllEssaysFragment(@NotNull IAllEssaysView.Listener listener) {
        this.listener = listener;
    }
}
