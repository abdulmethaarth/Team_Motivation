package com.affinity.teammotivation.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.affinity.teammotivation.R;

public class TestActivity extends AppCompatActivity {

    RelativeLayout bank,industries,fishing,rearing;
    ImageView back;
    TextView btn_next,btn_previious,btn_review;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        back = (ImageView)findViewById(R.id.back);
        btn_next = (TextView) findViewById(R.id.btn_next);
        btn_review = (TextView) findViewById(R.id.btn_review);
        btn_previious = (TextView) findViewById(R.id.btn_previious);
        bank = (RelativeLayout) findViewById(R.id.bank);
        industries = (RelativeLayout) findViewById(R.id.industries);
        fishing = (RelativeLayout) findViewById(R.id.fishing);
        rearing = (RelativeLayout) findViewById(R.id.rearing);

        bank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TestActivity.this,UpcomingTestActivity.class));
                finish();
            }
        });

        btn_review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TestActivity.this, "Coming Soon..", Toast.LENGTH_SHORT).show();
            }
        });

        industries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TestActivity.this,UpcomingTestActivity.class));
                finish();
            }
        });

        fishing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TestActivity.this,UpcomingTestActivity.class));
                finish();
            }
        });

        rearing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TestActivity.this,UpcomingTestActivity.class));
                finish();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TestActivity.this,SyllabusActivity.class));
                finish();
            }
        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TestActivity.this, DashBoardActivity.class));
                finish();
            }
        });

        btn_previious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TestActivity.this,IntroductionActivity.class));
                finish();
            }
        });
    }
}