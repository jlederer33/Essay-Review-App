package com.example.astudio.View;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.astudio.Model.Dashboards;
import com.example.astudio.Model.Essay;
import com.example.astudio.R;

import java.util.List;

public class EssayDashAdapter extends RecyclerView.Adapter<EssayDashViewHolder>{

    Context context;


    public EssayDashAdapter(Context context){
        this.context = context;
    }
    @NonNull
    @Override
    public EssayDashViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new EssayDashViewHolder(LayoutInflater.from(context).inflate(R.layout.essayitem, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull EssayDashViewHolder holder, int position) {
       Essay essay = Dashboards.essayList.get(position);
       holder.titleView.setText(essay.getTitle());
       holder.typeView.setText(essay.getType().toString());
       holder.textView.setText(essay.getText());
    }

    @Override
    public int getItemCount() {
        return Dashboards.essayList.size();
    }


}
