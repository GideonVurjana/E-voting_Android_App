package com.eddrix.project.evoting.activities;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.Fade;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityOptionsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.eddrix.project.evoting.R;
import com.eddrix.project.evoting.adapters.ElectionCandidatesAdpater;
import com.eddrix.project.evoting.design.Space;
import com.eddrix.project.evoting.models.ElectionCandidates;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CandidateActivity extends AppCompatActivity {
    Toolbar toolbar;
    ImageView dp_pic;

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
        setContentView(R.layout.activity_candidate_vote);

        toolbar=findViewById(R.id.toolbar);
        toolbar.setTitle("Janasena Party");
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorAccent));
        setSupportActionBar(toolbar);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationIcon(R.drawable.back);
        toolbar.setNavigationOnClickListener(view -> finish());
        dp_pic=findViewById(R.id.imageView2);

        dp_pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewDP();
            }
        });




    }

    private void viewDP() {
        Fade fade = new Fade();
        View decor = getWindow().getDecorView();
        //below 3 lines of code is to exclude action bar,title bar and navigation bar from animation.
        fade.excludeTarget(decor.findViewById(R.id.action_bar_container), true);
        fade.excludeTarget(android.R.id.statusBarBackground, true);
        fade.excludeTarget(android.R.id.navigationBarBackground, true);
        getWindow().setEnterTransition(fade);
        //we are also setting fade animation for exit transition.
        getWindow().setExitTransition(fade);
        ActivityOptionsCompat activityOptionsCompat =
                ActivityOptionsCompat.makeSceneTransitionAnimation(this,dp_pic,"profile");
        Intent in = new Intent(this,CandidateDP_Screen.class);
        startActivity(in,activityOptionsCompat.toBundle());

    }

}
