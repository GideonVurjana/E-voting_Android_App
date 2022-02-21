package com.eddrix.project.evoting.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.eddrix.project.evoting.R;

import java.util.ArrayList;
import java.util.List;

public class ResultFragment extends Fragment {

    RecyclerView recyclerView;
    Context context;

    //List<job> jobList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=getContext();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_results,container,false);
       // recyclerView=view.findViewById(R.id.jobs_rec);

//        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(context);
//        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
//
//        jobList=new ArrayList<>();
//
//        jobList.add(new job(1,"Android Developer","Vugido Food-Hub",R.drawable.vugi,"","something ...................","Apply Now"));
//        jobList.add(new job(1,"Machine Learning Engineer","AZBotics",R.drawable.azbotics,"","something ...................","Apply Now"));
//
//        jobList.add(new job(1,"Data Scientist","Google",R.drawable.google,"","something ...................","Apply Now"));
//
//        jobList.add(new job(1,"Business Manager","Amazon",R.drawable.amazon,"","something ...................","Apply Now"));
//
//        jobList.add(new job(1,"Android Developer","Facebook",R.drawable.fb,"","something ...................","Apply Now"));
//
//        jobList.add(new job(1,"ios Developer","Apple",R.drawable.apple,"","something ...................","Apply Now"));
//        jobList.add(new job(1,"Ui/Ux Designer","Samsung",R.drawable.samsung,"","something ...................","Apply Now"));
//
//        jobList.add(new job(1,"Software Engineer","Microsoft",R.drawable.microsoft,"","something ...................","Apply Now"));
//
//        jobList.add(new job(1,"Data Analyst","AZBotics",R.drawable.azbotics,"","something ...................","Apply Now"));
//
//        recyclerView.addItemDecoration(new Space(1,10,true,0));
//        recyclerView.setLayoutManager(linearLayoutManager);
//
//
//
//
//        JobsPostAdapter jobsPostAdapter=new JobsPostAdapter(jobList,context);
//
//        recyclerView.setAdapter(jobsPostAdapter);
        return view;
    }
}
