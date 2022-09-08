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

public class DashBoardActivity extends AppCompatActivity {

    ImageView back,share;
    RelativeLayout wrong,skipped,correct;
    TextView btn_leaderboard,btn_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        wrong = (RelativeLayout) findViewById(R.id.wrong);
        skipped = (RelativeLayout) findViewById(R.id.skipped);
        correct = (RelativeLayout) findViewById(R.id.correct);
        back = (ImageView)findViewById(R.id.back);
        share = (ImageView)findViewById(R.id.share);


        correct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashBoardActivity.this, InsightActivity.class));
                finish();
            }
        });

        skipped.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashBoardActivity.this,InsightActivity.class));
                finish();
            }
        });

        wrong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashBoardActivity.this,InsightActivity.class));
                finish();
            }
        });

          back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashBoardActivity.this, TestActivity.class));
                finish();
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DashBoardActivity.this, "Coming soon", Toast.LENGTH_SHORT).show();
            }
        });

        btn_leaderboard = (TextView) findViewById(R.id.btn_leaderboard);
        btn_home = (TextView) findViewById(R.id.btn_home);


        btn_leaderboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashBoardActivity.this, StudentsPercentageActivity.class));
                finish();
            }
        }); btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashBoardActivity.this, MainActivity.class));
                finish();
            }
        });
    }
}