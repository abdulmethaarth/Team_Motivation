package com.affinity.teammotivation.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.affinity.teammotivation.R;
import com.affinity.teammotivation.models.Constants;

public class ProfileActivity extends AppCompatActivity {

    ImageView back,notify;
    TextView btn_logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        back = (ImageView)findViewById(R.id.back);
        notify = (ImageView)findViewById(R.id.notify);
        btn_logout = (TextView) findViewById(R.id.btn_logout);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this,MainActivity.class));
                finish();
            }
        });

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getSharedPreferences(Constants.MY_PREFS_NAME, MODE_PRIVATE).edit();
                editor.clear();
                editor.apply();
                startActivity(new Intent(ProfileActivity.this,SplashActivity.class));
                finish();
            }
        });

        notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this,NotifyActivity.class));
                finish();
            }
        });
    }
}