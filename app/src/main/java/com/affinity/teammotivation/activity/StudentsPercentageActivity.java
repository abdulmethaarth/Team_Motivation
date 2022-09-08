package com.affinity.teammotivation.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.affinity.teammotivation.R;
import com.affinity.teammotivation.adapter.StudentList_Adapter;

public class StudentsPercentageActivity extends AppCompatActivity {

    ImageView back;
    int[] first_list_images = {R.drawable.user_profile, R.drawable.user_profile, R.drawable.user_profile, R.drawable.user_profile,R.drawable.user_profile,R.drawable.user_profile,R.drawable.user_profile,R.drawable.user_profile,R.drawable.user_profile,R.drawable.user_profile};
    String [] catname = {"Druva Taylor" ,"Steve Smith" ,"Tony Stark" ,"Taylor Mathew" ,"Druva Taylor","Jhone Peter","Peter Parker","Druva Taylor","Master Taylor","Elisabeth Moni"};
    RecyclerView first_listlView;
    String [] sno = {"1.","2.","3.","4.","5.","6.","7.","8.","9.","10"};
    String [] percentage = {"97.5%","96%","94.5%","90.5%","85.3%","80.5%","78.5%","75%","70%","72%"};
    StudentList_Adapter first_listlAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students_percentage);

        back = (ImageView)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StudentsPercentageActivity.this, InsightActivity.class));
                finish();
            }
        });

        first_listlView = (RecyclerView) findViewById(R.id.first_listcat);
        first_listlAdapter = new StudentList_Adapter(StudentsPercentageActivity.this, first_list_images,catname,sno,percentage);
        LinearLayoutManager filayoutManager= new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false);
        first_listlView.setAdapter(first_listlAdapter);
        first_listlView.setLayoutManager(filayoutManager);
    }
}