package com.affinity.teammotivation.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.affinity.teammotivation.adapter.IntroList_Adapter;
import com.affinity.teammotivation.R;

public class IntroductionActivity extends AppCompatActivity {

    ImageView back;

    int[] images = {R.drawable.staff_img1, R.drawable.staff_img2, R.drawable.staff_img3, R.drawable.staff_img4,R.drawable.staff_img1,R.drawable.staff_img2, R.drawable.staff_img3, R.drawable.staff_img4, R.drawable.staff_img1,R.drawable.staff_img2, R.drawable.staff_img3,R.drawable.staff_img4, R.drawable.staff_img1,R.drawable.staff_img2, R.drawable.staff_img3,R.drawable.staff_img4};
    RecyclerView first_listlView;
    String [] sno = {"General Physiology","Nerve and Muscles","Cardiovascular System","Central Nerve System","Endocrine System","Gastrointestinal System","Blood","Respiratory System","Renal System","Reproductive System","Special Senses"};
    String [] testQues = {"20 Questions","32 Questions","25 Questions","28 Questions","40 Questions","35 Questions","27 Questions","37 Questions","35 Questions","36 Questions","36 Questions"};
    String [] testname = {"Physiology General","Nerve and Muscles","Cardiovascular","entral Nerve System","Endocrine System","Gastrointestinal","Blood","Respiratory System","Renal System","Reproductive System","Special Senses"};
    IntroList_Adapter first_listlAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);

        back = (ImageView)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(IntroductionActivity.this,SyllabusActivity.class));
                finish();
            }
        });

        first_listlView = (RecyclerView) findViewById(R.id.first_listcat);
        first_listlAdapter = new IntroList_Adapter(IntroductionActivity.this,sno,testQues,testname,images);
        LinearLayoutManager filayoutManager= new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false);
        first_listlView.setAdapter(first_listlAdapter);
        first_listlView.setLayoutManager(filayoutManager);

    }
}