package com.affinity.teammotivation.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.affinity.teammotivation.R;

public class VerificationActivity extends AppCompatActivity {

    ImageView back;
    TextView Continue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);

        back = (ImageView)findViewById(R.id.back);
        Continue = (TextView) findViewById(R.id.btn_continue);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(VerificationActivity.this,LoginOptionActivity.class));
                finish();
            }
        });

        Continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(VerificationActivity.this,MainActivity.class));
                finish();
            }
        });
    }
}