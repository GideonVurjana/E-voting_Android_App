package com.eddrix.project.evoting.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.eddrix.project.evoting.R;
import com.eddrix.project.evoting.adapters.HomeViewPageAdapter;
import com.eddrix.project.evoting.fragments.ElectionFragment;
import com.eddrix.project.evoting.fragments.ProfileFragment;
import com.eddrix.project.evoting.fragments.ResultFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    ViewPager2 viewPager2;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = this.getWindow();
        if (Build.VERSION.SDK_INT >= 23) {


            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(this.getResources().getColor(R.color.black));
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);



        }else if(Build.VERSION.SDK_INT<22){
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(this.getResources().getColor(R.color.black));

        }
        setContentView(R.layout.activity_main);

        toolbar=findViewById(R.id.toolbar);
        viewPager2=findViewById(R.id.jos_pager);


        toolbar.setTitle("E-Voting");
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorAccent));
        setSupportActionBar(toolbar);




        List<Map<String, Object>> mapList = new ArrayList<>();

        Map<String, Object> stringObjectMap = setTabTitleAndFragment("Elections", new ElectionFragment());
        Map<String, Object> settingMap = setTabTitleAndFragment("Results", new ResultFragment());
        Map<String, Object> profile = setTabTitleAndFragment("Profile", new ProfileFragment());


        mapList.add(stringObjectMap);
        mapList.add(settingMap);
        mapList.add(profile);

        final HomeViewPageAdapter viewPagerAdapter = new HomeViewPageAdapter(this, mapList);
        viewPager2.setAdapter(viewPagerAdapter);

        TabLayout tabLayout = findViewById(R.id.tab_layout);

        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) ->
                tab.setText(viewPagerAdapter.getTitle(position))).attach();
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
//        MenuItem menuItem=menu.findItem(R.id.notifications);
//        menuItem.setVisible(false);
        return super.onCreateOptionsMenu(menu);
    }


    Map<String, Object> setTabTitleAndFragment(String title, Fragment fragment){

        Map<String, Object> fragmentWithTitleMap = new HashMap<>();

        fragmentWithTitleMap.put("fragmentTitle", title);
        fragmentWithTitleMap.put("fragment", fragment);

        return fragmentWithTitleMap;
    }

}