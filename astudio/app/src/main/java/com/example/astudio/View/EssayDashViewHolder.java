package com.example.astudio.View;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.astudio.R;

public class EssayDashViewHolder extends RecyclerView.ViewHolder {
    TextView titleView, textView, typeView;

    public EssayDashViewHolder(@NonNull View itemView){
        super(itemView);
        titleView = itemView.findViewById(R.id.titleTextView);
        typeView = itemView.findViewById(R.id.typeTextView);
        textView = itemView.findViewById(R.id.textTextView);
    }
}
