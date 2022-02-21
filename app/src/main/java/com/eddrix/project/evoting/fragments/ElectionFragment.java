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
import com.eddrix.project.evoting.adapters.ElectionsAdapter;
import com.eddrix.project.evoting.design.Space;
import com.eddrix.project.evoting.models.Election;

import java.util.ArrayList;
import java.util.List;


public class ElectionFragment extends Fragment {

    RecyclerView recyclerView;
    Context context;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=getContext();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_election,container,false);
        recyclerView=view.findViewById(R.id.electionRecyclerView);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        fetchData();
        return view;
    }

    private void fetchData() {

        List<Election> electionList=new ArrayList<>();

        electionList.add(new Election("Panchayat Elections","Start Date: 12/10/2022","End Date : 14/10/2022",true));
        electionList.add(new Election("Something Elections","Start Date: 12/10/2022","End Date : 14/10/2022",false));
        electionList.add(new Election("Everything Elections","Start Date: 12/10/2022","End Date : 14/10/2022",true));
        electionList.add(new Election("Don't know Elections","Start Date: 12/10/2022","End Date : 14/10/2022",false));
        electionList.add(new Election("Whatever Elections","Start Date: 12/10/2022","End Date : 14/10/2022",true));


        ElectionsAdapter electionsAdapter=new ElectionsAdapter(electionList,context);
        recyclerView.addItemDecoration(new Space(1,20,true,0));
        recyclerView.setAdapter(electionsAdapter);




    }
}
