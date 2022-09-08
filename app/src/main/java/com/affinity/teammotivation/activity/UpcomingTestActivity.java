package com.affinity.teammotivation.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.affinity.teammotivation.R;
import com.affinity.teammotivation.adapter.UpcomingList_Adapter;

public class UpcomingTestActivity extends AppCompatActivity {

    ImageView back;
   // String [] catname = {"Introduction to Maths" ,"Introduction to Maths" ,"Introduction to Maths" ,"Introduction to Maths" ,"Introduction to Maths","Introduction to Maths","Introduction to Maths","Introduction to Maths","Introduction to Maths","Introduction to Maths"};
    RecyclerView first_listlView;
    //String [] sno = {"Week 1","Week 2","Week 3","Week 4","Week 5","Week 6","Week 7","Week 8","Week 9","Week 10"};
    String [] time = {"09 Jan, 2021 Mon","15 Jan, 2021 Mon","21 Jan, 2021 Mon","21 Jan, 2021 Mon","15 Jan, 2021 Mon","15 Jan, 2021 Mon","15 Jan, 2021 Mon","15 Jan, 2021 Mon","15 Jan, 2021 Mon","15 Jan, 2021 Mon"};
    UpcomingList_Adapter first_listlAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcoming_test);

        back = (ImageView)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(   UpcomingTestActivity.this,MainActivity.class));
                finish();
            }
        });

        first_listlView = (RecyclerView) findViewById(R.id.first_listcat);
        first_listlAdapter = new UpcomingList_Adapter(UpcomingTestActivity.this, time);
        LinearLayoutManager filayoutManager= new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false);
        first_listlView.setAdapter(first_listlAdapter);
        first_listlView.setLayoutManager(filayoutManager);

    }
}