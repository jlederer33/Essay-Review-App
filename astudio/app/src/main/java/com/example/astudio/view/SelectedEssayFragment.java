package com.example.astudio.view;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.astudio.R;
import com.example.astudio.databinding.FragmentSelectedessayViewBinding;
import com.example.astudio.databinding.FragmentUseressaysViewBinding;
import com.example.astudio.model.Essay;
import com.example.astudio.model.Review;

import org.w3c.dom.Text;

import java.util.ListIterator;

public class SelectedEssayFragment extends Fragment implements ISelectedEssayView{

    public class ReviewViewholder extends RecyclerView.ViewHolder{
        TextView reviewTitle, reviewText;

        public ReviewViewholder(@NonNull View itemView) {
            super(itemView);
            reviewTitle = itemView.findViewById(R.id.reviewTitle);
            reviewText = itemView.findViewById(R.id.reviewText);

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
            return new SelectedEssayFragment.ReviewViewholder(LayoutInflater.from(context).inflate(R.layout.essayitem, parent, false));

        }

        @Override
        public void onBindViewHolder(@NonNull ReviewViewholder holder, int position) {
            Review review = essay.reviewList.get(position);
            holder.reviewTitle.setText(review.getTitle());
            holder.reviewTitle.setText(review.getText());
        }

        @Override
        public int getItemCount() {
            return 0;
        }
    }

    private final Listener listener;
    private FragmentSelectedessayViewBinding binding;

    private Essay essay;


    public SelectedEssayFragment(Listener listener, Essay essay) {
        this.essay = essay;
        this.listener = listener;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.binding = FragmentSelectedessayViewBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        this.binding.selectedEssayTitle.setText(essay.getTitle());
        this.binding.selectedEssayText.setText(essay.getText());

        this.binding.backToUserEssays.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               SelectedEssayFragment.this.listener.onEssaysClicked();
            }
        });
    }
}