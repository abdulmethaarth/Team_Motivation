package com.affinity.teammotivation.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.affinity.teammotivation.R;
import com.affinity.teammotivation.adapter.VideList_Adapter;

public class VideoActivity extends AppCompatActivity {


    ImageView back;

    //String [] sname = {"Druva Taylor" ,"Steve Smith" ,"Tony Stark" ,"Taylor Mathew" ,"Druva Taylor","Jhone Peter","Peter Parker","Druva Taylor","Master Taylor","Elisabeth Moni"};
    RecyclerView first_listlView;
    String [] sno = {"Alexy Tatiana","Matheshwar","Mugilan","Misfer Mathew","Harini Bala","Bala Ravichandar","Abinav Mathesh","Ishan kishan","Mugan Rao"};
    String [] testQues = {"20 Questions","32 Questions","25 Questions","28 Questions","40 Questions","35 Questions","27 Questions","37 Questions","35 Questions"};
    String [] testname = {"Anatomy" ,"Physicology" ,"Biochemistry" ,"Pathology " ,"Pharmacology","Microbiology","Forensic Medicine","P.S.M","Ophthalmology"};
   VideList_Adapter first_listlAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);


        back = (ImageView)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(VideoActivity.this,SyllabusActivity.class));
                finish();
            }
        });

        first_listlView = (RecyclerView) findViewById(R.id.first_listcat);
        first_listlAdapter = new VideList_Adapter(VideoActivity.this,sno,testQues,testname);
        LinearLayoutManager filayoutManager= new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false);
        first_listlView.setAdapter(first_listlAdapter);
        first_listlView.setLayoutManager(filayoutManager);
    }
}