package com.eddrix.project.evoting.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class HomeViewPageAdapter extends FragmentStateAdapter {


    List<Map<String, Object>> mapList;

    public HomeViewPageAdapter(@NonNull FragmentActivity fragmentActivity, List<Map<String, Object>> mapList) {
        super(fragmentActivity);
        this.mapList = mapList;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return (Fragment) Objects.requireNonNull(mapList.get(position).get("fragment"));
    }

    @Override
    public int getItemCount() {
        return mapList.size();
    }

    public String getTitle(int position){

        String title = (String) mapList.get(position).get("fragmentTitle");

        if(title == null) title = "No Title";

        return title;
    }
}
