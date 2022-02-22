package com.eddrix.project.evoting.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.eddrix.project.evoting.R;
import com.eddrix.project.evoting.activities.ElectedCandidatesActivity;
import com.eddrix.project.evoting.models.Election;

import java.util.ArrayList;
import java.util.List;


public class ElectionsAdapter extends RecyclerView.Adapter<ElectionsAdapter.MyViewHolder>{

    List<Election> squareMediumModelList;
    Context context;
    Activity activity;

    public ElectionsAdapter(List<Election> squareMediumModelList, Context context) {
        this.squareMediumModelList = new ArrayList<>(squareMediumModelList);
        this.context = context;
        activity= (Activity) context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.election_row_design,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Election squareMediumModel=squareMediumModelList.get(position);

        holder.name.setText(squareMediumModel.getElectionName());
        holder.startdate.setText(squareMediumModel.getStartdate());
        holder.enddate.setText(squareMediumModel.getEndDate());


        if (squareMediumModel.isActivestate())
            Glide.with(context).load(R.drawable.active_election).into(holder.active);
        else
            Glide.with(context).load(R.drawable.unactive_election).into(holder.active);


        holder.cl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //show all candidates who are participating the selected election...
                context.startActivity(new Intent(context, ElectedCandidatesActivity.class));

            }
        });
    }

    @Override
    public int getItemCount() {
        return squareMediumModelList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return (position);
    }

    @Override
    public long getItemId(int position) {
        return (position);
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{

        ConstraintLayout cl;
        TextView name,startdate,enddate;
        ImageView active;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name=itemView.findViewById(R.id.textView);
            cl=itemView.findViewById(R.id.cl);
            startdate=itemView.findViewById(R.id.textView2);
            enddate=itemView.findViewById(R.id.textView3);
            active=itemView.findViewById(R.id.imageView);



        }
    }



}
