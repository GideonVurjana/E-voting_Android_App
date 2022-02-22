package com.eddrix.project.evoting.activities;

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

import com.bumptech.glide.Glide;
import com.eddrix.project.evoting.R;

import java.util.Objects;

public class CandidateDP_Screen extends AppCompatActivity {
    ImageView img;
    Toolbar toolbar;
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

        setContentView(R.layout.candidate_dp_screen);

        toolbar=findViewById(R.id.toolbar);

        toolbar.setTitle("Pavan Kalyan");
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorAccent));
        setSupportActionBar(toolbar);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationIcon(R.drawable.back);
        toolbar.setNavigationOnClickListener(view -> finish());

        Fade fade = new Fade();
        img=findViewById(R.id.imageView7);
        Glide.with(this).load(R.drawable.pavan_janasena).into(img);

        // here also we are exclusing status bar, action bar and navigation bar from animation.
//        fade.excludeTarget(android.R.id.statusBarBackground, true);
//        fade.excludeTarget(android.R.id.navigationBarBackground, true);
        // below methods are used for adding enter and exit transition.
        getWindow().setEnterTransition(fade);
        getWindow().setExitTransition(fade);
    }
}
