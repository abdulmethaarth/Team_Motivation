package com.affinity.teammotivation.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.affinity.teammotivation.R;

public class InsightActivity extends AppCompatActivity {

    ImageView back,profile;
    LinearLayout lattest_Card,overall_rank;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insight);

        overall_rank = (LinearLayout) findViewById(R.id.overall_rank);
        lattest_Card = (LinearLayout) findViewById(R.id.lattest_Card);
        back = (ImageView)findViewById(R.id.back);
        profile = (ImageView)findViewById(R.id.profile);

        lattest_Card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InsightActivity.this, StudentsPercentageActivity.class));
                finish();
            }
        });

        overall_rank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InsightActivity.this,StudentsPercentageActivity.class));
                finish();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InsightActivity.this, DashBoardActivity.class));
                finish();
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InsightActivity.this,ProfileActivity.class));
                finish();
            }
        });
    }
}