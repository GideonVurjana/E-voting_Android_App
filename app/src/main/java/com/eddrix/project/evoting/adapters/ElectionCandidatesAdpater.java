package com.eddrix.project.evoting.adapters;

import android.app.Activity;
import android.content.Context;
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
import com.eddrix.project.evoting.models.ElectionCandidates;

import java.util.ArrayList;
import java.util.List;


public class ElectionCandidatesAdpater extends RecyclerView.Adapter<ElectionCandidatesAdpater.MyViewHolder>{

    List<ElectionCandidates> squareMediumModelList;
    Context context;
    Activity activity;

    public ElectionCandidatesAdpater(List<ElectionCandidates> squareMediumModelList, Context context) {
        this.squareMediumModelList = new ArrayList<>(squareMediumModelList);
        this.context = context;
        activity= (Activity) context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.candidates_elected_deisgn,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        ElectionCandidates squareMediumModel=squareMediumModelList.get(position);

        Glide.with(context).load(squareMediumModel.getPartyimage()).into(holder.imageView);
        holder.name.setText(squareMediumModel.getPartyname());
        holder.des.setText(squareMediumModel.getPartyDescription());
        holder.company.setText(squareMediumModel.getLeadername());




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

        ConstraintLayout constraintLayout;
        ImageView imageView;
        TextView name,des,company;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.imageView3);
            constraintLayout=itemView.findViewById(R.id.cl);
            des=itemView.findViewById(R.id.textView13);
            name=itemView.findViewById(R.id.textView11);
            company=itemView.findViewById(R.id.textView12);



        }
    }



}
