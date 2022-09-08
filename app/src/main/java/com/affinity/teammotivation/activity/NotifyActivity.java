package com.affinity.teammotivation.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.affinity.teammotivation.adapter.Notify_Adapter;
import com.affinity.teammotivation.R;

public class NotifyActivity extends AppCompatActivity {

    ImageView back;
    int[] first_list_images = {R.drawable.noti_bell, R.drawable.noti_bell, R.drawable.noti_bell, R.drawable.noti_bell,R.drawable.noti_bell,R.drawable.noti_bell,R.drawable.noti_bell,R.drawable.noti_bell,R.drawable.noti_bell,R.drawable.noti_bell};
    String [] catname = {"Pharmacology Tnd Paper - 1.." ,"Pharmacology Tnd Paper - 2..." ,"Pharmacology Tnd Paper - 3..." ,"Pharmacology Tnd Paper - 4..." ,"Pharmacology Tnd Paper - 5...","Pharmacology Tnd Paper - 6...","Pharmacology Tnd Paper - 7...","Pharmacology Tnd Paper - 8...","Pharmacology Tnd Paper - 9...","Pharmacology Tnd Paper - 10..."};
    RecyclerView first_listlView;
    Notify_Adapter first_listlAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notify);


        back = (ImageView)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NotifyActivity.this,MainActivity.class));
                finish();
            }
        });

        first_listlView = (RecyclerView) findViewById(R.id.first_listcat);
        first_listlAdapter = new Notify_Adapter(NotifyActivity.this, first_list_images,catname);
        LinearLayoutManager filayoutManager= new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false);
        first_listlView.setAdapter(first_listlAdapter);
        first_listlView.setLayoutManager(filayoutManager);

    }
}