package com.eddrix.project.evoting.activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.eddrix.project.evoting.R;
import com.eddrix.project.evoting.dialogs.MyDialogLoader;
import com.google.android.material.textfield.TextInputEditText;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class ActivityLogin extends AppCompatActivity implements View.OnClickListener {

    private static final int CODE = 1;
    Button button;
    TextView SignUp;
    Toolbar toolbar;
    private MyDialogLoader myDialogLoader;
    TextInputEditText username,password;

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
        setContentView(R.layout.activity_login);


        toolbar=findViewById(R.id.toolbar);


        toolbar.setTitle("Login");
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorAccent));
        setSupportActionBar(toolbar);
        username=findViewById(R.id.username);
        password=findViewById(R.id.email);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationIcon(R.drawable.back);
        toolbar.setNavigationOnClickListener(view -> finish());
        button=findViewById(R.id.button);
        button.setOnClickListener(this);
        SignUp=findViewById(R.id.login);
        String text = "<font color=#cc0029>No account? </font> <font color=#ffcc00>Register Now</font>";
        SignUp.setText(Html.fromHtml(text));
        SignUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v.getId()==R.id.login){


            startActivityForResult(new Intent(ActivityLogin.this,ActivityRegisteration.class),CODE);
            //finish();
        }else if(v.getId()==R.id.button){
            if(checkFields()){
                // send network request...
                sendCredentials(username.getText().toString(),password.getText().toString());
                button.setEnabled(false);
            }else {
                Toast.makeText(this,"Please Check All fields",Toast.LENGTH_LONG).show();
            }
        }
    }

    private void sendCredentials(String username, String password) {
        Map<String,Object>map=new HashMap<>();
        map.put("USERNAME",username);
        map.put("PASSWORD",password);
        Loader(true,"Logging you in");



    }


    private boolean checkFields() {

        if(Objects.requireNonNull(username.getText()).toString().equals("")|| Objects.requireNonNull(password.getText()).toString().equals("")){
            return false;
        }else
            return true;
    }

    public void Loader(boolean state, String msg) {
        if (myDialogLoader == null) {
            myDialogLoader=new MyDialogLoader();
        }
        if (state){
            Bundle bundle=new Bundle();
            bundle.putString("MSG",msg);
            myDialogLoader.setArguments(bundle);
            myDialogLoader.show(getSupportFragmentManager(), "DL");
        } else {
            myDialogLoader.dismiss();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==CODE){
            if (resultCode==RESULT_OK)
                finish();
        }
    }
}
