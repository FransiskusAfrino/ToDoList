package com.Afrino.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        int loadingTime = 3000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeActivity = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(homeActivity);
                finish();
            }
        }, loadingTime);
    }
}