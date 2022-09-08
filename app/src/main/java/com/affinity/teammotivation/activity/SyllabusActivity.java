package com.affinity.teammotivation.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.affinity.teammotivation.R;
import com.affinity.teammotivation.adapter.SyllabusList_Adapter;

public class SyllabusActivity extends AppCompatActivity {

    ImageView back;
    int[] images = {R.drawable.test_series_icon, R.drawable.studymaterial_icon, R.drawable.studymaterial_icon, R.drawable.bank_icon,R.drawable.studymaterial_icon,R.drawable.test_series_icon, R.drawable.studymaterial_icon, R.drawable.studymaterial_icon, R.drawable.bank_icon,R.drawable.studymaterial_icon, R.drawable.bank_icon,R.drawable.studymaterial_icon, R.drawable.bank_icon,R.drawable.studymaterial_icon, R.drawable.bank_icon,R.drawable.studymaterial_icon};
    String [] catname = {"Anatomy" ,"Physicology" ,"Biochemistry" ,"Pathology " ,"Pharmacology","Microbiology","Forensic Medicine","E.N.T","P.S.M","Ophthalmology","Surgery","Gynaecology & Obstertrics","Paediatrics","Radiology","Dermatology","Anaesthesia"};
    RecyclerView first_listlView;
    String [] sno = {"Active Tests: 6/10","Active Tests: 7/10","Active Tests: 6/8","Active Tests: 9/10","Active Tests: 5/5","Active Tests: 10/10","Active Tests: 6/8","Active Tests: 6/10","Active Tests: 4/10","Active Tests: 6/10","Active Tests: 6/10","Active Tests: 6/10","Active Tests: 7/7","Active Tests: 8/9","Active Tests: 2/10","Active Tests: 8/10"};
   // String [] percentage = {"08 Jun - 21 Jun","21 Jun - 30 Jun","01 Jul - 14 Jul","15 Jul - 28 Jul","28 Jul - 12 Aug","12 Aug - 28 Aug","28 Jul - 28 Jul","15 Jul - 28 Jul","15 Jul - 28 Jul","15 Jul - 28 Jul","15 Jul - 28 Jul","15 Jul - 28 Jul","15 Jul - 28 Jul","15 Jul - 28 Jul","15 Jul - 28 Jul","15 Jul - 28 Jul"};
    SyllabusList_Adapter first_listlAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syllabus);

        back = (ImageView)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(   SyllabusActivity.this,MainActivity.class));
                finish();
            }
        });

        first_listlView = (RecyclerView) findViewById(R.id.first_listcat);
        first_listlAdapter = new SyllabusList_Adapter(SyllabusActivity.this, catname,sno,images);
        LinearLayoutManager filayoutManager= new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false);
        first_listlView.setAdapter(first_listlAdapter);
        first_listlView.setLayoutManager(filayoutManager);

    }
}