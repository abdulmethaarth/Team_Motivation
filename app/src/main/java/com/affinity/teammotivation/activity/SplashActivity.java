package com.affinity.teammotivation.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.affinity.teammotivation.R;
import com.affinity.teammotivation.models.Constants;

public class SplashActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 1500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
               /* startActivity(new Intent(SplashActivity.this,LoginOptionActivity.class));
                finish();*/
                SharedPreferences prefs = getSharedPreferences(Constants.MY_PREFS_NAME, MODE_PRIVATE);
                if(prefs.getBoolean(Constants.KEY_OTP_LOGGED_IN, false)){
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    finish();
                }
                else {
                    startActivity(new Intent(SplashActivity.this,LoginOptionActivity.class));
                    finish();
                }
            }
        },SPLASH_TIME_OUT);
    }
}