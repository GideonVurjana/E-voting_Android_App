package com.eddrix.project.evoting.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.eddrix.project.evoting.R;
import com.eddrix.project.evoting.config.MyPreferences;

@SuppressLint("CustomSplashScreen")
public class Splashscreen extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        Window window = this.getWindow();
        if (Build.VERSION.SDK_INT >= 23) {


            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(this.getResources().getColor(R.color.colorAccent));
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);



        }else if(Build.VERSION.SDK_INT<22){
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(this.getResources().getColor(R.color.colorAccent));

        }


        setContentView(R.layout.activity_splashscreen);

        int TIME = 3000;
        new Handler().postDelayed(() -> {

            MyPreferences myPreferences=new MyPreferences(getApplicationContext());

            if(!myPreferences.getVerified()){

           // startActivity(new Intent(Splashscreen.this, ActivityLogin.class));


            }else{
                //launch login activity..
                startActivity(new Intent(Splashscreen.this,MainActivity.class));
            }

            finish();
        }, TIME);

    }
}